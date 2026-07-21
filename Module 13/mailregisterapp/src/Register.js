import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      password: '',
      errors: {
        name: '',
        email: '',
        password: ''
      }
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.validateField = this.validateField.bind(this);
  }

  validateField(fieldName, value) {
    let errorMsg = '';
    switch (fieldName) {
      case 'name':
        if (value.length < 5) {
          errorMsg = 'Name should have at least 5 characters';
        }
        break;
      case 'email':
        if (!value.includes('@') || !value.includes('.')) {
          errorMsg = 'Email should contain @ and .';
        }
        break;
      case 'password':
        if (value.length < 8) {
          errorMsg = 'Password should have at least 8 characters';
        }
        break;
      default:
        break;
    }
    return errorMsg;
  }

  handleChange(event) {
    const { name, value } = event.target;
    const errorMsg = this.validateField(name, value);

    this.setState((prevState) => ({
      [name]: value,
      errors: {
        ...prevState.errors,
        [name]: errorMsg
      }
    }));
  }

  handleSubmit(event) {
    event.preventDefault();
    const { name, email, password } = this.state;

    const nameError = this.validateField('name', name);
    const emailError = this.validateField('email', email);
    const passwordError = this.validateField('password', password);

    if (nameError || emailError || passwordError) {
      this.setState({
        errors: {
          name: nameError,
          email: emailError,
          password: passwordError
        }
      });
      alert('Validation Failed! Please correct the errors in the form.');
    } else {
      alert(`Registration Successful!\nWelcome, ${name}\nEmail: ${email}`);
    }
  }

  render() {
    const { name, email, password, errors } = this.state;

    return (
      <div className="register-card">
        <h2>Mail Registration Form</h2>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              name="name"
              value={name}
              onChange={this.handleChange}
              placeholder="Enter name (min 5 chars)"
            />
            {errors.name && <span className="error-message">{errors.name}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="text"
              id="email"
              name="email"
              value={email}
              onChange={this.handleChange}
              placeholder="Enter email (must have @ and .)"
            />
            {errors.email && <span className="error-message">{errors.email}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              name="password"
              value={password}
              onChange={this.handleChange}
              placeholder="Enter password (min 8 chars)"
            />
            {errors.password && <span className="error-message">{errors.password}</span>}
          </div>

          <button type="submit" className="btn register-btn">
            Register
          </button>
        </form>
      </div>
    );
  }
}

export default Register;
