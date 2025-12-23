# 🏨 Hotel Reservation Application

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![CLI](https://img.shields.io/badge/CLI-000000?style=for-the-badge&logo=windows-terminal&logoColor=white)

A **Java-based Command Line Interface (CLI) Hotel Reservation Application** that enables customers to search for rooms, create accounts, make reservations, and view their bookings.  
Administrators can manage rooms, customers, and reservations through a dedicated admin menu.

This project demonstrates **Object-Oriented Programming (OOP)** principles, **layered architecture**, and **robust user input handling** in Java.

---

## 📌 Features

### 👤 Customer Features
- Create a customer account with email validation
- Search for available rooms using check-in and check-out dates
- Reserve a room after confirmation
- View all personal reservations
- Robust input handling (application never crashes on invalid input)

### 🧑‍💼 Admin Features
- Add rooms (Single / Double) using numeric selection
- View all rooms
- View all customers
- View all reservations
- Add test data for quick setup
- Robust admin input validation with re-prompts

---

## 🛠️ Technologies Used
- **Java**
- **IntelliJ IDEA**
- **Java Collections** (`Map`, `Set`, `List`)
- **Object-Oriented Programming (OOP)**
- **Command Line Interface (CLI)**

---

## 🧱 Application Architecture

The application follows a **layered architecture** to ensure clean separation of concerns:
UI Layer
├── MainMenu
├── AdminMenu

Resource Layer
├── HotelResource
├── AdminResource

Service Layer
├── CustomerService
├── ReservationService

Model Layer
├── Customer
├── Room
── RoomType
├── Reservation


---

## 📅 Date Handling

- **Input Format:** `MM/dd/yyyy`
- **Display Format:** `EEE MMM dd yyyy`

**Example:**
Input : 10/01/2025
Output : Wed Oct 01 2025


---

## ▶️ How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/Hotel-Reservation-Application.git
2. Open the project in IntelliJ IDEA
3. Run the application from:
    "hotel.ui.HotelApplication"

## 🧪 Sample Usage Flow

1. 🧑‍💼 Admin logs in and adds test data or rooms  
2. 👤 Customer creates an account  
3. 🔍 Customer searches for available rooms  
4. ✅ Customer confirms and reserves a room  
5. 📄 Customer views reservation summary  

---

## ✅ Key Highlights

- Prevents double booking of rooms  
- Graceful handling of invalid user inputs  
- Clean, user-friendly CLI interaction  
- In-memory data storage (no database dependency)

---
