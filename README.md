# Expense Tracker - CPSC 210 Personal Project


## Project Proposal

**What will the application do?**

The application is an expense tracker that tracks a user's expenses.
A user will be able to keep tabs on their spendings as well as get personal insight from graphs.
The user will be able to add invidual expenses to different types of expense categories
that they define.

The application will be able to visualize the user's expenses into a graph.

**Who will use it?**

Individuals who need to keep tabs on their income and purchase history so that they can budget appropriately.
These users may want to see personal analytics and visualize their expenditure throughout the month.
Even if someone may be great at account keeping and money management, 
it is almost always difficult--or at the very least time consuming--to keep track of transactions by hand.
An application that simplifies this process would be quite usefull.

**Why is this project of interest to you?**

I am in the process of learning how to properly budget my money every month and certainly,
it can be quite daunting to encapsulate your monthly expenditure into comprehensible chunks all at once.
I thought that creating an application to simplify the budgeting and finance management process for me
would not only be interting, but also rather usefull.


## User Stories

- As a user, I want to be to view the list of expenses in each expense category.
- As a user, I want to be able to add, remove, and update new or existing expenses in my list of expense categories.
- As a user, I want to be able to see the number of expenses that I have.
- As a user, I want to be able to see the total cost of my expenses.
- As a user, I want to be able to visualize my monthly expenditure into graphs.

- As a user, when I select the quit option from the application menu, I want to have the option to save my list of expenses 
with their respective names, categories, cost, and payment status.
- As a user, I want to be given the option to load my list of expenses from file when I start the Expense Tracker application.

## Instructions for End User
- You can view the panel that displays the expenses you have added on the left. This panel is scrollable.
- You can add and remove expenses from your list of expenses by clicking on the respective button and following the prompt.
- You can update existing expenses by hovering over the respective button and selecting one of the options in the dropdown menu. These options are renaming, changing category, changing cost, or ing the payment status of an expense.
- A pie graph will appear on the right panel when you add at least one expense. The pie graph displays the cost of each category by percentage.
- You can save your list of expenses by clicking the save button.
- You can reload your list of expenses by clicking the load button.

## Phase 4: Task 2
- A representative example for event logging below

```text
Fri Nov 28 13:53:44 PST 2025
Event log cleared.

Fri Nov 28 13:53:44 PST 2025
New ExpenseList Created

Fri Nov 28 13:53:44 PST 2025
Loading expense list

Fri Nov 28 13:53:44 PST 2025
Added expense, Name: Rock, Category: Pet, Cost: 8.0, Payment Status: false

Fri Nov 28 13:53:44 PST 2025
Added expense, Name: McDonalds, Category: Food, Cost: 10.0, Payment Status: true

Fri Nov 28 13:53:44 PST 2025
Added expense, Name: Swimming Pass, Category: Recreation, Cost: 6.0, Payment Status: true

Fri Nov 28 13:53:44 PST 2025
Finished loading expense list

Fri Nov 28 13:53:56 PST 2025
Removed expense, Name: Swimming Pass, Category: Recreation

Fri Nov 28 13:54:07 PST 2025
Changed Expense Cost, Name: Rock, Previous Cost: 8.0, New Cost: 10.0

Fri Nov 28 13:54:19 PST 2025
Added expense, Name: Shirt, Category: Clothes, Cost: 5.0, Payment Status: true

Fri Nov 28 13:54:22 PST 2025
Requested total number of expenses: 3

Fri Nov 28 13:54:26 PST 2025
Requested total cost of expenses: $25.0

Fri Nov 28 13:54:32 PST 2025
Saved expense list
```

## Phase 4: Task 3
- Refactoring: If I had more time to work on the project, I would refactor my implementation of the ExpenseTrackerGUI's dependency on ExpenseList. In its present state, ExpenseList has a few methods that either returns some sort of List or a value after iterating through the listOfExpenses. These methods have some redudancy and it would improve the cleanliness of the code if I were to modify these methods to be more abstract and take in some parameter, say return all the names of the expenses in the listOfExpenses. Moreover, I could also create a class in the ui specifically for the different panels of the ExpenseTrackerGUI. Since I have many buttons with different functionality, a panel for a table containing expenses, and a panel for a PieGraph, I could put these panels into their own class. This could potentially decrease coupling and increase cohension, increase readability, and also increase the testability of the code. By taking these steps to refactor the code, I believe I could further improve the design philosophy and structure of the program.