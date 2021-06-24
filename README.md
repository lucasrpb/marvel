**MARVEL CHALLENGE**

**Disclaimer:** I've implemented only the first two endpoints of the API
and not all features in them, because I was busy doing another interviews and technical challenges and 
the features missing are pretty much a repetition of the already implemented ones (for a real job of course I would not do that). 

For this project I've used Spring Boot, which is the de-facto standard 
in the Java community. I've used common patterns like dependency injection,
and MVC. I've separated the API and business parts. That's why they are repeated models
for the entities. However, they have been designed this way because in the public API some data
cannot be accessed. So the JSON models are needed.

The application starts with pre-populated data.

Examples of testing using tools like Postman: 

_To get all characters:_
http://localhost:3000/v1/public/characters?name=Lucas-1&limit=10

_To get one specific character:_
http://localhost:3000/v1/public/characters/87

Observation: the ids generated are auto-incremented. So, to find the existing ones to test, 
call the api http://localhost:3000/v1/public/characters to get all and pick one id!

To download the code to your local machine you must have git in your local environment. 
Having done that proceed with the command: 

`git clone https://github.com/lucasrpb/marvel`

Now cd into the directory...

`cd marvel`

To test the code:

`.\gradlew test`

To compile and run the code: 

`.\gradlew run`

