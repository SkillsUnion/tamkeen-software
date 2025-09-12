# Lifting States Up

## Learning Objectives

1. Implement the "lifting state up" technique to manage shared state between multiple React components.
2. Analyze component hierarchies to determine the appropriate location for shared state management.
3. Construct a React application that maintains a single source of truth by passing state and event handlers as props from parent to child components.

## Lifting State Up

Managing state on components can get challenging and confusing when you need to share data between multiple components.  Especially so while still having to preform live updates and dynamically render content. The process of lifting up state means your children components actually receive data as props. Instead of storing the data on each child, you store the data on a shared parent of both child components. The documentation of React for <a href="https://react.dev/learn/sharing-state-between-components" target="_blank">lifting the state up</a> is a useful reference to learn and understand how it is implemented.

> Note: It is important that we pass both the state and handler function from `Accordion` to `Panel` so the app can maintain only one "**source of truth**" state for the active value in `Panel`. If it helps, we recommend drawing the component hierarchy to visualise how data flows in the application and verifying our understanding.
