# blogapp

This React application was built for **Module 13 (Hands-On Lab 4: Component Lifecycle & Fetch API)** in the Digital Nurture Java FSE program.

## Features
- **Post Class Model**: `src/Post.js` defining `Post(id, title, body)` model.
- **Posts Class Component**: `src/Posts.js` managing state and fetching blog posts asynchronously.
- **`componentDidMount()` Hook**: Calls `loadPosts()` to fetch data from `https://jsonplaceholder.typicode.com/posts`.
- **`componentDidCatch()` Hook**: Displays alert popups and catches component execution errors gracefully.

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
