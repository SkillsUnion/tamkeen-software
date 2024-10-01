## Part 2 - ArrayLists

The problem with arrays is that they are of a fixed size. Once we have created an array, we cannot change its size. This is where `ArrayList` comes in.

The ArrayList is a flexible data structure that allows us to store a sequence of values, all of the same type. It is similar to an array, but it is dynamic in size.

Create `LearnArrayLists.java` and code along.

To use ArrayList, we need to import it at the top of the file.

```java
import java.util.ArrayList;
```

This can also be automatically imported by VSCode.

### Declaring and Instantiating an ArrayList

```java
// Declare an ArrayList of Strings
ArrayList<String> namesList = new ArrayList<String>();
```

The `<String>` part is called a **type parameter**. We specify a type parameter using angle brackets `<>`, sometimes informally called "the diamond".

This is used to specify the type of the elements in the `ArrayList`. We can only store elements of this type in the `ArrayList`.

It is actually not necessary to specify the type parameter on the right side of the assignment. This is because Java can infer the type from the left side.

```java
ArrayList<String> namesList = new ArrayList<>();
```

⚠️ The `ArrayList` can be declared without a type parameter. This is called a **raw type** and it is not recommended as it can lead to bugs.

For example, you could accidentally add an `Integer` to an `ArrayList` that should only contain `String` elements.

It also makes the code less maintainable because it is not clear what type of elements the `ArrayList` should contain.

Furthermore, the types are not checked at compile time. This means that you will only find out about the error at runtime i.e. when the program is running.

For example:

```java
ArrayList rawList = new ArrayList();
rawList.add("Hello");
Integer myInt = (Integer) rawList.get(0); // ClassCastException
```

If the type parameter had been specified, the compiler would have caught the error because we cannot cast a `String` to an `Integer`.

Note that `ArrayLists` can only store object references, not primitive types. This means that we cannot use `int`, `char`, etc. as the type parameter. Instead, we have to use the corresponding wrapper class `Integer`, `Character`, etc.

```java
ArrayList<int> numbers = new ArrayList<>(); // ❌ ERROR
ArrayList<Integer> numbers = new ArrayList<>(); // ✅ OK
```

### Adding Elements

We can add elements to an `ArrayList` using the `add()` method.

```java
namesList.add("Ironman");
namesList.add("Captain America");
namesList.add("Hawkeye");
namesList.add("Hulk");
```

### Accessing Elements

We can access elements in an `ArrayList` using the `get()` method.

```java
System.out.println(namesList[0]); // ❌ ERROR
System.out.println(namesList.get(0)); // Ironman
System.out.println(namesList.get(1)); // Captain America
System.out.println(namesList.get(2)); // Hawkeye
System.out.println(namesList.get(3)); // Hulk
```

### Updating Elements

We can update elements in an `ArrayList` using the `set()` method.

```java
namesList[0] = "test"; // ❌ ERROR
namesList.set(0, "Black Widow");
System.out.println(namesList.get(0)); // Black Widow
```

### Removing Elements

We can remove elements from an `ArrayList` using the `remove()` method.

```java
namesList.remove(0);
System.out.println(namesList);
```

When we remove an element, the indices of the elements after it are shifted down by one.

### ArrayList Length

We can get the length of an `ArrayList` using the `size()` method.

```java
System.out.println(namesList.size()); // 3
```

### Creating and Populating an ArrayList

We can create an `ArrayList` and populate it with elements using `Arrays.asList()`.

```java
ArrayList<String> heroes = new ArrayList<>(Arrays.asList("Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor"));
```

### Add an ArrayList to another ArrayList with `addAll()`

We can add all the elements from one `ArrayList` to another using `addAll()`.

```java
ArrayList<String> heroes = new ArrayList<>(Arrays.asList("Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor"));
ArrayList<String> moreHeroes = new ArrayList<>(Arrays.asList("Doctor Strange", "Spiderman", "Black Panther"));

heroes.addAll(moreHeroes);
System.out.println(heroes); // [Ironman, Captain America,  Hawkeye, Hulk, Black Widow, Thor, Doctor Strange, Spiderman, Black Panther]
```

### Search for an element with `contains()`

We can search for an element in an `ArrayList` using `contains()`. This method returns `true` if the element is found, or `false` if it is not.

```java
ArrayList<String> villainsList = new ArrayList<>(Arrays.asList("Thanos", "Ultron", "Loki"));
System.out.println("Is Thanos here? " + villainsList.contains("Thanos"));
System.out.println("Is Spiderman here? " + villainsList.contains("Spiderman"));
```

### Search for an element index with `indexOf()` or `lastIndexOf()`

We can search for the index of an element in an `ArrayList` using `indexOf()`. This method returns the index of the first occurrence of the element, or `-1` if it is not found.

```java
System.out.println("Index of Thanos: " + villainsList.indexOf("Thanos"));
System.out.println("Index of Ultron: " + villainsList.indexOf("Ultron"));
```

We can also search for the index of the last occurrence of an element using `lastIndexOf()`.

```java
System.out.println("Last index of Thanos: " + villainsList.lastIndexOf("Thanos"));
System.out.println("Last index of Ultron: " + villainsList.lastIndexOf("Ultron"));
```

### Remove a set of elements with `removeAll()`

We can remove a set of elements from an `ArrayList` using `removeAll()`. This method takes in another `ArrayList` and removes all the elements that are in it.

```java
ArrayList<String> moreVillains = new ArrayList<>(Arrays.asList("Ultron", "Loki"));

villainsList.removeAll(moreVillains);
System.out.println(villainsList);
```

### Remove all elements with `clear()`

We can remove all the elements from an `ArrayList` using `clear()`.

```java
villainsList.clear();
System.out.println(villainsList);
```

### Check if an ArrayList is empty with `isEmpty()`

We can check if an `ArrayList` is empty using `isEmpty()`. This method returns `true` if the `ArrayList` is empty, or `false` if it is not.

```java
System.out.println("villainsList.isEmpty() " + villainsList.isEmpty());
```

### Specify elements not to be removed with `retainAll()`

We can specify elements not to be removed from an `ArrayList` using `retainAll()`. This method takes in another `ArrayList` and removes all the elements that are not in it.

```java
heroes.retainAll(Arrays.asList("Ironman", "Spiderman"));
System.out.println("heroes " + heroes);
```

---
