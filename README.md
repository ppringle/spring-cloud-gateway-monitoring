# spring-cloud-gateway-monitoring

This project setups up an instance of **Spring Cloud Gateway**, with observability features.

The gateway currently exposes a single route, which is currently designed to modify the request body,
upper-casing any content found therein.

## Running the project locally

The project can be run locally with the following command:

```
mvn spring-boot:run
```

# Sample requests

## Route which transforms the request body content to uppercase:

```
curl -X POST "http://localhost:8080/post" -i -d "Welcome"
```

The content returned should resemble the following:

```
HTTP/1.1 200 OK
Date: Tue, 30 May 2023 14:41:25 GMT
Content-Type: application/json
Content-Length: 577
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true

{
  "args": {}, 
  "data": "{\"content\":\"WELCOME\"}", 
  "files": {}, 
  "form": {}, 
  "headers": {
    "Accept": "*/*", 
    "Content-Length": "21", 
    "Content-Type": "application/json", 
    "Forwarded": "proto=http;host=\"localhost:8080\";for=\"127.0.0.1:58715\"", 
    "Host": "httpbin.org", 
    "User-Agent": "curl/7.88.1", 
    "X-Amzn-Trace-Id": "Root=1-64760b12-203221397c0cf3f71eafe5e0", 
    "X-Forwarded-Host": "localhost:8080"
  }, 
  "json": {
    "content": "WELCOME"
  }, 
  "origin": "127.0.0.1, 66.207.217.99", 
  "url": "https://localhost:8080/post"
}
```

