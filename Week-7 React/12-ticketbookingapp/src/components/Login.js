import React from 'react';

function Login({ onLogin }) {
  return (
    <button onClick={onLogin}>Login</button>
  );
}

export default Login;