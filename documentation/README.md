# Sber "beautifulcode" сервис проверки скобок в тексте

## Сборка и запуск сервиса

### Собираем jar
```bash
./gradlew brackets-service:infrastructure:bootstrap:uberJar
```

### Запускаем сервис (у вас должна быть установлена java 17)
```bash
java -jar ./codebase/brackets-service/infrastructure/bootstrap/build/libs/bootstrap-1.0-uber.jar
```
