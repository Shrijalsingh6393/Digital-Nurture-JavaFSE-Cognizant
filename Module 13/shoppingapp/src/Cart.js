import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { Itemname, Price } = this.props;
    return (
      <tr className="cart-row">
        <td className="item-name">{Itemname}</td>
        <td className="item-price">Rs. {Price}</td>
      </tr>
    );
  }
}

Cart.defaultProps = {
  Itemname: 'Item Unavailable',
  Price: 0
};

export default Cart;
