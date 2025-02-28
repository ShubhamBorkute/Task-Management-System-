# Task-Management-System-
## Overview
The Task Management System is a web application that allows users to create, update, and manage tasks efficiently. The backend is built with Spring Boot, and the frontend is developed using React.

## Features
- Create, update, and delete tasks
- Assign statuses (Pending, Completed)
- get tasks by id's
- Cross platform


## 🛠 Tech Stack
- Backend (Spring Boot - Port 8080)
- Java 17, Spring Boot 3+
- Spring Data JPA & Hibernate (ORM)
- MySQL (Database)
- Lombok
- REST API for communication

## Frontend (React - Port 3000)
- React.js (Vite)
- Tailwind CSS (Styling)
- Axios (API Calls)

## 📂 Project Structure
```
task-management-system-/
│── server/
│   ├── src/main/java/com/taskmanagmentsystem-/server/
│   │   ├── controller/   # API Controllers
│   │   ├── entity/       # JPA Entity Models
│   │   ├── repository/   # Spring Data JPA Repositories
│   │   ├── service/      # Business Logic Layer
│   │   ├── exception/    # Custom Exceptions
│   ├── src/main/resources/
│   │   ├── application.properties  # Database & Server Config
│   ├── pom.xml           # Backend Dependencies
│── client/
│   ├── src/
│   │   ├── components/   # UI Components
│   │   ├── pages/        # Pages & Views
│   │   ├── services/     # API Calls using Axios
│   ├── package.json      # Frontend Dependencies
│── README.md
```

## Setup Instructions
### Clone the Repository
```
git clone https://github.com/ShubhamBorkute/Task-Management-System-.git
cd task-management-system-
```

### Update Database Credentials in src/main/resources/application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
```
## Build & Run Backend
```
mvn clean install
mvn spring-boot:run
```
## Frontend Setup (React - Port 3000)
- Navigate to frontend directory
  ```
  cd ../frontend
  ```
  - Install dependencies
    ```
    npm install
    ```
    - Start the frontend
    ```
    npm start
   ```

## 🔗 API Endpoints
```
| Method	       | Endpoint	                 | Description
| GET	           | /tasks	                   | Get all tasks
| POST	         | /tasks	                   | Add a new task
| GET	           | /tasks/{taskId}	         | Get a task by ID
| PUT	           | /tasks/{taskId}	         | Update a task
| DELETE	       | /tasks/{taskId}	         | Delete a task
```

## 📜 Contribution Guidelines
- Fork the Repository
- Create a Feature Branch
  ```
  git checkout -b feature-branch
  ```
### Commit Changes
```
git commit -m "Added new feature"
```
### Push to GitHub & Open a Pull Request

## 📩 Contact
### For any issues, contact Shubham Borkute.
