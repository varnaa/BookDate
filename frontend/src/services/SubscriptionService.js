import axios from "axios";

const CUSTOMER_API_URL = "http://localhost:8080/customers/"
const SUBSCRIPTION_API_URL = "subscriptions/"

class SubscriptionService {

    createNewSubscriptionHostedPage(customerId, formData){
        return axios.post(CUSTOMER_API_URL+customerId+"/"+SUBSCRIPTION_API_URL, formData, {
            headers:{
                "content-type":"application/json"
            }
        })
    }

    createUpdateSubscriptionHostedPage(subscriptionId,formData){
        return axios.post(CUSTOMER_API_URL+SUBSCRIPTION_API_URL+subscriptionId, formData, {
            headers:{
                "content-type":"application/json"
            }
        })
    }

    cancelSubscription(subscriptionId){
        return axios.post(CUSTOMER_API_URL+SUBSCRIPTION_API_URL+subscriptionId+"/cancel", formData, {
            headers:{
                "content-type":"application/json"
            }
        })
    }

    reactivateSubscription(subscriptionId){
        return axios.post(CUSTOMER_API_URL+SUBSCRIPTION_API_URL+subscriptionId+"/reactivate", formData, {
            headers:{
                "content-type":"application/json"
            }
        })
    }



}
export default new SubscriptionService();