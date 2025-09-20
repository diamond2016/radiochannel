## Current Status

The project is currently in the initial development phase. The backend has been set up with Spring Boot, and the core domain models (`RadioStation`, `Genre`, `Tag`, `UserFeedback`) have been created as JPA entities.

The service layer has been implemented with `RadioStationService`, `GenreService`, and `UserFeedbackService`, along with their implementations. The data access layer is handled by Spring Data JPA repositories.

The next steps will involve creating REST controllers to expose the services through a REST API, and then developing a frontend to consume the API.

> [!NOTE]
> This documentation is a work in progress.

### Find a Radio Channel
This project aims to discover and add to a database all useful info about radio channels streaming on the Internet.

This will allow you to stream your favorite radio channel.

The technology is based on a Spring Boot java project.

The database will initially be a plain JSON file persisted on the filesystem, while the in-memory system will use an H2 database.

The system consists of bots that scan the Internet and a backend to persist, manage, and serve data.

The frontend will be in JavaScript or ThymeLeaf (to be defined).


### 📚 Public Streaming Radio Databases

- [**Radio Browser**](https://www.radio-browser.info/) is a collaborative platform that collects thousands of radio stations from around the world. It offers:
  - An open API to integrate data into apps or projects.
  - A public database with an open license.
  - Detailed information for each station (name, streaming URL, language, country, genre, etc.).

- [**Maccanismi – Italian Radio Streaming URL List**](https://www.maccanismi.it/2012/08/21/elenco-url-streaming-radio-italiane-sul-web-rtl-rds-radio-kiss-kiss-r101-virgin-radio-e-moltre-altre/) collects over 200 direct links to Italian radio stations, useful if you are interested in a national collection.

- [OpenData StackExchange](https://opendata.stackexchange.com/questions/5406/dataset-of-radio-stations-live-streaming-urls-collaboratively-curated) has discussions and links to user-curated datasets, with technical details and suggestions on licensing and reuse.

---

---

### 🧾 Recommended Data for a Personal Collection

1. RadioStation
Represents a radio station available for streaming.

Field | Type | Description
---|---|---
id | UUID / Long | Unique identifier
name | String | Official station name
streamUrl | String | Direct URL to the audio stream (e.g., .mp3, .aac)
website | String | Official website
country | String | Country of origin
language | String | Main language
bitrate | Integer | Stream quality (e.g., 128 kbps)
codec | String | Audio format (e.g., MP3, AAC)
logoUrl | String | Image/logo URL
isActive | Boolean | Flag to indicate if the link is working
description | String | Short description
genres | List<Genre> | Associated genres (many-to-many relationship)
tags | List<Tag> | Keywords (many-to-many relationship)

2. Genre
Musical or thematic category of the radio (e.g., Rock, Jazz, News, Talk).

Field | Type | Description
---|---|---
id | UUID | Unique identifier
name | String | Name of the genre
description | String | Optional description

**Relationship**: RadioStation ↔ Genre (many-to-many)

3. Tag
Free labels for filtering or categorizing (e.g., “indie”, “politics”, “local”, “live”).

Field | Type | Description
---|---|---
id | UUID | Unique identifier
label | String | Tag text

**Relationship**: RadioStation ↔ Tag (many-to-many)

4. UserFeedback (optional, for future extensions)
Allows users to leave comments, ratings, or reports.

Field | Type | Description
---|---|---
id | UUID | Unique identifier
radioId | UUID | Associated radio station
userId | UUID | User (if authenticated)
rating | Integer | Rating (e.g., from 1 to 5)
comment | String | Free text
timestamp | DateTime | Date and time of the feedback


🔧 Technical Considerations
- **Spring Boot**: Use JPA with Hibernate to manage entity relationships.
- **Separate DTOs**: For REST exposure, it's better to use DTOs to avoid infinite loops in relationships.
- **Validations**: Use annotations like `@NotBlank`, `@URL`, `@Min`, `@Max` to ensure data integrity.
- **Caching**: Useful for valid stream URLs, avoiding repeated calls to non-working radios.
- **Scheduler**: You could implement a periodic job to check the status of streaming links.


## 📐 Diagramma Entità-Relazioni (E-R)

```
[RadioStation]───<associa>───[Genre]
     │                         ▲
     │                         │
     ├────<associa>────[Tag]───┘
     │
     └────<riceve>────[UserFeedback]
```

---

### 🔹 Entità principali

#### 🟦 RadioStation
- **id** (PK)
- name
- streamUrl
- website
- country
- language
- bitrate
- codec
- logoUrl
- isActive
- description

#### 🟩 Genre
- **id** (PK)
- name
- description

> Relazione: **RadioStation ↔ Genre** (molti-a-molti)

#### 🟨 Tag
- **id** (PK)
- label

> Relazione: **RadioStation ↔ Tag** (molti-a-molti)

#### 🟥 UserFeedback *(opzionale)*
- **id** (PK)
- radioId (FK → RadioStation)
- userId *(se previsto)*
- rating
- comment
- timestamp

---

### 🔗 Relazioni

| Relazione            | Tipo           | Cardinalità               |
|----------------------|----------------|---------------------------|
| RadioStation–Genre   | molti-a-molti  | Una radio può avere più generi e viceversa |
| RadioStation–Tag     | molti-a-molti  | Una radio può avere più tag e viceversa    |
| RadioStation–Feedback| uno-a-molti    | Una radio può avere più feedback           |

---
