# Freight Transport Region (FTR) Microservices Application 🚢

This project implements a **microservices-based Freight Transport Region (FTR) management system** to streamline international shipping operations.  
It manages **Users, Terminals, Vehicles, and Workitems** with a focus on scalability, resilience, and observability.

---

## 🚀 Features
- **User Management**: Create, update, view, and delete user profiles with authentication & login APIs.  
- **Terminal Management**: Manage terminals, track capacity, update status, and allocate to shipments.  
- **Vehicle Management**: Register, fetch, update, and retire vehicles; ensure active status validation.  
- **Workitem Management**: Create shipping requests, assign terminals, allocate vehicles, track shipment status.  
- **Service Discovery & Health Checks**: Integrated **Consul** for dynamic host discovery and **Spring Boot Actuator** for runtime health monitoring.  
- **API Gateway & Routing**: Configured **Spring Cloud Gateway** for intelligent request routing, filtering, and load balancing.  
- **Monitoring & Observability**: Exposed metrics via **Prometheus** for performance monitoring and alerting.  
- **Resilience**: Implemented **Resilience4j** (circuit breakers, retries, rate limiting) for fault-tolerance.  

---

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot, Spring Cloud  
- **Service Discovery**: Consul  
- **Gateway**: Spring Cloud Gateway  
- **Resilience**: Resilience4j  
- **Monitoring**: Prometheus + Actuator  
- **Database**: MySQL (per microservice schema)  
- **Persistence**: Spring Data JPA / Hibernate  
- **API Testing**: Postman  

---

## 📂 Microservices Implemented
- **User Service** → User registration, profile management, login.  
- **Terminal Service** → CRUD operations for terminals, capacity management.  
- **Vehicle Service** → Vehicle registration, updates, and allocation.  
- **Workitem Service** → Create and track shipments, assign terminals & vehicles.  

Each microservice runs independently and registers with **Consul** for discovery.  

---

## ⚙️ Architecture
```
 ┌──────────┐         ┌──────────┐       ┌──────────┐
 │  Client  │────────▶│ API GW  │──────▶│ Services │
 └──────────┘         │ (SCG)    │       │ (User,   │
                      │          │       │ Terminal,│
                      │          │       │ Vehicle, │
                      │          │       │ Workitem)│
                      └──────────┘       └──────────┘
                          │                   │
                    ┌─────────────┐     ┌─────────────┐
                    │   Consul    │     │ Prometheus  │
                    │ (Discovery) │     │ (Metrics)   │
                    └─────────────┘     └─────────────┘
```

---

## ▶️ Getting Started


### 2️⃣ Run Consul
```bash
consul agent -dev
```
Access UI at: `http://localhost:8500`

### 3️⃣ Start Microservices
Each service can be run via:
```bash
mvn spring-boot:run
```

### 4️⃣ Access APIs via Gateway
```http
http://localhost:8080/ftr/<service-endpoint>
```

---

## 📊 Monitoring
- **Actuator** endpoints available at `/actuator` (health, metrics, info).  
- **Prometheus** scrapes metrics from actuator `/actuator/prometheus`.  
