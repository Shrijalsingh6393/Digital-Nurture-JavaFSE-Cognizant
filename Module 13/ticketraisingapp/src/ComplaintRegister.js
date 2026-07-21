import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const { ename, complaint } = this.state;
    if (!ename.trim() || !complaint.trim()) {
      alert('Please enter both Employee Name and Complaint details.');
      return;
    }

    const refNo = Math.floor(100000 + Math.random() * 900000);
    alert(`Thanks ${ename}\nYour Complaint was successfully registered\nTransaction ID is: ${refNo}`);
  }

  render() {
    return (
      <div className="form-card">
        <h2>Register Your Complaint</h2>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="ename">Employee Name:</label>
            <input
              type="text"
              id="ename"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              placeholder="Enter Employee Name"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="complaint">Complaint Details:</label>
            <textarea
              id="complaint"
              name="complaint"
              rows="5"
              value={this.state.complaint}
              onChange={this.handleChange}
              placeholder="Describe your complaint here..."
              required
            />
          </div>

          <button type="submit" className="btn submit-btn">
            Submit Complaint
          </button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
