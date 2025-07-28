import React from 'react';
import './style.css';

export class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div className="main-container">
        <h1>Mall People Counter</h1>

        <div className="row">
          <div className="half-screen vertical">
            <p>People Entered: {this.state.entrycount}</p>
            <button className="green-button" onClick={this.UpdateEntry}>
              Login
            </button>
          </div>

          <div className="half-screen vertical">
            <p>People Exited: {this.state.exitcount}</p>
            <button className="exit-button" onClick={this.UpdateExit}>
              Exit
            </button>
          </div>
        </div>
      </div>
    );
  }
}
