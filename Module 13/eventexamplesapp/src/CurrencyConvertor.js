import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      euros: null
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ amount: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const rupees = parseFloat(this.state.amount);
    if (!isNaN(rupees) && rupees >= 0) {
      // Conversion rate: 1 Euro = 90 Indian Rupees -> Euro = rupees / 90
      const convertedEuros = (rupees / 90).toFixed(2);
      this.setState({ euros: convertedEuros });
      alert(`Converting ${rupees} INR to Euro: €${convertedEuros}`);
    } else {
      alert('Please enter a valid numeric amount in Indian Rupees');
    }
  }

  render() {
    return (
      <div className="converter-card">
        <h2>Currency Convertor (Rupees to Euro)</h2>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="amount">Amount in INR (Rupees): </label>
            <input
              id="amount"
              type="number"
              value={this.state.amount}
              onChange={this.handleChange}
              placeholder="Enter amount in Rupees"
              required
            />
          </div>
          <button type="submit" className="btn convert-btn">
            Convert
          </button>
        </form>
        {this.state.euros !== null && (
          <div className="result-box">
            <p>Equivalent Amount in Euro: <strong>€{this.state.euros}</strong></p>
          </div>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
