import React, { Component } from "react";
import CustomerService from "../services/CustomerService";
import Navbar from "./Navbar";
export default class Signup extends Component {
	constructor(props) {
		super(props);
		this.state = {
			display_name: "",
			salutation: "",
			first_name: "",
			last_name: "",
			email: "",
			mobile: 0,
			billing_address: {
				street: "",
				city: "",
				state: "",
				zip: 0,
				country: "",
			},
			shipping_address: {
				street: "",
				city: "",
				state: "",
				zip: 0,
				country: "",
			},
			user: {
				email: "",
				password: "",
			},
			subscriptions: [],
		};

		this.handleChange = (event) => {
			this.setState({ [event.target.name]: event.target.value });
		};

		this.handleSubmit = (event) => {
			event.preventDefault();
			CustomerService.postCustomer(this.state).then((response) => {
				if (response.status >= 200 && response.status < 300) {
					// todo redirect to login component
				} else {
					alert("Unable to sign up!");
				}
			});
		};
	}
	render() {
		return (
			<div>
                <Navbar></Navbar>
				<section
					class="u-align-center u-clearfix u-white u-section-2"
					id="sec-1eff"
				>
					<div class="u-clearfix u-sheet u-sheet-1">
						<h1 class="u-text u-text-1">SIGN UP</h1>
						<div class="u-form u-form-1">
							<form
								action="#"
								method="POST"
								class="u-clearfix u-form-spacing-20 u-form-vertical u-inner-form"
								style={{ padding: "10px" }}
								source="email"
								name="form"
							>
								<div class="u-form-group u-form-name">
									<label for="name-3b9a" class="u-label">
										First Name
									</label>
									<input
										type="text"
										placeholder="Enter First Name"
										id="name-3b9a"
										name="first_name"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-1"
										required="required"
									/>
								</div>
								<div class="u-form-group u-form-group-2">
									<label for="text-02c6" class="u-label">
										Last Name
									</label>
									<input
										type="text"
										placeholder="Enter Last Name"
										id="text-02c6"
										name="last_name"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2"
										required="required"
									/>
								</div>
								<div class="u-form-email u-form-group">
									<label for="email-3b9a" class="u-label">
										Email
									</label>
									<input
										type="email"
										placeholder="Enter a valid email address"
										id="email-3b9a"
										name="email"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-3"
										required="required"
										autofocus="autofocus"
									/>
								</div>
								<div class="u-form-group u-form-group-4">
									<label for="text-36af" class="u-label">
										Username
									</label>
									<input
										type="text"
										placeholder="enter username"
										id="text-36af"
										name="display_name"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-4"
										required="required"
									/>
								</div>
								<div class="u-form-group u-form-phone u-form-group-5">
									<label for="phone-fbd8" class="u-label">
										Mobile
									</label>
									<input
										type="tel"
										pattern="\+?\d{0,3}[\s\(\-]?([0-9]{2,3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})"
										placeholder="Enter your phone (e.g. +14155552675)"
										id="phone-fbd8"
										name="mobile"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-5"
										required="required"
									/>
								</div>
								<div class="u-form-address u-form-group u-form-group-6">
									<label for="address-a023" class="u-label">
										Address
									</label>
									<input
										type="text"
										placeholder="Enter your street"
										id="address-a023"
										name="street"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-6"
										required="required"
									/>
								</div>
								<div class="u-form-address u-form-group u-form-group-7">
									<label
										for="address-724e"
										class="u-form-control-hidden u-label"
									>
										Address
									</label>
									<input
										type="text"
										placeholder="enter your city"
										id="address-724e"
										name="city"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-7"
										required="required"
									/>
								</div>
								<div class="u-form-group u-form-group-8">
									<label
										for="text-eaaf"
										class="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="emter your state"
										id="text-eaaf"
										name="state"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-8"
										required="required"
									/>
								</div>
								<div class="u-form-group u-form-group-9">
									<label
										for="text-d5e3"
										class="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="enter your zip"
										id="text-d5e3"
										name="zip"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-9"
										required="required"
									/>
								</div>
								<div class="u-form-group u-form-group-10">
									<label
										for="text-c0c6"
										class="u-form-control-hidden u-label"
									></label>
									<input
										type="text"
										placeholder="enter your country"
										id="text-c0c6"
										name="country"
										class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-10"
										required="required"
									/>
								</div>
								<div class="u-align-center u-form-group u-form-submit">
									<a
										href="#"
										class="u-border-5 u-border-black u-btn u-btn-rectangle u-btn-submit u-button-style u-gradient u-none u-btn-1"
									>
										SIGN UP
										<br />
									</a>
									<input
										type="submit"
										value="submit"
										class="u-form-control-hidden"
									/>
								</div>
								<div class="u-form-send-message u-form-send-success">
									{" "}
									Thanks for registering.
								</div>
								<div class="u-form-send-error u-form-send-message">
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
