# List and Keys

## Learning Objectives

1. Explain the purpose and importance of keys when rendering lists of JSX elements in React.
2. Implement unique and stable keys for list items to optimize React's rendering performance.
3. Evaluate different methods for generating unique keys, including database IDs, incrementing counters, and third-party libraries like UUID.

## Lists and Keys

JSX keys in an array help us to identify unique items from their siblings. Keys help React to identify different JSX elements throughout their lifetimes. You can generate key values in whatever way you would like, but if you've pulled data out of a database, they might already have identities, such as an ID property. 

You could create your own incrementing counter to set unique keys within an application or implement <a href="https://www.npmjs.com/package/uuid" target="_blank">uuid</a> or another package that can assign unique id's within an application.

Here is the <a href="https://react.dev/learn/rendering-lists" target="_blank">documentation</a> on how to render lists and use keys in React.

Some points to consider about keys:
1. Always use keys when rendering JSX elements in a list for performance reasons.
2. Keys should be unique among siblings
3. Keys cannot change

## Additional References
1. [Why use React keys](https://www.epicreact.dev/why-react-needs-a-key-prop)

## Rendering Arrays as Lists

Copy the starter code in this [repo](https://github.com/SkillsUnion/se-sample-react-condrendlist/part-2-begin) and start the React app.

> Note: we will see some folders like `context` and `reducers` in this starter code, but we will deal with how these work when we move to the Full Stack module.

For this section, we need to install an external library to generate unique IDs:

```
npm install uuid
```

UUID is an identifier that is unique that is of fixed size and contains a time field. A UUID can be used for multiple purposes, from tagging objects to reliably identifying persistent objects across a network.

uuid is an external js library that is used to create UUIDs to be used as keys. 

Change into your work folder and start the React app.

```
cd part-2-begin
npm run dev
```

### What is CRUD?

When testing out a new programming language or framework, we often build a basic application to check out its functionalities. A popular application used for this purpose is a CRUD application:

| Action | Description |
|---|---|
| **Create** | Add a new record to a list or database |
| **Read** | View an existing record |
| **Update** | Edit and update an existing record |
| **Delete** | Remove an existing record |

In the previous lessons, we have already done **Create** and **Read** part of the app, refer to `handlerAddProduct` in `Product.jsx` and the `ViewList.jsx` component. In this section, we will continue the CRUD app by adding **Delete** function.

### Step 1: Add Delete UI Element and Handler

Insert a new column in the `ViewList` table to display a delete button and enable its `onClick` handler:

```js
// ViewList.jsx
return (
  ...
  <thead>
    <tr>
      ...
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
      <tr ...>   
        ...
        <td>{item.total.toFixed(2)}</td>
        <td onClick={() => console.log('Delete handler here...')}>❌</td>
      </tr>
    ...
  </tbody>
)
```

The `onClick` attribute receives an anonymous arrow function to allow `handlerDeleteItem(...)` to be passed as a function. Otherwise, the handler will be exectuted immediately during rendering. 

Test the delete button by pressing it and observing the console log output.

Next, `ViewList` must receive the delete handler from its parent `Product`, where the product list state is held. Change the function component to accept the handler as a prop and pass it to `onClick` as a function.

```js
// ViewList.jsx
...
function ViewList({ list, sum, handlerDeleteItem }) {
  ...
  return(
    ...
    <td onClick={() => handlerDeleteItem(item.id)}>❌</td>
    ...
  )
}
```

### Step 2: Add Unique ID to Product Item

In order to delete the selected item from the product list, we need to create a unique ID for each list item. Import the `uuid` function and use it to generate a unique ID during item creation:

> Don't forget to install the 'uuid' npm library!

```js
// Product.jsx
import { v4 as uuid } from 'uuid';
...
const handlerAddProduct = () => {
  const newItem = {
    id: uuid(),
    ...
  }
}
```
In `ViewList`, change the `<tr key={...} />` attribute to make use of the new `item.id`:

```js
// ViewList.jsx
  ...
  {list.map((item) => (
    <tr key={item.id}>
  ))}
  ...
```

> React developers recommend the use of uniquely generated IDs for list `key` attributes, instead of simple index keys. This will ensure proper re-rendering of list items in the DOM.

### Step 3: Add Delete Handler Function and Pass as a Prop

Add the delete handler function:

```js
// Product.jsx
...
const handlerDeleteProduct = (id) => {
  const newList = list.filter((item) => item.id !== id);
  setList(newList);
}
...
```

Pass the delete handler to `ViewList` as a prop:

```js
// Product.jsx
...
return(
  ...
  <ViewList
    ...
    handlerDeleteItem={handlerDeleteProduct}
  >
)
```

There are many techniques to remove an item from an array in Javascript and this is just one of the popular ones. To delete an item from the list, apply the ES6 `filter` method to list to create a new list that includes every item in the current list, except for the item with the delete ID parameter. 

The **Delete** function should work now.