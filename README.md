
# 🏬 Mall-Management-System  
Backend system for mall management built using Spring Boot, MongoDB and MySQL.

---

## 📌 Table of Contents  
- [Overview](#overview)  
- [Key Features](#key-features)  
- [Tech Stack](#tech-stack)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Installation](#installation)  
  - [Running Locally](#running-locally)  
- [Project Structure](#project-structure)  
- [API Endpoints](#api-endpoints)  
- [Configuration](#configuration)  
- [Future Plans](#future-plans)  
- [Contributing](#contributing)  
- [License](#license)  
- [Contact](#contact)  

---

## 📖 Overview  
Mall-Management-System is a backend application intended for managing mall operations — stores, tenants, leases, maintenance, visits, etc.  
It uses Spring Boot for the server, employing a hybrid persistence architecture combining MongoDB and MySQL for different data requirements.

---

## ✨ Key Features  
- CRUD operations for tenants, stores, leases and mall events  
- Hybrid persistence: document store (MongoDB) + relational (MySQL)  
- RESTful API endpoints for integration with front-end or mobile apps  
- Configuration driven, modular design for extension  
- Logging and error handling built into the application  

---

## 🛠 Tech Stack  
- **Language**: Java  
- **Framework**: Spring Boot  
- **Databases**:  
  - MySQL — for relational data (e.g., leases, store contracts)  
  - MongoDB — for flexible document data (e.g., event logs, maintenance records)  
- **Build Tool**: Maven  
- **Packaging**: .jar executable via Spring Boot  
- **Others**: Spring Data JPA, Spring Data MongoDB  

---

## 🚀 Getting Started  

### ✅ Prerequisites  
- Java JDK 11+  
- Maven  
- MySQL server  
- MongoDB server  
- Git  

### 📥 Installation  
```bash
git clone https://github.com/PerfectCoder123/Mall-Management-System.git
cd Mall-Management-System
````

### 📦 Build & Run

```bash
mvn clean install
java -jar target/mall-management-system-0.0.1-SNAPSHOT.jar
```

By default, the server will start on port **8080** (unless configured otherwise).

---

## 📁 Project Structure

```
Mall-Management-System/
 ├─ src/
 │   ├─ main/
 │   │   ├─ java/com/example/mall/
 │   │   │   ├─ controller/
 │   │   │   ├─ service/
 │   │   │   ├─ repository/
 │   │   │   ├─ model/
 │   │   └─ resources/
 │   │       ├─ application.properties
 │   │       └─ ...
 │   └─ test/
 ├─ pom.xml
 └─ README.md
```

---

## 🔌 API Endpoints

Here are some example REST endpoints (adjust based on actual implementation):

| Method | Endpoint                | Description              |
| ------ | ----------------------- | ------------------------ |
| GET    | `/api/tenants`          | List all tenants         |
| POST   | `/api/tenants`          | Create a new tenant      |
| GET    | `/api/stores/{storeId}` | Get store by ID          |
| PUT    | `/api/leases/{leaseId}` | Update lease information |
| DELETE | `/api/events/{eventId}` | Delete a mall event      |


---

## ⚙ Configuration

The application uses `application.properties` or `application.yml` for configuration. Typical settings:

* MySQL connection URL, username, password
* MongoDB database and host
* Server port, logging level
* Any custom configuration (e.g., threshold values, API keys)

Make sure you update the configuration to match your local or production environment before running.

---

## 🔮 Future Plans

* Add authentication/authorization (e.g., OAuth2, JWT)
* Add front-end dashboard (React/Vue) interacting with this backend
* Add advanced analytics (foot-traffic, store performance, heat-maps)
* Multi-tenant support (multiple malls in one system)
* Microservices split for high scalability

---

## 🤝 Contributing

Contributions are welcome!

1. Fork this repository
2. Create a new branch: `git checkout -b feature/xyz`
3. Commit your changes: `git commit -m "Add feature xyz"`
4. Push to your fork: `git push origin feature/xyz`
5. Open a Pull Request describing your changes

Please ensure code is clean, tested, and you update relevant documentation.

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more details.

---

## 📬 Contact

Created by **[@PerfectCoder123](https://github.com/PerfectCoder123)**
Feel free to raise issues, give feedback or suggest improvements.
