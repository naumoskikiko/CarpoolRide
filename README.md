```markdown
# Carpool Ride Sharing API 🚗💨

A RESTful API for managing carpool rides built with **Spring Boot 3.1.5** and **H2 Database**. Perfect for coordinating shared rides between drivers and passengers.

[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-brightgreen.svg)](https://spring.io/projects/spring-boot)

## 🌟 Features

- **Full CRUD Operations** for ride management
- Passenger management system
- Search/filter rides by:
  - Pickup/dropoff locations
  - Driver name
  - Available seats
- H2 in-memory database with web console
- Comprehensive error handling
- Sample data initialization
- RESTful endpoints with proper HTTP verbs

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Maven 3.9+
- Postman/curl (for testing)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/yourusername/carpool-ride-api.git
cd carpool-ride-api
```

2. Build and run:
```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## 🔧 Configuration

### Database Setup (application.properties)
```properties
spring.datasource.url=jdbc:h2:mem:carpool
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
```

### Default H2 Console Access:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:carpool`
- Username: `sa`
- Password: (empty)

## 📚 API Documentation

### Endpoints Overview

| Method | Endpoint                      | Description                          |
|--------|-------------------------------|--------------------------------------|
| POST   | /rides                        | Create new ride                      |
| GET    | /rides                        | Get all rides                        |
| GET    | /rides/{id}                   | Get ride by ID                       |
| PUT    | /rides/{id}                   | Update ride                          |
| DELETE | /rides/{id}                   | Delete ride                          |
| GET    | /rides/search                 | Search by locations                  |
| POST   | /rides/{id}/passengers        | Add passenger                        |
| DELETE | /rides/{id}/passengers        | Remove passenger                     |
| GET    | /rides/driver/{driverName}    | Find rides by driver                 |
| GET    | /rides/available              | Get rides with available seats       |

---

## 💻 API Examples

### 1. Create New Ride
```http
POST /rides
Content-Type: application/json

{
    "driverName": "John Doe",
    "pickupLocation": "Central Station",
    "dropoffLocation": "Tech Park",
    "departureTime": "2024-03-20T08:00:00",
    "availableSeats": 4
}
```

### 2. Add Passenger to Ride
```http
POST /rides/1/passengers
Content-Type: text/plain

"Alice Smith"
```

### 3. Search Rides
```http
GET /rides/search?pickup=Downtown&dropoff=Airport
```

### 4. Get Available Rides
```http
GET /rides/available
```

---

## 🛠️ Error Handling

The API returns appropriate HTTP status codes:

- `404 Not Found`: Ride not found
- `400 Bad Request`: Invalid passenger operation
- `201 Created`: Successful resource creation
- `204 No Content`: Successful deletion

Example error response:
```json
{
    "timestamp": "2024-03-19T14:30:45.123+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Ride not found with id: 99",
    "path": "/rides/99"
}
```

---

## 🧩 Project Structure

```
src/main/java
└── carPoolRide
    ├── CarPoolRideApplication.java     # Main application class
    ├── controller
    │   └── RideController.java        # API endpoints
    ├── model
    │   └── Ride.java                  # Entity definition
    ├── repository
    │   └── RideRepository.java        # Database operations
    └── service
        └── RideService.java           # Business logic
```

---

## � Testing the API

### Using cURL:
```bash
# Create ride
curl -X POST -H "Content-Type: application/json" \
-d '{"driverName":"John","pickupLocation":"Downtown","dropoffLocation":"Airport","departureTime":"2024-03-20T08:00:00","availableSeats":3}' \
http://localhost:8080/rides

# Get all rides
curl http://localhost:8080/rides
```
## 📊 Sample Data

Initial rides created at startup:
1. ID 1: Petar's ride (3 seats)
2. ID 2: Andrej's ride (2 seats)

Test passenger operations using these IDs!

---

## 📈 Future Improvements

- [ ] Add user authentication
- [ ] Implement ride booking system
- [ ] Add payment integration
- [ ] Include real-time notifications
- [ ] Add geolocation search
- [ ] Implement rating system
