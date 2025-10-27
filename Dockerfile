# Use a lightweight official OpenJDK base image
FROM openjdk:17-slim AS build

# Set working directory
WORKDIR /app

# Copy only source files first (better for caching)
COPY *.java ./

# Compile Java files
RUN javac Main.java

# Use a smaller runtime image for better performance
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy compiled class files from build stage
COPY --from=build /app/*.class ./

# Default command to run the application
CMD ["java", "Main"]
