import React, { Component } from "react";
import Navigationbar from "./Navigationbar";
import {Button} from "react-bootstrap";
import SubscriptionService from "../services/SubscriptionService";

export default class Checkout extends Component {
	constructor(props) {
		super(props);
		var customerId = null;
		if (localStorage.getItem("customerID") === null) {
			window.location.replace("/login");
		}else{
			console.log(localStorage);
			customerId=localStorage.getItem("customerID");
		}
		var existingSubscription = JSON.parse(
			localStorage.getItem("subscriptionObject")
		);
		var planCode = this.props.match.params.planCode;

		if (existingSubscription !== null) {
			this.state = {
				subscription_id: existingSubscription.subscription_id,
				customer_id: customerId,
				plan_code: planCode,
				quantity: existingSubscription.plan_quantity,
				price: 0,
				addon_code: "",
				addon_type: "" ,
				addon_price: 0,
				billing_cycles:existingSubscription.plan.billing_cycles
			};
		} else {
			this.state = {
				subscription_id: null,
				customer_id: customerId,
				plan_code: planCode,
				quantity: 1,
				price: 0,
				addon_code: "",
				addon_type: "",
				addon_price: 0,
				billing_cycles:1
			};
		}
	}

	getPlanPrice = () => {
		if (this.state.plan_code == "reader") {
			this.setState({ price: 499 });
		} else if (this.state.plan_code == "avid-reader") {
			this.setState({ price: 999 });
		} else {
			this.setState({ price: 1999 });
		}
	};

	getAddOnPrice = () => {
		if (this.state.addon_code == "1") {
			this.setState({ addon_price: 199 });
		} else if (this.state.addon_code == "2") {
			this.setState({ addon_price: 399 });
		} else {
			this.setState({ addon_price: 499 });
		}
	};

	handleBillingCycle = (event) =>{
		if(event.target.value="1"){
			this.setState({billing_cycles:1});
		}else if(event.target.value="3"){
			this.setState({billing_cycles:3});
		}else if(event.target.value="6"){
			this.setState({billing_cycles:6});
		}else{
			this.setState({billing_cycles:12});
		}
	}

	componentDidMount() {
		this.getPlanPrice();
	}

	handleChange = (event) => {
		this.setState({ [event.target.name]: event.target.value });
		if(event.target.name == "addon_code"){
			this.getAddOnPrice();
		}
	};

	handleSubmit = (event)=>{
		console.log(this.state);
		var hostedPageurl = "";
		if(this.state.subscription_id == null){
			 SubscriptionService.createNewSubscriptionHostedPage(this.state).then((response) => {
				hostedPageurl = response.data;
				console.log(hostedPageurl);
			});	
		}else{
			console.log("inside else");
			SubscriptionService.createUpdateSubscriptionHostedPage(this.state).then((response) => {
				hostedPageurl = response.data;
				console.log(hostedPageurl);
			});	
		}	
		// localStorage.removeItem("subscriptionObject");
		// // redirect 
		// window.location.replace(hostedPageurl);
	}
	render() {
		return (
			<div>
				<Navigationbar></Navigationbar>
				<section className="u-clearfix u-section-1" id="sec-a116">
					<div className="u-clearfix u-sheet u-sheet-1">
						<div className="u-align-center u-container-style u-expanded-width u-product u-product-1">
							<div className="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xs u-container-layout-1">
								<h1>Product Title</h1>
								<div className="u-product-control u-product-variations u-product-variations-1">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Quantity
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
												defaultValue={this.state.quantity}
												name="quantity"
												onChange={this.handleChange}
											>
												<option name="quantity" value="1">
													1
												</option>
												<option name="quantity" value="2">
													2
												</option>
												<option name="quantity" value="3">
													3
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-2">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Add ons
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
												name="addon_code"
												defaultValue={this.state.addon_code}
												name="addon_code"
												onChange={this.handleChange}
											>
												<option value="">None</option>
												<option value="1">2 - Extra Scented candles</option>
												<option value="2">
													1 small box of book merchandise
												</option>
												<option value="3">
													1 big box of book merchandise
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-3">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Add On Type
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
												defaultValue={this.state.addon_type}
												name="addon_type"
												onChange={this.handleChange}
											>
												<option name="type" value="one_time">
													One Time
												</option>
												<option name="type" value="recurring">
													Recurring
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-4">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Subscripton Type
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
												defaultValue={this.state.billing_cycles}
												name="billing_cycles"
												onChange={this.handleChange}
											>
												<option name="billing_cycles" value="1">
											
													One Time
												</option>
												<option name="billing_cycles" value="3">
											
													Quaterly
												</option>
												<option name="billing_cycles" value="6">
												
													Half Yearly
												</option>
												<option name="billing_cycles" value="12">
											
													Yearly
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<Button
									className="u-black u-btn u-button-style u-product-control u-btn-1"
									onClick={this.handleSubmit}
								>
									SUBSCRIBE
								</Button>
							</div>
						</div>
					</div>
				</section>
			</div>
		);
	}
}
