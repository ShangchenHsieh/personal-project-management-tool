import React, { Component } from 'react'
import Header from './Layout/Header';
import Projectitem from './Projects/Projectitem';
class Dashboard extends Component {
  render() {
    return (
        <div className="projects">
          <Header/>
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Projects</h1>
                <br />
                <a href="ProjectForm.html" className="btn btn-primary">
                  Create a Project
                </a>
                <br />
                <hr />
                <Projectitem />
              </div>
            </div>
          </div>  
        </div>
    )
  }
}

export default Dashboard;