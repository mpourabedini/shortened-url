# shortened-url

This project is a containerized spring boot application for creating and redirecting short urls. To run this locally you should use Dockerfile under src/main/resources/sql directory to get mysql up. After that main spring boot application can be initiated using main Dockerfile in root directory.

After application get started, you can shorten long urls using Post method with such a request path: http://localhost:8080/mapped-urls
and request body as json:
{
	"originalUrl": "https://www.google.com/search?q=iron+man&oq=iron+man&aqs=chrome..69i57j0l5.21973j0j7&sourceid=chrome&ie=UTF-8"
}

And it is possible to redirect created short url using request path for example:
http://localhost:8080/mapped-urls/redirect?shortUri=http://shortUrl.com/XZyN5F
