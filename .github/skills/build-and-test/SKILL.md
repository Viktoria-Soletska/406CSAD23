---
name: build-and-test
description: "Configure pom.xml for Java 17 and JUnit 5, generate AppTest.java, and run Maven tests."
---

# Skill: build-and-test

## When to Apply
Use after `project-scaffold` to configure Maven compilation, test dependencies, and unit tests.

## Inputs
- `project_root`: Maven root directory.
- `package_name` (default: `ua.lpnu.apks`): package containing `App.java`.

## Outputs
- `pom.xml` configured with Java 17 (`maven-compiler-plugin`), `org.junit.jupiter:junit-jupiter` (`test` scope), and `maven-surefire-plugin`.
- `src/test/java/ua/lpnu/apks/AppTest.java` verifying `App.buildGreeting()` and `App.main()` stdout output.

## Verification
```powershell
mvn clean test
```
Success requires exit code `0` and all JUnit 5 tests passing (`Failures: 0, Errors: 0`).

## Error Handling
If compilation or tests fail, halt immediately, record the Maven diagnostic output in `docs/ai-log.md`, and resolve the root cause before continuing.
