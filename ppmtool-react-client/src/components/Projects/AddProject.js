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
                <form>

                  <div className="form-group">
                    <input type="text" className="form-control form-control-lg" placeHolder="Project Name" name="projectName"/>
                  </div>

                  <div className="form-group">
                    <input type="text" className="form-control form-control-lg" placeHolder="Unique Project ID" name="projectIdentifier"/>
                  </div>

                  <div className="form-group">
                    <textarea className="form-control form-control-lg" placeholder="Project Description" name="description"></textarea>
                  </div>

                  <h6>Start Date</h6>
                  <div className="form-group">
                    <input type="date" className="form-control form-control-lg" name="start_date"></input>
                  </div>

                  <h6>Estimate End Date</h6>
                  <div className="form-group">
                    <input type="date" className="form-control form-control-lg" name="end_date"></input>
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