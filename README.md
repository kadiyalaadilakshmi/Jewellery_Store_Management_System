# Jewellery Store Management System 

A Java program that simulates a Jewellery Store Management System.  
It allows the management of customer purchases of gold and silver items, generates bills with GST, applies discounts for high-value purchases, and manages cash with proper note deductions.  

Demonstrates **object-oriented programming (OOP)** concepts such as **inheritance, encapsulation, and polymorphism**.

---

## Features 
- Add customer details (ID, name, phone number)
- Manage jewellery items (Gold and Silver) with default pricing
- Calculate item price based on weight
- Generate detailed bill with:
  - Base price
  - GST (3%)
  - Discount for bills > ₹1,00,000
- Accept customer payment and return change
- Deduct cash from available notes and track remaining notes
- Error handling for insufficient payment or change

---

## Classes Overview 
- **`JewelleryItem`** – Base class for jewellery items
- **`GoldItem` / `SilverItem`** – Inherit from `JewelleryItem` with default prices
- **`Customer`** – Stores customer details
- **`Bill`** – Generates bill, calculates GST and discounts
- **`CashManager`** – Manages cash notes and change
- **`Main`** – Runs the program, handles input/output

---

## Usage 
1. Open the project in VS Code.
2. Run the `Main` class.
3. Enter customer details, jewellery type, item details, and weight.
4. The system generates the bill automatically.
5. Enter the payment amount to complete the transaction and return change.

---

## Example Output 
