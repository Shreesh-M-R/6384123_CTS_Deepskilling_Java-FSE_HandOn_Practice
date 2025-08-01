import React, { useState } from 'react';

function CurrencyConverter() {
  const [amount, setAmount] = useState('');
  const [fromCurrency, setFromCurrency] = useState('INR');
  const [toCurrency, setToCurrency] = useState('USD');
  const [result, setResult] = useState(null);

  const conversionRates = {
    INR: { USD: 0.012, EUR: 0.011, GBP: 0.0095 },
    USD: { INR: 83.33, EUR: 0.92, GBP: 0.79 },
    EUR: { INR: 90.91, USD: 1.09, GBP: 0.86 },
    GBP: { INR: 105.26, USD: 1.27, EUR: 1.16 }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!amount || isNaN(amount)) {
      alert('Please enter a valid amount');
      return;
    }
    const rate = conversionRates[fromCurrency][toCurrency];
    const convertedAmount = parseFloat(amount) * rate;
    setResult(convertedAmount.toFixed(2));
  };

  return (
    <div className="currency-converter">
      <h2>Currency Converter</h2>
      <div className="converter-form">
        <label>Amount:</label>
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          className="input-field"
          placeholder="Enter amount"
        />
        <br/>
        <label>From:</label>
        <select
          value={fromCurrency}
          onChange={(e) => setFromCurrency(e.target.value)}
          className="select-field"
        >
          <option value="INR">INR</option>
          <option value="USD">USD</option>
          <option value="EUR">EUR</option>
          <option value="GBP">GBP</option>
        </select>
        <label>To:</label>
        <select
          value={toCurrency}
          onChange={(e) => setToCurrency(e.target.value)}
          className="select-field"
        >
          <option value="USD">USD</option>
          <option value="INR">INR</option>
          <option value="EUR">EUR</option>
          <option value="GBP">GBP</option>
        </select>
        <button onClick={handleSubmit} className="btn btn-convert">
          Convert
        </button>
        {result && (
          <p className="result">
            {amount} {fromCurrency} = {result} {toCurrency}
          </p>
        )}
      </div>
    </div>
  );
}

export default CurrencyConverter;