import React, { Component } from "react";
import CustomerService from "../services/CustomerService";
import Navigationbar from "./Navigationbar";
import { Button } from "react-bootstrap";

export default class Signup extends Component {
	constructor(props) {
		super(props);
		this.state = {
			display_name: "",
			first_name: "",
			last_name: "",
			email: "",
			mobile: 0,
			street: "",
			city: "",
			state: "",
			zip: 0,
			country: "",
			password: "",
			subscriptions: [],
		};
	}

	handleChange = (event) => {
		this.setState({ [event.target.name]: event.target.value });
	};

	handleSubmit = (event) => {
		event.preventDefault();
		CustomerService.postCustomer(this.state).then((response) => {
			if (response.status >= 200 && response.status < 300) {
				window.location.replace("/login");
			} else {
				alert("Unable to sign up!");
			}
		});
	};
	render() {
		return (
			<div>
				<Navigationbar></Navigationbar>
				<section
					className="u-align-center u-clearfix u-white u-section-2"
					id="sec-1eff"
				>
					<div className="u-clearfix u-sheet u-sheet-1">
						<h1 className="u-text u-text-1">SIGN UP</h1>
						<div className="u-form u-form-1">
							<form
								action="#"
								method="POST"
								className="u-clearfix u-form-spacing-20 u-form-vertical u-inner-form"
								style={{ padding: "10px" }}
								source="email"
								name="form"
							>
								<div className="u-form-group u-form-name">
									<label for="name-3b9a" className="u-label">
										First Name
									</label>
									<input
										type="text"
										placeholder="Enter First Name"
										id="name-3b9a"
										name="first_name"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-1"
										required="required"
										name="first_name"
										defaultValue={this.state.first_name}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-2">
									<label for="text-02c6" className="u-label">
										Last Name
									</label>
									<input
										type="text"
										placeholder="Enter Last Name"
										id="text-02c6"
										name="last_name"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2"
										required="required"
										name="last_name"
										defaultValue={this.state.last_name}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-4">
									<label for="text-36af" className="u-label">
										Username
									</label>
									<input
										type="text"
										placeholder="enter username"
										id="text-36af"
										name="display_name"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-4"
										required="required"
										defaultValue={this.state.display_name}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-email u-form-group">
									<label for="email-3b9a" className="u-label">
										Email
									</label>
									<input
										type="email"
										placeholder="Enter a valid email address"
										id="email-3b9a"
										name="email"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-3"
										required="required"
										autoFocus="autofocus"
										defaultValue={this.state.email}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-password u-form-group">
									<label for="email-3b9a" className="u-label">
										Password
									</label>
									<input
										type="password"
										placeholder="Enter a valid password"
										id="email-3b9a"
										name="password"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-3"
										required="required"
										autoFocus="autofocus"
										defaultValue={this.state.password}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-phone u-form-group-5">
									<label for="phone-fbd8" className="u-label">
										Mobile
									</label>
									<input
										type="tel"
										pattern="\+?\d{0,3}[\s\(\-]?([0-9]{2,3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})"
										placeholder="Enter your phone (e.g. +14155552675)"
										id="phone-fbd8"
										name="mobile"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-5"
										required="required"
										defaultValue={this.state.mobile}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-address u-form-group u-form-group-6">
									<label for="address-a023" className="u-label">
										Address
									</label>
									<input
										type="text"
										placeholder="Enter your street"
										id="address-a023"
										name="street"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-6"
										required="required"
										defaultValue={this.state.street}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-address u-form-group u-form-group-7">
									<label
										for="address-724e"
										className="u-form-control-hidden u-label"
									>
										Address
									</label>
									<input
										type="text"
										placeholder="enter your city"
										id="address-724e"
										name="city"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-7"
										required="required"
										defaultValue={this.state.city}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-8">
									<label
										for="text-eaaf"
										className="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="emter your state"
										id="text-eaaf"
										name="state"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-8"
										required="required"
										defaultValue={this.state.state}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-9">
									<label
										for="text-d5e3"
										className="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="enter your zip"
										id="text-d5e3"
										name="zip"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-9"
										required="required"
										defaultValue={this.state.zip}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-form-group u-form-group-10">
									<label
										for="text-c0c6"
										className="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="enter your country"
										id="text-c0c6"
										name="country"
										className="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-10"
										required="required"
										defaultValue={this.state.country}
										onChange={this.handleChange}
									/>
								</div>
								<div className="u-align-center u-form-group u-form-submit">
									<Button
										className="u-border-5 u-border-black u-btn u-btn-rectangle u-btn-submit u-button-style u-gradient u-none u-btn-1"
										onClick={this.handleSubmit}

									>
										SIGN UP
										<br />
									</Button>
								</div>
								<div className="u-form-send-message u-form-send-success">
									{" "}
									Thanks for registering.
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
