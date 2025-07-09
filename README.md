# 🐾 Pet Tracker Application

A Spring Boot application for tracking pets (dogs & cats) using different types of trackers. Tracks which pets are outside the power-saving zone.

---

## 🚀 How to Run

```bash
./mvnw spring-boot:run
# or
mvn spring-boot:run
```
---


### 📋 Get All Pets
```bash
curl http://localhost:8080/pets
```

### 📊 Pets Outside Power Saving Zone
```bash
curl http://localhost:8080/pets/outside-zone
```

---