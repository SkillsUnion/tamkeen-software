# Dependencies

### Lesson Objectives
1. Understand the purpose of dependencies in a Spring Boot application and how to configure them using Maven.

2. Learn how to add and manage dependencies in the `pom.xml` file for a Spring Boot project.

3. Gain hands-on experience with installing and using the `spring-boot-starter-web` and `spring-boot-devtools` dependencies.

---
Dependencies are external libraries that our application depends on. For example, if we want to use the Spring Web library, we need to add the dependency to our project.

We can search for dependencies in **<a href="https://mvnrepository.com/" target="_blank">Maven Central</a>**.

Dependencies are specified in the `pom.xml` file. The `pom.xml` file is the Maven Project Object Model (POM) file. It is an XML file that contains information about the project and configuration details used by Maven to build the project.

Let's install our first dependency, the **<a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web" target="_blank">Spring Boot Starter Web</a>**


If you copied the XML from Maven Central, just omit the `<version>` tag, so that it will follow the version specified in the `<parent>` tag.

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
```

> Sidenote: you can install an **<a href="https://marketplace.visualstudio.com/items?itemName=redhat.vscode-xml" target="_blank">extension</a>** for XML formatting in VS Code. This will help you to format the XML nicely.

The `groupId` identifies the group of the dependency while the `artifactId` identifies the artifact (library) of the dependency.

The `spring-boot-starter-web` dependency is a starter dependency that includes all the dependencies required to build a web application.

By adding this dependency, we are embedding the Tomcat web server into our application.

Try starting the app now.

Open your browser and access the app at `localhost:8080`. You will see a Whitelabel Error Page, which means that it is working correctly. This is because we have not defined any routes yet.

We can add a placeholder page by adding an `index.html` file in the `resources/static` folder.

To change the port number, we can specify the port number in the `application.properties` file. The default port number is `8080`.

```
# Server Configuration
server.port=8081
```

You will need to restart the app for the changes to take effect.

### Central vs Local Maven Repository

Maven downloads the dependencies from a central repository. The central repository is located at **<a href="https://repo.maven.apache.org/maven2/" target="_blank"> This is the default repository that Maven uses</a>**

If you are using Maven for the first time, it will take some time to download the dependencies from the central repository. Subsequent downloads will be faster as the dependencies are cached locally.

When you run your application, Maven looks for the dependencies in the local repository first. If it cannot find the dependencies, it will download the dependencies from the central repository.

You can check out your local Maven repository at `C:\Users\<username>\.m2\repository` (Windows) or `~/.m2/repository` (Mac/Linux).

### Adding a Second Dependency

Let's add a second dependency, the **<a href ="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools" target="_blank">Spring Boot DevTools</a>** This library provides additional development-time features such as automatic restart of the application when we update and save our code.

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

Try changing the code or the server port. You will notice that the application will restart automatically.

---

#### Additional Resources: 

- <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/" target="_blank">Spring Boot Documentation</a>

- <a href="https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html" target="_blank">Maven Dependency Management Guide</a>







