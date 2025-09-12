# React

## Learning Objectives
1. Construct functional React components using JSX syntax to combine JavaScript and HTML-like markup.
2. Implement the useState hook to create and manage state variables within React functional components.
3. Apply the useEffect hook to handle side effects and lifecycle events in React applications.
4. Develop React components that conditionally render UI elements based on props and component state.
5. Evaluate different styling approaches in React, including inline styles, CSS stylesheets, and component libraries like React Bootstrap.
6. Deploy a React application to GitHub Pages for online sharing

## Introduction

<a href="https://react.dev" target="_blank">React</a> is a frontend framework and library that allows us to create custom, nest-able UI elements with a combination of HTML and JavaScript syntax (JSX). React's HTML-like structure makes it easy to visualise, and its integrated JS makes it easy to render dynamic data. Alternative but less popular frontend libraries include <a href="https://vuejs.org" target="_blank">Vue</a> and <a href="https://angular.dev/" target="_blank">Angular</a>.

We will use React's official <a href="https://react.dev/learn" target="_blank">guide</a> to learn React, and the <a href="https://vitejs.dev/guide/" target="_blank">Vitejs</a> environment to scaffold our first React apps. Vite is a build tool that provides a fast and lean development experience for modern web projects. Vite leverages new advancements in the JavaScript ecosystems, the ability of native ES modules within the browser and the rise of JavaScript tools written in compile-to-native languages. This is because browsers do not read React natively; they read HTML, CSS and JS, not JSX.

## React App Creation

Open terminal on VS Code and enter the following command:
 
```sh
npm create vite@latest
```

Follow the prompts that would appear:
1. Choose `y` for Ok to Proceed
2. Enter `my-app` for the project name
3. Choose `React` for the framework
4. Choose `JavaScript` for the variant (you can also choose `JavaScript with SWC)

A React project will be generated in the `my-app` folder. Take a look at how JSX is being rendered into DOM element.

Change to the app folder:
```sh
cd my-app
```
Install the dependencies and start the app:
```sh
npm install
npm run dev
```
Once the React app has compiled succesfully, the server will be up and you can view the app in your browser at `http://localhost:5173`. From this point onwards, the app automatically reload whenever you save any new changes to your source code. 

While the server is running, port:5173 will be reserved until you 'kill' the server by  CTRL-C. If you start another React app server with `npm run dev`, you will be asked to choose a different port number.