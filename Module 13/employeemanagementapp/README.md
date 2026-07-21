# employeemanagementapp

This React application was built for **Module 13 (Hands-On Lab 14: React Context API - Refactoring Prop Drilling to Context)** in the Digital Nurture Java FSE program.

## Features
- **ThemeContext**: `src/ThemeContext.js` declaring `ThemeContext = createContext('light')`.
- **Context Provider**: `src/App.js` wrapping the application in `<ThemeContext.Provider value={theme}>`.
- **Eliminated Prop Drilling**: `src/EmployeesList.js` renders `<EmployeeCard />` without passing `theme` as props.
- **Context Consumer**: `src/EmployeeCard.js` using `useContext(ThemeContext)` hook to retrieve theme value and apply `light-btn` or `dark-btn` button class names dynamically.

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
