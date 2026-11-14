# RadFlow — Project Overview

RadFlow is a portfolio-grade **mini Radiology Information System (RIS) with a DICOM viewer**, demonstrating a synthetic walk-in radiology workflow. It is **not a certified clinical system**.

## Users and modalities
- Roles: Admin, Receptionist, Technician, Radiologist.
- Modality scope: CT, MR and DX.

## Target workflow
Login → Patient Registration → Walk-in Visit → Service Selection → Demo Billing → Worklist → Viewer → Radiologist Reporting → Report Approval → PDF.

## Architecture
A modular monolith with separate frontend applications:

```text
radflow/
├── ris-frontend/       # Angular 21 + TypeScript; Tailwind planned
├── dicom-viewer/       # React + TypeScript + Vite; Cornerstone3D planned
├── radflow-backend/    # Java 17 + Spring Boot 4.0.9 + Spring Data JPA
├── infrastructure/     # Docker Compose / deployment later
├── PROJECT_OVERVIEW.md
└── PROGRESS.md
```

## Technology and constraints
- MySQL 8.0 locally; Flyway owns schema migrations.
- Spring Data JPA, DTOs, service/repository layering and bean validation.
- Mock billing first; Razorpay **Test Mode** later.
- Orthanc when DICOM integration starts. Planned viewer tools: Window/Level, Zoom, Pan, Stack Scroll.
- Git/GitHub; target **₹0 recurring cost initially**.
- **Synthetic patient data only** and appropriately licensed/public demo DICOM studies.
- No committed credentials, production data or real payments.
- Preserve existing office tools; prefer project-local tooling.

## Implementation status — November 14, 2026 (Day 2 closed)

### Working foundation
- Backend compiles/starts and `GET /api/health` was tested (HTTP 200).
- Angular 21 RIS and React/Vite viewer shells are running (reported completed).
- MySQL and Flyway are working; V1 created `patients`, V2 successfully altered it.
- GitHub foundation checkpoint `baf5cd1`; Patient module checkpoint **`7076de3` pushed to `main`**.

### Patient Registration — implemented foundation, not yet an API
- `Patient` JPA entity; `PatientRepository` (Spring startup found one repository).
- `PatientRegistrationRequest` and `PatientRegistrationResponse` DTOs.
- `PatientService` skeleton with constructor injection.
- `MrnGenerator` utility designed to format database IDs as `RF-000001`, etc.

### Important unfinished work
- Design MRN creation compatible with required `mrn` at insert time, avoiding concurrency issues.
- Implement registration business logic, `POST /api/patients`, validation, error handling and Postman tests.
- Review DTO/generator code and confirm Patient getters/setters; verify post-push Git cleanliness.
- Then proceed incrementally to walk-in visits, service selection, mock billing, worklist, viewer, reporting and PDF.
- Authentication and authorization remain a separate planned stage and must be addressed before treating endpoints as secure.

## Development discipline
One manageable task per step, review implementation before proceeding, verify behavior, and stop when the day's agreed target is complete. See `PROGRESS.md` for session checkpoints.
