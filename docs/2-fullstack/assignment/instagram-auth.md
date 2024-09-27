# Assignment: Instagram Auth

## Learning Objectives

1. Know how to decompose complex components into multiple smaller, more manageable components
2. Understand where to put authentication in a UX flow to lure users in and give them as much reason to login as possible
3. Understand how to use Firebase Authentication
4. Know how to read documentation to apply a new technology

## Introduction

We will build on the previous exercise to incorporate authentication and user information on all posts, likes and comments.

## Setup

1. Start with the code we wrote in the previous exercise in our forked and cloned copy of the <a href="https://github.com/SkillsUnion/instagram-base-app" target="_blank">Rocket Academy Instagram starter repo</a>
2. Set up Firebase Authentication in our local `firebase.jsx` as per the <a href="https://firebase.google.com/docs/auth/web/start" target="_blank">official Firebase documentation</a>
   1. Under "Add and initialize the Authentication SDK", we will need to import `getAuth` and export a named export with the Auth object, like `export const auth = getAuth(firebaseApp);`
   2. Skip "(Optional) Prototype and test with Firebase Local Emulator Suite" and everything below it for now; that content will be covered in the next step.
3. <a href="https://firebase.google.com/docs/auth/web/password-auth#before_you_begin" target="_blank">Enable Email/Password sign-in</a> in the Firebase console (Step 3 in the linked docs)
   1. Once in the Auth section of our app in the Firebase console, click "Get started" button
   2. Choose the Email/Password sign-in method from the menu
   3. Enable Email/Password
4. Practice safe sharing, create implement your .env so that you do not share your Firebase credentials online when pushing to GitHub.

## Base: Users must login to post, posts have author identity

1. Refactor app into multiple components each in separate files for maintainability.
   1. Now that our app is starting to become complex (100+ lines of news feed code alone in `App.jsx`), we may want to consider refactoring `App` into multiple components for maintainability before adding new functionality such as auth.
   2. In our reference solution we separate `App.jsx`, `Composer.jsx` (the form to create new posts) and `NewsFeed.jsx` files for their respective components and put them in a c`omponents` folder in `src` that contains the component `.jsx` files and their relevant `.css` files.
      1. This will require some re-wiring of relative imports to files such as `src/firebase.jsx` and in files such as `src/main.jsx`.
   3. Separate composer state and logic into a `Composer` component in `Composer.jsx` and news feed state and logic into a `NewsFeed` component in `NewsFeed.jsx`. Import both `Composer` and `NewsFeed` in `App.jsx` to render them in the `App` component as before. Revise <a href="https://react.dev/learn/your-first-component" target="_blank">React docs for composing components</a> for a refresher.
   4. If you customised your UI in previous exercises, feel free to decompose your components however makes sense for your UI.
2. Update our user flow such that a user needs to log in to post. They should still see the news feed (without composer) before logging in (to lure them in). But when they are not logged in, we display a button to "Create Account or Sign In" instead of the composer.
   1. Consider storing `loggedInUser` as state in `App` component and using the `onAuthStateChanged` listener in `App`'s `componentDidMount` to keep `loggedInUser` updated. `App` can use `loggedInUser` to determine whether to render the "Create Account or Sign In" button or the composer.
   2. Consider also storing `shouldRenderAuthForm` boolean state in `App` component and creating a class method `toggleAuthForm` in `App` that toggles `shouldRenderAuthForm`. When an unauthenticated user clicks "Create Account or Sign In" button, `App` can call `toggleAuthForm` and render the auth form instead of the news feed. Once the user authenticates, auth form logic can call `toggleAuthForm` again for `App` to render composer and news feed instead of auth form.
   3. Create a new `AuthForm` component in `components/AuthForm.jsx` for the auth form and import it where relevant in `App`.
      1. You may find the <a href="https://www.w3schools.com/tags/att_input_type_email.asp" target="_blank">email HTML input type</a> and <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/password" target="_blank">password HTML input type</a> helpful for email validation and hiding passwords in the password field
3. All posts should now render the author's identity as part of the post.

>**Import Bootstrap CSS to use React Bootstrap**
>
>If we wish to use React Bootstrap, don't forget to <a href="https://react-bootstrap.github.io/docs/getting-started/introduction#css" target="_blank">import Bootstrap CSS</a> in either `main.jsx` or `App.jsx`.
>
>If you see the following Webpack warning, this is an <a href="https://github.com/twbs/bootstrap/issues/36259" target="_blank">open Bootstrap issue</a>, non-breaking and should be resolved by Bootstrap soon. Can ignore for now.
>
>```
>Warning
>(6:29521) autoprefixer: Replace color-adjust to print-color-adjust. The color-adjust shorthand is currently deprecated.
>```

>**Test using incognito mode**
>
>Use <a href="https://support.google.com/chrome/answer/95464?hl=en\&co=GENIE.Platform%3DDesktop" target="_blank">incognito mode</a> to open our app without storing logins across sessions. Without implementing logout functionality, our browsers may cache logins making it more difficult to test login functionality more than once when not in incognito mode.

## Comfortable: Identity in navbar

1. Display the logged-in user's identity in a navbar at the top of the app. Consider using <a href="https://react-bootstrap.github.io/docs/components/navbar#text-and-non-nav-links" target="_blank">React Bootstrap's `Navbar` component</a> for this.

## More Comfortable: Identity for likes and comments

1. If you haven't already, implement like and/or comment functionality for posts from Comfortable and More Comfortable in the Instagram Posts exercise
2. Likes should now be associated with a user's identity, and a user can only like a post at most once
3. Comments should show the author's identity like posts

## Submission

Deploy your app to the internet, follow Vitejs GitHub Pages <a href="https://vitejs.dev/guide/static-deploy.html" target="_blank">deployment instructions here</a>.