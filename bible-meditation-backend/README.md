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

## API
- POST /api/meditations
  - body: { "reference": "John 3:16", "verseText": "...(optional)", "contextTag": "anxiety"(optional) }

- GET /api/meditations/health
