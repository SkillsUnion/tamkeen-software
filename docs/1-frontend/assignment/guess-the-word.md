# Assignment: Guess The Word

## Learning Objectives

1. Construct React forms using controlled components to manage form data.
2. Apply JavaScript logic within React components to enhance application functionality.

## Introduction

Guess The Word (aka Hangman) is a single-player game where a user tries to guess all letters in a secret word with a limited number of guesses. Correct guesses will reveal the instances of the guessed letter in the word. Incorrect guesses will reduce "guesses remaining". A user wins when they guess all letters in the word correctly, and loses when there are no guesses remaining.

## Starter Code

Fork and clone the <a href="https://github.com/SkillsUnion/guess-the-word" target="_blank"> Guess The Word repo</a>. Understand the following starter code in `App.jsx` before creating GTW, and feel free to change anything you would like in `App.jsx`. Run `npm install` to install packages and `npm run dev` to start the app, next open your browser and navigate to <a href="http://localhost:5173/" target="_blank">http://localhost:5173</a>.

```jsx
import "./App.css";
import { getRandomWord } from "./utils";
import { useState } from "react";

function App() {
  // currWord is the current secret word for this round. Update this with the updater function after each round.
  const [currWord, setCurrentWord] = useState(getRandomWord());
  // guessedLetters stores all letters a user has guessed so far
  const [guessedLetters, setGuessedLetters] = useState([]);

  // Add additional states below as required.

  const generateWordDisplay = () => {
    const wordDisplay = [];
    // for...of is a string and array iterator that does not use index
    for (let letter of currWord) {
      if (guessedLetters.includes(letter)) {
        wordDisplay.push(letter);
      } else {
        wordDisplay.push("_");
      }
    }
    return wordDisplay.toString();
  };

  // create additional function to power the

  return (
    <>
      <div className="card">
        <h1>Guess The Word</h1>
        <h3>Word Display</h3>
        {generateWordDisplay()}
        <h3>Guessed Letters</h3>
        { guessedLetters.length > 0 ? guessedLetters.toString(): "-"}
        <br />
        <h3>Input</h3>
        {/* Insert form element here */}
      </div>
    </>
  );
}

export default App;
```

## Base

Add a form HTML element in `App.jsx` as per what we learned in React Forms to allow the user to input guesses. Each guess can only consist of 1 letter at a time. Control form input using component state as per the React Guide.

When the user guesses a letter, add that letter to the `App` component's `guessedLetters` state. Consider using the spread operator when adding the new letter to trigger React to re-render. The existing starter code logic will read `guessedLetters` and render correctly-guessed letters in the Word Display section and render all guessed letters in the Guessed Letters section.

Add logic and state to track whether the user has guessed all letters of the word and how many guesses the user has left (can start with 10). If the user guesses all letters correctly, tell them they have won. If the user runs out of guesses, reveal the word and tell them they have lost. When the round ends, give the user an option to play again.

>**Hard-code secret word for easier testing**
>
>When testing your app, you may find it easier to hard-code the secret word initialised in state. Guessing words is hard!

## Comfortable

Style the app to clarify what each UI component is for. Create an image that appears gradually with every wrong guess for the user to visualise how many guesses they have left. Consider using <a href="https://react-bootstrap.github.io/components/accordion" target="_blank">React Bootstrap</a> or <a href="https://mui.com/core/" target="_blank">MUI</a> components as default styles.

## More Comfortable

Allow the user to play multiple rounds and display their score across rounds, e.g. how many times they have guessed the word out of how many rounds.

## Submission

Submit the Github link of your assignment repository