---
name: init
description: "Orchestrator command: sequentially run git-init, create-project, create-build, create-actions, and check."
agent: build-engineer
---

## Execution Order

Run each command strictly one after another:
1. `/git-init`
2. `/create-project`
3. `/create-build`
4. `/create-actions`
5. `/check`

## Fail-Fast & Idempotence Rules
- Stop immediately if any step fails, is blocked, or reports a conflict; never run dependent steps after a failure.
- Ensure re-running `/init` does not overwrite valid configurations or duplicate entries.
- Record all prompts, diagnostics, and outcomes in `docs/ai-log.md`.
