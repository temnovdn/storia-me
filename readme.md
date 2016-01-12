1. написать вехнеуровневый тест-план (10-12 блоков, детализация на уровне названий тест-кейсов или групп тест-кейсов) для проведения функционального тестирования формы авторизации пользователя на сайте storia.me; 
2. текстом описать вариант реализации фреймворка для автоматизации тестирования формы авторизации; 
3. написать простой скрипт автоматизирующий позитивный тестовый сценарий для входа в приложение и продемонстрировать его работу.

This is a template for a storia.me functional tests framework.
Created as a maven artifact with use of Selenium and TestNG.

To run tests from bash:

$ mvn clean test -Dtest=login.xml

To run tests from IntelliJ Idea - rightclick on login.xml and select "Run".

Test log will be in ./logs/admin.log

#Test method me.storia.login.StoriaMeLoginTests.passwordUsernameLogin needs valid login/password to pass.
