package org.cabr4;

// Entry point for running a Spring Boot application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

  // Main method: JVM entry point
  // This method starts the Spring Boot application
  public static void main(String[] args) {

    // Boots the Spring application:
    // - creates the application context
    // - scans components (@Controller, @Service, @Repository, etc.)
    // - starts the embedded web server (Tomcat by default)
    SpringApplication.run(Main.class, args);
  }
}
