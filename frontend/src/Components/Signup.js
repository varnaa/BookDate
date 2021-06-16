import React, { Component } from 'react'
import CustomerService from '../services/CustomerService';

export default class Signup extends Component {
    constructor(props){
        super(props);
        this.state={
            "display_name": "",
            "salutation": "",
            "first_name": "",
            "last_name": "",
            "email": "",
            "mobile": 0,
            "billing_address": {
                "street": "",
                "city": "",
                "state": "",
                "zip": 0,
                "country": ""
            },
            "shipping_address": {
                "street": "",
                "city": "",
                "state": "",
                "zip": 0,
                "country": ""
            },
            "user":{
                "email":"",
                "password":""
            },
            "subscriptions":[]
        }

        handleChange = (event) => {
            this.setState({ [event.target.name]: event.target.value });
          };

        handleSubmit = (event) => {
            event.preventDefault();
            CustomerService.postCustomer(this.state).then((response) => {
              if (response.status >= 200 && response.status < 300) {
                 // todo redirect to login component
              }else{
                  alert("Unable to sign up!");
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
