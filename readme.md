# ms-product-management

This project was created for the Java Spring Boot class taught by Felipe Futema in the MBA in Software Engineering program at Impacta Tecnologia.

The project was derived from the original repository maintained by Felipe Futema:

- [Original repository by Felipe Futema](https://github.com/FelipeFutemaImpacta/ms-product-management)
- [Current repository](https://github.com/EvangelistaR/ms-product-management)

---

# Technologies Used

- Java 21
- Spring Boot
- Maven

Main dependencies configured in the project are managed through the Maven `pom.xml` file.

---

# Prerequisites

Before running the project locally, install:

- Java 21
- Maven 3.9+
- Git

Recommended IDEs:

- IntelliJ IDEA
- VS Code
- Eclipse

---

# Clone the Repository

```bash
git clone https://github.com/EvangelistaR/ms-product-management.git
cd ms-product-management
```

---

# Compile the Project

Using Maven:

```bash
mvn clean install
```

If the repository contains Maven Wrapper files (`mvnw`), you can also use:

Linux/macOS:

```bash
./mvnw clean install
```

Windows:

```bash
mvnw.cmd clean install
```

---

# Run the Application

## Using Maven

```bash
mvn spring-boot:run
```

## Using Maven Wrapper

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

---

# Run the Generated JAR

After compiling the application, execute:

```bash
java -jar target/ms-product-management-0.0.1-SNAPSHOT.jar
```

---

# Default URL

After startup, the application will be available at:

```text
http://localhost:8080
```

---

# Running Tests

Execute the test suite with:

```bash
mvn test
```

Or:

```bash
./mvnw test
```

---

# Useful Maven Commands

## Clean build artifacts

```bash
mvn clean
```

## Generate application package

```bash
mvn package
```

## Build without tests

```bash
mvn clean install -DskipTests
```

---

# Project Structure

```text
src/
 ├── main/
 │    ├── java/
 │    └── resources/
 └── test/
```

---

# Application Configuration

Configuration files are located in:

```text
src/main/resources/
```

Examples:

```text
application.properties
```

or

```text
application.yml
```

---

# Java Version

Verify your installed Java version:

```bash
java -version
```

The project requires Java 21.

---

# Troubleshooting

## Port already in use

If port `8080` is already occupied, change the server port in:

```properties
server.port=8081
```

---

# Credits

This project was developed as part of the Java Spring Boot course for the MBA in Software Engineering at Impacta Tecnologia.

Special thanks to Felipe Futema for the original project structure and course guidance.