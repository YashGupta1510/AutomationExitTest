# TestNG Selenium Assignment - Automation Testing for Flipkart.com

This project automates 20 test cases for Flipkart.com using Selenium WebDriver, Java, TestNG, and following the Page Object Model (POM) architecture. It includes features like selective test execution based on an Excel file, central configuration through properties files, logging, and Extent Reports for detailed test reporting. The project also utilizes custom-made utility JAR files for common functionalities and integrates with Jenkins for continuous integration and continuous deployment (CI/CD).

## Features:

- **TestNG Framework**: Organizes test cases and facilitates parallel execution.
- **Selenium WebDriver**: Automates web browser interactions.
- **Page Object Model (POM)**: Enhances test maintenance and readability by separating page-specific actions and locators.
- **Annotation Transformer**: Allows marking test cases for execution via an Excel file.
- **Properties File**: Centralizes configuration settings such as base URLs.
- **Logging**: Provides detailed logs for debugging and tracking test execution flow.
- **Extent Reports**: Generates HTML reports with comprehensive test execution results.
- **Custom Utilities (JAR files)**: Reusable components for common functionalities.
- **Jenkins Integration**: Supports automated builds and test execution as part of CI/CD pipelines.

## Project Structure:

- **src/main/java**: Contains the main Java source files.
  - **annotationUtils**: Includes Anottaion Transformer class for Selective execution of test cases based on the Excel file.
  - **listenerUtils**: Custom Test Listener for proper logging and reporting.
  - **pages**: Page classes based on POM for different pages of Flipkart.com.
- **src/main/resources**: Contains the main resources files.
 - **log4j2.xml**: Configuration for logging.

- **src/test/java**: Holds the test classes.
  - **tests**: Test classes implementing the TestNG framework.
- **src/test/resources**: Contains the main resources files.
  - **config.properties**: Base configuration for the project including base urls.
  - **flipkart_test_cases.xlsx**: Contains all the test cases with their description, test data, test name and execution required dropdown

- **testng.xml**: TestNG configuration file defining suites and test cases.

- **logs**
  -**output.log**: Logs created during the run are stored here.
- **report**
  -**TestReport.html**: Html file for the Extent Report generated after completion of suite.
- **screenshots**
  -**imgs**: Screenshots taken by the driver when a test case fails.
- **libs**
  -**exit-test-utils-0.0.1-SNAPSHOT.jar**: Utilities JAR created for common utilites and basic funcitons.

## Setup Instructions:

1. **Prerequisites**:
   - Java JDK installed (8)
   - Maven installed (version 3.6.3)
   - WebDriver binaries are not required if using latest selenium(4.x+)

2. **Project Setup**:
   - Clone the repository: `git clone https://github.com/YashGupta1510/AutomationExitTest.git`
   - Import the project into your IDE (Eclipse, IntelliJ IDEA, etc.).

3. **Configuration**:
   - Update `config.properties` with appropriate URLs and other settings.
   - Ensure Excel file (`flipkart_test_cases.xlsx`) for selective test execution is correctly formatted.

4. **Building and Running Tests**:
   - Run `mvn clean test` to compile the project and execute the tests.
   - Alternatively, trigger builds and tests using Jenkins pipelines.

5. **Viewing Reports**:
   - After test execution, view Extent Reports (`report/TestReport.html`) for detailed test results.

6. **CI/CD Integration**:
   - Configure Jenkins jobs to build the project and trigger tests automatically.

7. **Troubleshooting**:
   - Check logs (`/logs/output.log`) for debugging purposes.
   - Verify Jenkins console output for build and test failures.

## Contributors:

- **Yash Gupta** - *Initial work* - [YashGupta1510](https://github.com/YashGupta1510)

