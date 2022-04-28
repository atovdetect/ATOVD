import React, {Component} from 'react';
import axios from 'axios';
 import {Link, Redirect} from 'react-router-dom';
 import TitleComponent from "./title";
export default class Login extends Component {

    state = {
        email: '',
        password: '',
        redirect: false,
        authError: false,
        isLoading: false,
        location: {},
    };

    handleEmailChange = event => {
        this.setState({email: event.target.value});
    };
    handlePwdChange = event => {
        this.setState({password: event.target.value});
    };

    handleSubmit = event => {
        event.preventDefault();
        this.setState({isLoading: true});
        const url = 'https://gowtham-rest-api-crud.herokuapp.com/login';
        const email = this.state.email;
        const password = this.state.password;
        let bodyFormData = new FormData();
        bodyFormData.set('email', email);
        bodyFormData.set('password', password);
        axios.post(url, bodyFormData)
            .then(result => {
                if (result.data.status) {
                    localStorage.setItem('token', result.data.token);
                    this.setState({redirect: true, isLoading: false});
                    localStorage.setItem('isLoggedIn', true);
                }
            })
            .catch(error => {
                console.log(error);
                this.setState({authError: true, isLoading: false});
            });
    };

    // componentDidMount() {
    //     const url = 'https://freegeoip.app/json/';
    //     axios.get(url)
    //         .then(response => {
    //             const location = response.data;
    //             this.setState({ location });
    //         }) 
    //         .catch(error => {
    //             this.setState({ toDashboard: true });
    //             console.log(error);
    //         });
    // }

    renderRedirect = () => {
        if (this.state.redirect) {
            return <Redirect to='/dashboard'/>
        }
    };

    render() {
        const isLoading = this.state.isLoading;
        return (
            <div className="login">
                <TitleComponent title="ATO Login "></TitleComponent>
           
              
                <section className="LoginSection">
                    <div className="box">
                        <div className="content">
                            <h1 className="form-title">ATO Login</h1>
                            <div className="title-box mb22">
                                <div><label className="label">Login</label></div>
                                <div><Link to={'register'}>New user - Register here</Link></div>
                            </div>
                            <form onSubmit={this.handleSubmit}>
                                <div className='container'>
                                <div className="row mb-0">
                                    <div className="input-icon">
                                        <i className="fa fa-user" aria-hidden="true"></i>
                                       <input className={"border-radius-bottom0 margin-bottom-1px " + (this.state.authError ? 'is-invalid' : '')} id="inputEmail" placeholder="Email address" type="text" name="email" onChange={this.handleEmailChange} autoFocus required/>
                                        {/* <label htmlFor="inputEmail">Email address</label> */}
                                    <div className="invalid-feedback">
                                        Please provide a valid Email.
                                    </div>
                                    </div>
                                </div>
                                <div className="row mb22">
                                    <div className="input-icon">
                                        <i className="fa fa-unlock-alt" aria-hidden="true"></i>
                                       <input type="password" className={"border-radius-top0 " + (this.state.authError ? 'is-invalid' : '')} id="inputPassword" placeholder="******" name="password" onChange={this.handlePwdChange} required/>
                                       {/* <label htmlFor="inputPassword">Password</label> */}
                                    <div className="invalid-feedback">
                                        Please provide a valid Password.
                                    </div>
                                    </div>
                                    {/* <span className="field-validation-error"> Please add error message here</span>  */}
                                </div>
                                <div className="d-flex valign-top row">
                                <button className="btn btn-primary btn-block submit" type="submit" disabled={this.state.isLoading ? true : false}>Login &nbsp;&nbsp;&nbsp;
                                    {isLoading ? (
                                        <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                    ) : (
                                        <span></span>
                                    )}
                                </button>
                                    {/* <input type="submit" id="submit-btn" value="Login" class="submit" /> */}
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



