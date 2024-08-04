# Команды для запуска тестов
***
Для запуска тестов локально на реальном устройстве использовать команду:
```shell
gradle clean test -DdeviceHost=real
```
***
Для запуска тестов локально на эмуляторе использовать команду:
```shell
gradle clean test -DdeviceHost=emulation
```
***
Для запуска тестов в Browserstack использовать команду:
```shell
gradle clean test -DdeviceHost=browserstack
```
***
При запуске по команде
```shell
gradle clean test 
```
тесты по умолчанию запускаются в Browserstack.
