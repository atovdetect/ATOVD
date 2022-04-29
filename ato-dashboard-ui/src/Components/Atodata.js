
import React, { useState, useEffect } from 'react';

 
function Atodata() {
    const [data, getData] = useState([])
    const URL = 'http://35.177.221.199:8080/ato-endpoints/fetchreport';
 
    useEffect(() => {
        fetchData()
    }, [])
 
 
    const fetchData = () => {
        fetch(URL)
            .then((res) =>
                res.json())
 
            .then((response) => {
                console.log(response);
                getData(response);
            })
 
    }
 
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
                {data.map((item, i) => (
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
