This is a template for a storia.me functional tests framework.
Created as a maven artifact with use of Selenium and TestNG.
Uses Yandex.Allure as a report module.

To run tests:

$ mvn clean test -Dtest=login.xml

Results will be generated as XML file:

To generate cool HTML test report from XML file above:

$ mvn site

Report will be generated in: 