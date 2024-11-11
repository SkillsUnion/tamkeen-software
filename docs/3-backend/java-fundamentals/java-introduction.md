
# Introduction To Java

## Lesson Objectives

  1. Become familiar with Java and its key terminology, including JDK, JVM, and JRE.

  2. Understand the the relationship and differences between JDK, JRE, and JVM.

  3. Write and execute simple Java code snippets directly in JShell 


## About Java

Java is a versatile, object-oriented programming language known for its "write once, run anywhere" capability. This means that Java code can run on any platform that supports the Java Virtual Machine (JVM), making it highly portable. It is widely used in web development, mobile applications, enterprise software, and large-scale systems due to its stability, security features, and extensive library support.

## Key Reasons for Using Java:
- Platform Independence: Java applications can run on any device with a JVM, enhancing portability.

- Object-Oriented: Promotes modular, maintainable, and reusable code with principles like encapsulation and inheritance.

- Robust and Secure: Java includes memory management, error handling, and security features, making it ideal for large applications.

- Rich Ecosystem: A vast standard library (Java Standard Library) and frameworks like Spring and Hibernate support diverse development needs.

- Scalability: Ideal for both small-scale applications and large, distributed systems.


## Java Terminology

- Java Development Kit (JDK) - to write code.
- Java Runtime Environment (JRE) - to run code.
- JVM is a virtual machine that runs Java bytecode. It is the engine that executes Java programs.


<img src="jdk.png" width="450">


 The JVM (Java Virtual Machine) is the core part of Java, responsible for executing Java programs. It takes the compiled bytecode and translates it into machine code for the underlying operating system. The JRE (Java Runtime Environment) includes the JVM and the libraries necessary to run Java applications, but it does not provide development tools. The JDK (Java Development Kit), on the other hand, includes the JRE along with additional tools like compilers and debuggers, making it necessary for developing Java applications. In short, JVM runs the program, JRE runs pre-compiled programs, and JDK is used to develop and compile Java code.
 When you install JDK, JRE is part of it.

#### <a href="https://www.digitalocean.com/community/tutorials/difference-jdk-vs-jre-vs-jvm" target="_blank">Click here to learn more on jdk vs jre vs jvm</a>.

## Installation Check

From this point onwards we will start coding in Java using VSCode editor. So kindly ensure that you have gone through the welcome module and completed all the installations successfully including JDK, VSCode editor and extension pack for java in VSCode.

## JShell

Jshell is a REPL (Read-Eval-Print-Loop) tool that allows you to execute Java code in an interactive manner. This is useful for testing out simple Java code without having to create a Java project.

Start jshell in your terminal:

```bash
$ jshell
```

Try your first Java code:

```bash
jshell> System.out.println("Hello World");
Hello World
jshell> /exit
```


