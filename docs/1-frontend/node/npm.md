# NPM

## Learning Objectives

1. Explain the purpose of NPM and initialize a new NPM project using the command line
2. Understand the structure and importance of the package.json file in managing project dependencies
3. Demonstrate how to install, use, and manage third-party packages in a Node.js application
4. Identify best practices for version control in NPM projects, including which files to commit and which to ignore

## Introduction

![NPM allows us to install, manage and use 3rd-party packages](<../assets/0.5.2 - NPM Illustration.png>)

[NPM](https://www.npmjs.com) (Node Package Manager) is Node's most popular package manager and allows us to install 3rd-party software packages (aka libraries) in our apps. All apps use 3rd-party libraries, and package managers like NPM simplify managing app dependencies.

## Follow Along

We recommend you initialise your own NPM project to inspect the files we discuss on this page.

To create a new NPM project, create a folder, `cd` inside and initialise a new NPM project in that folder with `npm init -y`. The `-y` flag accepts defaults by answering `yes` to all setup questions.

```
mkdir my-first-npm-project
cd my-first-npm-project
npm init -y
```

## `package.json`

If we created our NPM project as above, we should now see a single file in `my-first-npm-project`: `package.json`.

```
% mkdir my-first-npm-project
% cd my-first-npm-project
my-first-npm-project % npm init -y
Wrote to /Users/kai/rocket-code/my-first-npm-project/package.json:

{
  "name": "my-first-npm-project",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}


my-first-npm-project % ls
package.json
```

`package.json` is the most important file in an NPM project because it specifies which packages our project depends on. When we install new packages, `package.json` lists those packages' names and versions. When other SWEs clone our code on their own computers and need to run it, `package.json` helps them install the exact packages and versions they need.

The following is the `package.json` generated after running `npm init -y`. Notice it has no packages yet, but contains other metadata for our project that is less relevant for us now.


```json
{
  "name": "my-first-npm-project",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}
```

## Installing NPM Packages

To install NPM packages, run the install command `npm install`, or `npm i` for short, followed by the package name. The following command downloads and installs the [`cows` package](https://www.npmjs.com/package/cows), a package to create ASCII cow images.


```
npm i cows
```
```
my-first-npm-project % npm i cows

added 1 package, and audited 2 packages in 3s

found 0 vulnerabilities
```

After installing `cows`, we should see 1 new file and 1 new folder: `package-lock.json` and `node_modules` respectively in addition to `package.json`.

```
my-first-npm-project % ls
node_modules		package-lock.json	package.json
```

Feel free to peek at `package-lock.json` and `node_modules`, but their contents are primarily metadata for our app that we most likely never need to touch. `package-lock.json` lists the versions of the packages we installed and of the packages that our installed packages depend on, aka "dependencies". `node_modules` contains code of installed packages and their dependencies. NPM relies on all 3 of these files and folders to operate.

`package.json` should now look like the following.

```json
my-first-npm-project % cat package.json
{
  "name": "my-first-npm-project",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "dependencies": {
    "cows": "^2.1.1"
  }
}
```

Notice there is a new `dependencies` section that contains the package `cows` and its version. Now, any time we clone a copy of this project and run `npm i` from within the project folder, NPM will install the packages listed in this `dependencies` section of `package.json`.

## Using NPM Packages

Popular NPM packages almost always have clear instructions on how to use the package. We can typically find these instructions on the [NPM website](https://www.npmjs.com/package/cows) and on the [package's GitHub repo](https://github.com/sindresorhus/cows).

> **Require vs Import Syntax**
>
> You may notice the `cows` package instructions tell us to import `cows` with `require`. This is an older version of JS syntax still widely seen but being phased out.

```javascript
const cows = require("cows");
```

The above `require` statement can be translated to the below `import` statement. `require` statements translated to `import` always use default exports, because there are no named exports with `require` syntax.

```javascript
import cows from "cows";
```

`import` statements work out of the box in Create React App, but to use them with NPM we will need to add `"type": "module"` key value pair to `package.json`. You can see it here in the [documentation](https://nodejs.org/api/packages.html#type)

When you are trying to implement the Cows package it will be very helpful if you visit the [documentation](https://github.com/sindresorhus/cows) so you know the conventional usage of this package.

First you will need to import (or require) the package and then invoke the cows() function to output the ASCII Cows. You may need to console.log the output of the function.

## What to Commit to Git

We should always commit both `package.json` and `package-lock.json` to Git for others that clone our project to have the same packages and versions.

We should avoid committing `node_modules` to Git, because `node_modules` can get large, and everything in `node_modules` can be installed with `npm i`. Committing large files like `node_modules` to Git can unnecessarily slow down Git operations such as pulling and pushing from GitHub.

> **Automatically ignore specified files and folders in Git**
> 
> Git allows for a special file called `.gitignore` anywhere in a Git repo that instructs Git to ignore specified files. To always ignore folders like `node_modules`, we can add `node_modules` on a line of its own in a `.gitignore` file in the NPM project's root directory.

## How to Find NPM Packages

NPM packages are typically discovered via Google Search and tutorials. We will direct you to all packages we need, although we encourage you to independently find new packages to enhance your projects.
