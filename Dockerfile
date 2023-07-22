FROM ubuntu:latest
LABEL authors="pedrosimoes"

# Set the working directory inside the container
WORKDIR /app


# Specify the command to run the backend application
CMD ["java", "-jar", "backend.jar"]
