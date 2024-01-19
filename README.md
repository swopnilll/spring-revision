# Stereotype Annotations in Spring:

Stereotype annotations are used to automatically create Spring beans in the application context, which is the Spring IoC (Inversion of Control) Container.

## Main Stereotype Annotation:
- @Component is the main stereotype annotation.
- Other stereotype annotations are derived from @Component:
  - @Controller
  - @Service
  - @Repository 

## Purpose of Annotations:

* @Component: Main stereotype annotation.
* @Service: Used for creating Spring beans at the service layer.
* @Repository: Used for creating Spring beans for repositories at the DAO (Data Access Object) layer.
* @Controller: Used for creating Spring beans at the controller layer.

## Layer-specific Usage:

Annotate classes based on the layer they belong to:
* @Controller for classes in the controller layer.
* @Service for classes in the service layer.
* @Repository for classes in the DAO layer.

# Software Development Concepts: Service, Controller, and Repository

This README provides an overview of key software development concepts: service, controller, and repository. These concepts are fundamental to various architectural patterns, enhancing modularity, maintainability, and scalability in software development.

## Service

- **Meaning:**
    - A service encapsulates specific business logic or functionality within a software system.
    - It provides a set of operations or functionalities accessible by other parts of the application.

- **Concept:**
    - Services are integral to the Service-Oriented Architecture (SOA) paradigm, promoting modular, loosely coupled services.
    - They execute specific tasks, often involving complex business rules or calculations.
    - Services may be stateful or stateless and can communicate with other services to achieve system-level goals.

## Controller

- **Meaning:**
    - A controller manages user input and facilitates the flow of data between the user interface and underlying business logic or services.
    - It acts as an intermediary, interpreting user inputs and updating the model (application data) and view (user interface).

- **Concept:**
    - Controllers play a crucial role in the Model-View-Controller (MVC) architectural pattern.
    - They help separate concerns, making the application more modular and easier to maintain.
    - Controllers handle user interactions, updating the model and view accordingly.

## Repository

- **Meaning:**
    - A repository manages data access logic and abstracts interactions with underlying data storage, such as a database.
    - It provides a set of methods for querying and manipulating data.

- **Concept:**
    - Repositories follow the repository pattern, centralizing and abstracting data access logic.
    - They decouple the application from specific details of data storage, promoting easier testing and maintenance.
    - Repositories are often used in combination with Object-Relational Mapping (ORM) frameworks for mapping between domain objects and the database.

## Overall Concept

- **Architecture:**
    - The concepts of service, controller, and repository are foundational to various software architectural patterns, including MVC and SOA.
    - These patterns aim to enhance modularity, maintainability, and scalability in software development.

- **Layered Architecture:**
    - Services, controllers, and repositories are typically distributed across different layers in a layered architecture, promoting separation of concerns.
    - This separation facilitates easier management and evolution of each component independently.

In summary, these concepts contribute to the organization and structure of software systems, adhering to principles like separation of concerns, modularity, and reusability.

## Real Example use case: Tiktok

## Overview

This project involves building a TikTok web app with a React frontend and a Spring backend. The backend architecture utilizes the following components:

### Controller (Spring MVC)

Controllers handle incoming HTTP requests and serve as the entry point for communication with the React frontend. They define endpoints for various actions like video uploads and user interactions.

```java
@RestController
public class TikTokController {
    @Autowired
    private TikTokService tikTokService;

    @PostMapping("/api/uploadVideo")
    public ResponseEntity<String> uploadVideo(@RequestBody VideoDto videoDto) {
        tikTokService.processUploadedVideo(videoDto);
        return ResponseEntity.ok("Video uploaded successfully");
    }

    // Other endpoints for user interactions, authentication, etc.
}
```

### Service

Services contain the business logic of the application and act as an intermediate layer between the controller and the repository. They handle operations such as video processing, user management, and interactions with the database.

```java
@Service
public class TikTokService {
    @Autowired
    private VideoRepository videoRepository;

    public void processUploadedVideo(VideoDto videoDto) {
        videoRepository.save(new Video(videoDto.getTitle(), videoDto.getUrl()));
    }

    // Other business logic methods for user interactions, recommendations, etc.
}
```

### Repository (Spring Data JPA)
Repositories manage database interactions and provide methods for storing and retrieving data. They abstract away the details of database operations.

```java
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    // Custom query methods for video-related operations
    List<Video> findByUploader(User uploader);
}
```

# Service-Repository Separation

The separation of concerns between the service layer and the repository layer is a common practice in software development and is part of the broader design principle known as the Service Layer Pattern.

## Key Principles

### Modularity and Abstraction:

- **Service Layer:**
  - Contains the business logic and application-specific functionality.
  - Achieves a modular design, encapsulating the core logic of the application.
  - Focuses on high-level operations.

- **Repository Layer:**
  - Deals specifically with data access and storage.
  - Abstracts away the details of how data is stored, retrieved, and manipulated.
  - Provides a clean and consistent interface for data access.

### Testability:

- **Service Layer:**
  - Business logic can be unit tested independently of the database.
  - Enables mocking or providing test implementations for repository interactions.

- **Repository Layer:**
  - Keeps data access logic separate, allowing integration tests specifically for data storage and retrieval.

### Flexibility and Maintainability:

- **Service Layer:**
  - Handles changes in business logic or requirements without affecting data access.
  - Promotes flexibility and ease of adaptation to evolving requirements.

- **Repository Layer:**
  - Localizes modifications when switching databases or changing data access strategies.

### Encapsulation of Responsibilities:

- **Service Layer:**
  - Focuses on orchestrating business processes, handling transactions, and coordinating interactions between entities.
  - Remains agnostic of how data is persisted.

- **Repository Layer:**
  - Concentrates on the mechanics of data access, dealing with database queries, updates, and transactions.
  - Does not concern itself with higher-level application logic.

### Readability and Maintainability:

- **Service Layer:**
  - Enhances code readability by presenting a clear and concise view of the application's business logic.
  - Avoids cluttering the code with database-related details.

- **Repository Layer:**
  - Maintains a clear and focused set of responsibilities related to data access.
  - Makes the code more readable and maintainable.

In summary, the separation of the service and repository layers adheres to the principle of "Separation of Concerns," promoting modularity, testability, and maintainability in software development. Each layer has its specific responsibilities, making the overall architecture more flexible and adaptable to changes.
