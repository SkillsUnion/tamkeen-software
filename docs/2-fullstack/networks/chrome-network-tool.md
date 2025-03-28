# Chrome DevTools Network Panel

## Learning Objectives

1. Know how to inspect network requests and responses in Chrome

## Introduction

Google Chrome and other modern browsers provide convenient functionality for analysing network requests and responses. This is through the DevTool's Network Panel. It will help us debug our apps when our frontend do not receive the data we expect from our backend.

## Usage

<a href="https://developer.chrome.com/docs/devtools/open/" target="_blank">Open Chrome DevTools</a>. The following image shows the DevTools Network panel after we send a request to `google.com`. Notice there are many more requests than the initial `google.com` request. These secondary requests are typically for scripts, images and other resources the page needs to function.

![The Network panel shows a list of requests from this browser in increasing chronological order. Source: Rocket Academy](<../assets/network-panel.png>)

Click on an individual request to inspect its details. The Headers tab shows important request and response headers such as URL, HTTP method and response status code. The Response tab shows response data. Both are helpful in determining whether a bug is in our frontend or backend logic.

![Clicking on an individual request shows us that request's details.](<../assets/network-panel-headers.png>)

## Disabling Cache

We recommend <a href="https://stackoverflow.com/a/7000899" target="_blank">disabling Chrome's cache when DevTools is open</a> to avoid situations when our apps do not reflect recent code changes due to caching. We recommend keeping this checkbox checked permanently to save us time during development.
