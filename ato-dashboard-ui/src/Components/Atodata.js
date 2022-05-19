
import React, { useState, useEffect } from 'react';
import apiClient from "../Components/axios";

 
function Atodata() {
  //  const [data, state] = useState([])
    // const URL = 'http://35.177.221.199:8080/ato-endpoints/fetchreport';
   //ß const URL = 'http://3.8.16.176:8080/ato-endpoints/fetchreport';

    const [persons, setPersons] = useState([]);

    useEffect(() => {
        fetchData()
    }, [])
 
 
    const fetchData = () => {
      apiClient.get('ato-endpoints/fetchreport').then(res => {
        const persons = res.data;
        setPersons(persons);
      });

      // apiClient.get(`https://jsonplaceholder.typicode.com/users`)
      // .then(res => {
      //   const persons = res.data;
      //   this.setState({ persons });
      // })
          // data.
          //     getData(data);
          //     return  data


              // fetch(URL)
              //     .then((res) =>
              //         res.json())
      
              //     .then((response) => {
              //         console.log(response);
              //         getData(response.response.results);
              //     })
              // apiClient.post
    }


    // const fetchData1 = () => {
    //     console.log(" >> test >>");
    //      fetch(URL, {
    //          method: 'GET',
    //                  headers: {
    //                      'Content-Type': 'application/json',
    //                      'X-My-Custom-Header': 'value-v',
    //                      'appId' : '1231231243'
    //          }
    //      }).then(data => {
    //          let response =data.json()
    //          console.log(response);
    //          //getData(response.response.results);
    //          return response.response.results;
    //      })
  
    //  }
 
    // render() {
        // return (
        //   <ul>
        //     {
        //       this.state.persons
        //         .map(person =>
        //           <li key={person.id}>{person.name}</li>
        //         )
        //     }
        //   </ul>
        // )
    //   };

    // "anomaliId": 89,
    //     "date": "Fri May 13 18:32:57 CDT 2022",
    //     "description": " Request body exceeded the maximum size ",
    //     "ipaddress": "0:0:0:0:0:0:0:1",
    //     "datectedData": "byteLength = 51104",
    //     "appId": null


    return (
        <>
            <tbody>
                <tr>
                    <th>Anomaly Id</th>
                    <th>Date</th>
                    <th>Description</th>
                    <th>ipaddress</th>
                    <th>requestHeaders</th>
                </tr>
                {persons.map((item, i) => (
                    <tr key={i}>
                        <td>{item.anomaliId}</td>
                        <td>{item.date}</td>
                        <td>{item.description}</td>
                        <td>{item.ipaddress}</td>
                        <td>{item.datectedData}</td>
                    </tr>
                ))}
            </tbody>
 
        </>
    );
}
 
export default Atodata;
