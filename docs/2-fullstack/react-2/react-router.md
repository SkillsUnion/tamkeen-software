# React Router

## Learning Objectives

1. Use React Router to keep our app URLs in sync with components we are viewing.
2. Learn how implement React Router in our applications.
3. Learn how to control user flow with React Router.
4. Learn how to implement Private Routing within our applications.

## Introduction

React Router DOM is a React library that enables us to keep our app URLs in sync with Components that are rendered in the browser. Prior to React Router DOM, we needed to extensively add supplementary code to our app so that our URL did update, which is fine for small single-page apps but less so when our apps gets more complex with many pages and different URL endpoints.

Scroll through the <a href="https://reactrouter.com/" target="_blank">React Router DOM homepage</a> to become familiar with the implementation concepts that are used by this package. The implementations that follow aim to give you an understanding of the routing system in React Router DOM quickly and without fuss.

## Official Tutorial

Complete the official React Router DOM tutorial to familiarise yourself with React Router. Once we learn the mechanics of React Router we will integrate it into our React ViteJS apps.

<a href="https://reactrouter.com/en/main/start/overview" target="_blank">React Router</a>

1. React Router can be implemented in a variety of ways, we will be show casing the use of <a href="https://reactrouter.com/en/main/routers/create-browser-router" target="_blank">createBrowserRouter</a> and <a href="https://reactrouter.com/en/main/utils/create-routes-from-elements" target="_blank">createRoutesFromElements</a> in the code samples below to implement the router system.
2. Pay attention to how we can implement nested `Route`s within the router system.
3. Pay attention to how the `Outlet` component renders out sub components within the nested router system.
4. Always add an `ErrorElement` within the router system in our apps for robustness and to help redirect users to a useful page.
5. Note we need to import the React Router React Hook `useParams` from `react-router-dom` to get URL params when to use within our router system.

### Vital Imports

1. <a href="https://reactrouter.com/en/main/routers/create-browser-router" target="_blank">createBrowserRouter</a> This function is used to create a router system, it uses the DOM History API in order to update the URL and manage the application's history. To use this function, we need pass in an array of objects that represent each endpoint within your web application and the desired Component that you want to render. It should be noted that using this function unlocks the use of 'loaders', 'actions' and 'fetchers' that can be added into more complex implementations of React Router.

2. <a href="https://reactrouter.com/en/main/utils/create-routes-from-elements" target="_blank">createRoutesFromElements</a> This is a utility function that creates route objects out of <a href="https://reactrouter.com/en/main/route/route" target="_blank">Route</a> elements. This can help with readability when developing your router system, this makes the React Router system appear as JSX as opposed to objects.

3. <a href="https://reactrouter.com/en/main/routers/router-provider" target="_blank">RouterProvider</a> All router objects are passed into this Component to render your application within the browser, not that you need to pass all route objects or `Route`'s into the provider otherwise the application will not be able to handle the route.

4. <a href="https://reactrouter.com/en/main/route/route" target="_blank">Route</a> - This Component is used to define the Component or Components that will render depending on the current url path that is in the browser. We utilise Route nesting to develop our complex application layouts as well as data dependencies. `Route`'s contain a 'path' prop that will render the Component onto the screen if the current url matches the 'path' property. The other vital prop on a Route is the 'element' prop that signifies the JSX or Component that is to be rendered. If an `Outlet` is contained in these Components, nested `Route` Components may also be rendered onto the screen, depending on the URL.

5. <a href="https://reactrouter.com/en/main/components/outlet" target="_blank">Outlet</a> - This Component is used so that multiple path Components can be rendered onto the browser. Therefore the use of `Outlet`s faciliate nested routing such that we can view multiple Components.

6. <a href="https://reactrouter.com/en/main/components/link" target="_blank">Link</a> - This component allows our users to navigate through the application such that they can visit every path and therefore every component. The links have a 'to' prop which should match a `Route`'s path prop.

### Example Simple Implementation

```jsx
import { Link } from "react-router-dom";
function Navbar() {
  return (
    <div className="navbar">
      <Link to="/">Home</Link>
      <Link to="/api">Api</Link>
      <Link to="/profile">Profile</Link>
      <Link to="/component">Component</Link>
    </div>
  );
}
export default Navbar;
```

```jsx
import Navbar from "./Components/Navbar.jsx";
import "./App.css";

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

export default function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: (
        <div>
          <Navbar />
          <h1>Hello World</h1>
        </div>
      ),
    },
    {
      path: "api",
      element: (
        <div>
          <Navbar />
          <h1>Hello Api</h1>
        </div>
      ),
    },
    {
      path: "profile",
      element: (
        <div>
          <Navbar />
          <h1>Profile</h1>
        </div>
      ),
    },

    {
      path: "component",
      element: (
        <div>
          <Navbar />
          <h1>Component</h1>
        </div>
      ),
    },
  ]);
  return (
    <>
      <h1>Hello World</h1>
      <RouterProvider router={router} />
    </>
  );
}
```

<figure><img src="../assets/profile.png" alt=""><figcaption><p>http://localhost:5173/profile</p></figcaption></figure>

The code above will implement a simple form of routing within our a basic React Application, when viewing the application in the browser following the command `npm run dev`, you will be able to access each element that was passed into `createBrowserRouter`, based off the URL endpoint that is visited. Eg: `http://localhost:5173/profile` to render the Profile Component.   As you can see from the code above each object contains a "path" and an "element" key. The element can be a collection of JSX or a React Component, we will explore using Components within the router in the next example. Note that the path value matches a `Link`'s "to" property value that is defined in the file `Navbar.jsx`. This is how routing is set up utilising React Router DOM.

If you would like to checkout the code implementation, please checkout <a href="https://github.com/SkillsUnion/react-routing/tree/simple_example" target="_blank">this repository</a>.

It should be noted that developers can pass any number of props that are required to React Components within the Application. To showcase this we can use the code sample above, we will pass a prop into the `Navbar` Component. Add a prop to your Components in the conventional fashion, consider the sample below:

```jsx
<Navbar disabled={false} />
```

Note that this is just a sample and is not implemented within the codebase.

### Sample Implementation Nested Routes

```jsx
import CallApi from "./Components/CallApi.jsx";
import Root from "./Components/Root.jsx";
import Profile from "./Components/Profile.jsx";
import Component from "./Components/Component.jsx";
import ErrorPage from "./Components/ErrorPage.jsx";
import Home from "./Components/Home.jsx";
import "./App.css";

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

export default function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Root />,
      errorElement: <ErrorPage />,
      children: [
        { path: "/", element: <Home /> },
        { path: "api", element: <CallApi /> },
        {
          path: "profile",
          element: <Profile />,
          children: [
            {
              path: "edit",
              element: (
                <div>
                  <h3>Edit Profile</h3>
                  <p>Edit me now</p>
                </div>
              ),
            },

            {
              path: "view",
              element: (
                <div>
                  <h3>View Profile</h3>
                  <p>View me now</p>
                </div>
              ),
            },
          ],
        },
        { path: "component", element: <Component /> },
      ],
    },
  ]);
  return (
    <>
      <h1>Hello World</h1>
      <RouterProvider router={router} />
    </>
  );
}
```

In the code sample above, there are two nested routes, every Component is nested under the '/' route and there are two nested routes under '/profile'. 

The first '/' path nests these additional paths, 'api', 'profile', 'component'. 

While the second nested example '/profile' nests the paths 'edit' and 'view'. 

This is indicated by the children property in the objects specified above. If an object doesnt contain the children property, it doesn't nest any paths.

When developing an application that contains nested routes, it should be noted that you will need to use an `Outlet` on the parent Route's in order to render its children based off the visited URL. This can be seen in the case of the `Root` path, with the value of '/'  in this example.

Below is the `Root` Component where we have embedded the `Navbar` within the `return` statement before the `Outlet` to reduce repetitive code. Note that this `Outlet` is used to render out the child Components listed within the `App.jsx`, the `Outlet` empowers the routes `'/'`, `'/api'`, `'/profile'`, `'/component'`, as well as `'/error'`, when visited these paths render the `Home`, `CallApi`, `Profile`, `Component` and `ErrorPage` Components respectively. 

The `Navbar` Component can be found within the example above, `Navbar.jsx`.

```jsx
import { Outlet } from "react-router-dom";
import Navbar from "./Navbar";
export default function Root() {
  return (
    <div>
      <Navbar />
      <Outlet />
    </div>
  );
}
```

The `Profile` Component, shown below, also contains an `Outlet` to facilitate the nested routes `'/profile/edit'` and `'/profile/view'`.  These paths render JSX elements as opposed to Components within the example  `App.jsx`. Note how the `Profile` also contains `Link` elements such that the user can navigate to the child components.

```jsx
import { Link, Outlet } from "react-router-dom";
function Profile() {
  return (
    <>
      <div className="navbar">
        <Link to="edit">Edit Profile</Link>
        <Link to="view">View Profile</Link>
      </div>
      <h1>Profile</h1>
      <Outlet />
    </>
  );
}
export default Profile;
```

### User Flow

Once you have set up basic routing, you will want to consider your user flow. If users should be pushed to a new page or when an action is complete, we use the method below to achieve this.

The <a href="https://reactrouter.com/en/main/hooks/use-navigate" target="_blank">useNavigate</a> hook allows us to move our users around our application using React Router. An example of this implementation can be seen within our example.

The `ErrorPage` Component is rendered when a user has navigated to a path that isn't handled in the implemented router system. As indicated by the code below, `useNavigate` has been implemented to help the user. This tool allows us to access and alter the current url that the user has visited. In this example, the user will be navigated back to the home page when the "Home" button is clicked. Note that we could push the users to any page handled within the React Router system, just pass in the relevant path.

```jsx
import { useNavigate } from "react-router-dom";
function ErrorPage() {
  const navigate = useNavigate();
  return (
    <>
      <h1>This route is not found! Please use the give navigation bars</h1>
      <button onClick={() => navigate("/")}>Home</button>
    </>
  );
}
export default ErrorPage;
```

Below are the some example Components that could be used to implement the React Router example above.

```jsx
function Home() {
  return (
    <>
      <h1>Welcome back Home</h1>
    </>
  );
}
export default Home;
```



```jsx
function Component() {
  return (
    <>
      <h1>Component</h1>
    </>
  );
}
export default Component;
```



```jsx
import axios from "axios";
import { useState, useEffect } from "react";
import PokeCard from "./PokeCard";

export default function CallApi() {
  const [pokemon, setPokemon] = useState([]);
  const [input, setInput] = useState("");

  useEffect(() => {
    axios.get("https://pokeapi.co/api/v2/pokemon/geodude").then((data) => {
      console.log(data);
      const unpackedData = data.data;
      console.log(unpackedData);
      setPokemon([...pokemon, unpackedData]);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.get(`https://pokeapi.co/api/v2/pokemon/${input}`).then((data) => {
      let info = data.data;
      setPokemon([...pokemon, info]);
    });
  };

  return (
    <>
      <h1>Pokemon Incoming!</h1>
      <input
        type="text"
        value={input}
        placeholder="Pokemon Name"
        onChange={(e) => setInput(e.target.value)}
      />
      <input type="submit" value="submit" onClick={handleSubmit} />
      {pokemon && pokemon.length > 0 ? (
        pokemon.map((avatar) => (
          <div key={avatar.id}>
            <PokeCard {...avatar} />
          </div>
        ))
      ) : (
        <p>No Pokemon here</p>
      )}
    </>
  );
}
```



```jsx
export default function PokeCard(props) {
  return (
    <div className="card">
      <h2>{props.name}</h2>
      <img src={props.sprites.front_default} alt={props.name} />
      <p>{props.weight}</p>
    </div>
  );
}
```


<figure><img src="../assets/profile-view.png" alt=""><figcaption><p>http://localhost:5173/profile/view</p></figcaption></figure>

This is the output of the current code showcasing the nested route and what it would look like. If you would like to checkout the code implementation please checkout <a href="https://github.com/SkillsUnion/react-routing/tree/nested_routes" target="_blank">this repository</a>.

### createRoutesFromElements

While the above implementation works and is able to render out various pages, it is possible to make routing easier to read, such that you can easily identify nested routes within your codebase. 

To do this, we would need to convert the objects that were passed in the previous example into `Route` Components, passing any required properties, the key props are "path" and "element".


```jsx
import CallApi from "./Components/CallApi.jsx";
import Root from "./Components/Root.jsx";
import Profile from "./Components/Profile.jsx";
import Component from "./Components/Component.jsx";
import ErrorPage from "./Components/ErrorPage.jsx";
import Home from "./Components/Home.jsx";
import User from "./Components/User";
import "./App.css";

import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";

export default function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path="/" element={<Root />}>
        <Route path="/" element={<Home />} />
        <Route path="/api" element={<CallApi />} />
        <Route
          path="/profile"
          element={<Profile />} >
          <Route
            path="edit"
            element={
              <div>
                <h3>Edit Profile</h3>
                <p>Edit me now</p>
              </div>
            }
          />
          <Route
            path="view"
            element={
              <div>
                <h3>View Profile</h3>
                <p>View me now</p>
              </div>
            }
          />
        </Route>
        <Route path="/component" element={<Component />} />
        <Route path="/user/:username" element={<User />} />
        <Route path="*" element={<ErrorPage />} />
      </Route>
    )
  );

  return (
    <>
      <h1>Hello World</h1>
      <RouterProvider router={router} />
    </>
  );
}
```


In the code sample above, nested routes become easier to identify compared to the earlier implementation of React Router DOM as `Route` tags wrap around any child 'routes' or 'paths'. 

This is indicated by the `Route` tag which renders the `Root` Component, it starts on line 20 and encompasses all defined `Route`s and closes on line 48. 

Another example of this is the `Route` that renders the `Profile` Component, it is defined on line 23 and closes on like 44, encompassing the `Route`s that contain the paths 'edit' and 'view'. 

By developing an application in this manner, it is possible to map out possible pages and understand the routing system that was setup.

### Parameters and useParams

Notice how we added an additional `Route` in the example above, the `user` route, which renders the `User` Component, note that the path property has been implemented with the `username` parameter. 

This parameter signifies that the value is whatever is passed within the URL provided the rest of the path matches. EG: "http://localhost:5173/user/sam" and  "http://localhost:5173/user/kai" render the the same Component but will appear difference every time the url changes. Below is the `User` Component, it displays a welcome message as well as the "username" that is passed into the URL.   

We can consider this Component to be dynamic because when you navigate to the page and React Router will process the endpoint value of the URL to alter what is rendered within the browser.  

> Note: If you are implementing this code, there are no navigation `Link`s to this Component, to visit this Component alter the URL in the browser or generate some `Link`s and add them to the Navbar Component.


```jsx
import { useParams } from "react-router-dom";

function User() {
  const params = useParams();
  return (
    <>
      <h1>Welcome back {params.username}</h1>
    </>
  );
}

export default User;
```


<figure><img src="../assets/hello-john.png" alt=""><figcaption><p>http://localhost:5173/user/John</p></figcaption></figure>

If you would like to checkout the code implementation please checkout <a href="https://github.com/SkillsUnion/react-routing/tree/nested_routes_route" target="_blank">this repository</a>.

## Private Routing

It should be noted that the section below should only be attempted after authentication has been implemented within an application. 

Before this, you wouldn't be implementing a meaningful authenticated routing system. We will be covering authentication later within this module.

When you have achieved authentication within your applications, you may desire to create private routes. Private routes are routes whose components are wrapped in authenticating logic.

This means that users who are not authenticated are unable to access the URL that they tried to visited and will be redirected to another page within the application.

```jsx
const RequireAuth = ({ children, redirectTo, user }) => {
  const isAuthenticated = user.uid ? true : false;
  return isAuthenticated ? children : <Navigate to={redirectTo} />;
};

// Within a React functional component, wrapped inside a createBrowserRouter object element
      {  
        path: "profile",
        element: (
          <RequireAuth redirectTo={"/"} user={user}>
            <Profile />
          </RequireAuth>
        ),
        children: [
          {
            path: "edit",
            element: (
              <div>
                <h3>Edit Profile</h3>
                <p>Edit me now</p>
              </div>
            ),
          },

          {
            path: "view",
            element: (
              <div>
                <h3>View Profile</h3>
                <p>View me now</p>
              </div>
            ),
          },
        ],
      },
```


The `RequireAuth` function checks to see if the user is authenticated, by validating the existence of a "user.uid", if this uid exists, then, the Component will proceed to render the appropriate Components, in this case the `Profile`. On the other hand if the uid is return undefined, the user is seen as not logged in and they will be redirected to the '/' path. 

If you would like to checkout the code implementation, please checkout <a href="https://github.com/SkillsUnion/react-routing/tree/nested_routes_route_auth" target="_blank">this repository.</a>
