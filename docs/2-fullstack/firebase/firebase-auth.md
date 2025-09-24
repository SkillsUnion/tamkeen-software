# Firebase Authentication

## Learning Objectives

1. Use Firebase Authentication to authenticate our users with API calls instead of custom password-hashing or OAuth logic
2. Learn how to set up Firebase Authentication with React

### Introduction

{% include youtube.html id="8sGY55yxicA" %}
Firebase Authentication is a plug-and-play authentication solution for our apps. Source: Firebase


<a href="https://firebase.google.com/docs/auth" target="_blank">Firebase Authentication</a> allows us to authenticate our apps' users, manage their accounts in the Firebase console and easily access user auth information from within our application. It makes authentication easy so we can focus on our app logic.

Start by reading the official Firebase Authentication tutorials linked below. Skip "Sign in with a pre-built UI" and "Get Started"; we will not use the former because it is currently incompatible with React 18, and we will go through the latter in the upcoming exercise.

### Users in Firebase Projects

Here is the <a href="https://firebase.google.com/docs/auth/users" target="_blank">documentation</a> for users in Firebase projects.

1. We will primarily use email and password auth for learning. Feel free to use other forms of auth in your exercises and projects.
2. The Firebase Auth instances provides convenient access to the currently logged-in user. We can use this throughout our app.
3. Auth listeners provide a convenient way to trigger relevant components to re-render when a user logs in or out.

### Manage Users

Here is the <a href="https://firebase.google.com/docs/auth/web/manage-users" target="_blank">documentation</a> for managing users in Firebase projects.

We want to retrieve current user from the Auth object in our apps, e.g. to display logged-in user in places such as navbars, profile pages and comment bars.

### Firebase Storage Basic security rules

Here is the <a href="https://firebase.google.com/docs/rules/basics?authuser=0\&hl=en#cloud-storage" target="_blank">documentation</a> for Firebase Storage Basic Security Rules in Firebase projects.

When you have successfully setup firebase authentication you can update your security rules for Firebase storage.

### Sample Implementation

Please checkout the finished code in this <a href="https://github.com/skillsUnion/firebase-examples/tree/auth" target="_blank">repository</a>, ensure that you're on the `auth` branch. 

If you want to test out the application on your machine you will need to have registered an Application on Firebase with Authentication activated. 

Use the `sample.env` within the application to create an `.env` file with your Firebase credentials. With this in mind if you want to run the application on your machine you will need to install the dependencies with the command `npm install` after the installation you can then run the application with the command `npm run dev`.  Then open a browser of your choice and navigate to  http://localhost:5173.
