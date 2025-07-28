import React from "react";

export class Cart extends React.Component {
  render() {
    return (
      <table border="1" align="center" cellPadding="10" style={{ color: "green" }}>
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {this.props.item.map((cartItem, index) => (
            <tr key={index}>
              <td>{cartItem.itemname}</td>
              <td>{cartItem.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}
