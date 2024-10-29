# The `useState` Hook

## Learning Objectives

- Apply the useState hook to create and manage state variables in React functional components.
- Apply the recommended naming convention for useState variables to improve code readability.
- Implement effective state management practices, including grouping related state variables and updating state based on its current value.

## Using the `useState` Hook

We will use the <a href="https://react.dev/reference/react/useState">`useState`</a> Hook most often. 

> Follow the naming convention of `X` and `setX` as the de-structured state variable names from `useState`. This makes our code more readable because other engineers will immediately know what each variable is for.

### Sample `useState` Hook

{% include youtube.html id="eb6HKsxHoas" %}
React Hooks `useState`

### React State management, `useState`

While creating your application and enlarging functionalities you will find that you are developing your components and states into much larger and complex files than you had before. It is important to manage state effectively and reduce redundant or duplicated states within your application.

Here is the documentation for <a href="https://react.dev/learn/managing-state" target="_blank">state management</a>

1. When using `useState` to manage component states, you can follow these steps:
   - Import the `useState` hook from the react package, at the top of the component file
   - Within your functional component declare a state variable and the updater function using the `useState` hook. As shown on <a href="https://react.dev/learn/managing-state#reacting-to-input-with-state" target="_blank">line 4</a>.
   - The initialValue of the state is passed into `useState`.
   - You can update this variable using the updater function.
2. We will take a deeper look onto `useContext` and `useReducer` later in this course.
3. When developing your states, group information of two state variables always change together, therefore unify them into a single state variable. Here are some more rules regarding <a href="https://react.dev/learn/choosing-the-state-structure" target="_blank">state structure</a>.
4. When updating a state variable, it's possible to use its current value, this is done by invoking a callback function on the updater function. Take a look at <a href="https://react.dev/reference/react/useState#updating-state-based-on-the-previous-state" target="_blank">these examples here</a>.
