# 🛒 Java E-commerce Checkout System (MVC)

A clean, object-oriented Java application following the **MVC (Model-View-Controller)** architecture. This mini e-commerce system simulates a checkout process, including product handling, cart operations, shipping cost calculation, and customer payment.

---

## 📌 Features

- Add products to a cart
- Expirable and non-expirable products
- Stock availability and expiration checks
- Shipping cost calculation
- Balance checking and deduction
- Clean checkout receipt
- Error handling (e.g. expired items, out-of-stock, insufficient balance)

---

## 🧱 MVC Project Structure

```
ecommerce/
└── src/
    └── main/
        └── java/
            ├── App.java                           # Entry point (Console-based View)
            │
            ├── controller/                        # Controller Layer
            │   └── CheckoutController.java        # Handles user checkout and interaction logic
            │
            ├── model/                             # Model Layer
            │   ├── Product.java                   # Base product class
            │   ├── ExpirableProduct.java          # Products with expiration date
            │   ├── NonExpirableProduct.java       # Products without expiration
            │   ├── Shippable.java                 # Interface for shippable products
            │   ├── ShippableProduct.java          # Concrete product that is shippable
            │   ├── CartItem.java                  # Represents an item in the cart
            │   └── Cart.java                      # Represents the entire shopping cart
            │
            ├── service/                           # Service Layer (Business Logic)
            │   ├── CheckoutService.java           # Business rules for checkout process
            │   └── ShippingService.java           # Handles shipping logic and calculations
            │
            └── customer/                          # Domain Entity: Customer
                └── Customer.java                  # Customer class with balance and pay logic

```

---

## 📂 MVC Overview

- **Model**: Contains the core domain logic and data (products, cart, customer).
- **View**: Currently the `App.java`, responsible for displaying output to the user (via console).
- **Controller**: Handles user input and coordinates between model and service (`CheckoutController.java`).
- **Service**: Business rules and operations (`CheckoutService`, `ShippingService`).

---

## ▶️ How to Run

1. Navigate to the `src` folder:
   ```bash
   cd ecommerce/src
   ```
2. Compile and run:
   ```bash
   javac App.java && java App
   ```

---

## 📦 Example Output

```
** Shipment notice **
3.0x TV               15000g
2.0x Cheese             400g
Total package weight: 15.4kg

** Checkout receipt **
2x Cheese            400.00
3x TV                9000.00
1x Scratch Card      50.00
----------------------
Subtotal: 3250.0
Shipping: 462.0
Amount: 3712.0
```

---

## 🧠 Concepts Used

- MVC architecture
- Object-Oriented Programming (OOP)
- Abstraction, inheritance, interfaces
- Console-based application design

---



## 🧪 Test Cases



### Test Summary Table

| Test Case | Scenario                                | Type       | Outcome             |
|-----------|------------------------------------------|------------|-----------------------------|
| TC1       | Mixed products, valid checkout           | ✅ Positive | Success + Receipt + Shipping |
| TC2       | Expired product in cart                  | ❌ Negative | Error: Product is expired    |
| TC3       | Requested quantity exceeds stock         | ❌ Negative | Error: Not enough stock      |
| TC4       | Cart is empty                            | ❌ Negative | Error: Cart is empty         |
| TC5       | Customer balance too low                 | ❌ Negative | Error: Insufficient balance  |
| TC6       | Only non-shippable products              | ✅ Positive | Success + No shipping notice |

---

## ✅ Test Case 1: Successful Checkout with Mixed Products
**Scenario**: Valid products (shippable and non-shippable), sufficient balance  
**Cart**:
- 2x Cheese @ 100 (0.4kg each)
- 3x TV @ 1000 (5kg each)
- 1x Scratch Card @ 50  
  **Customer Balance**: 4000

**Output**:
```
** Shipment notice **
2x Cheese 800g
3x TV 15.0kg
Total package weight: 15.8kg

** Checkout receipt **
2x Cheese 200.0
3x TV 3000.0
1x Scratch Card 50.0
----------------------
Subtotal: 3250.0
Shipping: 474.0
Amount: 3724.0
Remaining Balance: 276.0
END
```

---

## ❌ Test Case 2: Expired Product
**Scenario**: Product has expired  
**Cart**:
- 1x Cheese (expired)

**Output**:
```
Error: Cheese is expired.
```

---

## ❌ Test Case 3: Out of Stock
**Scenario**: Requested quantity exceeds available stock  
**Cart**:
- 3x TV (only 2 in stock)

**Output**:
```
Error: Not enough stock for TV
```

---

## ❌ Test Case 4: Empty Cart
**Scenario**: No items in cart

**Output**:
```
Error: Cart is empty.
```

---

## ❌ Test Case 5: Insufficient Balance
**Scenario**: Customer cannot afford checkout  
**Cart**:
- 1x TV @ 1000  
  **Customer Balance**: 100

**Output**:
```
Error: Insufficient balance.
```

---

## ✅ Test Case 6: Only Non-Shippable Products
**Scenario**: Only digital or non-shippable items  
**Cart**:
- 2x Scratch Card @ 50  
  **Customer Balance**: 4000

**Output**:
```
** Checkout receipt **
2x Scratch Card 100.0
----------------------
Subtotal: 100.0
Shipping: 0.0
Amount: 100.0
Remaining Balance: 3900.0
END
```



## 👤 Author

**Youssef Ali Mamdouh**