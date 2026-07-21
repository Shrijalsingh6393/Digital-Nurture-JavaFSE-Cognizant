# cricketapp

This React application was built for **Module 13 (Hands-On Lab 9: ES6 Features - Map, Filter, Destructuring, Spread Operator & Flag Rendering)** in the Digital Nurture Java FSE program.

## Features
- **ListofPlayers Component**: `src/ListofPlayers.js` declaring 11 players, rendering them using ES6 `.map()`, and filtering scores below 70 using ES6 arrow functions (`.filter(p => p.score < 70)`).
- **IndianPlayers Component**: `src/IndianPlayers.js` demonstrating ES6 Array Destructuring (Odd/Even Teams) and Array Merging using the Spread Operator (`[...T20players, ...RanjiTrophyplayers]`).
- **Flag-Based Conditional Rendering**: `src/App.js` displaying `<ListofPlayers />` when `flag = true` and `<IndianPlayers />` when `flag = false`.

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
