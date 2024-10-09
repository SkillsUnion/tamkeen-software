# Assignment:  The Vehicle Hub

## Learning Objectives

- Understanding OOP principles:

    - How inheritance allows you to create more specific classes from a general one.

    - How encapsulation provides control over data access and modification in classes.

    - How polymorphism is achieved by overriding methods in subclasses.


## Introduction

Create a basic vehicle management system that allows the creation and management of different types of vehicles (e.g., cars and bikes) using inheritance and encapsulation.

## Explanation

There will be a base or parent class called Vehicle which has private properties and public methods.

Car and Bike classes inherit from the Vehicle base class, reusing and extending its properties and methods.

Properties like make, model, year, etc., are private and can only be accessed and modified using getters and setters.

The describe() method is overridden in the Car and Bike classes to provide specific information for each vehicle type.

<iframe width="560" height="315" src="https://www.youtube.com/embed/gICOd0m84R0?si=cNBBze5Aag-x597F&amp;start=377" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

## Instructions

##    Fork and clone a copy of <a href="https://github.com/SkillsUnion/vehicle-hub.git" target="_blank">Vehicle Hub repo</a>

### Set Up Your Project:

   -  Create a new Java project named Vehicle Hub.

   -  In your src folder, create four Java classes: Vehicle, Car, Bike, and Main.

###  Requirements

### Vehicle Class (Base Class):

           A. Properties: make, model, year

           B. Methods:

                 * describe(): Prints vehicle details.

                 * startEngine(): Prints a message indicating the engine has started.

           C. Constructors

                 * A constructor that takes make, model, and year as parameters and initializes them.

           D. Getters and Setters for all properties (encapsulation). 


### Car Class (Subclass of Vehicle):

           A. Additional Property: numberOfDoors

           B. Methods:

                 * describe(): Override the method to include the number of doors in the description.

                 * honk(): Prints "Car is honking!"

           C. Constructors

                 * A constructor that takes make, model, year, and numberOfDoors.

           D. Getters and Setters for all properties (encapsulation).     

### Bike Class (Subclass of Vehicle):

           A. Additional Property: type (e.g., mountain, road, etc.

           B. Methods:

                 * describe(): Override the method to include the bike type in the description.

                 * ringBell(): Prints "Bike bell is ringing!"

           C. Constructors

                 * A constructor that takes make, model, year, and type.
                 
           D. Getters and Setters for all properties (encapsulation). 

### Main Class(Test Class)

           A. Create instances of Car and Bike classes

           B. Use the describe(), startEngine(), honk() (for Car), and ringBell() (for Bike) methods.

           C. Demonstrate encapsulation by setting and getting properties through the getters and setters.          


## Sample Output for Car Object

  ```java
  Car: 2020 Toyota Corolla, 4 doors.
  Engine has started.
  Car is honking!
  ```

## Sample output for Bike Object

```java
Bike: 2019 Giant Escape, Type: Mountain.
Engine has started.
Bike bell is ringing!
```

## Sample Code

```java
//child class Car extends parent class Vehicle
public class Car extends Vehicle {

    //new property in child class
    int numberOfDoors;

    //constructor
    public Car(String make , String model ,int year , int doors)
    {
       super(make,model,year);
       numberOfDoors=doors;
    }


    //parent class (Vehicle) describe() method overridden
    @Override
    public void describe()
    {
        System.out.println("car make" + getMake());
        System.out.println(" Car model is " + getModel());
        
        System.out.println(" Car yearl is " + getYear());


        System.out.println( "number of doors is "+ numberOfDoors);


    }

    //getters and setters

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }


 //method in child class
    public void honk()
{
    System.out.println("Car is honking");
}
    
}
```

            

           
## Step-by-Step Implementation:

### Vehicle Class (Base Class):

           A. Declare the following private properties: make, model, and year.

           B.  Create a constructor that initializes these properties.

           C.  Provide getter and setter methods for each property.

           D.  Create two methods:

                  A. describe(): Prints the vehicle’s details (make, model, year).

                  B.   startEngine(): Prints a message that the engine has started.

### Car Class (Inherits from Vehicle):

           A.  Add a new private property: numberOfDoors.

           B.  Create a constructor that calls the Vehicle constructor and initializes   numberOfDoors.

           C.  Override the describe() method to include the number of doors.

           D.  Add a new method honk() that prints a message indicating the car is honking.

###  Bike Class (Inherits from Vehicle):

           A.  Add a new private property: type (e.g., mountain bike, road bike).

           B.  Create a constructor that calls the Vehicle constructor and initializes type.

           C.  Override the describe() method to include the bike’s type.

           D.  Add a new method ringBell() that prints a message indicating the bike bell is ringing.


### Main Class:

           A.  In the Main class, create the following objects:

           B.  A Car object with appropriate values for make, model, year, and number of doors.

           C.  A Bike object with appropriate values for make, model, year, and type.

           D.  Call the describe(), startEngine(), honk() (for Car), and ringBell() (for Bike)

           methods.

           E.  Demonstrate encapsulation by modifying and accessing vehicle properties using 

          getter and setter methods.

## Running the Program:

    - Compile and run your program.

    -  Ensure that the output correctly shows the description of the car and bike, demonstrates

    starting the engine, and shows the respective sound actions (honking or ringing the bell).

 ## Sample Output for Car Object

  ```java

  Car: 2020 Toyota Corolla, 4 doors.
  Engine has started.
  Car is honking!
  ```

## Sample output for Bike Object

```java

Bike: 2019 Giant Escape, Type: Mountain.
Engine has started.
Bike bell is ringing!
```
   










