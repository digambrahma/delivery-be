# delivery-be

This is a spring boot application that serves as the backend for the delivery-fe application. 

Features:

- User registration and authentication with phone
- User should be able to update his status e.g. status: active/inactive
- User should be able to update his coordinates continously whenever his status is active
- User should be able to accept/reject the delivery sent by the client


User/Driver model:

- driverId : long
- firstName : String 
- lastName : String 
- email : String 
- phone : String 
- city : String 
- coordinates : List of String
- deliveries : List of Delivery
- status : boolean

*******************
  
Delivery model:

- deliveryId : long
- to : String 
- from : String 
- item : String 
- date : String 
- active : boolean
