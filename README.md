# Flight Information System (FIS) Application

This repository contains a full-stack Flight Information System (FIS) application, comprising a Spring Boot backend API and a React frontend. The system is designed to manage flight information, user authentication, and provide a dashboard for flight statuses.

## Table of Contents

-   [Features](#features)
-   [Technologies Used](#technologies-used)
-   [Project Structure](#project-structure)
-   [Setup and Installation](#setup-and-installation)
    -   [Prerequisites](#prerequisites)
    -   [Backend Setup](#backend-setup)
    -   [Frontend Setup](#frontend-setup)
-   [Usage](#usage)
-   [API Endpoints](#api-endpoints)
-   [Authentication](#authentication)
-   [Contributing](#contributing)
-   [License](#license)

## Features

The Flight Information System application provides the following key features:

**Backend (FIS-API):**
-   User authentication and authorization (JWT-based).
-   User management.
-   Flight information management (status, remarks, airport changes).
-   Data persistence using Microsoft SQL Server.
-   RESTful API endpoints for frontend communication.

**Frontend (FIS_frontend):**
-   User login and dashboard.
-   Display of flight information.
-   Private routes for authenticated users.
-   API integration for fetching and displaying flight data.

## Technologies Used

**Backend (FIS-API):**
-   Java 17
-   Spring Boot (Web, Data JPA, Security)
-   Microsoft SQL Server JDBC Driver
-   JWT (JSON Web Tokens) for authentication
-   Lombok
-   Maven

**Frontend (FIS_frontend):**
-   React 19
-   TypeScript
-   Vite
-   Axios for API communication
-   React Router DOM for navigation
-   React Icons, Lucide React for icons
-   ESLint for code quality

## Project Structure

The repository is organized into two main directories:

```
.
├── FIS-Checkpoint last/     # Backend API (likely a previous version or checkpoint)
│   ├── FIS-API/             # Spring Boot Backend API
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/itsystem/yetiairlines/FIS/
│   │   │   │   │   ├── Authenticator/   # JWT utilities
│   │   │   │   │   ├── Controller/      # REST API controllers (FIS, User)
│   │   │   │   │   ├── Entity/          # JPA Entities and request/response models
│   │   │   │   │   ├── Repositories/    # Spring Data JPA repositories
│   │   │   │   │   └── Services/        # Business logic services
│   │   │   │   └── resources/           # Application properties, SSL certificate
│   │   ├── pom.xml                      # Maven project file
│   │   └── ...
│   └── ReadMe.txt                       # Backend specific README
└── FIS_Frontend_Second Last/ # Frontend Application (likely the current version)
    ├── FIS_frontend/        # React Frontend Application
    │   ├── public/          # Static assets (images, vite svg)
    │   ├── src/
    │   │   ├── api/         # API client definitions
    │   │   ├── assets/      # Static assets
    │   │   ├── components/  # Reusable React components (e.g., PrivateRoute)
    │   │   ├── context/     # React Context for authentication
    │   │   ├── pages/       # Application pages (Dashboard, Login, Preview)
│   │   │   ├── App.tsx      # Main application component
│   │   │   ├── main.tsx     # Entry point
│   │   │   └── ...
│   ├── index.html
│   ├── package.json         # Node.js dependencies and scripts
│   ├── tsconfig.json        # TypeScript configuration
│   ├── vite.config.ts       # Vite configuration
│   └── ...
├── Read me.txt              # Root level README (this file)
├── web.config               # IIS configuration (if deploying on Windows Server)
└── ...
```
*(Note: The presence of `FIS-Checkpoint last/` suggests it might be an older or backup version of the API. The instructions below will focus on `FIS_Frontend_Second Last/FIS_frontend` for the frontend and assume `FIS-Checkpoint last/FIS-API` is the intended backend.)*

## Setup and Installation

Follow these steps to set up and run the Flight Information System application locally.

### Prerequisites

-   Java Development Kit (JDK) 17 or higher
-   Maven
-   Node.js (LTS version recommended)
-   npm or Yarn
-   Microsoft SQL Server database

### Backend Setup

1.  **Navigate to the backend directory:**
    ```bash
    cd FIS-Checkpoint\ last/FIS-API
    ```

2.  **Configure SQL Server:**
    -   Ensure your SQL Server instance is running and accessible.
    -   Update `src/main/resources/application.properties` with your database connection details:
        ```properties
        spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=your_database_name;encrypt=true;trustServerCertificate=true;
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        ```
        *(Adjust `localhost:1433` and `databaseName` as per your SQL Server setup.)*

3.  **Build and run the backend:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    The backend API will start on `http://localhost:8080` by default.

### Frontend Setup

1.  **Navigate to the frontend directory (in a new terminal):**
    ```bash
    cd FIS_Frontend_Second\ Last/FIS_frontend
    ```

2.  **Install dependencies:**
    ```bash
    npm install
    # or yarn install
    ```

3.  **Start the frontend development server:**
    ```bash
    npm run dev
    # or yarn dev
    ```
    The frontend application will be accessible at `http://localhost:5173` (or another port if 5173 is in use).

## Usage

Once both the backend and frontend servers are running:
1.  Open your web browser and navigate to `http://localhost:5173`.
2.  Log in using valid credentials (you might need to register users via the API if no registration endpoint is exposed on the frontend).
3.  Explore the dashboard to view flight information.

## API Endpoints

The backend API exposes RESTful endpoints for managing users and flight data. Key endpoint categories include:

-   `/api/auth`: User authentication (login).
-   `/api/users`: User-related operations.
-   `/api/fis`: Flight information management (status, remarks, airport changes).

Detailed API documentation can be inferred from the `Controller` and `Entity` classes in the backend.

## Authentication

The application uses JWT (JSON Web Tokens) for secure authentication. Upon successful login, a JWT is issued to the client, which must be included in the `Authorization` header of subsequent API requests.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.
