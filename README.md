## Current Status

The project is currently in the initial development phase. The backend has been set up with Spring Boot, and the core domain models (`RadioStation`, `Genre`, `Tag`, `UserFeedback`) have been created as JPA entities.

The service layer has been implemented with `RadioStationService`, `GenreService`, and `UserFeedbackService`, along with their implementations. The data access layer is handled by Spring Data JPA repositories.

The next steps will involve creating REST controllers to expose the services through a REST API, and then developing a frontend to consume the API.

* RadioStation, is a radio station availible in streaming
* Genre, is a musical or theme category of the radio (Rock, Jazz, News, Talk,...)
* Tag, free tags to filter or better identify (“indie”, “political”, “local”, “live”)
* UserFeedback, allows users to leave comments or reports.

> [!NOTE]
> This documentation is a work in progress.

## Frontend Architecture

The project will include a simple and lightweight frontend built with a Server side templating.

*   **Technology**: Static HTML, CSS. ThymeLeaf form server side templating.
*   **Styling**: Bootstrap 5 is used for the UI components and layout, included via CDN.
*   **Operation**: The frontend is served as static assets from the `src/main/resources/static` directory of the Spring Boot application. 
    Then ThymeLeaf render the pages 

🔧 Technical Considerations
- **Spring Boot**: Use JPA with Hibernate to manage entity relationships.
- **Separate DTOs**: For REST exposure, it's better to use DTOs to avoid infinite loops in relationships.
- **Validations**: Use annotations like `@NotBlank`, `@URL`, `@Min`, `@Max` to ensure data integrity.
- **Caching**: Useful for valid stream URLs, avoiding repeated calls to non-working radios.
- **Scheduler**: You could implement a periodic job to check the status of streaming links.

## Entities and Class diagram 

1. RadioStation to UserFeedback Relationship (@OneToMany)
A single radio station can have many feedback entries, and each feedback entry belongs to only one radio station
2. RadioStation to Genre and Tag Relationships (@ManyToMany)
A radio station can have multiple genres (e.g., "Rock", "Pop"), and a single genre can be applied to many different radio stations. The same logic applies to tags. This is a many-to-many relationship
See class-diagram.md

Note: to enable lazy loading: spring.jpa.open-in-view=true