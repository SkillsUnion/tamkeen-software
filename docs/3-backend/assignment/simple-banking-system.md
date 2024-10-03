# Assignment: Simple Banking System

## Learning Objectives

1. Apply control flow statements and loops in a practical setting, simulating a simple banking system.


## Introduction

Create a simple banking system that allows users to perform basic banking operations such as viewing their balance, depositing money, withdrawing money, and exiting the system. The program should use control flow statements and loops to implement these functionalities.



## Instructions

### 1. Fork and clone a copy of <a href="https://github.com/SkillsUnion/banking-system.git" target="_blank">Banking repo</a>

### 2. Menu Options:

   - Option 1: View Balance:
     - Display the current balance to the user.
   - Option 2: Deposit Money:
     - Prompt the user to enter a deposit amount.
   - Ensure the amount is positive.
     - Add the deposit amount to the balance and display a confirmation message.
   - Option 3: Withdraw Money:
     - Prompt the user to enter a withdrawal amount.
     - Ensure the withdrawal amount is positive and less than or equal to the balance.
     - Deduct the amount from the balance and display a confirmation message.

   - Option 4: Exit:
     - Exit the loop and terminate the program with a friendly message.

### 3. Loop Structure:

   - The while loop should continue to show the menu until the user selects the "Exit" option.


   - If the user selects an invalid option (i.e., not 1-4), the program should display an error message and prompt them to select again.

   - After the user selects the "Exit" option, thank them for using the banking system and gracefully terminate the program.

   - Ensure the Scanner object is properly closed after use.

### 4. Sample Run :
```java
Banking System Menu:
1. View Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Choose an option (1-4): 2
Enter the amount to deposit: $500
You have successfully deposited $500
---------------------------
Banking System Menu:
1. View Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Choose an option (1-4): 1
Your current balance is: $500.0
---------------------------
Banking System Menu:
1. View Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Choose an option (1-4): 3
Enter the amount to withdraw: $200
You have successfully withdrawn $200
---------------------------
Banking System Menu:
1. View Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Choose an option (1-4): 1
Your current balance is: $300.0
---------------------------
Banking System Menu:
1. View Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Choose an option (1-4): 4
Thank you for using the banking system. Goodbye!
```



