---
name: create-actions
description: "Invoke github-actions skill to create scripts/ci.sh, scripts/ci.bat, and ci.yml."
agent: build-engineer
---

## Preconditions
- `pom.xml` and `AppTest.java` pass local `mvn clean test`.

## Actions
1. Apply skill `.github/skills/github-actions/SKILL.md`.
2. Create `scripts/ci.sh` and `scripts/ci.bat` running `mvn clean test package`.
3. Create `.github/workflows/ci.yml` with matrix strategy (`ubuntu-latest`, `windows-latest`, `macos-latest`) triggered on `push` and `pull_request` to `develop` and `main`.

## Verification
- Confirm `ci.yml` delegates execution to `scripts/ci.sh` and `scripts/ci.bat` with no inline Maven commands.
