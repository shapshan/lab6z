**Event Registration API (Laboratory Work 6)**

First Spring Boot backend for the Event Registration scenario: JSON GET endpoints, a service class,
constructor-based dependency injection and settings from `application.properties`.
In-memory only (no database, no frontend integration).

**Author:** Shapshan Abylaikhan, group Ds2504

**Requirements**
- JDK 17 or later
- The Gradle wrapper is used, so no separate Gradle installation is needed

**How to run**
Linux / macOS: `./gradlew bootRun`

Windows: `gradlew.bat bootRun`

The console should show that Tomcat started on port 8080. Run unit tests with `./gradlew test`.

**Endpoints**
| Endpoint | Description |
| --- | --- |
| `GET http://localhost:8080/api/hello` | Welcome message from `EventService` |
| `GET http://localhost:8080/api/events` | JSON array with 3 events |
| `GET http://localhost:8080/api/info` | Application name, course and semester from `application.properties` |
| `GET http://localhost:8080/api/events/{id}` | Bonus: one event, or 404 with a JSON error message |

**Structure**
```
src/main/java/kz/iitu/registration/
  EventRegistrationApplication.java
  controller/RegistrationController.java
  service/EventService.java
  model/EventInfo.java
src/main/resources/application.properties
```
- **Model (`EventInfo`)**: a record with `id`, `title`, `location`.
- **Service (`EventService`)**: `@Service`; stores the in-memory event list and the welcome message.
- **Controller (`RegistrationController`)**: `@RestController` on `/api`; receives `EventService` through
  its constructor (dependency injection) and returns data that Spring converts to JSON.
- **Configuration**: `app.course` and `app.semester` are read with `@Value` and shown in `/api/info`.
