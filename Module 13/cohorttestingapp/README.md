# cohorttestingapp

This React application was built for **Module 13 (Hands-On Lab 18: React Unit Testing with Jest & Enzyme)** in the Digital Nurture Java FSE program.

## Features
- **Enzyme Test Adapter Configuration**: Configured in `src/setupTests.js`.
- **Cohort Mock Data**: `src/Cohort.js` providing `CohortData` mock array.
- **CohortDetails Component**: `src/CohortDetails.js` rendering cohort details.
- **Unit Test Suite**: `src/CohortDetails.test.js` implementing 4 unit tests:
  1. `should create the component` (shallow loading in isolation)
  2. `should initialize the props` (mount and verify prop assignment)
  3. `should display cohort code in h3` (mount, find `h3`, and verify cohort code text)
  4. `should always render same html` (snapshot testing with `toMatchSnapshot()`)

## Running Unit Tests

In the project directory, run:

```bash
npm test
```
