
import React, { useState, useEffect } from 'react';
import apiClient from "../Components/axios";

 
function Atodata() {
  //  const [data, state] = useState([])
    state = {
        persons: []
      }
    // const URL = 'http://35.177.221.199:8080/ato-endpoints/fetchreport';
   //ß const URL = 'http://3.8.16.176:8080/ato-endpoints/fetchreport';
 
    useEffect(() => {
        fetchData()
    }, [])
 
 
    const  fetchData = () => {
let data =apiClient.get('ato-endpoints/fetchreport').then(res => {
    const persons = res.data;

    this.setState({ persons });
  })

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
        return (
          <ul>
            {
              this.state.persons
                .map(person =>
                  <li key={person.id}>{person.name}</li>
                )
            }
          </ul>
        )
    //   };


    return (
        <>
            <tbody>
                <tr>
                    <th>User Id</th>
                    <th>Date</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>ipaddress</th>
                    <th>requestHeaders</th>
                </tr>
                {this.state.persons((item, i) => (
                    <tr key={i}>
                        <td>{item.userId}</td>
                        <td>{item.date}</td>
                        <td>{item.description}</td>
                        <td>{item.ipaddress}</td>
                        <td>{item.requestHeaders}</td>
                    </tr>
                ))}
            </tbody>
 
        </>
    );
}
 
export default Atodata;
