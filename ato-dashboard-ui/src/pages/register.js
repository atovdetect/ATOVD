import React, { Component } from 'react';
import axios from 'axios';
import {Link, Redirect} from 'react-router-dom';

export default class Register extends Component {

    state = {
        name: '',
        email: '',
        password: '',
        redirect: false,
        authError: false,
        isLoading: false,
    };

    handleEmailChange = event => {
        this.setState({ email: event.target.value });
    };
    handlePwdChange = event => {
        this.setState({ password: event.target.value });
    };
    handleNameChange = event => {
        this.setState({ name: event.target.value });
    };

    handleSubmit = event => {
        event.preventDefault();
        this.setState({isLoading: true});
        const url = 'http://3.8.16.176:8080/ato-endpoints/registration';
        const email = this.state.email;
        const password = this.state.password;
        const name = this.state.name;
        let bodyFormData = new FormData();
        bodyFormData.set('email', email);
        bodyFormData.set('name', name);
        bodyFormData.set('password', password);
        axios.post(url, bodyFormData)
            .then(result => {
                this.setState({isLoading: false});
                if (result.data.status !== 'fail') {
                    this.setState({redirect: true, authError: true});
                }else {
                    this.setState({redirect: false, authError: true});
                }
            })
            .catch(error => {
                console.log(error);
                this.setState({ authError: true, isLoading: false });
            });
    };

    renderRedirect = () => {
        if (this.state.redirect) {
            return <Redirect to="/" />
        }
    };

    render() {
        const isLoading = this.state.isLoading;
        return (
            
            <div className="login">
            
          
            <section className="LoginSection">
                <div className="box">
                    <div className="content">
                        <h1 className="form-title">ATO Registration</h1>
                        <div className="title-box mb22">
                            <div><label className="label">Register</label></div>
                            <div><Link to={'login'}>Already Registered - Login here</Link></div>
                        </div>
                        <form onSubmit={this.handleSubmit}>
                            <div className='container'>
                           
                            <div class="row">
                        <div class="input-icon">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input type="text" id="inputName" className="form-control" placeholder="Name"  name="name" onChange={this.handleNameChange} required/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-icon">
                        <i class="fa fa-envelope-o" aria-hidden="true"></i>
                        <input id="inputEmail" className={"form-control " + (this.state.authError ? 'is-invalid' : '')} placeholder="Email address" type="text" name="email" onChange={this.handleEmailChange} autoFocus required/>
                        <div className="invalid-feedback">
                                        Please provide a valid Email. or Email Exist
                                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-icon">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" className="form-control" id="inputPassword" placeholder="******"  name="password" onChange={this.handlePwdChange} required/>

                        <div className="invalid-feedback">
                                        Please provide a valid Email. or Email Exist
                                    </div>
                        </div>
                    </div>

                            <div className="d-flex valign-top row">
                            <button className="btn btn-primary btn-block submit" type="submit" disabled={this.state.isLoading ? true : false}>Register &nbsp;&nbsp;&nbsp;
                                    {isLoading ? (
                                        <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                    ) : (
                                        <span></span>
                                    )}
                                </button>
                                <div><a href="forgot-password.html">Forgot Password?</a></div>
                            </div>
                            </div>
                        </form>
                    </div>
        
                </div>
            <p className="login-text-center">Copyright © 2022 ATO. All Rights Reserved. </p>
            </section>  
        
        {this.renderRedirect()}
        </div>

        );
    }
}


