# NinjaOne Backend Interview Project

The project is configured to use an in-memory H2 database that is volatile. If you wish to make it maintain data on application shut down, you can change the spring.database.jdbc-url to point at a file like `jdbc:h2:file:/{your file path here}`

## Starting the Application

Run the `BackendInterviewProjectApplication` class

Go to:
* http://localhost:8080/sample/1
* http://localhost:8080/sample/2

You should see results for both of these. The application is working and connected to the H2 database. 

## H2 Console 

In order to see and interact with your db, access the h2 console in your browser.
After running the application, go to:

http://localhost:8080/h2-console

Enter the information for the url, username, and password in the application.yml:

```yml
url: jdbc:h2:mem:localdb
username: sa 
password: password
```

You should be able to see a db console now that has the Sample Repository in it.

Type:

```sql
SELECT * FROM SAMPLE;
````

Click `Run`, you should see two rows, for ids `1` and `2`

### Suggestions

Feel free to remove or repurpose the existing Sample Repository, Entity, Controller, and Service. 

# API DOCUMENTATION

## End-point: Login
Authenticate user, creates a new authorization token.
### Method: POST
>```
>http://localhost:8080/oauth/token
>```

Body: url encoded

|Param|value|
|---|---|
|grant_type|password|
|username|sebastian|
|password|sebaspwd|

### 🔑 Authorization Basic Auth
    
|Username|password|
|---|---|
|ninjaone|ninjaonesecret|

## End-point: getCustomerMonthlyCost
Gets the monthly cost for a specific customer.
### Method: GET
>```
>http://localhost:8080/customer/services-cost/1
>```
### 🔑 Authentication oauth2


## End-point: addDevice
Creates a new device
### Method: POST
>```
>localhost:8080/device
>```
### 🔑 Authentication oauth2
### Body (**JSON**)

```json
{
    "name":"Another Windows PC",
    "deviceTypeId": 1
}
```

## End-point: getDevices
Gets a list of al created devices.
### Method: GET
>```
>localhost:8080/device/
>```
### 🔑 Authentication oauth2

## End-point: getDeviceById
Gets a device by its ID.
### Method: GET
>```
>localhost:8080/device/1
>```
### 🔑 Authentication oauth2


## End-point: updateDevice
Updates a device information.
### Method: PUT
>```
>localhost:8080/device/
>```
### 🔑 Authentication oauth2
### Body (**JSON**)

```json
{
    "id":1,
    "name":"First Windows PC",
    "deviceTypeId": 1
}
```

## End-point: deleteDevice
Deletes a device
### Method: DELETE
>```
>localhost:8080/device/6
>```
### 🔑 Authentication oauth2


## End-point: getDeviceServices
Gets all created services.
### Method: GET
>```
>http://localhost:8080/service/
>```
### 🔑 Authentication oauth2


## End-point: addService
Creates a new service.
### Method: POST
>```
>http://localhost:8080/service/
>```
### 🔑 Authentication oauth2
### Body (**JSON**)

```json
{
    "name":"Another new service"
}
```


## End-point: addUser
Creates a new User
### Method: POST
>```
>http://localhost:8080/user/add
>```
### 🔑 Authentication oauth2
### Body (**raw**)

```json
{
    "name":"sebastian",
    "password": "sebaspwd"
}
```


## End-point: deleteService
Deletes a service by its id.
### Method: DELETE
>```
>http://localhost:8080/service/5
>```
### 🔑 Authentication oauth2

_________________________________________________

