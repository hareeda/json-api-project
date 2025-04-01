JsonPlace API Automation Project
Overview
The JsonPlaceApiProject is an API automation testing framework designed to validate RESTful API endpoints using RestAssured, TestNG, and Karate. It ensures data integrity, validates responses against JSON schemas, and performs data-driven testing.

Features
Automated API Testing with RestAssured & Karate.

CRUD Operations Coverage: GET, POST, PUT, PATCH, DELETE.

JSON Schema Validation for API responses.

Data-Driven Testing using Excel (Apache POI).

Custom Reporting using Extent Reports.

Modular Framework with reusable API utilities.

BDD API Testing with Karate for alternative automation.

Tech Stack
Programming Language: Java

API Testing Frameworks: RestAssured, Karate

Test Runner: TestNG

Schema Validation: JSON Schema

Data Handling: Excel (Apache POI)

Reporting: Extent Reports

Build Tool: Maven

Method	HTTP Method	Description
getSingleResourceRequestTest()	GET	Retrieves a single resource and validates the response schema & data.
getListResourcesTest()	GET	Fetches a list of resources and validates JSON schema.
postResourcesRequest()	POST	Creates a new resource using data-driven testing and validates response.
putRequestTest()	PUT	Updates an existing resource and verifies the response.
patchRequestTest()	PATCH	Partially updates a resource and validates the response.
deleteRequestTest()	DELETE	Deletes a resource and verifies a successful deletion.
filterRequestTest()	GET (Filter)	Retrieves filtered results and validates JSON schema.
nestRequestTest()	GET (Nested)	Executes nested API requests and verifies JSON schema.

Prerequisites
Java 8+ installed

Maven installed
Git installed

Steps to Clone and Run
Clone the repository
git clone https://github.com/hareeda/JsonPlaceApiProject.git
cd JsonPlaceApiProject
Install dependencies

mvn clean install
Run API tests using Maven

mvn test
Run Karate tests

Open KarateRunner.java
Run as JUnit Test
Reporting
API test execution reports will be available in the Reports/ directory.
Extent Reports and logs can be found in the test-output/ folder.

Contribution
Feel free to fork the repository and contribute by submitting pull requests!
