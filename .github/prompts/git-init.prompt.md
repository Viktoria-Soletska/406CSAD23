---
name: git-init
description: "Verify Git repository state, update .gitignore, and inspect working tree status."
agent: build-engineer
---

## Preconditions
- Target workspace is readable.

## Actions
1. Check `git status` and ensure the repository is initialized without altering existing history.
2. Create or update `.gitignore` to exclude `target/`, `.idea/`, `*.class`, `.DS_Store`, and `Thumbs.db`.

## Verification
- Confirm `.gitignore` exists and `git check-ignore target/` matches `target/`.
