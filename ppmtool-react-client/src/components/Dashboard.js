import React, { Component } from 'react'
import CreateProjectButton from './Projects/CreateProjectButton';
import Projectitem from './Projects/Projectitem';
class Dashboard extends Component {
  render() {
    return (
        <div className="projects">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Projects</h1>
                <br />
                <CreateProjectButton />
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