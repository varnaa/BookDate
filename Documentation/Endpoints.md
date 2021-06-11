# REST API Endpoints

#### Customer

- `GET /customers/{customer_id}` - Retrieves a single customer
- `POST /customers` -  Creates new customer
- `PUT /customers/{customer_id}` -  Updates customer
- `DELETE /customer/{customer_id}` - Deletes the customer
<br/>
- `GET /customers/{customer_id}/subscriptions` - Retrievers all the subscriptions of a customer
- `POST /customers/subscriptions/{subscription_id}` - Updates a Subscription
- `DELETE /customers/subscriptions/{subscription_id}` - Deletes a subscription