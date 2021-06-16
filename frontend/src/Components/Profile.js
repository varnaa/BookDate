import React, { Component } from "react";
import SubscriptionService from "../services/SubscriptionService";
import { Button } from "react-bootstrap";
import Navigationbar from "./Navigationbar";

export default class Profile extends Component {
	constructor(props) {
		super(props);
		if (localStorage.getItem("customerID") == null) {
			window.location.replace("/login");
		}
		this.state = {
			customerId: localStorage.getItem("customerID"),
			subscriptionsList: [],
		};
	}

	handleChange = (event) => {
		this.setState({ [event.target.name]: event.target.value });
	};

	componentDidMount() {
		SubscriptionService.getSubscriptions(
			localStorage.getItem("customerID")
		).then((response) => {
			this.setState({ subscriptionsList: response.data });
		});
	}

	handleEdit = (subscription) => {
		localStorage.setItem("subscriptionObject", JSON.stringify(subscription));
		window.location.replace("/checkout/" + subscription.plan.plan_code);
	};

	handleCancel = (subscription) => {
		SubscriptionService.cancelSubscription(subscription);
		window.location.replace("/profile");
	};

	handleReactivate = (subscription) => {
		SubscriptionService.reactivateSubscription(subscription);
		window.location.replace("/profile");
	};

	render() {
		return (
			<div>
				<Navigationbar></Navigationbar>
				<h1 align="center">Your Subscriptons</h1>
				{console.log("inside render", this.state.subscriptionsList)}
				{this.state.subscriptionsList != undefined &&
					this.state.subscriptionsList != null &&
					this.state.subscriptionsList != [] &&
					this.state.subscriptionsList.map((subscription) => (
						<div
							align="center"
							style={{ border: "300px", margin: "200px" }}
							key={subscription.subscription_id}
						>
							
							<ul>
								<li>
									Plan
									<li>
										<b>Plan price:&nbsp;&nbsp;</b>
										{subscription.plan.price}
									</li>
									<li>
										<b>No:of subcription months left:&nbsp;&nbsp;</b>
										{subscription.plan.billing_cycles}
									</li>
								</li>
								<li>
									<b>Activated At:&nbsp;&nbsp;&nbsp;&nbsp; </b>{" "}
									{subscription.activated_at}
								</li>
								<li>
									<b>Plan Status:&nbsp;&nbsp;&nbsp;&nbsp; </b>{" "}
									{subscription.status}
								</li>
								<li>
									<b>Expires At:&nbsp;&nbsp;&nbsp;&nbsp;</b>
									{subscription.expires_at}
								</li>
								<li>
									<b>Last Billing Date:&nbsp;&nbsp;&nbsp;&nbsp;</b>
									{subscription.last_billing_at}
								</li>
								<li>
									<b>Next Billing Date:&nbsp;&nbsp;&nbsp;&nbsp;</b>
									{subscription.next_billing_at}
								</li>
								<li>{subscription.end_of_term}</li>
								{subscription.addOns != undefined &&
									subscription.addOns != [] &&
									subscription.addOns.map((addon) => (
										<li>
											<ul>
												<li>{addon.addon_code}</li>
												<li>{addon.quantity}</li>
												<li>{addon.type}</li>
											</ul>
										</li>
									))}
								<Button onClick={() => this.handleEdit(subscription)}>
									Edit
								</Button>
								&nbsp;&nbsp;
								{subscription.status === "live" ? (
									<Button onClick={() => this.handleCancel(subscription)}>
										Cancel
									</Button>
								) : (
									<Button onClick={() => this.handleReactivate(subscription)}>
										Reactivate
									</Button>
								)}
							</ul>
							<hr />
						</div>
					))}
				{(this.state.subscriptionsList == undefined ||
					this.state.subscriptionsList == null) && <h1>No Data Found</h1>}
			</div>
		);
	}
}
