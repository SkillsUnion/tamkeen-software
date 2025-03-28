# Async Await

## Learning Objectives

1. Use async-await syntax to manage promise control flow in lieu of `.then`
3. Apply try-catch syntax to provide the `.catch` functionality with async-await syntax

## Introduction

Async-await can be cleaner syntax but is functionally the same as `.then` syntax

`.then` syntax:

```javascript
// myFunc returns the return value of myFunc, currently undefined
const myFunc = () => {
  axios.get("foobar.com").then((data) => {
    // Do something with data after response received
    console.log(data);
  });
};
```

Async-await syntax:

```javascript
// myFunc returns a promise due to the async keyword
// The promise resolves to the return value of myFunc
const myFunc = async () => {
  const data = await axios.get("foobar.com");
  // Do something with data after response received
  console.log(data);
};
```

Async-await syntax allows us to write asynchronous JavaScript in a synchronous manner, like in the example above. This can result in cleaner code, but does not add new functionality.

`async` specifies a given function is asynchronous and returns a promise, and `await` will wait for a given promise to resolve before proceeding to the next line. `async` and `await` keywords must be used together; it is not meaningful to use `async` without `await`, and it is invalid to use `await` without `async`.

## Example: Async-await with `pg`

Async-await syntax is generally preferred due to its increased readability compared with `.then` syntax.

`.then` syntax:

```javascript
app.get('/users/:id', (request, response) => {
  const { id } = request.params;
  pool.query('SELECT * FROM users WHERE id = $1', [id]).then((result) => {
    const { rows } = result;
    response.send(rows);
  };
});
```

Async-await syntax:

```javascript
app.get("/users/:id", async (request, response) => {
  const { id } = request.params;
  const result = await pool.query("SELECT * FROM users WHERE id = $1", [id]);
  const { rows } = result;
  response.send(rows);
});
```

## Example: Catch errors with async-await

Try-catch syntax allows us to catch errors with async-await syntax in the same way we would catch errors with `.then` and `.catch` syntax.

`.then` syntax:

```javascript
const getRecipes = () => {
  // client is a Client instance from the Node pg library
  client
    // .query returns a promise
    .query("SELECT * from recipes WHERE category=vegan")
    .then((recipes) => {
      // Render the lovely vegan recipes
    })
    // The .catch block will trigger on error in either .query or .then block
    .catch((error) => {
      console.error(error);
      // Handle the error gracefully, e.g. render 404 page instead of crashing app
    });
};
```

Async-await syntax:

```javascript
const getRecipes = async () => {
  try {
    // client is a Client instance from the Node pg library
    const recipes = await client.query(
      "SELECT * from recipes WHERE category=vegan"
    );
    // Render the lovely vegan recipes
  } catch (error) {
    console.error(error);
    // Handle the error gracefully, e.g. render 404 page instead of crashing app
  }
};
```

Similar to `.catch` syntax, when there is an error in a `try` block, e.g. a request to a nonexistent URL, the error will cause our program will crash unless we catch that error in a `catch` block. Try-catch syntax is not directly related to promises, but is commonly used with async-await promise syntax.

## Example: Async-await does not pause programs, only code in current function

The following code executes "Before" and "After" `console.log`s before "Recipes".

```javascript
const getRecipes = async () => {
  try {
    // client is a Client instance from the Node pg library
    const recipes = await client.query(
      "SELECT * from recipes WHERE category=vegan"
    );
    // Render the lovely vegan recipes
    console.log("Recipes");
  } catch (error) {
    console.error(e);
    // Handle the error gracefully, e.g. render 404 page instead of crashing app
  }
};

console.log("Before");
getRecipes();
console.log("After");
```

Output

```
Before
After
Recipes
```

`getRecipes` will return before its logic has completed because it is an `async` function that contains an asynchronous `client.query`. `async` wraps `getRecipes` in a promise that returns immediately but resolves only when `getRecipes` logic is complete. Since there is no `.then` or `await` on the `getRecipes()` function call, the "After" `console.log` runs before `getRecipes` has resolved.

## Example: Async-await works with all promises, including the promise returned by `Promise.all`

We can use async-await with `Promise.all` to retrieve unrelated data concurrently with syntax that reads sequentially.

`.then` syntax:

```javascript
const getData = () => {
  const results = Promise.all([
    pool.query("SELECT * FROM recipes"),
    pool.query("SELECT * FROM categories"),
    pool.query("SELECT * FROM users"),
    // results is an array of results whose elements correspond
    // to the elements in the Promise.all parameter array
  ]).then((results) => {
    const [recipes, categories, users] = results;
    // Do something with recipes, categories and users
  });
};
```

Async-await syntax:

```javascript
const getData = async () => {
  // results is an array of results whose elements correspond
  // to the elements in the Promise.all parameter array
  const results = await Promise.all([
    pool.query("SELECT * FROM recipes"),
    pool.query("SELECT * FROM categories"),
    pool.query("SELECT * FROM users"),
  ]);
  const [recipes, categories, users] = results;
  // Do something with recipes, categories and users
};
```
