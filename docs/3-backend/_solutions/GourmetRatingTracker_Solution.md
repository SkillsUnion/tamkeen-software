
```java
import java.util.ArrayList;
import java.util.Scanner;

public class GourmetRatingTracker {
    // ArrayLists to store food names and their ratings
    private static ArrayList<String> foodItems = new ArrayList<>();
    private static ArrayList<Integer> ratings = new ArrayList<>();

    // Function to add a new food item and its rating
    public static void addFoodItem(String food, int rating) {
        foodItems.add(food);
        ratings.add(rating);
        System.out.println("Added: " + food + " with rating " + rating);
    }

    // Function to display all food items and their ratings
    public static void displayFoodItems() {
        System.out.println("\nFood Items and Ratings:");
        for (int i = 0; i < foodItems.size(); i++) {
            System.out.println(foodItems.get(i) + " - Rating: " + ratings.get(i));
        }
    }

    // Function to get the food with the highest rating
    public static void foodWithHighestRating() {
        if (foodItems.isEmpty()) {
            System.out.println("No food items in the list.");
            return;
        }

        int maxRating = ratings.get(0);
        String bestFood = foodItems.get(0);

        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) > maxRating) {
                maxRating = ratings.get(i);
                bestFood = foodItems.get(i);
            }
        }
        System.out.println("Food with highest rating: " + bestFood + " - Rating: " + maxRating);
    }

    // Function to remove food items with ratings below 5
    public static void removeLowRatedFoods() {
        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i) < 5) {
                System.out.println("Removing: " + foodItems.get(i) + " with rating " + ratings.get(i));
                foodItems.remove(i);
                ratings.remove(i);
                i--; // Adjust index after removal
            }
        }
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
