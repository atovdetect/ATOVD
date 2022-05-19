    package com.ato.controllers;

    import com.ato.LoginDTO;
    import com.ato.dao.Anomaly;
    import com.ato.dao.User;
    import com.ato.dto.DashBoard;
    import com.ato.dto.Email;
    import com.ato.dto.UserRegistration;
    import com.ato.respositories.AnomalyRepository;
    import com.ato.respositories.UserRepository;
    import com.ato.utils.AtoUtils;
    import com.ato.utils.EmailUtils;
    import io.airbrake.javabrake.Config;
    import io.airbrake.javabrake.Notice;
    import io.airbrake.javabrake.Notifier;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import javax.annotation.PostConstruct;
    import javax.servlet.http.HttpServletRequest;
    import java.util.*;

    @RestController
    public class VersionController {

        @Autowired
        EmailUtils emailUtils;

        @Autowired
        UserRepository userRepository;

        @Autowired
        AnomalyRepository anomalyRepository;

        @Autowired
        AtoUtils atoUtils;

        @PostConstruct
        public void init(){
            Config config = new Config();
            config.projectId = 413753;
            config.projectKey = "51752e0d24b4d93a9b1185e3554ae296";
            Notifier notifier = new Notifier(config);
            notifier.addFilter(
                    (
                            Notice notice) -> {
                        notice.setContext("environment", "production");
                        return notice;
                    });
        }

        @CrossOrigin(origins = "*", allowedHeaders = "*")
        @PostMapping ("/email")
        public String sendEmail(@RequestBody Email email) throws Exception{
            System.out.println(" -- Report received -- ");
            emailUtils.sendInDividualEmail2(email.getTo(),email.getMessage(),email.getSubject());
            return "Email send";
        }

        @CrossOrigin(origins = "*", allowedHeaders = "*")
        @PostMapping ("/reports")
        public String getVersion(@RequestBody Anomaly anomaly) throws Exception{
            System.out.println(" -- Report received -- ");
            anomalyRepository.save(anomaly);
            emailUtils.sendInDividualEmail(atoUtils.getRegisteredEmail(anomaly.getAppId()), "ATO Alert mail",
                    " ATO Anomaly Detected from IP Address [ "+anomaly.getIpaddress()+"] Description : " +anomaly.getDescription());
            return "data stored";
        }

        @GetMapping("/fetchreport_dev")
        public DashBoard fetchReport(HttpServletRequest request) {

            Anomaly anomaly = null;
            Collections.nCopies(10, anomaly).stream().toList();
            List<Anomaly> anomalyList = Collections.emptyList();

            return DashBoard.builder()
                    .anomalyList(anomalyList)
                    .noOfnewAlerts(String.valueOf(anomalyList.size()))
                    .noOfAnomalies(String.valueOf(anomalyList.size()))
                    .noOfCriticalAlerts("12")
                    .build();
        }

        @CrossOrigin(origins = "*", allowedHeaders = "*")
        @GetMapping("/fetchreport")
        public List<Anomaly> getIpAddres(HttpServletRequest request,@RequestHeader("appId") String appId) {
            Anomaly anomaly = null;
            List<Anomaly> anomalyList = new ArrayList();
;           for(Anomaly anomaly1:anomalyRepository.findAll()){
                anomalyList.add(Anomaly.builder().description(anomaly1.getDescription()).ipaddress(anomaly1.getIpaddress()).build());
            }
            return anomalyList;
        }

        /**
         *
         * @param request
         * @param loginDTO
         * @return
         * @throws Exception
         */
        @PostMapping("/login")
        public DashBoard userLogin(HttpServletRequest request,@RequestBody LoginDTO loginDTO) throws Exception{

            Optional<User> loginUser = userRepository.userLogin(loginDTO.getUserName(),loginDTO.getPassWord());
            if(loginUser.isPresent()){

                User user = (User) loginUser.get();
                Optional<List<Anomaly>> anomalies =  anomalyRepository.findAnomaliesByEmailID(user.getAppId());
                List<Anomaly> anomalyList  = anomalies.get();

                return DashBoard.builder()
                        .anomalyList(anomalyList)
                        .noOfnewAlerts(String.valueOf(anomalyList.size()))
                        .noOfAnomalies(String.valueOf(anomalyList.size()))
                        .noOfCriticalAlerts("12")
                        .appId(user.getAppId())
                        .build();
            }

            throw new Exception("invalid credentials");
        }

        /**
         *
         * @param request
         * @param userRegistration
         * @return
         */
        @PostMapping("/registration")
        public String userRegistration(HttpServletRequest request,@RequestBody UserRegistration userRegistration){
            User user=new User();
            user.setEmail(userRegistration.getUserEmail());
            user.setPhoneNumber(userRegistration.getUserPhoneNumber());
            user.setAppId(String.valueOf(UUID.randomUUID()));
            user.setPassword(userRegistration.getUserPassword());
            userRepository.save(user);
            return "USER_REGISTRED_SUCsESS";
        }
    }


