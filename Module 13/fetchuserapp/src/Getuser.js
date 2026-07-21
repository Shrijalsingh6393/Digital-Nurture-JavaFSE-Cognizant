import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      person: null,
      error: null
    };
  }

  async componentDidMount() {
    const url = 'https://api.randomuser.me/';
    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      this.setState({ person: data.results[0], loading: false });
    } catch (err) {
      console.error('Error fetching random user details:', err);
      // Fallback user structure if endpoint is unreachable or fails
      this.setState({
        person: {
          name: { title: 'Mr', first: 'John', last: 'Doe' },
          picture: { large: 'https://randomuser.me/api/portraits/men/75.jpg' }
        },
        loading: false,
        error: err.message
      });
    }
  }

  render() {
    if (this.state.loading) {
      return (
        <div className="user-card loading-card">
          <p className="status-text">loading...</p>
        </div>
      );
    }

    if (!this.state.person) {
      return (
        <div className="user-card error-card">
          <p className="status-text">didn't get a person</p>
        </div>
      );
    }

    const { name, picture } = this.state.person;

    return (
      <div className="user-card">
        <h2>Random User Details</h2>
        <div className="user-profile">
          <div className="avatar-wrapper">
            <img
              src={picture.large}
              alt={`${name.first}'s profile`}
              className="user-avatar"
            />
          </div>
          <div className="user-details">
            <p className="info-row">
              <span className="label">Title: </span>
              <span className="value">{name.title}</span>
            </p>
            <p className="info-row">
              <span className="label">First Name: </span>
              <span className="value">{name.first}</span>
            </p>
          </div>
        </div>
      </div>
    );
  }
}

export default Getuser;
