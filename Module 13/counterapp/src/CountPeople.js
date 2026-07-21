import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
    this.UpdateEntry = this.UpdateEntry.bind(this);
    this.UpdateExit = this.UpdateExit.bind(this);
  }

  UpdateEntry() {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  UpdateExit() {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div className="counter-container">
        <h1 className="counter-title">Mall Entry & Exit Counter</h1>
        <div className="counter-box">
          <div className="count-section entry-section">
            <button className="btn login-btn" onClick={this.UpdateEntry}>
              Login
            </button>
            <p className="count-text">
              People Entered: <span className="highlight-entry">{this.state.entrycount}</span>
            </p>
          </div>
          <div className="count-section exit-section">
            <button className="btn exit-btn" onClick={this.UpdateExit}>
              Exit
            </button>
            <p className="count-text">
              People Exited: <span className="highlight-exit">{this.state.exitcount}</span>
            </p>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;
