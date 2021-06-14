# REST API Endpoints

#### Customer

- `GET /customers/{customerId}` - Retrieves a single customer
- `POST /customers` - Creates new customer
- `PUT /customers/{customerId}` - Updates customer
- `DELETE /customer/{customerId}` - Deletes the customer
- `GET /customers/{customerId}/subscriptions` - Retrievers all the subscriptions of a customer
- `POST /customers/{customerId}/subscriptions` - Creates new subscription
- `POST /customers/subscriptions/{subscriptionId}` - Updates a Subscription 
- `POST /customers/subscriptions/{subscriptionId}/cancel` - cancels a subscription
- `POST /customers/subscriptions/{subscriptionId}/reactivate` - reactivate a subscription

