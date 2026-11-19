---
name: github-actions
description: "Generate cross-platform build scripts (scripts/ci.sh, scripts/ci.bat) and GitHub Actions matrix workflow."
---

# Skill: github-actions

## When to Apply
Use after local Maven build and tests pass to automate cross-platform CI on Ubuntu, Windows, and macOS.

## Inputs
- `project_root`: repository root with verified `pom.xml`.
- `branches`: `develop`, `main`.

## Outputs
- `scripts/ci.sh`: POSIX shell script (`#!/bin/sh`, `set -eu`, `exec mvn clean test package`) with LF line endings.
- `scripts/ci.bat`: Windows batch script (`@echo off`, `mvn clean test package`).
- `.github/workflows/ci.yml`: matrix workflow running on `ubuntu-latest`, `windows-latest`, and `macos-latest` that delegates build execution strictly to `scripts/ci.sh` and `scripts/ci.bat`.

## Verification
- Confirm `ci.yml` triggers on `push` and `pull_request` to `develop` and `main`.
- Confirm all 3 matrix OS jobs complete with status `success` on GitHub Actions.

## Error Handling
If a runner fails (e.g., script path mismatch, missing execute permission, or CRLF line endings), halt, log the runner error in `docs/ai-log.md`, and apply a targeted fix.
