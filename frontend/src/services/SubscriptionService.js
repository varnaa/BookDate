import axios from "axios";

const CUSTOMER_API_URL = "http://localhost:8080/customers/";
const SUBSCRIPTION_API_URL = "subscriptions/";

class SubscriptionService {
	createNewSubscriptionHostedPage(formData) {
		var addons =
			formData.addon_code == ""
				? null
				: [
						{
							addon_code: formData.addon_code,
							type: formData.addon_type,
							price: formData.addon_price,
							quantity: 1,
						},
				  ];
		var hostedpage = {
			customer_id: formData.customer_id,
			plan: {
				plan_code: formData.plan_code,
				price: formData.price,
				quantity: formData.quantity,
				billing_cycles: formData.billing_cycles,
			},
			addons: addons,
			coupon_code: "",
		};
		console.log(hostedpage);
		return axios.post(
			CUSTOMER_API_URL + hostedpage.customer_id + "/" + SUBSCRIPTION_API_URL,
			hostedpage,
			{
				headers: {
					"content-type": "application/json",
				},
			}
		);
	}

	createUpdateSubscriptionHostedPage(formData) {
		var addons =
			formData.addon_code == ""
				? null
				: [
						{
							addon_code: formData.addon_code,
							type: formData.addon_type,
							price: formData.addon_price,
							quantity: 1,
						},
				  ];
		var hostedpage = {
			subscription_id: formData.subscription_id,
			customer_id: formData.customer_id,
			plan: {
				plan_code: formData.plan_code,
				price: formData.price,
				quantity: formData.quantity,
				billing_cycles: formData.billing_cycles,
			},
			addons: addons,
		};
		console.log(hostedpage);
		return axios.post(
			CUSTOMER_API_URL +
				hostedpage.customer_id +
				"/" +
				SUBSCRIPTION_API_URL +
				hostedpage.subscription_id,
			hostedpage,
			{
				headers: {
					"content-type": "application/json",
				},
			}
		);
	}

	cancelSubscription(subscription) {
		return axios.post(
			CUSTOMER_API_URL + subscription.customer_id + "/" + SUBSCRIPTION_API_URL + subscription.subscription_id + "/cancel",
			{
				headers: {
					"content-type": "application/json",
				},
			}
		);
	}

	reactivateSubscription(subscription) {
		return axios.post(
			CUSTOMER_API_URL + subscription.customer_id + "/" + SUBSCRIPTION_API_URL + subscription.subscription_id + "/reactivate",
			{
				headers: {
					"content-type": "application/json",
				},
			}
		);
	}

	getSubscriptions(customerId) {
		console.log(customerId);
		var RESOURCE = CUSTOMER_API_URL + customerId + "/" + SUBSCRIPTION_API_URL;
		console.log(RESOURCE);
		return axios.get(RESOURCE);
	}
}
export default new SubscriptionService();
