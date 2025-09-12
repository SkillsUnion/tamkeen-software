# React useMemo - useCallback

## Learning Objectives

1. Learn what is Memoization and how it optimizes an application
2. Use React's useMemo and useCallback for memoization

## Introduction

We’ve talked about `useState` and `useEffect`, which are the building blocks of all React application. You can arguably create any React project with just these two hooks.

As your app scales, you might find that these hooks alone might not be enough to create an _optimised_ application because there’ll be lots of state changes and side-effects that will be happening and it might **slow your app down.**

This is why React comes with some built-in hooks to help alleviate this.

Here’s a list of additional React hooks from their <a href="https://react.dev/reference/react/hooks" target="_blank">documentation</a>.

Before we dive in, let’s take a look at one of the technique React uses called _memoization_.

### Memoization

So what is memoization?

From wikipedia:

> … **memoization** is an <a href="https://en.wikipedia.org/wiki/Optimization_(computer_science)" target="_blank">optimisation technique</a> used primarily to speed up computer programs by storing the results of expensive <a href="https://en.wikipedia.org/wiki/Subroutine" target="_blank">function calls</a> and returning the cached result when the same inputs occur again.

The key takeaways are:

* Optimisation technique
* Speed things up
* Returns cache result if input is the same

Let’s take a look at an example of an expensive function call by implementing the Fibonacci number of N sequence

```jsx
function fibonacci(n) {
	if (n < 2) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// What is the "4th" sequence in the Fibonacci's number?
fibonnacci(4)
// Answer: 3

// What is the "20th" sequence in the Fibonacci's number?
fibonnacci(20)
// Answer: 10946

// What is the "50th" sequence in the Fibonacci's number?
fibonnacci(50)
// Answer: uh oh something broke
```

As you can see, if you were to find the "50th" sequence in Fibonacci’s number using the code above, things start to break. The reason it broke is because our recursive call still calculates the value of the previous functions even when it has calculated it before

**This is how it looks like**

![](https://media.geeksforgeeks.org/wp-content/uploads/20220401221029/ezgifcomgifmaker.gif)

Gif from GeeksforGeeks <a href="https://www.geeksforgeeks.org/javascript-memoization/">https://www.geeksforgeeks.org/javascript-memoization</a><br> 

When you cache an answer from memory, this is where memoization comes in, so let’s optimise it by returning the cache result of our function instead!

```jsx
function memoisedFibonacci(n, cache = []) {
	if (n < 2) return 1;
    if (cache[n]) return cache[n];
    return cache[n] = memoisedFibonacci(n - 1, cache) + 
    memoisedFibonacci(n - 2, cache);
}

// What is the "50th" sequence in the Fibonacci's number?
fibonnacci(50)
// Answer: 20365011074
```

We’ve introduced an additional parameter to our function called `cache` and set the value of it to be an empty array if it doesn’t exists.

This stores the _previous_ value of our result and we send the value to our function so that the program doesn’t need to recompute the value again and again and again and again and again.

**This will lay the foundation of how memoization works**

## React.memo

<a href="https://react.dev/reference/react/memo" target="_blank">React Top-Level API - React</a>

One of the API that React provides us that helps with performance is `React.memo`.

`React.memo` is a higher order component and is used as a performance optimisation by memoizing the result.

Take for example a button component below:

```jsx
import React, { useState } from 'react';

const Button = (props) => {
  console.log("I am rendering as a button!")
  return (
      <button>{props.children}</button>
  )
}

function App() {
	const [text, setText] = useState('');

	const changeText = (e) => {
		setText(e.target.value);
	};

	return (
		<div className='App'>
			<input type='text' value={text} onChange={changeText} />
			<Button>Submit</Button>
		</div>
	);
}

export default App;
```

When the `App` loads, it will render the `Button` component.

Inside the `App`, if a user types in the input, it will call the function `changeText` which will call `setText` and re-render the components.

This might seem minor but on a page with many components, we don’t really want a simple `Button` component to re-render every time a user types right?

This is where `React.memo` comes in and is a handy way to optimise unnecessary re-renders.

```jsx
import React, { useState } from 'react';

// Wrapping my button component with React.memo
const Button = React.memo((props) => {
  console.log("I am rendering as a button!")
  return (
      <button>{props.children}</button>
  )
})

function App() {
	const [text, setText] = useState('');

	const changeText = (e) => {
		setText(e.target.value);
	};

	return (
		<div className='App'>
			<input type='text' value={text} onChange={changeText} />
			<Button>Submit</Button>
		</div>
	);
}

export default App;
```

By simply wrapping it in `React.memo` whenever state changes in the `App`, it will not cause a re-render of the `Button` component! React will skip rendering the component, and reuse the last rendered result.

> Note: 💡 A good way to know when to use it for a component is if the component renders the same result given the same props.

## useMemo

```jsx
const memoizedValue = useMemo(() => computeExpensiveValue(a, b), [a, b]);
```

> Returns a <a href="https://en.wikipedia.org/wiki/Memoization" target="_blank">memoized</a> value.

This is the equivalent of `React.memo` that we encountered except that it’s for **values.**

Below, we changed the `Button` component to track a `count` state. Every-time we click the button, we will add `1` to `count`. We also implemented the fibonacci sequence from above and plugged it into our `App`

```jsx
import React, { useState } from 'react';

const Button = React.memo((props) => {
	return <button onClick={props.handleOnClick}>{props.children}</button>;
});

function App() {
	const [num, setNum] = useState(0);
	const [count, setCount] = useState(0);

	const handleChangeNum = (e) => {
		setNum(e.target.value);
	};

	const handleCounterClick = (e) => {
		setCount((prevState) => prevState + 1);
	};

	const result = fibonacci(num);

	return (
		<div className='App'>
			<input type='number' value={num} onChange={handleChangeNum} />
			<p>The fibonacci number is {result} </p>
			<p>Counter is {count}</p>
			<Button handleOnClick={handleCounterClick}>Increase the counter!</Button>
		</div>
	);
}

function fibonacci(n) {
	console.log('calculating');
	if (n < 2) return 1;
	return fibonacci(n - 1) + fibonacci(n - 2);
}

export default App;
```

Notice how whenever we clicked on the `Button` component to add to the counter, our whole `App` re-renders again and we will have to recalculate our fibonacci number even though the `num` state didn’t change.

This is an issue especially if the number is big and our function will be really expensive to compute.

Luckily, this is where `useMemo` comes in and optimises the performance by _skipping_ the calculation part if the input hasn’t changed! In essence, we _memoized_ the result and from `useMemo` and we keep track of the input of `num` in the dependency array.

```jsx
import React, { useState, useMemo } from 'react';

const Button = React.memo((props) => {
	return <button onClick={props.handleOnClick}>{props.children}</button>;
});

function App() {
	const [num, setNum] = useState(0);
	const [count, setCount] = useState(0);

	const handleChangeNum = (e) => {
		setNum(e.target.value);
	};

	const handleCounterClick = (e) => {
		setCount((prevState) => prevState + 1);
	};

	// Wrap the function call in a useMemo hook and put num in the dependency array
	const result = useMemo(() => fibonacci(num), [num]);

	return (
		<div className='App'>
			<input type='number' value={num} onChange={handleChangeNum} />
			<p>The fibonacci number is {result} </p>
			<p>Counter is {count}</p>
			<Button handleOnClick={handleCounterClick}>Increase the counter!</Button>
		</div>
	);
}

function fibonacci(n) {
	console.log('calculating');
	if (n < 2) return 1;
	return fibonacci(n - 1) + fibonacci(n - 2);
}

export default App;
```

## useCallback

If you ran the code above, you’ll actually realise that our previous `Button` component that we wrapped in `React.memo` actually is re-rendering again.

Hmm, but nothing changed right? If you look a little closer, this time we are passing in a prop called `handleOnClick` which takes in a function.

```jsx
<Button handleOnClick={handleCounterClick}>Increase the counter!</Button>
```

Well if you passed in a primitive value such as a `string` or an `integer`, it won’t cause a re-render if the value remained the same, but why did passing in a `function` caused an issue?

The real reason is because functions are compared by reference and not by value. The code below illustrates this example:

```jsx
const funct1 = function() {
  return 20;
};
const funct2 = function() {
  return 20;
};
console.log(funct1 === funct2); // this will be false
```

Whenever React re-renders, the function will be re-generated on every single render, producing a unique function each time. That is to say that the function we passed on to our `Button` component has “changed” on each render, causing it to re-render again!

Fortunately, React has provided us with the `useCallback` hook that will allow us to keep that function that we created to be the same `handleCounterClick` every time.

```jsx
import React, { useState, useMemo, useCallback } from 'react';

const Button = React.memo((props) => {
	console.log('is this rendering?');
	return <button onClick={props.handleOnClick}>{props.children}</button>;
});

function App() {
	const [num, setNum] = useState(0);
	const [count, setCount] = useState(0);

	const handleChangeNum = (e) => {
		setNum(e.target.value);
	};

	// We wrap our function here with the useCallback hook to preserve that reference
	const handleCounterClick = useCallback((e) => {
		setCount((prevState) => prevState + 1);
	}, []);

	const result = useMemo(() => fibonacci(num), [num]);

	return (
		<div className='App'>
			<input type='number' value={num} onChange={handleChangeNum} />
			<p>The fibonacci number is {result} </p>
			<p>Counter is {count}</p>
			<Button handleOnClick={handleCounterClick}>Increase the counter!</Button>
		</div>
	);
}

function fibonacci(n) {
	console.log('calculating');
	if (n < 2) return 1;
	return fibonacci(n - 1) + fibonacci(n - 2);
}

export default App;
```

The `Button` component now will not re-render unnecessarily and we have optimised our `App` to have improved performance.

## Conclusion

Despite learning how to make our app more optimized, it’s not always necessary to use these hooks. Remember that they are there as tools to help when things feel sluggish or slow. React is a very powerful library that knows how to optimise itself even without using the hooks that we have learned.

Here’s a great article on when you should use the hooks that we have learned by Kent C. Dodds:

<a href="https://kentcdodds.com/blog/usememo-and-usecallback" target="_blank">When to useMemo and useCallback</a>

## Resources

Here's a really great resource by Josh W Comeau that takes deep dive into what we just went through.

<a href="https://www.joshwcomeau.com/react/usememo-and-usecallback/" target="_blank">Understanding useMemo and useCallback</a>
