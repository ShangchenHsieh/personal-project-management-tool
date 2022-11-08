import React, { Component } from 'react'

class AddProject extends Component {
  constructor() {
    super();
    this.state={
      projectIdentifier: "",
      projectName: "",
      description: "",
      startDate: "",
      endDate: ""
    }

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({[e.target.name]: e.target.value});
  }

  onSubmit(e) {
    e.preventDefault();
    const newProject = {
      projectIdentifier: this.state.projectIdentifier,
      projectName: this.state.projectName,
      description: this.state.description,
      startDate: this.state.startDate,
      endDate: this.state.endDate 
    }
    console.log(newProject);
  }

  render() {
    return (
      <div>
      {
        //check name attribute in input field
        //create constructor
        //set state
        //set value on input fields
        //create onChange function
        //set onChange on each input field
        //bind on constructor
        //check state change in react extension
      }
        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 mauto">
                <h5 className="display-4 text-center">Create project form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>

                  <div className="form-group">
                    <input type="text" className="form-control form-control-lg" 
                    placeHolder="Project Name" name="projectName" value={this.state.projectName} onChange={this.onChange}/>
                  </div>

                  <div className="form-group">
                    <input type="text" className="form-control form-control-lg" 
                    placeHolder="Unique Project ID" name="projectIdentifier" value={this.state.projectIdentifier} onChange={this.onChange} />
                  </div>

                  <div className="form-group">
                    <textarea className="form-control form-control-lg" 
                    placeHolder="Project Description" name="description" value={this.state.description} onChange={this.onChange}></textarea>
                  </div>

                  <h6>Start Date</h6>
                  <div className="form-group">
                    <input type="date" className="form-control form-control-lg" 
                    name="startDate" value={this.state.startDate} onChange={this.onChange}></input>
                  </div>

                  <h6>Estimate End Date</h6>
                  <div className="form-group">
                    <input type="date" className="form-control form-control-lg" 
                    name="endDate" value={this.state.endDate} onChange={this.onChange}></input>
                  </div>

                  <input type="submit" classname="btn btn-primary btn-block mt-4"></input>

                </form>
              </div>
            </div>
          </div>
        </div>




      </div>
    )
  }
}

export default AddProject;