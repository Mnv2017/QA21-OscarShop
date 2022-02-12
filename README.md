# Selenium project OscarWebStore

This project is intended to test website [OscarWebStore][OscarWebStore].

## Description

The project is written in [Java][Java] using [Selenium Webdriver][Selenium] and [TestNG][TestNG] testing framework.
[Gradle][Gradle] was used to build the project, as IDE was used [IntelliJ IDEA][IDE].

The project includes GUI tests to check the currently developed functionality of the site. The test suite is conventionally divided into **user, homepage, product** and **basket** modules.

Two test suites are formed:
- ***smoke-test*** with a script for logging in to the site and making book purchases.
- ***regression-suite***, which presents a set of tests for regression testing.

Test launching is automated with [Jenkins][Jenkins].

## Environment

The website was tested in **MacOS Big Sur v11.6.2** in the **Chrome v97** at a screen resolution of **2880 × 1800**.

## Installation

To configure the test environment and start the project, do the following steps:

* To work with Java you need to install [IDEA Community Edition][Idea]
  and [JDK 11][JDK].
* Create a `Tools/` directory in your computer's home directory.
* Download [Gradle 7.3.2][Gradle 7.3.2] and install it in the `Tools/` directory.
* Download and install [Google Chrome][Chrome].
* Download the appropriate version of the [ChromeDriver][ChromeDriver] and put it in the `Tools/` directory.

### Environment Variables

To specify the paths to the installed tools, you need to set environment variables.
This can be done by adding the following commands to the .bash_profile:

 ```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
export PATH=/Users/homedirectory/Tools:$PATH
export GRADLE_HOME=/Users/homedirectory/Tools/gradle-7.3.2
export PATH=$PATH:$GRADLE_HOME/bin
 ```
### Install and configure Jenkins

* Download [Jenkins (LTS)][Jenkins LTS] and put `jenkins.war` in the `Tools/` directory.
* Open a terminal in the `Tools/` directory and start Jenkins with command:
``` bash
java -jar jenkins.war
```
* Once started, you can access Jenkins at [localhost:8080](http://localhost:8080).
* In Jenkins user interface create `New Item` with type `Freestyle project`.

<details>
 <summary> Make the settings in section <strong><ins>Configure</ins></strong> as shown in the screenshots:</summary>
  <br/>

![Source Code Management](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/Jenkins1.png)

![Build](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/Jenkins2.png)

![Post-Build-Actions](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/Jenkins4.png)

 </details>

## Usage

### Running with Jenkins
<details>
 <summary> After starting the job in Jenkins with <strong><ins>Build now</ins></strong> the tests will start to run. </summary>
 <br/>

![Source Code Management](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/Jenkins%20Results%2013.png)

 </details>

<details>
 <summary> The results of the tests will be displayed in section <strong><ins>Test Result</ins></strong>. </summary>
 <br/>

![Source Code Management](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/JResults2-2.png)

 </details>

### Running with Gradle from the terminal

* ***Clone*** the project from GitHub onto your computer (if you want to make changes, do a ***fork*** to your repository first):
 ```bash
 git clone https://github.com/Mnv2017/QA21-OscarShop.git
 ```
* Open a terminal in the project directory and run the following commands:
```bash
./gradlew clean testSuite1
```
to run the **smoke test**,

```bash
./gradlew clean testAll
```
to run the **regression suite**.

### Running in IDE

* In Intellij IDEA create a new `Java` + `Gradle` project and select the clone directory as the project `Location`.
* File `build.gradle` contains the following dependencies:
 ```groovy
 dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:3.141.59'
    implementation 'org.testng:testng:7.4.0'
    implementation 'ch.qos.logback:logback-classic:1.2.3'
    implementation 'org.apache.commons:commons-math3:3.6.1'
}
 ```
* Create a directory `test_logs` at the root of the project. You can build project and run tasks in IDE.
 <details>
 <summary>Files with test results will be created in the directory <strong><ins>test_logs</ins></strong>: </summary>
 <br/>

![Log-files](https://github.com/Mnv2017/QA21-OscarShop/blob/main/images/IDEA-Log.png)

 </details>


[OscarWebStore]: https://selenium1py.pythonanywhere.com/en-gb/

[Gradle]: https://gradle.org/

[Gradle 7.3.2]: https://gradle.org/releases/

[java]: https://www.java.com/en/

[Selenium]: https://www.selenium.dev/

[TestNG]: https://testng.org/doc/index.html

[Jenkins]: https://www.jenkins.io/

[Jenkins LTS]: https://www.jenkins.io/download/

[IDE]: https://www.jetbrains.com/idea/

[Idea]: https://www.jetbrains.com/idea/download/#section=mac

[JDK]: https://adoptium.net/?variant=openjdk11&jvmVariant=hotspot

[Chromedriver]: https://sites.google.com/chromium.org/driver/

[Chrome]: https://www.google.com/chrome/
