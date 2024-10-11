# Firebase Hosting

## Learning Objectives

1. Use Firebase Hosting to deploy web applications easily and efficiently with configuration to support React Router's `BrowserRouter`
2. Learn how to deploy our apps to Firebase Hosting

### Introduction

{% include youtube.html id="jsRVHeQd5kU" %}
Firebase Hosting is a simple web-hosting tool that supports custom configuration. Source: Firebase


<a href="https://firebase.google.com/docs/hosting" target="_blank">Firebase Hosting</a> is a simple and robust web-hosting tool that allows us to deploy our static apps (like React apps) with custom configuration to support features such as React Router's `BrowserRouter`. It otherwise performs generally the same functionality as GitHub Pages that we used previously.

Read more on what Firebase Hosting can do for us <a href="https://firebase.google.com/docs/hosting/use-cases" target="_blank">here</a>.

### <a href="https://firebase.google.com/docs/hosting/quickstart" target="_blank">Get started</a>

1. We may want to read this in tandem with <a href="https://create-react-app.dev/docs/deployment#firebase" target="_blank">Create React App's deploy instructions for Firebase</a>.
   1. We can skip the warning about `service-worker.js` because we do not use that file in our repos at Rocket. Rocket deleted this file from Create React App starter code because service workers are for progressive web apps ("PWAs", web apps that run like native mobile apps on mobile devices) and we are not building PWAs.

### <a href="https://firebase.google.com/docs/hosting/full-config#rewrites" target="_blank">Configure hosting behaviour</a>: Set up `rewrites` to show the same content for multiple URLs

We will need this step to deploy our React apps with React Router `BrowserRouter` functionality.

1. <a href="https://create-react-app.dev/docs/deployment#firebase" target="_blank">Create React App's deploy instructions for Firebase</a> should take care of this for us automatically if we reply "Yes" to the option to "Configure as a single-page app (rewrite all urls to /index.html)?".

### <a href="https://firebase.google.com/docs/rules/basics?authuser=0\&hl=en" target="_blank">Basic Security Rules</a>

If you are unable to access the Firebase Realtime Database or Firebase Storage following deployment online, please checkout the document above. You may need to update your security rules for each Firebase application that is associated to the application. You can find this in the Rules section of each app.

You can also check out how to use firebase for ViteJS applications using the ViteJS documentation: https://vitejs.dev/guide/static-deploy#google-firebase
