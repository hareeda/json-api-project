Feature: Api testing of Json placeholder

Background:
  	* url 'https://jsonplaceholder.typicode.com'
  	* configure ssl = { trustAll: true }
  	* def id = 1

Scenario Outline: Get Single Resource
  	Given path '/posts/<id>'
  	And header Content-Type = 'application/json'
  	When method GET
  	Then status 200
  	And print response
  	* def expectedSchema = read('classpath:schemas/singleresource.json')
  	And match response == expectedSchema

  	Examples:
   	 	| id |
    	| 1  |

Scenario: Get list of resources
  	Given path '/posts'
  	And header Content-Type = 'application/json'
  	When method GET
  	Then status 200
  	And print response

Scenario Outline: Create multiple posts
  	Given path '/posts'
  	And request
  	"""
  	{
    	"title": "<title>",
    	"body": "<body>",
    	"userId": <userId>
  	}
  	"""
  	When method POST
  	Then status 201
  	And match response.title == "<title>"
  	And match response.body == "<body>"
  	And match response.userId == <userId>
  	And print response
  	* def expectedSchema = read('classpath:schemas/singleresource.json')
  	And match response == expectedSchema

  	Examples:
    	| title                | body                                                       | userId |
    	| Daily Activity Recap | Brief summary of todays events and accomplishments.        | 1      |
    	| Recipe Collection    | Compilation of favorite dishes and cooking instructions.   | 2      |
    	| Travel Bucket List   | List of dream destinations to visit someday.               | 3      |

Scenario Outline: Update resources using PUT
  	Given path '/posts/<id>'
  	And header Content-Type = 'application/json'
  	And request
  	"""
    {
    	"title": "<title>",
    	"body": "<body>",
    	"userId": <userId>
		}
    """
  	When method PUT
  	Then status 200  	
  	And match response.title == "<title>"
  	And match response.body == "<body>"
  	And match response.userId == <userId>
  	And print response

  	Examples:
    	| id | title                | body                                                       | userId |
    	| 1  | Daily Activity Recap | Brief summary of todays events and accomplishments.        | 1      | 

Scenario Outline: Update resources using PATCH
  	Given path '/posts/<id>'
  	And header Content-Type = 'application/json'
  	And request
  	"""
    {
    	"title": "<title>",
    	"body": "<body>",
    	"userId": <userId>
		}
    """
  	When method PATCH
  	Then status 200  	
  	And match response.title == "<title>"
  	And match response.body == "<body>"
  	And match response.userId == <userId>
  	And print response
  	* def expectedSchema = read('classpath:schemas/singleresource.json')
  	And match response == expectedSchema

  	Examples:
    	| id | title       | body                                                       | userId |
    	| 1  | Daily Recap | Brief summary of todays events and accomplishments.        | 1      | 

Scenario Outline: Delete a resource
  	Given path '/posts/<id>'
  	And header Content-Type = 'application/json'
  	When method DELETE
  	Then status 200
  	And print response

  	Examples:
    	| id |
    	| 1  |

Scenario: Filter resources
    Given path '/comments'
    And header Content-Type = 'application/json'
    And param postId = 1
    When method GET
    Then status 200
    And print response

Scenario: Nested resources
    Given path '/posts/1/comments'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And print response