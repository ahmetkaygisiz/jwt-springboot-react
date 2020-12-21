## Run
`mvn spring-boot:run`

### Endpoints
_Public :_ 
- /api/1.0/login : Returns a JWT token.

`curl 'http://{hostname}:8080/api/1.0/login' -i -X POST \
    -H 'Content-Type: application/json' \
    -d '{"username":"test","password":"test"}'`

Output : `{ "message":"Login successful.",
   "data":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA4MzI1NTMzLCJpYXQiOjE2MDgzMDc1MzN9.JheoGilMU5Kvz1WhuwE43qhsMmpOfu--aFOMD6v2Upg" }`
   
---    
- /api/1.0/signup : Returns message. 

`curl 'http://{hostname}:8080/api/1.0/login' -i -X POST \
    -H 'Content-Type: application/json' \
    -d '{"username":"test","password":"test"}'`

Output : `{"message":"User created."}`

---  
_Authenticated :_ 
- /api/1.0/home  : Return message.

`curl 'http://{hostname}:8080/api/1.0/home' -i -X GET \
     -H 'Content-Type: application/json' \
     -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA4MzI1NTMzLCJpYXQiOjE2MDgzMDc1MzN9.JheoGilMU5Kvz1WhuwE43qhsMmpOfu--aFOMD6v2Upg'`

Output : `{"message":"W3lc0m3 h0m3!"}`
