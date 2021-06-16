import axios from "axios";

const CUSTOMER_API_URL="http://localhost:8080/customers/"

class CustomerService{
    getCustomer(customerID){
        return axios.get(CUSTOMER_API_URL+customerID);
    }

    postCustomer(formData){
        return axios.post(CUSTOMER_API_URL, formData , {
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
        return axios.post("/login", formData , {
            headers:{
                "content-type":"application/json"
            },
        });
    }

}
export default new CustomerService();