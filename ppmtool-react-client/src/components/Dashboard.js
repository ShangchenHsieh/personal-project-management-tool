import React, { Component } from 'react'
import Header from './Layout/Header';
import Projectitem from './Projects/Projectitem';

class Dashboard extends Component {
  render() {
    return (
        <div>
            <Header />
            <h1 className="alert alert-warning">Welcome to dashboard</h1>
            <Projectitem />
        </div>
    )
  }
}

export default Dashboard;