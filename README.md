# 💻 Computer Accessories Shop System (Java OOP)

## 📖 Overview
This project is a terminal-based (CLI) Computer Accessories Shop Management System built with Core Java. The system deeply applies **Object-Oriented Programming (OOP)** principles to construct a highly cohesive, loosely coupled e-commerce domain model. It fully simulates a transaction loop—from browsing products and checking inventory to processing payments—by abstracting product catalogs, utilizing polymorphic payment gateways, and implementing basic Role-Based Access Control (RBAC).

## ✨ Key Features

* **Role-Based Access Control (RBAC)**:
    * Abstracted `User` base class with `Admin` and `Customer` entities.
    * The system dynamically routes permissions based on the logged-in user's identity, preventing unauthorized access.
* **Hidden Administrative Backdoor**:
    * A secure, pre-configured command code (`888`) grants authorized administrators (e.g., the built-in `admin1` account) access to a secure backend interface for dynamic inventory data entry.
* **Strategy Pattern in Payments**:
    * Defines a unified `PaymentMethod` interface.
    * Implements `PayPal` (email routing) and `CreditCard` (Card Number/CVV validation) strategies, allowing horizontal scaling of business logic without modifying the core checkout flow.
* **Polymorphism & Collections**:
    * Uses `List<Product>` to uniformly manage heterogeneous data types like `Keyboard` and `Mouse`.
    * Leverages polymorphic `toString()` overriding to standardize the output of product specifications.
* **Robust Exception Handling**:
    * Incorporates `try-catch` mechanisms in core interaction flows (e.g., barcode parsing, inventory entry) to prevent system crashes caused by dirty data injection.

## 🏗️ Architecture & Class Design

The system is divided into the following core modules based on their responsibilities:

* **Domain Models**
    * `Product` (Abstract): Defines common SKU attributes (Barcode, Brand, Price, etc.).
    * `Keyboard` / `Mouse`: Concrete product implementations containing specific business fields (e.g., layout, number of buttons).
    * `Address`: An independent Value Object to decouple shipping logic.
* **Enums**
    * `ConnectivityType` (WIRED/WIRELESS) / `ProductCategory` (MOUSE/KEYBOARD): Standardizes data dictionaries to avoid magic strings.
* **Payment Services**
    * `PaymentMethod` (Interface): Exposes the `processPayment()` contract.
    * `Receipt`: A transaction voucher entity encapsulating the checkout snapshot.
* **Controller Layer**
    * `Main`: The entry point of the application, responsible for initializing mock data, maintaining session state, and controlling the I/O event loop.

## 🚀 Getting Started

### Prerequisites
* **JDK**: Java 8 or higher.
* **IDE**: IntelliJ IDEA, Eclipse, or simply a standard terminal.

### Compilation & Execution
```bash
# 1. Compile all Java files
javac *.java

# 2. Run the application
java Main
