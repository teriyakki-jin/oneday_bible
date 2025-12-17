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

The project serves a refreshed web UI for creating meditations and reviewing recent ones.

- Open http://localhost:8080 in a browser while the server is running.
- Enter a reference (e.g., `John 3:16`), pick a context, and optionally paste the verse text.
- Submit to receive a reflection and prayer; recent meditations appear beneath the form.

## API
- POST /api/meditations
  - body: { "reference": "John 3:16", "verseText": "...(optional)", "contextTag": "anxiety"(optional) }

- GET /api/meditations/health
