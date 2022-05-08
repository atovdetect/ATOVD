 import React, {Component} from 'react';
  import {Link} from 'react-router-dom';
 import TitleComponent from "./title";


class Login extends Component {
    constructor() {
        super();
 
        this.state = {
            Email: '',
            Password: ''
        }
 
        this.Password = this.Password.bind(this);
        this.Email = this.Email.bind(this);
        this.login = this.login.bind(this);
    }
 
    Email(event) {
        this.setState({ Email: event.target.value })
    }
    Password(event) {
        this.setState({ Password: event.target.value })
    }
    login(event) {
        debugger;
        fetch('http://3.8.16.176:8080/ato-endpoints/login', {
            method: 'post',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                Email: this.state.Email,
                Password: this.state.Password
            })
        }).then((Response) => Response.json())
            .then((result) => {
                console.log(result);
                if (result.Status === 'Invalid')
                    alert('Invalid User');
                else
                    this.props.history.push("/dashboard");
            })
    }
 
    render() {
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
                            <form>
                                <div className='container'>
                                <div className="row mb-0">
                                    <div className="input-icon">
                                        <i className="fa fa-user" aria-hidden="true"></i>
                                        <input className="border-radius-bottom0 margin-bottom-1px" type="text" 
                                                 onChange={this.Email} 
                                                 placeholder="Enter Email" />
                                    <div className="invalid-feedback">
                                        Please provide a valid Email.
                                    </div>
                                    </div>
                                </div>
                                <div className="row mb22">
                                    <div className="input-icon">
                                        <i className="fa fa-unlock-alt" aria-hidden="true"></i>
                                       <input className="border-radius-top0" type="text" 
                                                 onChange={this.Password} 
                                                 placeholder="*******" />
                                    <div className="invalid-feedback">
                                        Please provide a valid Password.
                                    </div>
                                    </div>
                                    {/* <span className="field-validation-error"> Please add error message here</span>  */}
                                </div>
                                <div className="d-flex valign-top row">
                                <button className="btn btn-primary btn-block submit" type="submit" onClick={this.login} >Login
                                    {/* {isLoading ? (
                                        <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                    ) : (
                                        <span></span>
                                    )} */}
                                </button>
                                    <div><a href="forgot-password.html">Forgot Password?</a></div>
                                </div>
                                </div>
                            </form>
                        </div>
            
                    </div>
                <p className="login-text-center">Copyright © 2022 ATO. All Rights Reserved. </p>
                </section>  
            
            {/* {this.renderRedirect()} */}
            </div>


             
            
        );
    }
}
 
export default Login;
