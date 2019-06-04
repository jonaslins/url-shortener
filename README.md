# url-shortener

## How to run

1. ``mvnw clean package``
2. ``docker-compose up -d``

## Endpoints

### Shorten Url
POST localhost:8080/  
Content-Type: application/json  
Body:  
{  
	  "originalUrl":"https://github.com/jonaslins/"  
}
  
Response: 200 OK  
{  
  "code": "UqnPBrQ",  
	"originalUrl":"https://github.com/jonaslins/",  
  ...  
}  
  
### Redirect to original url  
GET localhost:8080/{code}  
Response: 302 FOUND   
Response Headers:  
 "Location": "https://github.com/jonaslins/"  


### Get shorten url statistics  
GET localhost:8080/{code}/statistics  
  
Response: 200 OK  
{  
	"originalUrl":"https://github.com/jonaslins/",  
  "hitCount": "9",  
  ...  
}  


