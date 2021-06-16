import React, { Component } from "react";
import CustomerService from "../services/CustomerService";
import Navbar from "./Navbar";
export default class Login extends Component {
	constructor(props) {
		super(props);
		this.state = {
			email: "",
			password: "",
		};

		this.handleChange = (event) => {
			this.setState({ [event.target.name]: event.target.value });
		};

		this.handleSubmit = (event) => {
			event.preventDefault();
			// makes call to backend api
			CustomerService.login(this.state).then((response) => {
				if (response.status >= 200 && response.status < 300) {
					// gets customer id from backend and stores it in session
					localStorage.setItem("customerId", response.data);
				} else {
					alert("Invalid user!");
				}
			});
		};
	}
	render() {
		return (
			<div>
        <Navbar></Navbar>
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
								action=""
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
                    value={this.state.email}
                    onChange={this.handleChange()}
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
                    value={this.state.password}
										className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"
                    onChange={this.handleChange()}
									/>
								</div>
								<div className="u-align-center u-form-group u-form-submit">
									<a
										href="#"
										className="u-black u-btn u-btn-submit u-button-style u-custom-font u-heading-font u-hover-palette-2-base u-text-body-alt-color u-text-hover-white u-btn-1"
									>
										login
										<br />
									</a>
									<input
										type="submit"
										value="submit"
                    onClick={this.handleSubmit()}
										className="u-form-control-hidden"
									/>
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
