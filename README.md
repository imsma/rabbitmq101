# Spring Boot RabbitMQ Producer & Consumer Example bySMA

Welcome to the **Spring Boot RabbitMQ** RabbitMQ101 repository bySMA! This project is a simple, hands-on guide to setting up message queues using RabbitMQ with Spring Boot.

[View Code](https://github.com/imsma/rabbitmq101)

The projects use **OpenJDK 21**, **Spring Boot 3.3.5**, and **Maven** for dependency management, giving you the latest and greatest to work with.

## Tech Stack

- **Java**: OpenJDK 21
- **Spring Boot**: Version 3.3.5
- **Maven**: For build and dependency management
- **RabbitMQ**: Docker setup included for easy configuration

## Setting Up RabbitMQ with Docker

To make it easy to run RabbitMQ on your local machine, we’ll use Docker. If you don’t have Docker installed, [install it from here](https://docs.docker.com/get-docker/).

Once Docker is ready, start a RabbitMQ container with the following command:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

This command does a few things:

- Downloads the RabbitMQ image with a management plugin.
- Exposes RabbitMQ on port **5672** (for messaging) and **15672** (for the management dashboard).

Once it’s running, you can access the RabbitMQ management console at `http://localhost:15672` using the default credentials:

- **Username**: `guest`
- **Password**: `guest`

## Running the Spring Boot Applications

Follow these steps to run the Producer and Consumer projects.

1. **Clone the Repository**

   Clone this repo to your machine using HTTPS or SSH:

   ```bash
   git clone https://github.com/imsma/rabbitmq101.git
   ```

2. **Run the Spring Boot Application**

```bash
  ./mvnw spring-boot:run
```

3. **Build the Project with Maven**

   Run the Maven command to build the project. This command compiles the code and packages it into a runnable `.jar` file:

   ```bash
   ./mvnw clean install
   ```

4. **Run the Jar**

   After building, you can run the app with the following command:

   ```bash
   java -jar target/rabbitmq101.jar  # For the Producer app
   ```

   Alternatively, if you’re using an IDE like IntelliJ or Eclipse, simply run the `main` class for each project to start the applications.

## License

This project is licensed under the MIT License, which means you’re free to use, modify, and distribute it as you please.

## About bySMA

This example is part of the open-source initiative bySMA, where I, Shoket Mahmood Ahmed (SMA), share code samples, tools, and practical resources for developers. If this project helps you, check out more of my work on GitHub and my blog.

## Further Reading

For tips, tutorials, and insights, feel free to visit my blog at [sma.im](https://sma.im) – I'd love for you to explore and join the conversation!
