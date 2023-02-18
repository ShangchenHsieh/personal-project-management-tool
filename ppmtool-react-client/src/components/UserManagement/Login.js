import React, { Component } from 'react'

class Login extends Component {
  render() {
    return (
        <div className="login">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <h1 className="display-4 text-center">Log In</h1>
                    <form action="dashboard.html">
                        <div className="form-group">
                            <input type="email" className="form-control form-control-lg" placeholder="Email Address" name="email" />
                        </div>
                        <div className="form-group">
                            <input type="password" className="form-control form-control-lg" placeholder="Password" name="password" />
                        </div>
                        <div class="col-md-12 text-center">
                            <input type="submit" className="btn btn-primary btn-lg mt-4 " />
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
    )
  }
}

export default Login;
