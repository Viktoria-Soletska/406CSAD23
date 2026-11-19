---
name: check
description: "Validate project structure, Maven build, JUnit 5 tests, and CI configuration without modifying files."
agent: build-engineer
---

## Preconditions
- Project files, scripts, and CI workflow exist in the workspace.

## Actions
1. Verify presence of `pom.xml`, `App.java`, `AppTest.java`, `scripts/ci.sh`, `scripts/ci.bat`, and `.github/workflows/ci.yml`.
2. Run `mvn clean test` and confirm `git check-ignore target/` succeeds.
3. Validate `scripts/ci.sh` syntax (`sh -n scripts/ci.sh` if available) and inspect `ci.yml` structure without editing any files.

## Verification
- Report exact exit codes and test counts; fail immediately if any check fails.
