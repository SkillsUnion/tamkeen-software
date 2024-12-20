# AJAX

## Learning Objectives

1. Know what AJAX means and how its used
2. Send arbitrary HTTP requests from any React component to send and retrieve data from external APIs
3. Understand how to send HTTP requests from React components and where to send them

## Introduction

AJAX (Asynchronous JavaScript and XML) is a technique for sending asynchronous HTTP requests in JavaScript that can update UI without refreshing the page. XML is an older markup language for sending and receiving data that is now less commonly used than JSON, but the software community continues to use the abbreviation AJAX out of convention.

## AJAX in React

<a href="https://reactjs.org/docs/faq-ajax.html" target="_blank">React's official docs</a> provide clear examples of how to make AJAX requests from both class and Hook-based React components on component load.

<a href="https://reactjs.org/docs/faq-ajax.html" target="_blank">Ajax FAQ</a>

1. The examples use the <a href="https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API" target="_blank">Fetch</a> AJAX library, but we will use <a href="https://axios-http.com/docs/intro" target="_blank">Axios</a> because Axios is the most robust and popular.
2. The examples fetch first-load data in `componentDidMount` or `useEffect` instead of directly in the functional component to avoid fetching data every time the component re-renders
3. `res.json()` extracts the JSON object out of the response. `result` in the subsequent callback contains that object.
4. The examples show how to send AJAX requests to populate data in components on component load, but not how to send requests on a user action such as a button click (e.g. like button). For the latter we can safely define a callback method in our component (e.g. `handleClick`) that performs a request on button click without worrying about fetching data more times than necessary.

