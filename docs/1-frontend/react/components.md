# React Components

## Learning Objectives

1. Construct React components following the core rules of component creation and rendering.
2. Implement props to pass data from parent to child components in a React application.

## React Components

The concept of <a href="https://react.dev/learn/your-first-component" target="_blank">Components</a> is core to React, they are the foundation of our React code, we use components to build user interfaces. This makes them ideal starting points once you've understood the basics of React JSX. React allows developers to combine markup, CSS and JavaScript into components that could be reusable UI elements within your application. Similarly to HTML tags we can compose, order and nest components to develop full pages within React applications. When building a Component follow these rules:

1. Export the Component
2. Define the Component function
3. Add any markup required, this is what we want to display within the Component
4. Render the Component onto the React Application by nesting it into the App.jsx
5. User-defined components must be capitalised. Otherwise React will think they are HTML tags.

## <a href="https://react.dev/learn/passing-props-to-a-component" target="_blank">Component Props</a>

React components can communicate with each other via props, a parent may pass information down to child component and this data always flows downwards. There will be some familiar props associated to JSX tags, but you you can actually pass anything from a parent its children.

1. To pass props specify the information that should be passed from the parent to the child.
2. Access the prop information that was passed to the child component and set default values if required.
3. You can pass anything as a prop from a parent component to a child, you can access props by destructuring the individually passed sets of information or by referring to props.
4. Props are immutable, checkout <a href="https://react.dev/learn/passing-props-to-a-component#how-props-change-over-time" target="_blank">this example</a> to see how they can change over time.

## Creating a Parent/Child Component

The starter code in `App.jsx` has a ready-made `App` component, which will be the 'root' component where all your other React components will be based from. Additional components shall be added as children to the App component.

Create a `components` folder under `src`.

Create a new Parent component in the `components` folder:
```js
// Parent.jsx

function Parent() { 
  return(
    <>
      <h1>This is a Parent component</h1>
      <h2>The children components will be placed here</h2>
    </>
  );
}

export default Parent;
```
The export default allows the application to use the Parent class as a module to be used by the application. 

Remove the JSX code in the `App` component and replace it with a `Parent` component:

```js
// App.jsx

import './App.css';
import Parent from './components/Parent';

function App() {
  return (
    <Parent/>
  );
}

export default App;
```

Test and run the application:

```
 npm run dev
```

Create a Child component in the `components` folder:
```js
// Child.jsx

function Child() {
  return <div>This is a child component</div>
}

export default Child;
```

Import the newly created Child component into the Parent component that you created earlier.
```js
// Parent.jsx
import Child from './Child'

function Parent(){
  return(
    <>
      <h1>I am a parent!</h1>
      <Child />
    </>
  );
}

```
Check your browser to see any changes as the app 'hotloads' after every source code save. If the server crashes for any reason, just restart the server using `npm run dev`.

### Activity
Create a new component called AnotherChild that has a `<div>` component and two paragraphs inside the `<div>`. Import the new component in the `Parent` component. 

## Passing Props into a Component

Props (properties) is the way React communicates between parent and child components. It allows data to be passed from parent to child. To use props, add an attribute that corresponds to the data that is to be passed.

In Parent.jsx, add a few more Child components and add a *firstName* attribute to each Child, with a prop value to be passed to each Child component:

```js
// Parent.jsx
...
  <Child firstName="Tom" />
  <Child firstName="Charlie" />
  <Child firstName="Daisy" />
...
```
In the Child component, the props is a JS object that is passed from the parent component. Each value in the prop object can be accessed using dot notation, e.g. `prop.firstName`.

Change the Child component to accept props:

```js
function Child(props) {
  return <h2>Child name: {props.firstName}</h2>
}
```
You can use **ES6** object desctructuring as a shorthand to extract props:

```js
function Child(props) {
  const {firstName} = props;
  return <h2>Child name: {firstName}</h2>
}
```
Alternatively, the props can be extracted directly from the function's parameter list:

```js
function Child({ firstName }) {
  return <h2>Child name: {firstName}</h2>
}

```

### Activity

Add the props (lastName - string, age - number, hobbies - array of strings) sent to the `Child` component and display the information in the `Child` component.

## Specifying Default Values for Props

You can provide a default value in a component if its parent did not specify any value in the prop. For example code below, if the Parent has a Child component with no **firstName** value, the Child will take default value.

```js
// Child.jsx
function Child({ firstName = 'UNKNOWN' }) {
  return <h2>Child name: {firstName}</h2>
}
// Parent.jsx
...
  <Child firstName='Tom' />
  <Child />
...

// RESULTS:
// Child name: Tomato
// Child name: UNKNOWN

```
## Forwarding Props in Nested Components

Components can be nested by simply importing them into the return statement. 

Create a new component called Pet in the `components` folder and import into the Child component:

```js
// Pet.jsx
function Pet() {
  return (
    <p>I have a pet</p>
  )
}

// Child.jsx
function Child({ firstName }) {
  return (
    <>
      <h2>Child name: {firstName}</h2>
      <Pet />
    </>
  )
}
```
What if we want to know what type of Pet each Child has? We can specify each pet from the Parent and pass the prop *petType* down tree:

```js
// Parent.jsx
...
  <Child firstName='Tom' petType='cat'>
  <Child firstName='Charlie' petType='dog'>
  <Child firstName='Daisy' petType='hamster'>
...
```
Modify Child to forward the *petType* prop:

```js
// Childs.jsx

function Child({ firstName, petType }) {
  return (
    <>
      <h2>Child name: {firstName}</h2>
      <Pet type={petType} />
    </>
  )
}
```
And finally, let Pet accept the *type* component:
```js
// Pet.jsx
function Pet({ type }) {
  return (
    <p>I have a {type}</p>
  )
}
```
Note that in the above example, the props name can be changed when being passed between components.

### Activity

Add the following props to be sent from `Parent` to `Pet` component: petName - string, age - number, gender - string, isNeutered - boolean.

Display the information received in the `Pet` component.

## Passing JSX components as children props

A component can be used to wrap around another component by accessing a built-in prop called `children`. To nest components within another component, the parent component will receive the content in the `children` prop. 

![parent-child-diagram](./assets/parent-child-card.png)


Create a new Card component and apply a style and heading to its children:
```js
// Card.jsx

function Card({ children }) {
  return (
    <div className='card'>
      <h3>Details</h3>
      <hr />
      {children}
    </div>
  )
}
export default Card;
```

Wrap the Child component JSX within the Card component:
```js
// Child.jsx

import Pet from "./Pet";
import Card from "./Card";

function Child({ firstName, petType }) {
  return (
    <Card>
      <h2>Child name: {firstName}</h2>
      <Pet type={petType} />
    </Card>
  );
}
```

Create a new component called Car and wrap it around the Card component to inherit its features.
```js
// Car.jsx
import Card from "./Card";

function Car() {
  return(
    <Card>
      <h2>Car Model: Tesla Model 3</h2>
      <p>This is another component that uses Card</p>
    </Card>
  )
}
export default Car;
```
Add Car into the Parent component:

```js
import Child from "./Child";
import Car from "./Car";

function Parent() {
  return (
    <>
      <h1>Parent here!</h1>
      ...
      <Car />
    </>
  );
}

```


The Card component is used to wrap both `Child` and `Car` components to inherit its style properties.