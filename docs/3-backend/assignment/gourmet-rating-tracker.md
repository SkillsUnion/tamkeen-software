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

 -  Ensure that these two lists are parallel,meaning the item at index i in the food list corresponds to the rating at index i in the rating list.

### Core Functionalities to Implement:

 - Add Food Item:

   -  Create a method to allow users to add a food item and a corresponding rating.

-  Display Food Items and Ratings:

   -   Implement a method to print all food items with their ratings.

- Find Food with the Highest Rating:

   -  Implement a method to iterate through the ratings list and find the item with the highest rating.

- Delete Low-Rated Items:

   -  Implement a method to remove any food item with a rating below 5. Ensure that the corresponding item is removed from both lists.



### Handling User Input:

- Create a menu-driven console interface where users can select an option (e.g., add a food item, display all 

food   items, find the highest rating, delete food items, etc.).

- Use Scanner to take input from the user.

- Ensure that the program continues running until the user chooses to exit.

## Instructions for Students:

**Instructions for Students:**

You are provided with a semi-complete Java program for this assignment **Gourmet Rating Tracker**. Your task is to complete the incomplete methods marked with `// add your code here`. Specifically, you need to implement the logic for adding food items and their ratings, displaying all food items, finding the food item with the highest rating, and removing food items with ratings below 5. Use appropriate loops and conditions to work with the `ArrayList` data structure. You can copy and paste this code into your Java class to start working on it. Follow the comments and hints provided in the code to complete each section. Ensure the program works as expected and meets all the requirements outlined in the menu options.

```Java

import java.util.ArrayList;
import java.util.Scanner;

public class GourmetRatingTracker {
    // ArrayLists to store food names and their ratings
    private static ArrayList<String> foodItems = new ArrayList<>();
    private static ArrayList<Integer> ratings = new ArrayList<>();

    // Function to add a new food item and its rating
    public static void addFoodItem(String food, int rating) {
        // add your code here
        // Add the food name to foodItems and its rating to ratings
    }

    // Function to display all food items and their ratings
    public static void displayFoodItems() {
        System.out.println("\nFood Items and Ratings:");
        // add your code here
        // Loop through the foodItems and ratings lists and print each item with its rating
    }

    // Function to get the food with the highest rating
    public static void foodWithHighestRating() {
        if (foodItems.isEmpty()) {
            System.out.println("No food items in the list.");
            return;
        }
        // add your code here
        // Find and print the food item with the highest rating
    }

    // Function to remove food items with ratings below 5
    public static void removeLowRatedFoods() {
        // add your code here
        // Loop through the ratings list and remove items with ratings below 5
    }

    // Main function to run the Food Rating System
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Food Item");
            System.out.println("2. Display All Food Items");
            System.out.println("3. Check Food with Highest Rating");
            System.out.println("4. Remove Food Items with Rating Below 5");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter food name: ");
                    String food = scanner.nextLine();
                    System.out.print("Enter rating (1-10): ");
                    int rating = scanner.nextInt();
                    if (rating < 1 || rating > 10) {
                        System.out.println("Invalid rating. Please enter a rating between 1 and 10.");
                    } else {
                        addFoodItem(food, rating);
                    }
                    break;

                case 2:
                    displayFoodItems();
                    break;

                case 3:
                    foodWithHighestRating();
                    break;

                case 4:
                    removeLowRatedFoods();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
```


## Here is the sample output of the program
```java
Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 1

Enter food name: Pizza
Enter rating (1-10): 8
Added: Pizza with rating 8



Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 1

Enter food name: Fries
Enter rating (1-10): 4
Added: Fries with rating 4

Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 2

Food Items and Ratings:
Pizza - Rating: 8
Fries - Rating: 4

Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 3

Food with highest rating: Pizza - Rating: 8

Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 4

Removing: Fries with rating 4

Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 2

Food Items and Ratings:
Pizza - Rating: 8


Menu:
1. Add Food Item
2. Display All Food Items
3. Check Food with Highest Rating
4. Remove Food Items with Rating Below 5
5. Exit
Enter your choice: 5

Exiting...

```





