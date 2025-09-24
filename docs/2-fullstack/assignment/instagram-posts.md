# Assignment: Instagram Posts

## Learning Objectives

1. Understand how to use JavaScript promises
2. Understand how to use Firebase Storage
3. Understand how cloud storage works: upload files, store references to those files in our database
4. Know how to read documentation to apply a new technology

## Introduction

We will build on the previous exercise to incorporate file uploads and store data as posts to display on our shared feed.

## Setup

1. Start with the code we wrote in the previous exercise in our forked and cloned copy of the <a href="https://github.com/SkillsUnion/instagram-base-app" target="_blank">Instagram starter repo</a>.
2. Set up Firebase Storage in the repo as per the <a href="https://firebase.google.com/docs/storage/web/start" target="_blank">official Firebase documentation</a>
   1. Start from "Create a default Cloud Storage bucket"; we just completed the prerequisite in the previous step
      1. Choose "Start in Test mode" when setting up Cloud Storage to avoid setting up security rules for now. We will address this after learning Firebase Authentication.
      2. Choose a Cloud Storage location nearest to your users. See <a href="https://firebase.google.com/docs/projects/locations" target="_blank">Firebase docs</a> for a list of locations and their descriptions. Singapore is `asia-southeast1`.
   2. In "Add your bucket URL to your app", our bucket URL may already be in our Firebase config in `firebase.jsx`, but we will want to import `getStorage` from `firebase/storage` and `export const storage = getStorage(firebaseApp);` from `firebase.jsx` with the same pattern we used for Realtime Database. We can then import `storage` from `./firebase` in `App.jsx` like what we did with Realtime Database.
   3. We can ignore the options in "Advanced setup" for now; nothing there that we should need yet
3. Practice safe sharing, create implement your .env so that you do not share your Firebase credentials online when pushing to GitHub.

## Base: Upgrade form to include file uploads, build news feed

1. Upgrade the form we created in Instagram Chat to accept file uploads in addition to text. Form submissions will now be considered "posts" that we will save to our database and render in our news feed.
   1. We can use `<input type="file" />` to accept file inputs in our form. See code snippet below for an example of how to use file input fields with React.
   2. You can use placeholder images <a href="https://www.pexels.com/search/generator/">here</a> as sample images
   3. On form submit:
      1. Upload the file to Firebase Storage
      2. Save the response, the file's database URL together with the post text in Realtime Database.
         1. **Note**: Be careful when using promises we may have to wait for the upload and `getDatabaseURL` promises to resolve before we can save the database URL.
         2. **Note:** We may want to import and use functions from `firebase/storage` as per the Firebase Upload Files tutorial.
         3. **Note:** We may want to use <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import" target="_blank">import aliases</a> when importing functions of the same name such as `ref` from multiple modules, e.g. both `firebase/storage` and `firebase/database`. See code snippet below for example.
2. Upgrade the UI of our app to render posts nicely. Consider using <a href="https://react-bootstrap.github.io/docs/components/cards" target="_blank">React Bootstrap Cards</a> as a simple solution.
   1. You may find that the images we upload render too large. You can create and apply a CSS class on card images and setting `width` to `50vw` and `height` to `30vh` gave a good look.

>**Import Bootstrap CSS to use React Bootstrap**
>
>If we wish to use React Bootstrap, don't forget to <a href="https://react-bootstrap.github.io/docs/getting-started/introduction#css" target="_blank">import Bootstrap CSS</a> in either main`.jsx` or `App.jsx`.
>
>If you see the following Webpack warning, this is an <a href="https://github.com/twbs/bootstrap/issues/36259" target="_blank">open Bootstrap issue</a>, non-breaking and should be resolved by Bootstrap soon. Can ignore for now.
>
>```
>Warning
>(6:29521) autoprefixer: Replace color-adjust to print-color-adjust. The color-adjust shorthand is currently deprecated.
>```

### Example: File input field in React

```jsx
import { useState } from "react";

function App() {
  const [textInputValue, setTextInputValue] = useState("");
  const [fileInputFile, setFileInputFile] = useState(null);
  const [fileInputValue, setFileInputValue] = useState("");
  return (
    <>
      <h1>Instagram Bootcamp</h1>
      <div className="card">
        <form {/* Add in submit handler*/}>
          <input
            type="file"
            value={fileInputValue}
            onChange={(e) => {
              setFileInputFile(e.target.files[0]);
              setFileInputValue(e.target.value);
            }}
          />
          <br />
          <input
            type="text"
            value={textInputValue}
            onChange={(e) => setTextInputValue(e.target.value)}
          />
          <input
            type="submit"
            value="Send"
            // Disable Send button when text input is empty
            disabled={!textInputValue}
          />
        </form>
      </div>
    </>
  );
}
```

### Example: Import aliases for multiple named imports of the same name from different modules

The following code is in the reference solution. We give <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import" target="_blank">aliases</a> using `as` syntax to the named imports `ref` from both `firebase/database` and `firebase/storage`.

```jsx
import { onChildAdded, push, ref as databaseRef, set } from "firebase/database";
import {
  getDownloadURL,
  ref as storageRef,
  uploadBytes,
} from "firebase/storage";
```

## Comfortable: Implement likes

1. Implement like functionality on posts. Every post in the news feed has a heart-shaped like button that increments the posts' like count by 1 when we toggle it on. When we toggle the like button off, our app decrements the relevant posts' like count.
   1. This feature will be buggy for now (e.g. we can refresh our page and like the same post again for duplicate likes) until we implement authentication in the next exercise.

## More Comfortable: Comments

Implement commenting functionality on posts. Every post in the news feed has a comment bar that allows users to leave comments. We can store comments together with their post in our database.

## Submission

Deploy your app to the internet, follow Vitejs GitHub Pages <a href="https://vitejs.dev/guide/static-deploy.html" target="_blank">deployment instructions here</a>.