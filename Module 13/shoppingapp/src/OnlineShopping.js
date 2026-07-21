import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const CartItems = [
      { Itemname: 'Laptop', Price: 55000 },
      { Itemname: 'TV', Price: 45000 },
      { Itemname: 'Washing Machine', Price: 25000 },
      { Itemname: 'Mobile', Price: 15000 },
      { Itemname: 'Fridge', Price: 35000 }
    ];

    return (
      <div className="shopping-container">
        <h1 className="shopping-header">Items Ordered :</h1>
        <table className="shopping-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {CartItems.map((item, index) => (
              <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
