# REST API Endpoints

#### Customer

- `GET /customers/{customerId}` - Retrieves a single customer
- `POST /customers` - Creates new customer
- `PUT /customers/{customerId}` - Updates customer
- `DELETE /customer/{customerId}` - Deletes the customer
- `GET /customers/{customerId}/subscriptions` - Retrievers all the subscriptions of a customer
- `POST /customers/{customerId}/subscriptions` - Creates new hostedpage for subscription
- `POST /customers/subscriptions/{subscriptionId}` - Creates new hostedpage for updating subscription
- `POST /customers/subscriptions/{subscriptionId}/cancel` - cancels a subscription
- `POST /customers/subscriptions/{subscriptionId}/reactivate` - reactivate a subscription
- `POST /login` - verifies login details
- `POST /confirmsubscription?hostedpage_id=""`  - creates new subscription after payment
- `GET /plans` - retrieves all the plans
- `GET /addons` - retrieves all the addons

