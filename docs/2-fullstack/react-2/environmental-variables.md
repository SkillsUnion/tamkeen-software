# Environmental Variables

## Learning Objectives

1. Understand the purpose of the `.env` file and dotenv package
2. Implement the dotenv package in a React Application and store environmental variables
3. Use environmental variables stored in the `.env` file in React

## Introduction

When consuming third party APIs, developing databases, and deploying servers, you may want to obscure vital and secretive data that is used in your application. 

We can use the NPM package `dotenv` combined with the `.gitignore` file so that you never push sensitive data online always keep your information safe. Use a `.env` file to hide information such as database credentials, API keys, secrets and even your port number. It is imperative that you use environment variables as your API keys may be paired to a credit card and we want to make sure you are not exposing yourself or your future company to potential risks.

> Dotenv is a zero-dependency module that loads environment variables from a `.env` file into <a href="https://nodejs.org/docs/latest/api/process.html#process_process_env" target="_blank">`process.env`</a>. Storing configuration in the environment separate from code is based on <a href="http://12factor.net/config" target="_blank">The Twelve-Factor App</a> methodology.

## dotenv in React

Usually we would need to install dotenv into our applications, but as we are developing in a React environment we can just create a `.env` file and start putting our credentials in there. This is because react-scripts is able to process .env files whenever you run the command `npm run dev`, which means you will be able to use these hidden credentials in your application, but if you edit it you must completely restart the React App.

If you would like to checkout the documentation further, look at this set of <a href="https://github.com/motdotla/dotenv" target="_blank">documentation</a>.

>Note: There are different implementations of dotenv in different environments, in this set of documentation pay attention to the React example.

<a href="https://vitejs.dev/guide/env-and-mode.html#env-files" target="_blank">Vitejs & .env</a>

1. You will need to create a `.env` file in the root level of your React project.
2. Store your sensitive data inside the `.env` file.
   1. Note when developing .env files within a React application you must prefix its name with: \
      VITE`_SOME_...`
   2. You will need to reference it with the same prefix: `import.meta.env.VITE_SOME_...`
3. Ignore your .env file within the `.gitignore` file.
4. Create a .env.sample file to indicate what credentials are required in your application.
5.  Remember if you alter your .env file you may need to restart React application, stop your server and run `npm run dev`.

<figure><img src="../assets/sample-folder-structure.png" alt=""><figcaption><p>Sample Folder Structure</p></figcaption></figure>

<figure><img src="../assets/vite-env-variable.png" alt=""><figcaption></figcaption></figure>

<figure><img src="../assets/env-var-use.png" alt=""><figcaption></figcaption></figure>

#### Use cases for the .env?

When developing your applications you might be wondering what information you should share with collaborators and what you should never share. If you are developing an application that consumes or is connected to a third party that requires payments, you will be given keys or secrets to validate your account, this information should be placed in the .env and hidden from everyone but yourself.

If a key or secret that is linked to a credit card is accidentally put onto GitHub, this could have dire consequences. When developing with the paid subscriptions of APIs such as <a href="https://spoonacular.com/" target="_blank">Spoonacular API</a> or even <a href="https://console.cloud.google.com/" target="_blank">Google Cloud API</a> you will want to hide your API key as if it is accidentally put onto GitHub, you could be charged hundreds or even thousands as people can steal and use your key to power their applications.  You will then need to generate new keys, remove your application from GitHub and perhaps even stop your credit card.

API keys are not the only thing that should be stored in the .env file, database credentials as well as environmental details such as the port number should be safely hidden away. If a malicious developer was afforded the chance they would be able to steal all of the information stored and even delete the data. So save yourself and your potential companies time by securely storing your sensitive data in a .env file.