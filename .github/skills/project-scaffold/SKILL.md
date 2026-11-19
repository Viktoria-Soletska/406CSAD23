---
name: project-scaffold
description: "Create standard Java 17 Maven directory layout, App.java, and .gitignore rules."
---

# Skill: project-scaffold

## When to Apply
Use when initializing a new Java 17 Maven project or verifying the base directory structure.

## Inputs
- `project_root`: target workspace path.
- `package_name` (default: `ua.lpnu.apks`): Java package for source and test files.

## Outputs
- `src/main/java/ua/lpnu/apks/App.java` containing `main(String[] args)` and `static String buildGreeting()` returning `"Hello, World!"`.
- `src/test/java/ua/lpnu/apks/` directory ready for JUnit 5 tests.
- `.gitignore` excluding `target/`, `.idea/`, `*.class`, `.DS_Store`, and `Thumbs.db`.

## Verification
- Confirm `App.java` exists and prints `Hello, World!`.
- Run `git check-ignore target/` to verify build outputs are excluded from Git.

## Error Handling
If a target file already exists with conflicting logic, halt and report the conflict instead of overwriting user changes.
