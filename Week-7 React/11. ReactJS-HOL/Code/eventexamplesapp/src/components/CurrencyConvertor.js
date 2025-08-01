import React, { Component } from 'react';

   class CurrencyConvertor extends Component {
       constructor(props) {
           super(props);
           this.state = {
               rupees: '',
               euros: null
           };

           // Bind event handlers
           this.handleInputChange = this.handleInputChange.bind(this);
           this.handleSubmit = this.handleSubmit.bind(this);
       }

       // Handle input change
       handleInputChange(event) {
           this.setState({
               rupees: event.target.value
           });
       }

       // Handle form submission and conversion
       handleSubmit(event) {
           event.preventDefault(); // Prevent page reload
           const conversionRate = 0.011; // Approximate INR to EUR rate (1 INR = 0.011 EUR)
           const euros = parseFloat(this.state.rupees) * conversionRate;
           this.setState({
               euros: euros ? euros.toFixed(2) : null
           });
       }

       render() {
           return (
               <div>
                   <h2>Currency Convertor</h2>
                   <form onSubmit={this.handleSubmit}>
                       <label>
                           Indian Rupees (INR):
                           <input
                               type="number"
                               value={this.state.rupees}
                               onChange={this.handleInputChange}
                               style={{ margin: '10px', padding: '5px' }}
                               placeholder="Enter amount"
                           />
                       </label>
                       <button
                           type="submit"
                           style={{
                               padding: '10px 20px',
                               backgroundColor: '#28a745',
                               color: 'white',
                               border: 'none',
                               borderRadius: '5px',
                               cursor: 'pointer'
                           }}
                       >
                           Convert
                       </button>
                   </form>
                   {this.state.euros && (
                       <p>
                           {this.state.rupees} INR = {this.state.euros} EUR
                       </p>
                   )}
               </div>
           );
       }
   }

   export default CurrencyConvertor;