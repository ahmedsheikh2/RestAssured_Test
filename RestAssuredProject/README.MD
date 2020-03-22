## Rest Assurred Test
This repo has the source code for API Automation Framework developed for the test


### Tools & Technologies Used:
1) Eclispe
2) Maven
3) TestNG
4) Extent Reports
5) Log4j
6) AssertJ


### Project Setup
- Take clone of this repo in your local environment

- Open the project folder `RestAssuredProject` in any IDE of your choice

- Download all the dependencies by updating Maven

- On Eclipse, right click on project folder and run `Maven Test`

### Project Structure

- Package `com.apitest.validation` contains test file `smokeTest.java` that contains all the validations that are performed

- `com.utils.methods` package contains all the re-useable methods that are used to avoid redundancy within code

- Package `com.api.test.resource` contains resources of API's endpoints that are under test. All the API's paths and JSON payloads are managed under this package

- `resources` package contains utilities used for Extent Reports and Log4j plugins

- `log` folder consist of all the logs that are mantained for each execution

- Html report for execution is generated under folder `target/surefire-reports/ExtentReportsTestNG.html`. Open this file on browser in order to view reports

- `global.properties` file contains test data that is used during execution of test cases


### API's Under Test

Below mentioned API's Endpoints are used for smoke tests

1) Add a new pet to the store
```bash
https://petstore.swagger.io/v2/pet
```

2) Find pet by ID
```bash
https://petstore.swagger.io/v2/pet/1245
```

3) Finds Pets by status
```bash
https://petstore.swagger.io/v2/pet/findByStatus?status=sold
```

4) Deletes a pet
```bash
https://petstore.swagger.io/v2/pet/44702
```


