# HTTP Requests and Responses

## Learning Objectives

1. Know what HTTP requests and responses are
2. Know what to pay attention to in HTTP requests and responses
3. Learn how to send HTTP requests via JavaScript and Thunder Client

## Introduction

HTTP "requests" are instructions sent over the internet to create, retrieve, update or delete data. HTTP "responses" are acknowledgments of HTTP requests, containing information describing the status of the request and containing any relevant data. Libraries like Firebase wrap HTTP requests and responses in their library functions, but most data sources do not have libraries like Firebase and we will need to explicitly send HTTP requests to access those data sources.

We must assume it will take an indefinite amount of time to receive a response for an HTTP request, and use JavaScript promises or callbacks (promises preferred) to write logic that is dependent on the response. This is because our requests often must literally travel across the world and internet connectivity can be unstable.

## Important HTTP request and response headers

HTTP request and response headers are key-value pairs that store metadata for requests and responses. There are many kinds of request and response headers, and for our purposes we will pay attention to the request method and status code headers.

### Request Method

The <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods" target="_blank">request "method"</a> communicates the kind of action we are requesting. The 4 most common methods are `GET, POST, PUT, and DELETE`, of which GET and POST are the most common.

| Method | Purpose       | Notes                                                                                                 |
| ------ | ------------- | ----------------------------------------------------------------------------------------------------- |
| GET    | Retrieve data | GET is default and most common method. We trigger GET requests when we enter URLs in the browser bar. |
| POST   | Create data   | POST requests store data in the request "body", part of the request that is separate from headers     |
| PUT    | Update data   | Similar mechanics as POST but with different name for clear communication                             |
| DELETE | Delete data   | Similar mechanics as POST but with different name for clear communication                             |

### Response Status Code

The <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status" target="_blank">response "status code"</a> is a number that communicates the status of the request. Statuses can communicate success, failure and what kind of failure it was. Below are common status codes.

| Status Code | Meaning   | Notes                                                                |
| ----------- | --------- | -------------------------------------------------------------------- |
| 200         | OK        | 200 is the most common status code, and it generally means "success" |
| 404         | Not Found | Visited page that does not exist                                     |
| 403         | Forbidden | We do not have access to retrieve this resource                      |

Software engineers decide what status code to attach to each response in app logic. We will do this when we write our own backend servers in Module 3. When sending responses, we should strive to provide the most precise status code for the given request. <a href="https://www.restapitutorial.com/httpstatuscodes.html" target="_blank">This page</a> summarises HTTP status codes and what they represent.

## How to send requests

Our apps need to send HTTP requests to access data from external sources. We will learn to send HTTP requests programmatically using JavaScript (for our users) and a VS Code extension called <a href="https://www.thunderclient.com/" target="_blank">Thunder Client</a> (for us to test APIs independently from our frontends). Note we have already been sending requests with Chrome (by visiting websites).

### JavaScript

Rocket recommends using the NPM library <a href="https://axios-http.com/docs/intro" target="_blank">Axios</a> to send HTTP requests from our apps. Axios is the most robust and popular JavaScript request-sending library we are aware of.&#x20;

Below is an example Axios request from their <a href="https://axios-http.com/docs/example" target="_blank">official docs</a> that gets user data from the user with ID "12345". To use Axios we must install it as an <a href="https://www.npmjs.com/package/axios" target="_blank">NPM package</a> and import it in the relevant file with `import axios from "axios"`.

```javascript
// Make a request for a user with a given ID
axios.get('/user?ID=12345')
  .then(function (response) {
    // handle success
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
```

### Thunder Client

<a href="https://www.thunderclient.com/" target="_blank">Thunder Client</a> (TC) is a VS Code Extension that enables us to send requests and receive responses without our app frontends. This is helpful for testing APIs to determine if a bug is in the API or in our frontend.

TC provides a convenient interface for creating and populating request URLs, methods, bodies, and query parameters. After sending requests with TC, TC formats responses for us in the VS Code interface.

![Thunder Client provides a convenient interface for testing APIs. Source: Thunder Client](<../assets/thunder-client.png>)

There are many alternatives to Thunder Client, among which is a popular software called <a href="https://www.postman.com/" target="_blank">Postman</a>. You can try either Thunder Client or Postman to help you get familiarize with using different tools.
