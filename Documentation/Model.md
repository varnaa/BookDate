# Model

1. Customers
2. Address
3. Subscriptions
4. Plans
5. AddOns
6. Hosted Page

---

#### Customer

- customer_id - string
- display_name - string
- first_name - string
- last_name - string
- email - string
- mobile - int
- shipping_address - entity (1 - 1 mapping )
- billing_address - entity (1 - 1)
- user - entity (1 - 1)

### User

id - int

email - string

password - string

#### Shipping & Billing Address

- street - string
- city - string
- state - string
- zip - int
- country - string

---

#### Subscriptions

- subscription_id - string
- customer_id - string
- activated_at - string
- expires_at - string
- last_billing_at - string
- next_billing_at - string
- end_of_term - boolean
- plan - entity (many - 1)
- List<AddOn<L>> - entity (many - many)

#### Add-On

- addon_code - string
- quantity - string
- price - int
- type - string

#### Plan

- plan_code - string
- plan_description - string
- price - int
- billing_cycles - int

#### Hosted Page

- customer_id - string

- coupon_code - string

- starts_at - string

- Plan - entity

- List<AddOn<L>> - entity

####  
