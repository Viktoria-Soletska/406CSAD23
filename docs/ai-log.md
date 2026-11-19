# Журнал взаємодії з AI (`docs/ai-log.md`)

**Проєкт:** `406CSAD23` — Лабораторна робота №1 (Проєктування AI-агента для автоматизації розробки та CI/CD)  
**Варіант:** 23 (Java 17, Apache Maven, JUnit 5)

## Реєстр запитів та результатів

| ID | Етап | Запит / Дія | Змінені файли | Статус | Примітки та діагностика |
|---|---|---|---|---|---|
| L-01 | Архітектура | Створення маніфесту агента (`build-engineer.agent.md`), опису архітектури (`architecture.md`) та інструкції (`usage.md`). | `.github/agents/build-engineer.agent.md`, `docs/architecture.md`, `docs/usage.md`, `docs/ai-log.md` | Успішно | Базова гілка `develop`: визначено роль, правила безпеки та fail-fast стратегію. |
| L-02 | Навички (Skills) | Визначення модульних навичок `project-scaffold`, `build-and-test` і `github-actions`. | `.github/skills/project-scaffold/SKILL.md`, `.github/skills/build-and-test/SKILL.md`, `.github/skills/github-actions/SKILL.md`, `docs/ai-log.md` | Успішно | Задано вхідні/вихідні дані, перевірки та обробку помилок для кожного skill. |
| L-03 | Команди та Оркестратор | Створення 5 команд (`git-init`, `create-project`, `create-build`, `create-actions`, `check`) та оркестратора `init`. | `.github/prompts/*.prompt.md`, `docs/ai-log.md` | Успішно | Налаштовано ідемпотентний запуск і fail-fast зупинку при помилках. |
| L-04 | Проєкт і тести | Генерація `.gitignore`, `pom.xml`, `App.java` (`buildGreeting()`) та `AppTest.java`; локальна перевірка `mvn clean test`. | `.gitignore`, `pom.xml`, `src/main/java/ua/lpnu/apks/App.java`, `src/test/java/ua/lpnu/apks/AppTest.java`, `docs/ai-log.md` | Успішно | `Tests run: 2, Failures: 0, Errors: 0`, `BUILD SUCCESS`; `target/` ігнорується Git. |
