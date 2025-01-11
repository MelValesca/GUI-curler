# Curler

A **Java Swing** GUI application built and run with **Maven**.

## Table of Contents
1. [Description](#description)  
2. [Prerequisites](#prerequisites)   
3. [How to Run](#how-to-run)  
4. [Status](#Status)

---

## Description

This project demonstrates a basic **Java Swing** graphical user interface. It uses **Maven** to manage the build lifecycle and dependencies.

This project is a CTF-focused toolkit that allows you to brute force hidden or obscure repositories on a website. Through a user-friendly GUI, you can craft and send GET or POST requests, add custom headers, and even render returned HTML right inside the application. By customizing your requests before brute forcing, you can efficiently discover hidden site paths and gather insights for your capture-the-flag challenges.


---

## Prerequisites

- **Java 8+** (check with `java -version`)
- **Maven 3+** (check with `mvn -version`)
---


- **pom.xml**: Defines Maven plugins, dependencies, and project metadata.  
- **MainWindow.java**: Contains the `main` method and Swing code (e.g., `JFrame`).

---

## How to Run

1. **Build the project**:
    ```bash
    mvn clean compile
    ```

2. **Run the application**:

     ```bash
     mvn exec:java"
     ```

If everything is set up correctly, a GUI window should appear.

---

## Status

This project is still a work in progress, with new features and improvements planned for future.
