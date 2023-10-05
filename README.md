# Devops-final

This project includes several tests to ensure code quality and functionality. You can run the tests both in IntelliJ IDEA and from the command line using Gradle.

## Running Unit & Integration Tests in IntelliJ IDEA

1. Download the project and open it in IntelliJ IDEA.

2. In the project directory structure, right-click the "test" or "integrationTest" directory.

3. Choose "Run 'Tests in..'" to run all tests in that directory.

4. If you want to run a specific test file, right-click the file and choose "Run 'TestFileName'."

## Running System Tests in IntelliJ IDEA

1. Download the project and open the it in IntelliJ IDEA.

2. Right-click on DevopsFinalApplication found in java/com/example/devopsfinal and choose "Run 'DevopsFinalApplication'".

3. In the project directory structure, right-click the "systemTest" directory.

4. Choose "Run 'Tests in..'" to run all tests in that directory.

5. If you want to run a specific test file, right-click the file and choose "Run 'TestFileName'."

## Running Unit & Integration Tests from the Command Line with Gradle

1. Open a terminal.

2. Navigate to the project's root directory.
```bash
  cd my-project
```
3. Run the following command to build the project:
```bash
  ./gradlew build
```
4. Run the following command to execute unit tests: 
```bash
  ./gradlew test
```
5. Run the following command to execute integration tests: 
```bash
  ./gradlew integrationTest
```

## Running System Tests from the Command Line with Gradle
1. Open a terminal.

2. Navigate to the project's root directory.
```bash
  cd my-project
```
3. Run the following command to build the project:
```bash
  ./gradlew build
```
4. Run the DevopsFinalApplication
```bash
./gradlew bootRun 
```
5. Open a new terminal and navigate to the project's root directory.
```bash
  cd my-project
```
6. Run the DevopsFinalApplicationTest
```bash
./gradlew systemTest
```
