import axios from "axios";

const CUSTOMER_API_URL="http://localhost:8080/customers/"

class CustomerService{
    getCustomer(customerID){
        return axios.get(CUSTOMER_API_URL+customerID);
    }

    postCustomer(formData){
        var customer = {
                "display_name": formData.display_name,
                "first_name": formData.first_name,
                "last_name": formData.last_name,
                "email": formData.email,
                "mobile": formData.mobile,
                "billing_address": {
                    "street": formData.street,
                    "city": formData.city,
                    "state": formData.state,
                    "zip": formData.zip,
                    "country": formData.country
                },
                "shipping_address": {
                    "street": formData.street,
                    "city": formData.city,
                    "state": formData.state,
                    "zip": formData.zip,
                    "country": formData.country
                },
                "user":{
                    "email":formData.email,
                    "password":formData.password
                },
                "subscriptions":[]
            };
        return axios.post(CUSTOMER_API_URL, customer , {
            headers:{
                "content-type":"application/json"
            },
        });
    }

    putCustomer(customerID, formData){
        return axios.put(CUSTOMER_API_URL+customerID, formData, {
            headers:{
            "content-type":"application/json",
            },
        });
    }


    deleteCustomer(customerId){
        return axios.delete(CUSTOMER_API_URL+customerId);
    }


    login(formData){
        return axios.post("http://localhost:8080/login", formData , {
            headers:{
                "content-type":"application/json"
            },
        });
    }

}
export default new CustomerService();