# Bank Account Management System

## Overview
The Bank Account Management System is a Spring Boot application designed to manage bank accounts. It supports functionalities such as creating accounts, depositing, withdrawing, and transferring money between accounts.

## Features
- Create new bank accounts.
- View details of individual accounts.
- List all accounts.
- Deposit money into an account.
- Withdraw money from an account.
- Transfer money between accounts.

## Project Structure

```
CC-BANK/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── com/ │ │ │ └── code_compilers/ │ │ │ └── CC_BANK/ │ │ │ ├── BankApplication.java│ │ │ ├── controller/ │ │ │ │ ├── HomeController.java│ │ │ │ ├── AccountController.java│ │ │ ├── model/ │ │ │ │ ├── Account.java│ │ │ │ ├── CheckingAccount.java│ │ │ │ ├── SavingsAccount.java│ │ │ ├── repository/ │ │ │ │ ├── AccountRepository.java│ │ ├── resources/ │ │ │ ├── application.properties│ │ │ ├── templates/ │ │ │ │ ├── index.html│ │ │ │ ├── account.html│ │ │ │ ├── accounts.html│ │ │ │ ├── transfer.html│ │ │ ├── static/ │ │ │ ├── css/ │ │ │ └── style.css│ ├── test/ │ │ ├── java/ │ │ │ └── com/ │ │ │ └── code_compilers/ │ │ │ └── CC_BANK/ │ │ │ ├── BankApplicationTests.java└── pom.xml
```

## Setup and Installation

### Prerequisites
- JDK 23
- Maven
- MySQL Server

### Steps

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your_username/CC-BANK.git
    cd CC-BANK
    ```

2. **Create the Database**:
    Use MySQL Workbench or another MySQL client to execute the following SQL commands:
    ```sql
    CREATE DATABASE ccbank;
    USE ccbank;

    CREATE TABLE accounts (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        owner VARCHAR(100) NOT NULL,
        balance DOUBLE NOT NULL,
        account_type VARCHAR(20) NOT NULL CHECK (account_type IN ('CheckingAccount', 'SavingsAccount'))
    );

    CREATE TABLE checking_accounts (
        id BIGINT PRIMARY KEY,
        overdraft_limit DOUBLE NOT NULL,
        FOREIGN KEY (id) REFERENCES accounts(id)
    );

    CREATE TABLE savings_accounts (
        id BIGINT PRIMARY KEY,
        interest_rate DOUBLE NOT NULL,
        FOREIGN KEY (id) REFERENCES accounts(id)
    );
    ```

3. **Configure the Application**:
    Open `src/main/resources/application.properties` and set your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ccbank
    spring.datasource.username=your_database_username
    spring.datasource.password=your_database_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. **Build and Run the Application**:
    Use Maven to build and run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage
Once the application is running, you can access it in your web browser at `http://localhost:8080`.

### Endpoints

- **Home Page**: `http://localhost:8080/`
    - Lists all accounts and allows you to create new accounts.

- **View Account**: `http://localhost:8080/accounts/{id}`
    - View details of an account, deposit money, and withdraw money.

- **Transfer Money**: `http://localhost:8080/transfer`
    - Transfer money between accounts (implemented in `transfer.html`).

## Templates

- **index.html**: Home page to list all accounts.
- **account.html**: Displays account details and actions.
- **accounts.html**: Lists all accounts.
- **transfer.html**: Shows details of a transfer.

## Styles
Basic styling is provided in `src/main/resources/static/css/style.css`.

## License
This project is licensed under the MIT License. See the LICENSE file for more information.

---
