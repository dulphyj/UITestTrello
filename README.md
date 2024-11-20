# Automated UI Test for Trello Page

This repository contains automated UI tests for Trello's web page. The tests are written in Java and utilize Selenium for web automation, Cucumber for behavior-driven development (BDD), Log4j2 for logging, and Gradle for project management.

## Prerequisites

Before running the tests, make sure you have the following installed:

- Java JDK
- Gradle

## Setup

1. Clone this repository to your local machine.
2. Navigate to the project directory.

```bash
git clone https://github.com/dulphyj/UITestTrello.git
cd UITestTrello
```

3. Create a `gradle.properties` file in the root directory of the project with the following content:

```properties
email="your-email"
password="your-password"
webUrl=https://trello.com/login
```

Replace `"your-email"` and `"your-password"` with your Trello account credentials.

## Running Tests

To run the tests, execute the following command:

```bash
./gradlew clean executeFeatures -PcucumberOptions="@the-feature-to-run"
```

Replace `"the-feature-to-run"` with the specific feature file or scenario you want to execute.

## Project Structure

- `src/main/java`: Contains the Java source code.
- `src/test/java`: Contains the test files.
- `src/test/resources/features`: Contains the feature files written in Gherkin syntax.
- `build.gradle`: Contains project dependencies and configuration.

## Logging

Logging is implemented using Log4j2. Logs can be found in the `logs` directory.


## Acknowledgments

- Thanks to the developers of Selenium, Cucumber, Log4j2, and Gradle for their amazing tools.
- Special thanks to the Trello team for providing a platform for project management.

---