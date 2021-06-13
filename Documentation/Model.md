# Model

1. Customers
2. Address   
3. Subscriptions
4. Plans   
5. AddOns
6. Hosted Page
---

#### Customer

- customerId - string
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
- customerId - string
- activatedAt - string
- expiresAt - string
- lastBillingAt - string
- nextBillingAt - string
- endOfTerm - boolean
- plan - entity (many - 1)
- List<AddOn<L>> - entity (many - many)

#### Add-On

- addOnCode - string
- unit - string
- unitName - string
- price - string
- type - string

#### Plan

- planCode - string
- planDescription - string
- price - int
- billingCycles - int

#### Hosted Page

- customerId - string
- plan - entity
- List<Addon> - entity
- couponCode - string
- subscriptionId - string

