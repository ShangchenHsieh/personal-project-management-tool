
import './App.css';
import Dashboard from './components/Dashboard';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route} from "react-router-dom";
import AddProject from './components/Projects/AddProject';
import Header from './components/Layout/Header';
import {Provider} from "react-redux";
import store from "./store"
import React, { Component }  from 'react';
import UpdateProject from './components/Projects/UpdateProject';
import ProjectBoard from './components/ProjectBoard/ProjectBoard';
import AddProjectTask from './components/ProjectBoard/ProjectTasks/AddProjectTask';
import UpdateProjectTask from './components/ProjectBoard/ProjectTasks/UpdateProjectTask';
import Landing from './components/Layout/Landing';
import Register from './components/UserManagement/Register';
import Login from './components/UserManagement/Login';
import jwt_decode from "jwt-decode"
import setJWTToken from './securityUtils/setJWTToken';
import { SET_CURRENT_USER } from './actions/types';
import { logout } from './actions/securityActions';
import secureRoute from './securityUtils/secureRoute';
import SecureRoute from './securityUtils/secureRoute';
import { Switch } from 'react-router-dom';

const jwtToken = localStorage.jwtToken;
if(jwtToken) {
  setJWTToken(jwtToken);
  const decoded_jwtToken = jwt_decode(jwtToken);
  store.dispatch({
    type: SET_CURRENT_USER,
    payload: decoded_jwtToken
  })
  const currentTime = Date.now()/1000;
  if(decoded_jwtToken.exp < currentTime) {
    store.dispatch(logout())
    window.location.href="/";
  }
}

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          {
            // public route
          }
          <Route exact path="/" component={Landing} />
          <Route exact path="/register" component={Register} /> 
          <Route exact path="/login" component={Login} />
          {
            // private route
          }
          <Switch> 
            <SecureRoute exact path="/dashboard" component={Dashboard} />
            <SecureRoute exact path="/addProject" component={AddProject} />
            <SecureRoute exact path="/updateProject/:id" component={UpdateProject} />
            <SecureRoute exact path="/projectBoard/:id" component={ProjectBoard} />
            <SecureRoute exact path="/addProjectTask/:id" component={AddProjectTask} />
            <SecureRoute exact path="/updateProjectTask/:backlog_id/:pt_id" component={UpdateProjectTask} />
          </Switch>
          
        </div>
      </Router>
    </Provider>
  );
}

export default App;
