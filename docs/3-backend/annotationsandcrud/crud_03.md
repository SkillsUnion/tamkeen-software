# Crud Operations : Update and Delete

## Lesson Objectives

- Understand and Implement Update and Delete CRUD Operations

- Learn the Use of ResponseEntity and HTTP Status Codes


### Update

`@PutMapping` annotation is used in Spring Boot to update existing data. It handles HTTP PUT requests, which are used to modify an existing record.

To update a customer, similarly we need to get the `id` of the customer using the `@PathVariable` annotation.

We can use the previous helper method to get the index of the customer in the `customers` list.

```java
@PutMapping("/customers/{id}")
public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    int index = getCustomerIndex(id);
    customers.set(index, customer);
    return customer;
}
```

Based on IETF's <a href="https://tools.ietf.org/html/rfc7231#section-4.3.4" target="_blank"> HTTP specification
</a> the `PUT` method is used to replace the current representation of the target resource with the request payload.

This means that if the `id` does not exist, we should create a new `Customer` object with the `id` and the request payload. Note that this is not always the case, and it depends on the API design.

```java
@PutMapping("/customers/{id}")
public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    int index = getCustomerIndex(id);

    if( index == -1) {
        customers.add(customer);
        return customer;
    }

    customers.set(index, customer);
    return customer;
}
```

To keep our implementation simple, we will use the former method i.e., to only update if the record if it exists.

Note that you can also use the Patch method to update a resource. The `PATCH` method is used to apply partial modifications to a resource.

### Delete

`@DeleteMapping` annotation is used to delete data. It handles HTTP DELETE requests to remove a specific record.
To delete a customer, again, we need to use `@PathVariable` to get the `id` of the customer.

We can use the previous helper method to get the index of the customer in the `customers` list.

```java
@DeleteMapping("/customers/{id}")
public Customer deleteCustomer(@PathVariable String id) {
    int index = getCustomerIndex(id);
    return customers.remove(index);
}
```

### `ResponseEntity`

Now, we are currently just returning JSON data. We should also specify the status code, so that the consumer of our API gets a more meaningful response.

`ResponseEntity` is a generic type that allows us to specify the response body and the status code.

Currently it is always returning a `200` status code, which generally means that the request was successful. But there are other status codes that we should use to indicate the status of the request e.g.

- `200` - OK, used when a resource is retrieved
- `201` - Created, used when a new resource is created
- `204` - No Content, used when a resource is deleted
- `404` - Not Found, used when a resource is not found

<a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Status" target = "_blank">Click here to read more about Status Code </a>

We can use the `HttpStatus` enum to specify the status code.

```java
@PostMapping("/customers")
public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    customers.add(customer);
    return new ResponseEntity<>(customer, HttpStatus.CREATED);

    // Alternate syntax
    // return ResponseEntity.status(HttpStatus.CREATED).body(customer);
}
```