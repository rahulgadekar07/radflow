# RadFlow — Project Overview

RadFlow is a portfolio-grade **mini Radiology Information System (RIS) and PACS viewer** for demonstrating a synthetic walk-in radiology workflow. It is not intended for clinical use.

## Users
Admin, Receptionist, Technician, Radiologist.

## Supported modalities
CT, MR, DX.

## Core workflow
Login → Patient Registration → Walk-in Visit → Service Selection → Demo Billing → Worklist → Viewer → Radiologist Reporting → Report Approval → PDF.

## Viewer tools (planned)
Window/Level, Zoom, Pan, Stack Scroll.

## Architecture
A modular monolith with a separate viewer frontend:

```text
radflow/
├── ris-frontend/       # Angular + TypeScript; Tailwind planned
├── dicom-viewer/       # React + TypeScript + Vite; Cornerstone3D planned
├── radflow-backend/    # Java 17 + Spring Boot + Spring Data JPA
├── infrastructure/     # Docker Compose / deployment configuration (later)
├── PROJECT_OVERVIEW.md
└── PROGRESS.md
```

## Data and infrastructure
- MySQL locally; schema changes managed by Flyway migrations
- Mock payments initially, Razorpay Test Mode later
- Orthanc when DICOM integration begins
- Git + GitHub for version control
- Target ₹0 recurring hosting cost initially
- Synthetic patients and licensed/public demo DICOM studies only
- Never commit secrets or real patient data
- Preserve existing office tooling; prefer project-local versions

## Verified implementation at end of Day 1 (2026-11-13)
- GitHub repository created and initial directory structure pushed
- Spring Boot 4.0.9 backend compiled and launched with Java 17
- `GET /api/health` returned HTTP 200 from Postman
- `radflow_db` created in local MySQL 8.0
- Flyway V1 created `patients` and `flyway_schema_history` tables (history row still to be checked)

## Current milestone
Finish Angular RIS and React viewer shells, review Git security, and commit/push the full foundation. See `PROGRESS.md` for Day 2 tasks.
