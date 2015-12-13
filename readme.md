This is a template for a storia.me functional tests framework.
Created as a maven artifact with use of Selenium and TestNG.

To run tests from bash:

$ mvn clean test -Dtest=login.xml

To run tests from IntelliJ Idea - rightclick on login.xml and select "Run".

Test log will be in ./logs/admin.log

Test method me.storia.login.StoriaMeLoginTests.passwordUsernameLogin needs right login/password to pass.