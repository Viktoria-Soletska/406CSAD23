---
name: create-project
description: "Invoke project-scaffold skill to create Maven directory layout and App.java."
agent: build-engineer
---

## Preconditions
- `.gitignore` is configured so `target/` will remain untracked.

## Actions
1. Apply skill `.github/skills/project-scaffold/SKILL.md`.
2. Generate `src/main/java/ua/lpnu/apks/App.java` with `main()` and `buildGreeting()`.
3. Create `src/test/java/ua/lpnu/apks/` directory.

## Verification
- Confirm `App.java` exists and no existing user files were overwritten.
