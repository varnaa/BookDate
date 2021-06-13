# REST API Endpoints

#### Customer

- `GET /customers/{customerId}` - Retrieves a single customer
- `POST /customers` - Creates new customer
- `PUT /customers/{customerId}` - Updates customer
- `DELETE /customer/{customerId}` - Deletes the customer
- `GET /customers/{customerId}/subscriptions` - Retrievers all the subscriptions of a customer
- `POST /customers/subscriptions/{subscription_id}` - Updates a Subscription
- `DELETE /customers/subscriptions/{subscription_id}` - Deletes a subscription