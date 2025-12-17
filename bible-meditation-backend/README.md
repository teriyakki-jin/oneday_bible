# Bible Meditation Backend (Spring Boot)

## Run (Windows)
```bash
cd bible-meditation-backend
gradlew.bat bootRun
```

## Run (Mac/Linux)
```bash
cd bible-meditation-backend
./gradlew bootRun
```

Server: http://localhost:8080

### Frontend

The project now serves a minimal web UI for creating meditations.

- Open http://localhost:8080 in a browser while the server is running.
- Enter a reference (예: `John 3:16`), pick a context, and optionally paste the verse text.
- The page will call the backend and render a short reflection, prayer, and a list of recent meditations.

## API
- POST /api/meditations
  - body: { "reference": "John 3:16", "verseText": "...(optional)", "contextTag": "anxiety"(optional) }

- GET /api/meditations/health
