# gitclientapp

This React application was built for **Module 13 (Hands-On Lab 19: Testing Isolation & Mocking with Jest and Axios)** in the Digital Nurture Java FSE program.

## Features
- **GitClient Class**: `src/GitClient.js` invoking `https://api.github.com/users/:username/repos` using `axios`.
- **App Component**: `src/App.js` displaying fetched repository names for user `techiesyed`.
- **Unit Test Suite**: `src/GitClient.test.js` using `jest.mock('axios')` and `axios.get.mockResolvedValue()` to test repository name extraction in complete isolation without calling live APIs.

## Available Scripts

In the project directory, you can run:

### `npm start`
Runs the app in development mode.

### `npm test`
Runs Jest unit tests.
