# Assignment: Instagram Chat

## Learning Objectives

1. Install, import and use a 3rd-party library in React
2. Understand how to use Firebase Realtime Database
3. Understand how to structure chat data in a NoSQL JSON database
4. Know how to read documentation to apply a new technology

## Introduction

This is the first of multiple exercises culminating in an Instagram clone. We start with chat because it a common example and will allow us to warm up to network requests, promises and Firebase.

## Setup

1. Fork and clone the <a href="https://github.com/SkillsUnion/instagram-base-app" target="_blank">Instagram starter repo</a>
   1. Run `npm install` to install packages in `package.json` after cloning
2. <a href="https://firebase.google.com/docs/web/setup" target="_blank">Add Firebase to our project</a>
   1. Please follow the text and not the video instructions on the Firebase docs page because the video demonstrates creating a Firebase app from scratch, not with Rocket's starter repo that includes starter code from Vitejs.
   2. Create a Firebase project in the Firebase console and call it "Tamkeengram" (calling it "Instagram" may give our users scam warnings after we deploy)
      1. There is no need to enable Google Analytics for this project. Disable that option when creating a project to avoid creating a Google Analytics account.
   3. Register our app with our Firebase project - <mark style="color:red;">**you can do this in your Firebase console underneath your registered firebase project,**</mark>
      1. We can call our app "Tamkeengram"
      2. No need to set up Firebase Hosting for now
      3. No need to `npm install firebase` because Rocket has already installed it in `package.json`
      4. Replace the contents of the `firebaseConfig` object in `src/firebase.jsx` with our app's config details. Consider adding this to a .env. We will retrieve the `databaseUrl` property after the next step.
3. Set up Firebase Realtime Database in the repo as per the <a href="https://firebase.google.com/docs/database/web/start" target="_blank">official Firebase documentation</a>
   1. Start from Create a Database; we just completed the prerequisite in the previous step
      1. When creating a database in the Firebase console, select the location nearest to you when prompted to choose "Realtime Database location"
      2. Select "Start in test mode" for security rules; we can set up more stringent security rules later after learning about authentication.
         1. When we start in test mode, in 30 days Firebase may notify us they will turn off database access unless we update security rules. When that happens, feel free to set both read and write access to `true`, even though it is insecure for now. Nobody will hack us because our apps are not "important", and if your app is storing important data please let your section leader know so we can secure it better.
   2. Skip "Configure Realtime Database Rules" section in the docs; we will set up database rules after learning authentication.
   3. Initialise the Realtime Database JavaScript SDK
      1. The initialisation code has been set up in the starter repo in `src/firebase.jsx`
      2. Find your Realtime Database URL as per instructions in this section and paste it as the value of the `databaseURL` property in the `firebaseConfig` object in `src/firebase.jsx`. Your database URL should look something like `https://tamkeengram-abc123-default-rtdb.asia-southeast1.firebasedatabase.app/`.
      3. Once we have added the database URL to `firebase.jsx`, we should be able to start using our database in React components that import the database from `firebase.jsx`. See how we import the database in `App.jsx` for an example.
4. Practice safe sharing, create implement your .env so that you do not share your Firebase credentials online when pushing to GitHub.

## Familiarise yourself with starter code

1. As in previous exercises, most of this exercise's code and logic is in `App.jsx`.
   1. Notice the use of the `useState` to initialise the `messages` state.
   2. Notice the use of `useEffect` to emulate the lifecycle componentDidMount to add a Firebase's listener when the Component mounts.
   3. Notice the use of `writeData` helper method to save a message when the user clicks Send.
   4. Notice the mechanics of sending and retrieving data from Firebase with `ref`, `push`, `set`, `onChildAdded`.
2. Notice the boilerplate Firebase config in `firebase.jsx`. We will need to fill this in with our Firebase app's details.
   1. Notice how `firebase.jsx` exports the Realtime Database instance that we import in `App.jsx` to access the online database.

## Base: Create form and implement chat functionality

Add UI and logic to `App.jsx` to accept user input in a form, save it in Firebase on submit and render on the page after submit.

1. We may find material on controlled forms useful from Module 1
2. We should be able to open multiple client apps, e.g. multiple browser tabs or windows connected to our app and have them chat with each other in real time. We will be able to incorporate usernames once we implement authentication later in this module.

## Comfortable: Save and render date and time of each message

Save and render the date and time of each message in Firebase and our app respectively. We can use JavaScript's `Date` object to generate and send the current datetime to Firebase when a user sends a message. After retrieving datetimes with messages we can use `Date`'s built-in formatting methods to render datetime nicely next to each message.

## More Comfortable: Style the app

Customise the UI to make it visually appealing. Rocket did not customise the UI in our starter code or solution because our focus has been on Firebase mechanics.

## Submission

Deploy your app to the internet, follow Vitejs GitHub Pages <a href="https://vitejs.dev/guide/static-deploy.html" target="_blank">deployment instructions here</a>.