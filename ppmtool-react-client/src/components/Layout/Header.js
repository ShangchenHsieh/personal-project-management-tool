import React, { Component } from 'react'

class Header extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <div className="container">
            <a className="navbar-brand" href="Dashboard.html">
              Peronsal Project Management Tool
            </a>

            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
              <span className="navbar-toggler-icon" />
            </button>

              <ul className="navbar-nav mr-auto" >
                <li className="nav-item" >
                  <a className="nav-link" href="/dashboard">
                    Dashboard
                  </a>
                </li>
              </ul>

              <ul className="navbar-nav ml-auto">
              
                <li className="nav-item">
                  <a className="nav-link" href="/register.html">
                    Sign Up
                  </a>
                </li>

                <li className="nav-item">
                  <a className="nav-link" href="/login.html">
                    Login
                  </a>
                </li>

              </ul>
            
        </div>
      </nav>
    )
  }
}

export default Header