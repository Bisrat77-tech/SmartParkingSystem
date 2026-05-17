# 🅿️ Smart Parking System

<div align="center">

![Java Version](https://img.shields.io/badge/Java-8%2B-blue.svg)
![OOP](https://img.shields.io/badge/OOP-Comprehensive-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
[![GitHub stars](https://img.shields.io/github/stars/yourusername/Smart-Parking-System)](https://github.com/yourusername/Smart-Parking-System/stargazers)

**A comprehensive Java-based Smart Parking Management System demonstrating all core OOP concepts**

</div>

---

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [OOP Concepts Demonstrated](#oop-concepts-demonstrated)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [Usage Guide](#usage-guide)
- [Class Descriptions](#class-descriptions)
- [Sample Output](#sample-output)
- [Error Handling](#error-handling)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [Author](#author)
- [Acknowledgments](#acknowledgments)

## 🎯 Project Overview

The **Smart Parking System** is a console-based application that efficiently manages vehicle parking in a parking lot. It supports multiple vehicle types (Cars, Motorcycles, Trucks), calculates dynamic parking fees based on vehicle type and duration, processes payments, and provides real-time tracking of parking spot availability.

This project was developed as part of **BITS-OOP Task #3** to demonstrate mastery of Object-Oriented Programming concepts through a practical, real-world application.

### Key Highlights
- ✅ **100% Java** implementation
- ✅ **No external dependencies** - pure Java
- ✅ **Production-ready** code structure
- ✅ **Comprehensive error handling**
- ✅ **Modular design** following best practices

## ✨ Features

### Core Functionality
- **Multi-vehicle Support** - Park Cars, Motorcycles, and Trucks
- **Dynamic Pricing** - Different rates for different vehicle types
  - Cars: $2/hour (20% discount for electric vehicles)
  - Motorcycles: $1/hour
  - Trucks: $5/hour (50% extra for heavy trucks >3.5 tons)
- **Smart Spot Allocation** - Automatic assignment of available parking spots
- **Spot Types** - Standard, Electric, and Handicap spots available
- **Payment Processing** - Integrated payment system with change calculation
- **Real-time Status** - View parked vehicles and available spots
- **Revenue Tracking** - Track total revenue collected

### Technical Features
- **Input Validation** - Robust error handling for all user inputs
- **License Plate Validation** - Format checking (3-10 chars, alphanumeric)
- **Exception Handling** - Comprehensive try-catch blocks
- **Memory Management** - Efficient use of ArrayLists

## 🎓 OOP Concepts Demonstrated

| Concept | Implementation Location | Description |
|---------|------------------------|-------------|
| **Encapsulation** | `Vehicle.java` | Private variables with public getters/setters |
| **Inheritance** | `Car.java`, `Motorcycle.java`, `Truck.java` | Child classes extending `Vehicle` |
| **Polymorphism** | `ParkingLot.parkVehicle()` | Method accepting any `Vehicle` subtype |
| **Abstraction** | `Vehicle.java` | Abstract class with abstract methods |
| **Constructors** | All classes | Parameterized constructors with `super()` calls |
| **Method Overriding** | `calculateParkingFee()` | Each vehicle type implements its own logic |
| **Packages** | `com.smartparking.*` | Organized into models, services, utils |
| **Access Modifiers** | All classes | `private`, `protected`, `public` properly used |
| **Collections** | `ParkingLot.java` | `ArrayList<ParkingSpot>` and `ArrayList<Vehicle>` |
| **Exception Handling** | `Main.java`, `InputValidator.java` | try-catch blocks for input validation |
| **User Input** | `Main.java` | `Scanner` class for interactive console input |

## 📁 Project Structure
Smart-Parking-System/
│
├── com/
│ └── smartparking/
│ ├── Main.java # Application entry point
│ │
│ ├── models/ # Data models
│ │ ├── Vehicle.java # Abstract base class
│ │ ├── Car.java # Car implementation
│ │ ├── Motorcycle.java # Motorcycle implementation
│ │ ├── Truck.java # Truck implementation
│ │ └── ParkingSpot.java # Parking spot model
│ │
│ ├── services/ # Business logic
│ │ ├── ParkingLot.java # Parking management
│ │ └── PaymentService.java # Payment processing
│ │
│ └── utils/ # Utility classes
│ └── InputValidator.java # Input validation
│
├── .gitignore # Git ignore file
└── README.md # Project documentation

## 💻 Requirements

### Minimum Requirements
- **Java JDK** 8 or higher
- **Command Line** / Terminal / IntelliJ IDEA
- **RAM**: 256MB minimum
- **Disk Space**: 10MB

### Recommended
- **Java JDK** 11 or higher
- **IntelliJ IDEA** / Eclipse / VS Code
- **Git** (for version control)

## 🔧 Installation & Setup

### Option 1: Using IntelliJ IDEA (Recommended)

1. **Clone the repository:**
```bash
git clone https://github.com/YOUR_USERNAME/Smart-Parking-System.git
2. Open in IntelliJ IDEA:

File → Open → Select the project folder

3. Configure Project Structure:

File → Project Structure → Project

Set Project SDK to Java 8 or higher

4. Run the application:

Right-click on Main.java → Run 'Main.main()'
📖 Usage Guide
Main Menu Options
=== SMART PARKING SYSTEM ===
1. Park a vehicle
2. Remove a vehicle
3. View all parked vehicles
4. View available spots
5. View total revenue
6. Exit

Step-by-Step: Parking a Vehicle
Select option 1 from main menu

Choose vehicle type:

1 for Car

2 for Motorcycle

3 for Truck

Enter vehicle details:

License plate (3-10 characters, letters/numbers only)

Owner name

Parking hours

Type-specific details (electric, sidecar, weight)

System automatically:

Finds an available spot

Calculates parking fee

Parks the vehicle

Process payment:

Enter payment amount

Receive change if applicable

Step-by-Step: Removing a Vehicle
Select option 2 from main menu

Enter the license plate number

Vehicle is removed from the system

Spot becomes available for other vehicles

Example Session
=== SMART PARKING SYSTEM ===
Enter parking lot name: Downtown Plaza
Enter total number of spots: 15

✓ Downtown Plaza initialized with 15 spots

=== MENU ===
1. Park vehicle
2. Remove vehicle
3. View all vehicles
4. View available spots
5. View revenue
6. Exit
Choice: 1

=== PARK VEHICLE ===
1. Car
2. Motorcycle
3. Truck
Select type: 1
Enter license plate (3-10 chars): ABC123
Enter owner name: John Smith
Parking hours: 4
Is electric? (yes/no): no

✓ Car parked at spot #1 | Fee: $8.0

=== PAYMENT DETAILS ===
Vehicle: ABC123
Amount due: $8.0
Enter payment amount: $10
✓ Payment successful!
Change: $2.0
Receipt printed. Thank you!
📚 Class Descriptions
Vehicle (Abstract Class)
Purpose: Base class for all vehicle types

Key Attributes: licensePlate, ownerName, vehicleType, parkingFee

Key Methods:

calculateParkingFee(int hours) - abstract

getRequiredSpots() - abstract

Access Modifiers: Private with public getters/setters

Car
Purpose: Represents a car with electric option

Rate: $2/hour

Discount: 20% for electric vehicles

Spot Requirement: 1 spot

Motorcycle
Purpose: Represents a motorcycle

Rate: $1/hour

Spot Requirement: 1 spot

Truck
Purpose: Represents a truck with weight tracking

Rate: $5/hour

Heavy Load Surcharge: 50% extra for weight > 3.5 tons

Spot Requirement: 1 spot (2 spots for heavy trucks)

ParkingSpot
Purpose: Manages individual parking spots

Types: Standard, Electric, Handicap

Status: Occupied/Available

Methods: parkVehicle(), removeVehicle()

ParkingLot
Purpose: Manages the entire parking facility

Collections: ArrayList of ParkingSpot and Vehicle

Features:

Dynamic spot allocation

Revenue calculation

Vehicle tracking

PaymentService
Purpose: Handles payment processing

Features:

Payment validation

Change calculation

Receipt generation

InputValidator
Purpose: Validates user input

Features:

License plate pattern matching

Positive integer validation

Exception handling

📝 Author
Bisrat Zenebe

Course: BITS-OOP

Assignment: Task #3 - Smart Parking System

GitHub: @Bisrat77-tech

Email: your.email@example.com
