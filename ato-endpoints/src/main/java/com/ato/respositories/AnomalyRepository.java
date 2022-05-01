package com.ato.respositories;

import com.ato.dao.Anomaly;
import com.ato.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnomalyRepository extends  JpaRepository<Anomaly,Integer> {

    @Query("SELECT R FROM Anomaly R WHERE R.appId=?1")
    Optional<List<Anomaly>> findAnomaliesByEmailID(String appId);

}
