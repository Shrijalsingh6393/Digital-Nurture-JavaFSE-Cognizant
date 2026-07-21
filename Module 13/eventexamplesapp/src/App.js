import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
      pressMessage: ''
    };

    this.incrementValue = this.incrementValue.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleIncrease = this.handleIncrease.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleOnPress = this.handleOnPress.bind(this);
  }

  // Method a: Increment value
  incrementValue() {
    this.setState((prevState) => ({ counter: prevState.counter + 1 }));
  }

  // Method b: Say Hello message
  sayHello() {
    alert("Hello! Static Welcome Message from Event Handler.");
  }

  // Invokes multiple methods upon clicking Increase button
  handleIncrease() {
    this.incrementValue();
    this.sayHello();
  }

  // Decrement counter
  handleDecrement() {
    this.setState((prevState) => ({ counter: prevState.counter - 1 }));
  }

  // Function taking argument ('welcome')
  sayWelcome(msg) {
    alert(`Received Argument: ${msg}`);
  }

  // Synthetic Event OnPress handler
  handleOnPress(e) {
    alert(`Synthetic Event (${e.type}) Triggered: I was clicked`);
    this.setState({ pressMessage: "I was clicked" });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>React Event Examples Application</h1>
        </header>

        <main className="App-main">
          {/* Section 1: Counter & Multi-Method Invocation */}
          <section className="card-section">
            <h2>1. Counter & Multi-Method Execution</h2>
            <div className="counter-display">
              <p>Counter Value: <strong>{this.state.counter}</strong></p>
            </div>
            <div className="button-group">
              <button className="btn inc-btn" onClick={this.handleIncrease}>
                Increment (Multi-Method)
              </button>
              <button className="btn dec-btn" onClick={this.handleDecrement}>
                Decrement
              </button>
            </div>
          </section>

          {/* Section 2: Argument Passing */}
          <section className="card-section">
            <h2>2. Event Handler with Arguments</h2>
            <button className="btn welcome-btn" onClick={() => this.sayWelcome('welcome')}>
              Say Welcome
            </button>
          </section>

          {/* Section 3: Synthetic Event Handling */}
          <section className="card-section">
            <h2>3. Synthetic Event (OnPress / OnClick)</h2>
            <button className="btn press-btn" onClick={this.handleOnPress}>
              OnPress Event
            </button>
            {this.state.pressMessage && (
              <p className="press-output">{this.state.pressMessage}</p>
            )}
          </section>

          {/* Section 4: Currency Convertor */}
          <section className="card-section">
            <CurrencyConvertor />
          </section>
        </main>
      </div>
    );
  }
}

export default App;
