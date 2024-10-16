# Assignment: High Card

## Learning Objectives

1. Construct a standalone React application, demonstrating proficiency in HTML, CSS, and React.
2. Implement the deployment process to publish a React application on the internet.

## Introduction

High Card is a turn-based game between 2 or more players where each player draws a card and the player with the highest card wins that round. The overall winner is the player that has won the most rounds when the deck runs out of cards. We will implement High Card with React.

## Starter Code

### Clone starter code

Fork and clone the <a href="https://github.com/SkillsUnion/high-card" target="_blank">High Card repo</a> and understand the following starter code before creating High Card. Run `npm install` to install default packages our app needs to run, and run `npm run dev` to start the app next open your browser and navigate to <a href="http://localhost:5173/" target="_blank">http://localhost:5173</a>.

### Understand starter code

Notice a file `utils.jsx` (short for "utilities") in the `src` folder that contains helper functions for creating and shuffling a card deck. This is the same code we use in Coding Fundamentals.

```javascript
// Get a random index ranging from 0 (inclusive) to max (exclusive).
const getRandomIndex = (max) => Math.floor(Math.random() * max);

// Shuffle an array of cards
const shuffleCards = (cards) => {
  // Loop over the card deck array once
  for (let currentIndex = 0; currentIndex < cards.length; currentIndex += 1) {
    // Select a random index in the deck
    const randomIndex = getRandomIndex(cards.length);
    // Select the card that corresponds to randomIndex
    const randomCard = cards[randomIndex];
    // Select the card that corresponds to currentIndex
    const currentCard = cards[currentIndex];
    // Swap positions of randomCard and currentCard in the deck
    cards[currentIndex] = randomCard;
    cards[randomIndex] = currentCard;
  }
  // Return the shuffled deck
  return cards;
};

const makeDeck = () => {
  // Initialise an empty deck array
  const newDeck = [];
  // Initialise an array of the 4 suits in our deck. We will loop over this array.
  const suits = ["Hearts", "Diamonds", "Clubs", "Spades"];

  // Loop over the suits array
  for (let suitIndex = 0; suitIndex < suits.length; suitIndex += 1) {
    // Store the current suit in a variable
    const currentSuit = suits[suitIndex];

    // Loop from 1 to 13 to create all cards for a given suit
    // Notice rankCounter starts at 1 and not 0, and ends at 13 and not 12.
    // This is an example of a loop without an array.
    for (let rankCounter = 1; rankCounter <= 13; rankCounter += 1) {
      // By default, card name and card rank are the same as rankCounter
      let cardName = `${rankCounter}`;
      let cardRank = rankCounter;

      // If rank is 1, 11, 12, or 13, set cardName to the ace or face card's name
      if (cardName === "1") {
        cardName = "Ace";
        // Ace has higher rank than all other cards
        cardRank = 14;
      } else if (cardName === "11") {
        cardName = "Jack";
      } else if (cardName === "12") {
        cardName = "Queen";
      } else if (cardName === "13") {
        cardName = "King";
      }

      // Create a new card with the current name, suit, and rank
      const card = {
        name: cardName,
        suit: currentSuit,
        rank: cardRank,
      };

      // Add the new card to the deck
      newDeck.push(card);
    }
  }

  // Return the completed card deck
  return newDeck;
};

// Export functionality to create a shuffled 52-card deck
export const makeShuffledDeck = () => shuffleCards(makeDeck());
```

Understand `App.jsx`'s logic to deal 2 cards at a time from the card deck. Understand what each line of code does before moving on, and ask your batch mates if you're not sure what the code is doing.

```jsx
import React from "react";
import "./App.css";
import { makeShuffledDeck } from "./utils.jsx";
import { useState } from "react";

function App(props) {
  // Set default value of card deck to new shuffled deck
  const [cardDeck] = useState(makeShuffledDeck());
  // currCards holds the cards from the current round
  const [currCards, setCurrCards] = useState([]);

  const dealCards = () => {
    const newCurrCards = [cardDeck.pop(), cardDeck.pop()];
    setCurrCards(newCurrCards);
  };
  
  // You can write JavaScript here, just don't try and set your state!

  // You can access your current components state here, as indicated below
  const currCardElems = currCards.map(({ name, suit }) => (
    // Give each list element a unique key
    <div key={`${name}${suit}`}>
      {name} of {suit}
    </div>
  ));

  return (
    <div className="App">
      <header className="App-header">
        <h2>React High Card</h2>
        {currCardElems}
        <br />
        <button onClick={dealCards}>Deal</button>
      </header>
    </div>
  );
}

export default App;
```

## Base

Complete High Card with the following features.

1. Determine who has won each round (Player 1 or Player 2)
2. Keep score during each game (how many rounds has each player won)
3. Declare a winner at the end of each game when the deck has run out of cards, and give the players the option to restart the game.

## Comfortable

Add nice-to-have features.

1. Style the app to clarify what each UI component is for. Clarify which card belongs to which player. Consider using <a href="https://react-bootstrap.github.io/docs/components/accordion" target="_blank">React Bootstrap</a> or <a href="https://mui.com/core/" target="_blank">MUI</a> components as default styles.
2. Create a re-usable `PlayingCard` component to render cards nicely. This component can use playing card images or create a custom playing card UI.

## More Comfortable

If you have time and want to practise more.

1. Allow players to keep track of scores across games, not just across rounds within a single game.

## Submission

Submit the Github repository of your assignment link

