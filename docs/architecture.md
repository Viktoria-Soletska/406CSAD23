# Архітектура AI-агента (`build-engineer`)

## 1. Призначення та задачі агента

Агент **Build Engineer** розроблений для повної автоматизації життєвого циклу кросплатформного Java-проєкту (Варіант 23: Java 17, Apache Maven, JUnit 5). Він замінює розрізнені одноразові промпти на структурований, відтворюваний процес:

- формування стандартної ієрархії каталогів Maven та правил `.gitignore`;
- генерація вихідного коду застосунку *Hello World* та модульних тестів JUnit 5;
- конфігурація збірки в `pom.xml` та кросплатформних скриптів `scripts/ci.sh` і `scripts/ci.bat`;
- створення матричного конвеєра `.github/workflows/ci.yml` для Ubuntu, Windows і macOS;
- автоматична валідація результату без пошкодження існуючих файлів репозиторію.

## 2. Навички (Skills) та команди (Commands)

| Рівень | Ідентифікатор | Шлях | Призначення |
|---|---|---|---|
| Manifest | `build-engineer` | `.github/agents/build-engineer.agent.md` | Системна роль, обмеження безпеки, критерії завершення |
| Skill 1 | `project-scaffold` | `.github/skills/project-scaffold/SKILL.md` | Розгортання структури Maven, `App.java` та `.gitignore` |
| Skill 2 | `build-and-test` | `.github/skills/build-and-test/SKILL.md` | Налаштування `pom.xml`, генерація `AppTest.java` і запуск `mvn test` |
| Skill 3 | `github-actions` | `.github/skills/github-actions/SKILL.md` | Генерація `scripts/ci.sh`, `scripts/ci.bat` та `.github/workflows/ci.yml` |
| Command | `git-init` | `.github/prompts/git-init.prompt.md` | Перевірка Git-стану та оновлення `.gitignore` |
| Command | `create-project` | `.github/prompts/create-project.prompt.md` | Запуск навички `project-scaffold` |
| Command | `create-build` | `.github/prompts/create-build.prompt.md` | Запуск навички `build-and-test` |
| Command | `create-actions` | `.github/prompts/create-actions.prompt.md` | Запуск навички `github-actions` |
| Command | `check` | `.github/prompts/check.prompt.md` | Перевірка структури, збірки, тестів і YAML без редагування коду |
| Orchestrator | `init` | `.github/prompts/init.prompt.md` | Послідовний запуск `git-init` → `create-project` → `create-build` → `create-actions` → `check` |

## 3. Потік даних між етапами

```text
Запит користувача (/init)
   │
   ▼
[1] /git-init ────────► Стан Git + базовий .gitignore
   │
   ▼
[2] /create-project ──► Skill: project-scaffold ──► src/main/java/ua/lpnu/apks/App.java
   │
   ▼
[3] /create-build ────► Skill: build-and-test ────► pom.xml + AppTest.java + результат mvn test
   │
   ▼
[4] /create-actions ──► Skill: github-actions ────► scripts/ci.sh, scripts/ci.bat, ci.yml
   │
   ▼
[5] /check ───────────► Незалежна перевірка збірки, тестів і конфігурацій + запис у docs/ai-log.md
```

## 4. Обробка помилок (Fail-Fast)

Оркестратор `init` виконує кожен крок по черзі та негайно зупиняє конвеєр, якщо:
- будь-яка команда повертає ненульовий код завершення або помилку компіляції/тесту;
- відсутні необхідні інструменти (JDK, Maven) або виявлено конфлікт існуючих файлів;
- у конфігурації CI або скриптах виявлено синтаксичну помилку.

Після усунення причини помилки повторний запуск команд є ідемпотентним і не пошкоджує вже створені файли.
