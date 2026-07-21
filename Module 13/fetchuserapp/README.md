# fetchuserapp

This React application was built for **Module 13 (Hands-On Lab 17: Consuming REST APIs with fetch and componentDidMount)** in the Digital Nurture Java FSE program.

## Features
- **Getuser Component**: `src/Getuser.js` class component retrieving user details from `https://api.randomuser.me/`.
- **Async componentDidMount**: Executes `async componentDidMount()` to invoke the REST API endpoint and deserialize the JSON response.
- **Dynamic Render**: Displays user profile avatar (`picture.large`), `title`, and `first` name upon completion of asynchronous HTTP request.

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
