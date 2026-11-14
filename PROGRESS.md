# RadFlow — Progress Tracker

## Day 1 — November 13, 2026

### Completed and verified
- [x] Create ChatGPT RadFlow Project and project notes
- [x] Create GitHub monorepo with `ris-frontend/`, `dicom-viewer/`, `radflow-backend/`, and `infrastructure/`
- [x] Commit and push initial directory structure to `main` (`7158b1d`)
- [x] Generate Spring Boot backend (Java 17, Maven, Spring Boot 4.0.9)
- [x] Fix IntelliJ Maven import by selecting installed Maven 3.9.12
- [x] Compile and run backend successfully
- [x] Implement and test `GET /api/health` in Postman (HTTP 200)
- [x] Create local MySQL database `radflow_db`
- [x] Add Spring Data JPA, MySQL and Flyway dependencies
- [x] Configure environment-variable-based DB credentials
- [x] Create `V1__initial_schema.sql`; observed `patients` and `flyway_schema_history` tables in HeidiSQL

### Still to verify
- [ ] Confirm V1 success record in `flyway_schema_history`
- [ ] Confirm current backend code, migrations, and configuration are committed and pushed (only initial folder commit was verified)
- [ ] Review Git ignore rules and tracked files for local credentials before pushing

### Deferred
- [ ] Angular frontend shell (CLI 22 requires a newer Node patch than installed)
- [ ] React/Vite DICOM viewer shell
- [ ] Initial project documentation committed in the monorepo

### Environment / blockers
- Windows 11, Java 17.0.12, global Maven 3.9.12, MySQL 8.0.46
- Node 24.13.1; latest Angular CLI 22.2.7 requires Node 24.15.0 or another supported runtime
- Global `ng` command was unavailable after installation. Do not change global Node/npm or remove global packages until impact on existing office projects is understood.
- Maven Wrapper 3.10.0 encountered Windows temp-folder access errors; installed Maven 3.9.12 worked.

## Day 2 — November 14, 2026

### Goal
Finish the foundation and push it safely, without changing or breaking the existing office development setup.

### Plan (one task at a time; ~60–90 minutes if no new blockers)
- [ ] **1. Safety and Git review (~15 min):** inspect `git status`, ignored/untracked files and `.gitignore`; ensure secrets, `.idea/`, `target/`, `node_modules/` and build outputs will not be committed. Check whether the current machine shares tools with office projects.
- [ ] **2. Angular RIS shell (~20–25 min):** use project-local Angular CLI 21 with existing Node 24.13.1 (no global Node upgrade). Generate directly in `ris-frontend/`, install dependencies, and verify `localhost:4200`.
- [ ] **3. React viewer shell (~15–20 min):** scaffold React + TypeScript with Vite inside `dicom-viewer/`, install dependencies and verify the Vite dev server. Do not install Cornerstone3D yet.
- [ ] **4. Final checks and Git push (~15–20 min):** verify Flyway V1 history, ensure no credentials or generated dependencies are staged, commit backend + frontend shells + project docs, push to GitHub and confirm clean status.

### Next development session (after Day 2 foundation)
Start the first patient registration vertical slice: Patient JPA entity → repository → service → DTO/controller → Postman test, with synthetic data only. Schedule authentication/security as a separate, focused stage.

### Working agreement
One manageable task, verification, then the next. No changes to system-wide Node/npm/Angular tooling without evaluating impact on work projects.
