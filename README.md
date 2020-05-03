# Jersey-Hibernate-Vanilla

#USER APIS

GET http://localhost:8080/DietWebApp/rest/api/users/all

POST http://localhost:8080/DietWebApp/rest/api/user/add
{
   "firstName":"Sun",
   "lastName":"Raku",
   "email":"asas@gmail.com",
   "phone":"+49-342424323",
   "userName":"sun_raku"
}

#DIET APIS

GET http://localhost:8080/DietWebApp/rest/api/diets/all

POST http://localhost:8080/DietWebApp/rest/api/diet/add
{
   "foodName":"Khadi",
   "quantity":10,
   "unit":"Kg",
   "userId":1
}

DELETE http://localhost:8080/DietWebApp/rest/api/diet/delete

{
   "id":1,
   "foodName":"Khadi",
   "quantity":10,
   "unit":"Kg",
   "userId":1
}