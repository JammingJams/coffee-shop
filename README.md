**☕ Coffee Shop Ordering System**

**📌 Overview**

This is a console-based Coffee Shop Ordering System built in Java. The application allows users to:

Create and manage customer orders
Select drinks, meals, snacks, and desserts
Customize items with add-ins (sweeteners, creamers, spices, etc.)
Handle inventory tracking
Generate receipts and update stock after checkout

The project demonstrates object-oriented design, including:


Inheritance
Polymorphism
Interfaces
Enums
File I/O
Design patterns (Factory + Maps refactoring)



**🧱 Project Structure**

com.pluralsight
│

├── App.java                  → Entry point

├── Controller

│     └── InventoryLogger.java → Handles file I/O (inventory + receipts)

│

├── View

│     └── MainMenu.java        → User interaction

│     └── ListStorage.java     → Stores maplists

│     └── Display.java         → UI

├── Model

│     ├── Product.java         → Base abstract class

│     ├── ShoppingCart.java    → Cart management

│     │

│     ├── Drinks

│     │   ├── Coffee.java

│     │   └── Tea.java

│     │

│     ├── BreakfastMeals

│     │   ├── BreakfastSandwiches.java

│     │   ├── BakedGoods.java

│     │   └── MeatTypes.java

│     │

│     ├── OtherItems

│     │   ├── Snacks.java

│     │   └── Desserts.java

│     │

│     └── SpecialityItems

│         └── SpecialCoffee.java

│
├── Interface

│     ├── AddIn.java

│     ├── AddRemoveExtras.java

│     ├── AddRemoveExtraMeats.java

│     └── DateTimeLogger.java


**🚀 Features**
**✅ Order Management**


Start a new order
Add items from multiple categories:

Coffee ☕
Tea 🍵
Breakfast 🍳
Snacks 🍟
Desserts 🍰
Specialty drinks




**✅ Customization**


Add or remove:

Sweeteners
Creamers
Spices
Flavorings
Dessert-style toppings


Add extra meats to breakfast items


**✅ Inventory System**


Loads inventory from CSV file
Tracks item availability
Updates stock when items are ordered
Prevents ordering unavailable items


**✅ Checkout System**


Displays total cost
Saves receipt to file
Clears cart after purchase



**📂 Data Files**
Inventory File
src/main/resources/CoffeeShopInventory.csv

Contains:
ClassName|ItemName|Price|ServingSize|Quantity


Receipt File
src/main/resources/Reciept.txt

Each checkout appends:

Purchased items
Total cost
Timestamp



**🛠️ Technologies Used**


Java
Object-Oriented Programming (OOP)
File I/O (BufferedReader / Writer)
Collections (Map, ArrayList)
Enums & Interfaces



**🧠 Design Patterns Used**
✔ Factory Pattern
Used to simplify object creation of:

Coffee
Tea
Food items



✔ Map-Based Lookup
Replaces large switch statements:

Cleaner input handling
Easier scalability
Less error-prone


⚙️ How to Run

Clone or download the project
Open in your IDE (IntelliJ, Eclipse, etc.)
Run:


JavaApp.javaShow more lines



**👨‍💻 Author**
Noah Logan



**📜 License**
This project is for educational purposes.
