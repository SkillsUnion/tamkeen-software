# useContext

## Learning Objectives

1. Use React Context to access shared state from our components without passing props
2. Learn how to use `useContext` to simplify syntax when using context with functional components

## Introduction

React context allows us to share state across our app without passing it as props. This is helpful for apps with many levels of component nesting; when we would need to use the same state across multiple components and pass state as props through many levels of components (aka "prop drilling"). The React team recommends we use context sparingly because it makes component reuse more difficult.

> "Context is designed to share data that can be considered “global” for a tree of React components, such as the current authenticated user, theme, or preferred language." - React official docs on context

> "...sometimes the same data needs to be accessible by many components in the tree, and at different nesting levels. Context lets you “broadcast” such data, and changes to it, to all components below. Common examples where using context might be simpler than the alternatives include managing the current locale, theme, or a data cache." - React official docs on context

Please read the official React guide on <a href="https://react.dev/learn/passing-data-deeply-with-context" target="_blank">React Context</a>.

1. Note the <a href="https://react.dev/learn/passing-data-deeply-with-context" target="_blank">Create Context example</a>, at this point the default value is being passed. In this case, it refers to the largest heading level in this example but any value can be passed, even an object.
2. Note the <a href="https://react.dev/learn/passing-data-deeply-with-context" target="_blank">Use Context example</a>, after developing a context, you can use the information within by utilising the `useContext` hook.
3. Note the <a href="https://react.dev/learn/passing-data-deeply-with-context#step-3-provide-the-context" target="_blank">Provide the Context example</a>, to give Components access to the generated context, you must create a Context Provider to encapsulate all of the Components that require this information.
4. Check out this full example <a href="https://react.dev/learn/passing-data-deeply-with-context#context-passes-through-intermediate-components" target="_blank">here</a> and try to breakdown how to implement and use context within a React application to avoid prop drilling and repetitive code.

## `useContext`

`useContext` is a React Hook that allows us to retrieve the latest value of the context object passed to it. We recommend using `useContext` for context when using functional components.

Please read the following official React guide on <a href="https://react.dev/reference/react/useContext" target="_blank">useContext</a>.

1. Besides providing simpler syntax for reading context, `useContext` does not change the use cases for context. The examples from the official guide on context still apply, albeit with different syntax.

### Sample Implementation example

{% include youtube.html id="bLHAhj_ywW8" %}
React Hooks useContext

Please check out this <a href="https://github.com/SkillsUnion/react-context" target="_blank">repository</a> for an example implementation of React useContext, ensure that you're on the `main` branch if you want to test out the application on your machine.

You will need to install the dependencies with the command `npm install` after the installation you can then run the application with the command `npm run dev`. Note that the video's code is similar but not the same as the given repository.

Checkout the files `App.jsx`, to see the how to create context using the `createContext` method, implemented on line 20. 

The `user` object is also defined in the App.jsx and is passed into the `UserContext.Provider`, this file also showcases how to share this context information by wrapping around the `RouterProvider` so that all children (wrapped components) can share the user data.

Within the `Profile.jsx` we can see how to use the user information that is shared within the Applications context. It is required that you import the UserContext that was defined in the `App.jsx` as well as the `useContext` from React. Then utilise the `useContext` method passing in the requested context, in this case, the `UserContext`. Then you can access the information as your would a JavaScript object inside the Components JSX.
