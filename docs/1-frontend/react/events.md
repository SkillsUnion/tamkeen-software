# Handling Events

## Learning Objectives

1. Identify the steps required to handle events in React applications using JSX.
2. Implement event listeners and callback functions to respond to user interactions in React components.
3. Apply techniques to manage event propagation and prevent default behaviors in React event handling.

## Handling Events

When users click on a button they expect some result, or some change, take the counter example if you click on the button the state increments. To develop these types of functionality within our React applications we will need to <a href="https://react.dev/learn/responding-to-events" target="_blank">handle events</a>, by assigning an event listener to our elements and define some callback functions to handle the event in a meaningful way. In our JSX code we need to follow these steps to handle events.

1. How do you handle events?
   1. Attach the event listener to the element, such as an `onClick` or `onBlur` event.
   2. Define the callback function that will handle said event, accessing the event data if required. Remember to pass this function to the event handler.
   3. Update state within this callback function by calling an updater function, run a side effect or execute any code.
2. "Events on DOM elements" are the same as <a href="https://www.w3schools.com/js/js_events.asp" target="_blank">JavaScript events or HTML events</a>. JS events allow us to perform logic on events that happen on our web pages such as mouse clicks. React supports a <a href="https://react.dev/reference/react-dom/components/common#common-props" target="_blank">wide range of events.</a>
3. Remember that functions that are passed to event handlers must be passed and not called, you can wrap the given function in an anonymous function if you need to pass in arguments.
4. You are able to stop event propagation as well as the default action.

## Event Handlers in JSX

Handling events in React is very similar to handling events on DOM elements. There are syntax difference between JSX and HTML when handling events:
- JSX events are named using camelCase, not lowercase
- JSX handlers are passed as functions, not as strings

*In HTML*
```html
<button onclick="handlerPlus()"> + </button>

```
*In JSX*
  
```js
<button onClick={handlerPlus}> + </button>

```

## Asynchronous React Rendering

We will using the starter code found [here](https://github.com/SkillsUnion/se-sample-react-events). Create a component called `Counter.jsx` in the `components` directory and include it in your `App.jsx` file. Copy and paste the [starter code](https://github.com/SkillsUnion/se-sample-react-events/blob/main/2.4-part-2-begin.jsx) in `Counter.jsx`. For optional styling, copy `App.css` from [style sheet](https://github.com/SkillsUnion/se-sample-react-events/blob/main/App.css) and replace it in your project root folder. 

Compile and start the React app.

```
npm run dev
```

Press the '+' button a few times and compare the app's behaviour with the code. 

Is the app behaviour expected? 

> Pause here and explain the behaviour before reading further

React will refresh a component on the Virtual DOM when there is a change component's state variable, e.g. `count`. The function `setCount` will update `count` whenever the event handlers, `handlerPlus` and `handlerMinus` are called via the `onClick` handler. 

In the code snippet below, you would expect the following to happen:
- `setCount` will immediately set the `count` state during the function call 
- The following `if` statement would have used the updated `count` state for comparison.

```jsx
...
const [count, setCount] = useState(0);
...
const handlerPlus = () => {
  setCount(count + 1);
  if (count >= 5) {
    setDiscount(20);
...
```
However, as you might have observed earlier, this is **not the case**!

What is really happening is that React will render its components *asynchronously*, i.e. not in the same order as the code is executed. There could be a delay between calling the `setCount` function and the `count` state variable being updated, resulting in a false value being used when the `if` statement is being executed in the handler.

The solution to this problem is to pass a function to the `setCount` as follows:

```js
const handlerPlus = () => {
  function myFunc(prevCount) {
    let count = prevCount + 1;
    if (count >= 5) {
      setDiscount(20);
    }
    return count;
  }
  setCount(myFunc);
};
```

## Higher Order Functions

In the previous section, `setCount` has become a **higher-order function**, as it is now elevated to accept another function `myFunc` as its argument, instead of a number. 

The function can be re-written using ES6 arrow arrow notation as follows:

```js
const handlerPlus = () => {
  setCount((prevCount) => {
    let count = prevCount + 1;
    if (count >= 5) {
      setDiscount(20);
    }
    return count;
  });
};
```
Higher-order functions treat functions just like data, e.g. string, numbers, booleans, objects, arrays. In Javascript, functions can be passed as arguments
and returned as functions.

You will encounter more examples of higher-order functions when using Javascript's popular Array methods, e.g. `map`, `filter` and `reduce`.

## Part 3: Passing Event Handlers as Props

Let's refactor the `<button>` element and wrap its functionality and styling into its own component, called `<Button>` (with a capital 'B'). This new component will take some props from its parent, the first one being a *label* to identify the button on the page. Also, `Button` will come with its own customised CSS styling, courtesy of its corresponding `.module.css`

Create a new `Button.jsx` component in the `components` folder:

```js
// Button.jsx
import styles from './Button.module.css'

function Button({ label }) {
  return (
    <button className={styles.button}>
      {label}
    </button>
  )
}
export default Button;

```
Copy the `Button.module.css` file from the [code](https://github.com/SkillsUnion/se-sample-react-events/blob/main/Button.module.css) folder.

Modify the parent `Counter` component to replace the HTML `<button>` elements with the new `Button` component:

```js
// Counter.jsx
...
return (
  <>
    <h2>{name}</h2>
    <Button label="-" />
    ...
    <Button label="+" />
...

```
The newly minted `Button` components should be visible now, but are more interactive! In order re-enable the buttons, we need to pass the handler functions to the children `Buttons` as props, let's call it `onClick`:

```js
    <Button label="-" onClick={handleMinus} />
    ...
    <Button label="+" onClick={handlePlus} />
```
Modify `Button` to accept the new prop:

```js
// Button.jsx
...
function Button({ label, onClick }) {
  return (
    <button className={styles.button} onClick={onClick} >
...

```
> Prop names are user-customisable, just make sure the prop names are identical in both parent and child components
 
The final code for `Button.jsx` and `Counter.jsx` can be found [here](https://github.com/SkillsUnion/se-sample-react-events/blob/main/2.4-part-4-button.jsx) and [here](https://github.com/SkillsUnion/se-sample-react-events/blob/main/2.4-part-4-counter.jsx).

### Activity (10 mins)

Implement a reset button component to zero out the quantity and pass an event handler to the component.

## Part 4: Using Events to Capture Input Fields

The `onChange` event handler is triggered when a value of an element, e.g. `<input>` changes. 

Create a new `Input` component that accepts an input value `value` and a `label` as props:

```js
// Input.jsx

function Input({ value, label }) {
  return (
    <div>
      <label>{label}</label>
      <br />
      <input />
    </div>
  );
}
export default Input;
```

Insert the new component into `Counter.js`:
```js
import Input from './Input'
...
reutrn (
  ...
  <Input value={name} label='Product'/>
)
```

Let's read from the input field and update the product label:
- Change the `<input value=...>` attribute to the controlled state `value`
- Add `handlerChange` to pass on keystroke inputs to the onChange function prop

```js
// Input.jsx

function Input({ value, label, onChange }) {
  const handleChange = (event) => {
    onChange(event.target.value);
  };
  return (
    <div>
      <label>{label}</label>
      <input value={value} onChange={handleChange} />
    </div>
...
```

Alternatively, you can write the handleChange function attribute as an inline function:

```js
function Input({ value, label, onChange }) {
  return (
    <div>
      <label>{label}</label>
      <input value={value} onChange={(e) => onChange(e.target.value)} />
    </div>
...

```

The event.target is a special object in JavaScript that reads the properties and attributes of the element whose event is triggered. In this case, event.target.value is able to read the `value` attribute of the `input` field. This is particularly useful as the event.target has access to each of the attributes of the element.

The parent `Counter` component must pass on its own handler to set the name of the product, in sync with the user type into the input field.

- Convert `name` into a controlled state variable with `setName` as update function
- Add `handleChange` to set the value of `name` using `setName`
- Pass `handleChange` as a prop to the child `Input` component

```js
// Counter.jsx
...
const [name, setName] = useState("Banana");
...
const handleChange = (value) => {
  setName(value);
};
...
return (
  ...
  <Input value={name} label="Product Name" onChange={handleChange} />
...
```
Update `Input` to accept `onChange` prop to accept `handleChange` from its parent.

```js
// Input.jsx
...
function Input({ config, label, onChange }) {
...
  const handleChange = (event) => {
    onChange(event.target.value);  // Execute onChange handler from parent
  };

```
Now, the product name will update when the user keys in any text in the input box.

---
### Commonly used events
| Event        | Description           |
| ------------ |:---------------------:|
| onClick      | The user clicks the element, typically used for buttons |
| onChange     | The element has been changed, this is useful for input fields |
| onSubmit     | The form has been submitted, this is useful for forms |
| onKeyDown    | The user pushes a keyboard key |
| onMouseOver  | The user moves the mouse over the element |
| onMouseOut   | The user moves the mouse away from the element |