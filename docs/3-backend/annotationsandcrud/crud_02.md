# Crud Operation: Read

## Lesson Objective

Learn to Implement API Endpoints for Data Retrieval: Understand how to create endpoints to fetch all customer data and retrieve specific customer data using @GetMapping and @PathVariable.

Enhance Data Management Skills: Explore techniques to preload data into a list and use helper methods to efficiently locate specific items in a collection.


### Read

For read, we will usually create 2 endpoints. One to get all the objects, and another to get a specific object.

#### Get all customers

```java
@GetMapping("/customers")
public ArrayList<Customer> getAllCustomers() {
    return customers;
}
```

Let's preload some data into our `customers` list by adding them to the constructor. We can just add the first names and last names.

```java
public CustomerController() {
    customers.add(new Customer("Bruce", "Banner"));
    customers.add(new Customer("Peter", "Parker"));
    customers.add(new Customer("Stephen", "Strange"));
    customers.add(new Customer("Steve", "Rogers"));
}
```

This will mean we need a constructor in our `Customer` class that takes in the first name and last name.

```java
public Customer(String firstName, String lastName) {
    this.id = UUID.randomUUID().toString();
    this.firstName = firstName;
    this.lastName = lastName;
}
```

Now try to get all the customers using Postman.

#### Get a specific customer

To get a specific customer, we need to know the `id` of the customer. We can get the `id` from the URL. using the `@PathVariable` annotation.

Since we are storing the data in an array, we need to find the index of the customer in the array.

Let's create a helper method to do this since we will be using it in multiple places.

```java
private int getCustomerIndex(String id) {
    for( Customer customer: customers) {
        if(customer.getId().equals(id)) {
            return customers.indexOf(customer);
        }
    }

    // Not found
    return -1;
}
```

Now we can create our `getCustomer` method.

```java
@GetMapping("/customers/{id}")
public Customer getCustomer(@PathVariable String id) {
    int index = getCustomerIndex(id);
    return customers.get(index);
}
```

Try retrieving a customer using Postman.

What happens when we try to retrieve a customer that does not exist?
