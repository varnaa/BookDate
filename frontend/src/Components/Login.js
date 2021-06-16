import React, { Component } from 'react'
import CustomerService from '../services/CustomerService';

export default class Login extends Component {
    constructor(props){
        super(props);
        this.state={
            "email":"",
            "password":""
        }

        handleChange = (event) => {
            this.setState({ [event.target.name]: event.target.value });
          };


        handleSubmit = (event) => {
            event.preventDefault();
            // makes call to backend api
            CustomerService.login(this.state).then((response) => {
              if (response.status >= 200 && response.status < 300) {
                // gets customer id from backend and stores it in session
                localStorage.setItem("customerId",response.data);
              }else{
                  alert("Invalid user!");
              }
            });
        };
    }
    render() {
        return (
            <div>
                
            </div>
        )
    }
}
