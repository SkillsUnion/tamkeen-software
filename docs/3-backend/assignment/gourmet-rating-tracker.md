# Assignment:  Gourmet Rating Tracker: Rate and track restaurant menu items.

## Learning Objectives

- Understand and apply the use of ArrayList in Java for storing and managing dynamic collections of data.

- Develop functions to perform common operations such as adding, removing, and updating elements in an ArrayList.
  
- Implement logic to handle ratings and comparisons, such as finding the highest-rated item and filtering based on conditions.


## Introduction

Create a rating tracking system that rates and tracks a restaurant's food menu items.
The tracker allows users to store and manage menu items along with their ratings.
The users will be able to add new menu items,rate them,view all items,find the highest-rated item, and delete items with low ratings.

## Instructions

###    Fork and clone a copy of <a href="https://github.com/SkillsUnion/gourmet-rating-tracker.git" target="_blank">gourmet-rating-tracker repo</a>

###    Create a new Java class called GourmetRatingTracker (or use your preferred project name).

###    Use of ArrayList:

   -    You will use two ArrayList objects.

    -   One to store the names of food items.

     -  One to store their ratings (integers between 1 and 10).

     -  Ensure that these two lists are parallel,meaning the item at index i in the food list corresponds to the 
        rating at index i in the rating list.

### Core Functionalities to Implement:

 - Add Food Item:

   -  Create a method to allow users to add a food item and a corresponding rating.

-  Display Food Items and Ratings:

   -   Implement a method to print all food items with their ratings.

- Find Food with the Highest Rating:

   -  Implement a method to iterate through the ratings list and find the item with the highest rating.

- Delete Low-Rated Items:

   -  Implement a method to remove any food item with a rating below 5. Ensure that the corresponding item is removed from both lists.

- Delete by Name:

   -  Implement a method that allows users to delete a food item by entering its name.

### Handling User Input:

- Create a menu-driven console interface where users can select an option (e.g., add a food item, display all 

food   items, find the highest rating, delete food items, etc.).

- Use Scanner to take input from the user.

- Ensure that the program continues running until the user chooses to exit.





