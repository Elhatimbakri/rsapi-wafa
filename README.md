# Insurance Quote Management System - Wafa Assurance

This project is a web-based application designed to streamline the management of insurance quotes at Wafa Assurance. By automating and centralizing the quote creation, validation, and tracking processes, this application enhances operational efficiency and helps ensure compliance with regulatory standards. It also provides an improved experience for clients and agents by reducing manual errors and simplifying workflow management.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Automated Quote Management**: Create, validate, and track insurance quotes in a single system.
- **Client and Asset Management**: Store and manage client information and assets associated with quotes.
- **Regulatory Compliance**: Helps ensure the quote processes meet regulatory requirements.
- **Centralized Database**: Maintains all client and quote data securely in one place.
- **Reporting and Tracking**: View quote histories, manage statuses, and access data analytics.
- **User Authentication and Authorization**: Secure access for employees and authorized users only.
- **Audit and Logging**: Track actions for compliance and auditing purposes.

## Tech Stack
- **Frontend**: React.js
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Modeling**: UML, draw.io for designing entity relationships and workflows

## Project Structure
insurance-quote-management/ ├── backend/ │ ├── src/ │ │ ├── main/ │ │ │ ├── java/ │ │ │ ├── resources/ │ │ └── test/ ├── frontend/ │ ├── src/ │ ├── public/ └── README.md


## Getting Started

### Prerequisites
- **Java 11** or later
- **Node.js** and **npm**
- **MySQL** database
- **Spring Boot CLI** (optional for running Spring Boot applications)

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Elhatimbakri/rsapi-wafa.git
    ```

2. **Setup Backend**:
    - Navigate to the `backend` folder and install dependencies.
    - Configure the `application.properties` file in `src/main/resources` with your MySQL database credentials.
    - Run the backend:
      ```bash
      ./mvnw spring-boot:run
      ```

3. **Setup Frontend**:
    - Navigate to the `frontend` folder.
    - Install frontend dependencies and start the server:
      ```bash
      npm install
      npm start
      ```

### Database Setup
- Set up a MySQL database named `insurance_quotes`.
- Run the database migration scripts located in `backend/src/main/resources/db` to set up the tables.

## Usage
1. Access the application at `http://localhost:3000` once both frontend and backend are running.
2. **Login** using provided credentials to access the dashboard.
3. **Create Quotes** by entering client information, selecting assets, and adding specific quote details.
4. **Manage Quotes** through the dashboard to validate, modify, and view details of all stored quotes.
5. **Export Data** to generate reports or view audit trails.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request to suggest changes.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a pull request

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

*Project maintained by Wafa Assurance IT Team.* 
