** Overview

The Hotel Reservation System is a Java-based application that simulates hotel booking operations. It allows management of rooms, reservations, payments, and different room types.

This project demonstrates object-oriented programming principles such as inheritance, encapsulation, and modular design.

** Features
Create and manage hotel rooms
Support for multiple room types:
Standard Room
Deluxe Room
Suite Room
Make reservations
Handle customer payments
Database connection support (via DBConnection.java)
Simple console-based interaction (via Main.java)
** Project Structure
CodeAlpha_HotelReservationSystem/
│
├── src/
│   ├── DBConnection.java      # Handles database connectivity
│   ├── DeluxeRoom.java       # Deluxe room implementation
│   ├── Hotel.java            # Core hotel management logic
│   ├── Main.java             # Entry point of the application
│   ├── Payment.java          # Payment processing logic
│   ├── Reservation.java      # Reservation details and logic
│   ├── Room.java             # Base class for rooms
│   ├── StandardRoom.java     # Standard room implementation
│   └── SuiteRoom.java        # Suite room implementation
│
└── README.md
** Getting Started
Prerequisites
Java JDK 8 or higher
Eclipse IDE (or any Java IDE)
Running the Project
Clone or download the repository
Open the project in Eclipse

Navigate to:

src → Main.java
Run the Main class
** OOP Concepts Used
Inheritance → Room → StandardRoom, DeluxeRoom, SuiteRoom
Encapsulation → Private fields with getters/setters
Abstraction → General room behavior defined in Room
Polymorphism → Different room pricing/behavior
** Payment Flow
User selects a room
Creates a reservation
Payment is processed via Payment.java
Booking is confirmed
** Database Integration
Managed using DBConnection.java
Can be extended to connect with MySQL or other databases
