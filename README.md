# sample-java-framework
A lite framework for quick sanity checks

Download IntelliJ community edition
https://www.jetbrains.com/idea/download/#section=mac

Open project directory in IntelliJ
(Give IntelliJ some time to finish processes and download dependencies, you’ll see it running at the bottom of the window)

If you navigate to a JAVA file and see a message saying “Project SDK is not defined” click the Setup SDK text

Make sure in the maven Project Settings > Project you have JDK 1.8 as your java path.
Same for Platform Settings > SDKs should be 1.8 as well.
If you dont see it in the list you may need to download the 1.8 JDK from oracle site.

Click the Maven tab on the right hand side of IntelliJ
Then double click test to run tests

To see the rich, step by step, reporting including screenshots after the build is finished,
go to the allure project on the right hand side. Double click allure:report and wait for build success,
then double click allure:serve. When the report opens in the browser click xUnit on the right side
this will take you to all of the test cases that were executed

![Alt text](/src/main/resources/allureExample.png?raw=true "Reporting Example")

