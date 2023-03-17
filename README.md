# 🚀 Backend Spring Boot 🚀

Create a Spring Boot project that includes the following functionalities:

### 🔐 Login Service 🔐
This service should receive a login and password and check if it matches the data in the database.
The password must be encrypted.
It should return a token for access to the other services.

### 📝 Registration Service 📝
This service should receive the login and password to be registered in the database.
The password must be stored encrypted.

### 📚 Skills Listing Service 📚
This service should receive the user ID and return all skills associated with it.

### 💼 Skill Association Service 💼
This service should receive the user, skill, and level to persist in the database.

### 🔧 Skill Association Update Service 🔧
This service should receive the skill association ID and level for updating in the database.

### 🗑️ Skill Association Deletion Service 🗑️
This service should receive the skill association ID and delete it from the database.

Only the Login Service should be public. The others should have JWT security and be accessed only with a valid token.

The project must include Spring Fox to generate automatic documentation of services using Swagger.

Remember to follow good practices for RESTful API. 🚀
