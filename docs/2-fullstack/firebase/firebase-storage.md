# Firebase Storage

## Learning Objectives

1. Use Firebase Storage to store and retrieve user-generated files on the cloud
2. Learn how to set up and use Firebase Storage with a React app

### Introduction

{% include youtube.html id="_tyjqozrEPY" %}
Firebase Storage is a convenient tool to store and retrieve user-generated files. Source: Firebase

<a href="https://firebase.google.com/docs/storage" target="_blank">Firebase Storage</a> is a cloud file storage system that allows us to store and retrieve user-generated files on behalf of our app's users. It allows us to upload user-generated files to Firebase with API calls directly from our frontends and save the locations of those files in our database for easy retrieval.

We start by reading the official Firebase Storage tutorials linked below. We will skip the Get Started page and come back to it when working on the relevant lesson.

> Note: Firebase Storage is a free service; however, you need to add billing information (ie. credit card / other payment options) in order for you to access this Firebase feature.

### Create a Reference

Here is the documentation about <a href="https://firebase.google.com/docs/storage/web/create-reference" target="_blank">Creating References</a>

1. Note how `ref` syntax is the same as with Realtime Database, but our files are stored in Firebase Storage, not Realtime Database.

### Upload Files

Firebase can also use upload files, the documentation can be found in this <a href="https://firebase.google.com/docs/storage/web/upload-files" target="_blank">link</a>

1. `uploadBytes` makes uploading files easy.
2. Note that `uploadBytes` returns a JS promise because we cannot be sure how long it will take for a file to finish uploading. Firebase examples use `.then` syntax to perform logic after promises resolve.
3. Rocket does not require we implement features to show upload progress to users, but that would be a nice touch for Comfortable exercises.
4. `getDownloadURL` function returns a JS promise that resolves to a URL for us to download the file we just uploaded. We will save each file's download URL to our database.

### Download Files

Firebase offers a way how to download files, the documentation can be found <a href="https://firebase.google.com/docs/storage/web/download-files" target="_blank">here</a>.

1. No need to worry about CORS Configuration for now unless we plan to have our users download files to their local drives from the browser

### Delete Files

Firebase also provides a way to do <a href="https://firebase.google.com/docs/storage/web/delete-files" target="_blank">file deletion</a>. 

1. Wait until the promise returned by `deleteObject` (and any other file upload/download/modifying functions) resolves before updating local state and UI.

### List Files

Here is the documentation for <a href="https://firebase.google.com/docs/storage/web/list-files" target="_blank">listing files</a>

1. We will not be using `list` and `listAll` functions to retrieve files in our apps, because we will save each file's download URL in our database and retrieve those URLs when loading those files in our apps.
2. No need to implement pagination when using Firebase Storage for the first time. 

### Handle Errors

<a href="https://firebase.google.com/docs/storage/web/handle-errors" target="_blank">Handling errors</a> is one of the most important concepts when dealling with connections.

1. If we happen to get a Firebase Storage error we can check the error code in the error object in the promise `.catch` block to verify what happened.


### Sample Implementation 

{% include youtube.html id="N66Y_Y6sCHc" %}
Firebase Storage Storing files


Note there has been a slight change within React, at minute 6:22, there should be a code alteration, line 76, the new value should be `e.target.value` , and not 'e.target.file'. Please make this amendment if you are following this video!

{% include youtube.html id="ztdboeP9Hhw" %}
Firebase Storage Displaying files

Please checkout the finished code in this <a href="https://github.com/skillsUnion/firebase-examples/tree/storage" target="_blank">repository</a>, ensure that you're on the `storage` branch. 

If you want to test out the application on your machine you will need to have registered an Application on Firebase with Realtime Database and Storage activated. 

To get the Firebase Credentials needed for our app to run, go to Project Settings -> Your app (adding an app if you haven't using the "Add App" and choose Web App) -> and check "npm" in the SDK setup and configuration option. You will get details such as the apiKey, authDomain, databaseURL, etc.

Use the `sample.env` within the application to create an `.env` file with your Firebase credentials. With this in mind if you want to run the application on your machine you will need to install the dependencies with the command `npm install` after the installation you can then run the application with the command `npm run dev`.  Then open a browser of your choice and navigate to  http://localhost:5173.
