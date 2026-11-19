---
name: create-build
description: "Invoke build-and-test skill to configure pom.xml, JUnit 5 tests, and verify locally."
agent: build-engineer
---

## Preconditions
- `src/main/java/ua/lpnu/apks/App.java` exists.

## Actions
1. Apply skill `.github/skills/build-and-test/SKILL.md`.
2. Create `pom.xml` targeting Java 17 and JUnit 5.
3. Create `src/test/java/ua/lpnu/apks/AppTest.java` and run `mvn clean test`.

## Verification
- Maven exits with `0` and `AppTest` reports `Failures: 0, Errors: 0`.
