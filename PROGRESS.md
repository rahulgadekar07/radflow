# RadFlow — Progress Tracker

## Day 1 — November 13, 2026

### Completed
- [x] Create the ChatGPT RadFlow Project and initial project notes.
- [x] Create the GitHub monorepo with `ris-frontend/`, `dicom-viewer/`, `radflow-backend/` and `infrastructure/`.
- [x] Push initial structure (`7158b1d`).
- [x] Set up Java 17, Spring Boot 4.0.9, Maven and MySQL 8.0.
- [x] Compile/start the backend and test `GET /api/health` (HTTP 200).
- [x] Configure Spring Data JPA, MySQL and Flyway; create `radflow_db` and `V1__initial_schema.sql`.

## Day 2 — November 14, 2026

### Foundation completed (earlier session)
- [x] Set up and run the Angular 21 RIS frontend shell.
- [x] Set up and run the React + TypeScript + Vite viewer shell.
- [x] Push foundation work to GitHub (previous checkpoint `baf5cd1`).
- [x] Confirm Flyway V1 success through the local schema history.

### Patient Registration backend (evening session)
- [x] Diagnose failed Flyway V2: V1 had already created `patients`.
- [x] Change V2 to `V2__alter_patients_table.sql`, resolve failed local migration history, and successfully apply V2.
- [x] Verify Spring Boot starts, MySQL connects, Flyway reports version 2 and JPA initializes.
- [x] Create `Patient` JPA entity.
- [x] Create `PatientRepository` with `findByMrn` and `existsByMrn`; startup confirmed **1 JPA repository**.
- [x] Create `PatientRegistrationRequest` DTO with validation annotations.
- [x] Create `PatientRegistrationResponse` DTO (completion reported; not separately code-reviewed).
- [x] Create `PatientService` constructor-injection skeleton.
- [x] Create `MrnGenerator` (`RF-` plus padded database ID; completion reported, not separately code-reviewed).
- [x] Commit and push patient foundation to `main`: **`7076de3`** (`feat(patient): add patient entity repository DTOs and service foundation`).

### Current design and known gaps
- The `patients` table has a required `full_name` and a required unique `mrn`. V2 added nullable `first_name`, `last_name`, `phone`.
- `MrnGenerator` derives MRN from the database ID, but a safe persistence sequence compatible with the current `mrn NOT NULL` constraint is **not implemented yet**.
- The service does not yet register patients; no registration controller/endpoint or registration Postman tests have been completed.
- Validation annotations will need `@Valid` at the controller boundary.
- Confirm getters/setters exist in `Patient` and review current DTO/generator code during next session.
- Git push was verified; a final post-push clean `git status` and credential/ignore review were not shown in the shared output.

### Next session — one small vertical slice at a time
1. Inspect current schema and decide a safe, concurrency-aware MRN persistence strategy; add a new Flyway migration if needed (do not edit applied V1/V2).
2. Implement `PatientService.registerPatient()` and map request/response DTOs.
3. Add `POST /api/patients` with `@Valid`; test happy path and validation/error paths in Postman with **synthetic patients only**.
4. Verify database state, review changes, and commit only tested work.

### Working agreement
- Set a realistic 30–60 minute session target and work **one task at a time**: implement → review → test → proceed.
- **Stop the session once the target is met**; do not automatically expand scope.
- End sessions with verification, Git status, a concise progress update, and the next starting point.
- Protect office development tooling and keep secrets and real patient data out of Git.

### Environment
Windows 11 · Java 17.0.12 · Spring Boot 4.0.9 · Maven 3.9.12 · MySQL 8.0.46 · Angular 21 · React + TypeScript + Vite.
