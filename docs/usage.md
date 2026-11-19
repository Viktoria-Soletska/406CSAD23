# Інструкція запуску AI-агента та локальної перевірки (`406CSAD23`)

## 1. Запуск AI-агента у VS Code

1. Відкрийте проєкт `406CSAD23` у Visual Studio Code із активованим **GitHub Copilot Chat**.
2. Перемкніться на агента **`build-engineer`** (файл маніфесту `.github/agents/build-engineer.agent.md`).
3. Для повного розгортання проєкту з нуля виконайте оркестратор:
   ```text
   /init
   ```
4. Для точкового запуску окремих етапів використовуйте команди:
   - `/git-init` — перевірка репозиторію Git та правил `.gitignore`;
   - `/create-project` — генерація структури каталогів та `App.java`;
   - `/create-build` — створення `pom.xml` і тестів `AppTest.java`;
   - `/create-actions` — створення `scripts/ci.sh`, `scripts/ci.bat` та `.github/workflows/ci.yml`;
   - `/check` — перевірка збірки, тестів і YAML-конфігурації без зміни коду.

## 2. Локальне складання та тестування

### Windows (PowerShell / CMD)
```powershell
.\scripts\ci.bat
```
або напряму через Maven:
```powershell
mvn clean test package
```

### Linux / macOS (Bash / SH)
```bash
chmod +x scripts/ci.sh
./scripts/ci.sh
```

## 3. Очікуваний результат

- Компіляція під **Java 17** завершується без помилок;
- Усі модульні тести `AppTest` на **JUnit 5** проходять (`Failures: 0, Errors: 0`);
- Генерується артефакт у каталозі `target/`, який ігнорується Git (`git status` залишається чистим).
