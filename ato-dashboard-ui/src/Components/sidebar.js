import React, {Component} from 'react';
import {Link} from 'react-router-dom';

export default class Sidebar extends Component {
    render() {
        return (
            <div id="wrapper">
                <ul className="sidebar navbar-nav">
                    <li className="nav-item active">
                        <Link to={'/dashboard'} className="nav-link"><i className="fas fa-fw fa-tachometer-alt"></i>
                            <span>&nbsp;Dashboard</span></Link>
                    </li>
                    <li className="nav-item active">
                        <Link to={'/dashboard'} className="nav-link"><i className="far fa-file-alt"></i>
                            <span>&nbsp;Overview</span></Link>
                    </li>
                    <li className="nav-item">
                        <Link to={'/index'} className="nav-link"><i className="fas fa-user-lock"></i>
                            <span>&nbsp;Credentials</span></Link>
                    </li>
                    <li className="nav-item">
                        <Link to={'/fileupload'} className="nav-link"><i className="fas fa-download"></i>
                            <span>&nbsp;Download</span></Link>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="tables.html">
                            <i className="fas fa-cogs"></i>
                            <span>&nbsp;Settings</span></a>
                    </li>
                </ul>
            </div>
        );
    }
}
