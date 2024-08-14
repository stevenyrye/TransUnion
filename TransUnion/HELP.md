Application using in memory database, when application started, visit DB console as http://localhost:8080/h2-console
select db jdbc:h2:mem:testdb user: sa password: password

An init record is pre inserted for test purpose. INSERT INTO employee (id, name, address, dob, phone_no, title, sin) VALUES (0, 'John Smith', '1 Yonge Street', '2000-12-12', '(416)123-4567', 'Sr. Developer', '0000');

A swagger UI 3 is also implemented with application, once application started, visit http://localhost:8080/swagger-ui.html , you can test from there.

GET endpoint: localhost:8080/employee?age=20&title=Sr. Developer a) if no params pass in (localhost:8080/employee), returns all employees. b) if only title pass in (localhost:8080/employee?title=Sr. Developer) , returns all employees filtered by title c) if only age pass in (localhost:8080/employee?age=20) , returns all employees filtered by the age older than the value d) if both age and title pass in (localhost:8080/employee?age=20&title=Sr. Developer), returns all employees filtered by the age older than the value and title

POST endpoint: localhost:8080/employee, insert record into DB (id auto-generated) a) Request payload: { "name": "John Smith1", "address": "1 Yonge Street", "dateOfBirth": "2000-12-12", "phoneNo": "(416)123-4567", "title": "Sr. Developer", "sin": "123312" }

Console log implemented

Enjoy

About
TransUnion Test

Resources
 Readme
 Activity
Stars
 0 stars
Watchers
 1 watching
Forks
 0 forks
Releases
No releases published
Create a new release
Packages
No packages published
Publish your first package
Footer
