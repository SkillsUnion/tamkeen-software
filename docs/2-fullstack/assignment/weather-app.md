# Assignment: Weather App

## Learning Objectives

1. Know how to send an HTTP request and handle response data in a frontend app
2. Know how to send an AJAX request and load response data in a React app
3. Know how to chain promises with multiple AJAX calls
4. Know how to read API documentation to use a new API

## Introduction

We will build a weather app that shows the latest weather forecast for a city that a user enters.

## Setup

1. Fork and clone the <a href="https://github.com/SkillsUnion/weather-app-base" target="_blank"> Weather App Repo</a>
2. <a href="https://home.openweathermap.org/users/sign_up" target="_blank">Create an Open Weather account</a> to access Open Weather's free weather API. After confirming your email you will receive an API key to use to make API requests. <mark style="color:red;">**This can take up to 24 hours so please do this during pre-class.**</mark>

## Base: Show current weather for user-provided city

### Instructions

1. Create an input field where users can input the city they would like to check the weather for. Provide instructions on the page so users know to enter a city name in the input.
2. When a user inputs a city name, use <a href="https://openweathermap.org/current" target="_blank">Open Weather's current weather data API</a> to retrieve the weather in that city and display it to the user. The app should update the weather when the user inputs a new city or submits the same city again.
   1. To install <a href="https://axios-http.com/docs/intro" target="_blank">Axios</a> to make requests, run `npm i axios` and import Axios from the relevant component.
   2. We will send GET requests because we are retrieving and not creating or updating any data.
   3. Notice the API URL uses <a href="https://en.wikipedia.org/wiki/Query_string#Structure" target="_blank">URL query parameters</a> to customise the API call. We specify query parameters in key-value pairs separated by `=`, where we separate each key-value pair with `&`.
   4. When developing with APIs, feel free to `console.log` API responses to understand the format of the response before writing code logic. See below code example for an illustration.
   5. We will need to use <a href="https://openweathermap.org/api/geocoding-api" target="_blank">Open Weather's geocoding API</a> to translate location names to coordinates before querying the current weather data API. You may find it helpful to chain promises with `.then` syntax.
      1. To chain multiple asynchronous function calls with `.then`, we can return the promises of the subsequent function calls in their `.then` callbacks instead of creating a nested `.then`. See example below for illustration.
   6. We may find it helpful to specify `metric` units for the `units` parameter of the API. This will return all temperature values in Celsius instead of Kelvin.
   7. Consider displaying the relevant icon next to the weather. Open Weather returns an icon code with weather info and we can retrieve the relevant icon using <a href="https://openweathermap.org/weather-conditions" target="_blank">Open Weather's Icon URLs</a> and an HTML `img` tag.

>**Making our API key public**
>
>By making API requests to Open Weather directly from our frontend app, we are effectively making our Open Weather API public because all frontend code is visible to users. This is discouraged in production apps because hackers can use our Open Weather account to make requests for free. We will learn how to build backend servers to hide sensitive data such as API keys in Module 3.

### Example: `console.log` response to understand response format

We can `console.log` the response to the API request to understand its format before we try to parse data from the response.

```jsx
handleSubmit = (event) => {
  event.preventDefault();
  axios
    .get(
      `https://api.openweathermap.org/geo/1.0/direct?q=${cityInputValue}&limit=1&appid=${OPEN_WEATHER_API_KEY}`
    )
    .then((response) => {
      console.log(response);
      // Write remaining logic once we understand response format
    });
};
```

The logging revealed that the data I want is in `response.data[0]`.

### Example: Chain multiple Axios requests without nesting

Promise syntax is flexible, and there are preferred and less-preferred ways of handling promises. We typical prefer only have 1 level of nesting for chained promises for readability.

#### Bad

We should never need more than 1 level of nesting for `.then`s. This makes our code harder to read, because the `.then` execution flow becomes non-linear.

```jsx
handleSubmit = (event) => {
  event.preventDefault();
  axios
    .get(
      `https://api.openweathermap.org/geo/1.0/direct?q=${cityInputValue}&limit=1&appid=${OPEN_WEATHER_API_KEY}`
    )
    // City geo data is in response.data[0]
    // Arrow functions with no curly braces return value after arrow
    .then((response) => response.data[0])
    .then((cityGeoData) =>
      axios
        .get(
          `https://api.openweathermap.org/data/2.5/weather?lat=${cityGeoData.lat}&lon=${cityGeoData.lon}&appid=${OPEN_WEATHER_API_KEY}&units=metric`
        )
        .then((response) => {
          const { data: weatherData } = response;
          console.log(weatherData);
        })
    );
};
```

#### Good

We can return the promise returned by the 2nd `axios.get` in its `.then` callback, and obtain the result of that promise in the subsequent `.then`. This allows us to have only 1 level of nesting.

`.then` callbacks accept both values and promises as return values. If a previous `.then` callback returns a promise, the subsequent `.then` callback will receive that promise's resolved value as a parameter. Read more on `.then` behaviour in <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then" target="_blank">official docs</a>.

```jsx
handleSubmit = (event) => {
  event.preventDefault();
  axios
    .get(
      `https://api.openweathermap.org/geo/1.0/direct?q=${cityInputValue}&limit=1&appid=${OPEN_WEATHER_API_KEY}`
    )
    // City geo data is in response.data[0]
    // Arrow functions with no curly braces return value after arrow
    .then((response) => response.data[0])
    .then((cityGeoData) =>
      axios.get(
        `https://api.openweathermap.org/data/2.5/weather?lat=${cityGeoData.lat}&lon=${cityGeoData.lon}&appid=${OPEN_WEATHER_API_KEY}&units=metric`
      )
    )
    .then((response) => {
      const { data: weatherData } = response;
      console.log(weatherData);
    });
};
```

## Comfortable: Show hourly and daily forecasts for coming days

In addition to the current weather, display a daily forecast, represented by hourly data to the user in tables. You may find the <a href="https://openweathermap.org/forecast5" target="_blank">Open Weather API documentation</a> helpful.

## More Comfortable: Show forecast data in a graph

Render the forecast data in a graph instead of a table. You may find React chart libraries like <a href="https://recharts.org/en-US/" target="_blank">Recharts</a> helpful.

## Submission

Submit the Github link of your assignment repository