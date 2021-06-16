import React, { Component } from "react";
import CustomerService from "../services/CustomerService";
import Navigationbar from "./Navigationbar";
import { Button } from "react-bootstrap";
export default class Login extends Component {
	constructor(props) {
		super(props);
		this.state = {
			email: "",
			password: "",
		};
	}

	handleChange = (event) => {
		this.setState({ [event.target.name]: event.target.value });
	};

	handleSubmit = (event) => {
		event.preventDefault();
		console.log(this.state);
		CustomerService.login(this.state).then((response) => {
			response = response.data;
			console.log("Customer id =>"+response);
		if(response === "invalid user"){
			alert("Invalid user");
		}else{
			alert("login successfull")
			localStorage.removeItem("customerID");
			localStorage.removeItem("customerId");
			var customerid = JSON.parse(JSON.stringify(response));
			console.log(customerid);
			console.log(customerid.response);
			localStorage.setItem("customerID",customerid.response);
			window.location.replace("/");
		}
		});
		
		
	};
	render() {
		return (
			<div>
				<Navigationbar></Navigationbar>
				<section
					className="u-align-center u-clearfix u-white u-section-1"
					id="carousel_1e5d"
				>
					<div className="u-clearfix u-sheet u-sheet-1">
						<h2 className="u-custom-font u-font-playfair-display u-text u-text-1">
							Login
						</h2>
						<div className="u-border-10 u-border-palette-2-base u-line u-line-horizontal u-line-1"></div>
						<div className="u-expanded-width-xs u-form u-form-1">
							<form
								className="u-clearfix u-form-spacing-20 u-form-vertical u-inner-form"
							>
								<div className="u-form-email u-form-group">
									<label
										for="email-780d"
										className="u-form-control-hidden u-label"
									>
										Email
									</label>
									<input
										type="email"
										placeholder="Enter your email"
										name="email"
										className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
										required="required"
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-2">
									<label
										for="text-22c8"
										className="u-form-control-hidden u-label"
									></label>
									<input
										type="password"
										placeholder="Enter your password"
										name="password"
										required="required"
										className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-align-center u-form-group u-form-submit">
									<Button
										className="u-black u-btn u-btn-submit u-button-style u-custom-font u-heading-font u-hover-palette-2-base u-text-body-alt-color u-text-hover-white u-btn-1"
										onClick={this.handleSubmit}
									>
										login
										<br />
									</Button>
								
								</div>
								<div className="u-form-send-message u-form-send-success">
									You're account has been successfully created
								</div>
								<div className="u-form-send-error u-form-send-message">
									{" "}
									Unable to send your message. Please fix errors then try again.{" "}
								</div>
							</form>
						</div>
					</div>
				</section>
			</div>
		);
	}
}
