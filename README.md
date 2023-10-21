# Upload Download Files System

------------------------------------------

## Improvements
* Add user authentication and management
* checking authorization for each user from token


------------------------------------------

## How to run

### Terminal
* cd ./docker-compose
* docker-compose up

------------------------------------------

#### System
* postgres
* Maven >= 4.0.0
* JDK >= 17
* Docker
* Docker-compose

------------------------------------------

#### IDE setup
* Clone the repo and open pom.xml file with intelliJ, and automatically it will download all the needed dependencies
* Click on "Run" from the upper main menu 

------------------------------------------

#### main apis
* API to create space : 
  * curl --location 'http://localhost:8080/api/item?email=edit%40gmail.com' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=8A80FDF207950DE1D523D5461078D9C6' \
    --data '{
    "type": "SPACE",
    "name": "stc-assessments",
    "permissionGroupId": 1
    }'
  
* API to create folder :
    * curl --location 'http://localhost:8080/api/item?email=edit%40gmail.com' \
      --header 'Content-Type: application/json' \
      --header 'Cookie: JSESSIONID=8A80FDF207950DE1D523D5461078D9C6' \
      --data '{
      "type": "FOLDER",
      "name": "stc-assessments",
      "permissionGroupId": 1,
      "parentItemId":1
      }'

* API to create file :
    * curl --location 'http://localhost:8080/api/file?email=edit%40gmail.com' \
      --header 'Cookie: JSESSIONID=8A80FDF207950DE1D523D5461078D9C6' \
      --form 'file=@"/C:/Users/okhairy/Desktop/UPDATE TEST CASES AGENT.txt"' \
      --form 'name="TEST"' \
      --form 'parentItemId="2"'

* API to get file :
    * curl --location 'http://localhost:8080/api/item/3?email=edit%40gmail.com' \
      --header 'Cookie: JSESSIONID=8A80FDF207950DE1D523D5461078D9C6'

* API to download file :
    * curl --location 'http://localhost:8080/api/file/1' \
      --header 'Cookie: JSESSIONID=8A80FDF207950DE1D523D5461078D9C6'
