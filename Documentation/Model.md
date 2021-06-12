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
- displayName - string 
- firstName - string
- lastName - string
- email - string  
- password - string 
- mobile - int  
- address - entity (1 - 1)
- List<Subscriptions<su>> - entity ( many - many)


#### Address

- street - string
- city - string
- state - string
- zip - int
- country - string

---

#### Subscriptions

- subscription_id - string 
- customer_id - string
- activatedAt - string 
- expiresAt - string
- lastBillingAt - string
- nextBillingAt - string  
- end_of_term - boolean
- plans - entity (many - 1)
- addOns - entity (many - many)

#### Add-Ons
- name - string
- unit - string
- unitName - string
- price - string
- type - string

#### Plans
- planCode - string
- planDescription - string
- price - int
- billingCycles - int


#### Hosted Pages
- customer_id - string
- plan - entity
- addons - entity
- couponCode - string


