# Continuous Integration

## Learning Objectives
1. Explain what Continuous Integration is and how a basic CI workflow looks like
2. Identify the jobs that make up a typical CI.
3. Explain why is it important to stops CI from progressing to CD when CI fails.
4. Implement the CI workflow with build and test jobs.

## What is Continuous Integration

[Continuous Integration](https://martinfowler.com/articles/continuousIntegration.html) is a software development practice where members of a team integrate their work frequently, usually each person integrates at least daily - leading to multiple integrations per day. Each integration is verified by an automated build (including tests) to detect integration errors as quickly as possible. Many teams find that this approach leads to significantly reduced integration problems and allows a team to develop cohesive software more rapidly.

### Why is Continuous Integration Needed? 

In the past, developers on a team might work in isolation for an extended period of time and only merge their changes to the main branch once their work was completed. This made merging code changes difficult and time-consuming, and also resulted in bugs accumulating for a long time without correction. These factors made it harder to deliver updates to customers quickly.

### The Benefits of Continuous Integration

- Improved code quality: CI enables developers to catch errors early in the development process, leading to better code quality and fewer bugs.
- Faster feedback: CI provides rapid feedback to developers, allowing them to quickly identify and fix issues.
- Faster time to market: CI enables teams to deliver high-quality software faster, reducing the time to market for new features.
- Improved collaboration: CI encourages collaboration between developers, enabling them to work together more effectively

### How does Continuous Integration Work? 

With continuous integration, developers frequently commit to a shared repository using a version control system such as Git. Prior to each commit, developers may choose to run local unit tests on their code as an extra verification layer before integrating. A continuous integration service automatically builds and runs unit tests on the new code changes to immediately surface any errors.

### CI Tools
There are many different CICD workflow tools available and here are some of the commonly used:
1. [Github Actions](https://github.com/features/actions)
2. [Gitlab CI/CD](https://docs.gitlab.com/ee/ci/)
3. [Bamboo](https://www.atlassian.com/software/bamboo)
4. [Jenkins](https://www.jenkins.io/)
5. [CircleCI](https://circleci.com/)

Each of these tools have their own advantages and disadvantages so it is up to the team to determine which CICD workflow tool to use.

### CI Pipeline

To achieve Continuous Integration, a CI Pipeline is created that would contain the list of jobs and workflows needed. 

A **pipeline** is a list of workflows that would be done in sequence. The **workflow** has a series of jobs that are defined by the developer. The pipeline can be automated such that any code changes done will trigger the pipeline and run the jobs.

<img src="https://circleci.com/docs/assets/img/docs/pipelines-dashboard.png" width="75%">

There are typically three jobs in the CI Pipeline (can be more based on the organization's needs):
1. Build / compile
1. Run tests
1. Upon tests passed, publish container image to registry and proceed to the CD Pipeline

> Fork this [repository](https://github.com/SkillsUnion/se-devops-node-demo) as we will be using this code base for the next lessons. This code base is a simple ExpressJS application that would print "Hello World" when localhost:3000 is accessed.

We will follow the commands below to:
1. Install dependencies / build / compile
2. Run tests

This will simulate the manual step-by-step project flow that we will later automate using CI.

### Install Dependencies

On your Terminal, change directory to the node application. Run the following command to install dependencies.

```sh
npm install
```

In this case, JavaScript do not need to be compiled. Hence, there is no compilation step. Installing the dependencies is considered part of preparing the application to run.

Examples of programming languages that require compilation:
- Java
- C++
- C#
- Golang

### Run Tests

Tests that are executed in the CI Pipeline must be self contained. For example, if your tests depend on a running database, the tests might fail if the database is down. If your tests depends on a set of databases, making it self contained can possibly means that you might need to setup a database container to go along with the tests.

There are different types of tests that can be executed at this stage, such as:
- **unit tests** - test against small unit of code
- **end to end tests (e2e)** - test if a user story is functioning properly
- **integration tests** - test a module against another 
- **performance tests** 
- **security tests** - there are multiple layers of security to tests for

Only a simple unit test is included for this repository. Run the following command:

```sh
npm test
```

To fail the test, you can make changes to this [file](https://github.com/SkillsUnion/se-devops-node-demo/blob/main/controller.js) and run `npm test` again.

### Run the Application

To see the actual output of the application, you may run the following command and go to `http://localhost:3000` on your browser.

```sh
npm start
```
### Testing Frameworks

Each language has its own testing frameworks that it can utilize to create unit tests for automation. Here are some of them:
1. JavaScript - Jest, MochaJS, ChaiJS
2. Java - JUnit
3. Python - Pytest, unittest
4. C# - MS Unit Test

### CircleCI

For this programme, we will be using CircleCI to ease the learners in understanding the CICD workflow. But feel free to try out other CICD tools to enhance the learnings.

[CircleCI](https://circleci.com) is a CI tool that simplifies parts of DevOps processes, letting engineering teams get to building products by allowing teams to build fully-automated pipelines, from testing to deployment.

### CircleCI account preparation and setup
You are required to setup the following items before proceeding to the next part.

1. Ensure you already have an account with Docker Hub
2. Ensure you have installed Docker locally
3. Create a new account in CircleCI

Optional - install [CircleCi CLI](https://circleci.com/docs/local-cli/#installation)

Before commiting changes to git, it is good to run the command ```circleci config validate``` to ensure the config.yml file has a valid configuration.

### CI Configuration and CircleCI's config.yml

The `config.yml` is a configuration file used to define and configure the pipeline for the project. It is stored in the root directory of the project's repository and provides instructions to CircleCI on how to build, test, and deploy your code.

The `config.yml` consists of several parts that work together to define the pipeline. Here are some that will be encountered in the next few lessons.

1. Jobs: They describe specific tasks or steps in your CI/CD pipeline.
```yml
build:
  docker:
    - image: cimg/node:16.10
  steps:
    - checkout
    - node/install-packages:
        pkg-manager: npm
    - run: |
        echo "Installing dependencies..."
        npm install
```

2. Workflows: They define the sequence and dependencies of jobs within workflows. You can create complex workflows with multiple jobs and conditional logic.
```yml
workflows:
  simple_workflow:
    jobs:
      - build
      - test:
          requires:
            - build
```

3. Orbs: Are reusable packages of configuration that help integrate new tools with just a single line of code.
```yml
orbs:
  node: circleci/node@5.0.1
```

4. Executors: Specify the execution environment for jobs.
```yml
executor: docker/docker
```

5. Environmental variables: Used to store sensitive data or configuration options

More can be found in the [documentation](https://circleci.com/docs/) of CircleCI.

### Setup Circle CI

Step 1: Fork [this repository](https://github.com/SkillsUnion/se-sample-cicd) to your personal github account

Step 2: In the forked repository, create `./.circleci/config.yml` and put in file the following code:

```yml
version: 2.1

orbs:
  node: circleci/node@5.0.1
```
Step 3: Push this change to GitHub.

Step 4: Sign in / sign up CircleCI.com using your github account and link the forked repository to CircleCI.

We will break down what needs to be done in the three jobs listed in first part.

### The Build Job

In this job, we will:
1. Wrap all the jobs under a jobs: section.
1. Define a node image container (we would use node v16 in this example, but we can use v18 and higher)
1. Check out code 
1. Install the `npm` 
1. Run `npm install`

```yaml
build:
  docker:
    - image: cimg/node:16.10
  steps:
    - checkout
    - node/install-packages:
        pkg-manager: npm
    - run: |
        echo "Installing dependencies..."
        npm install
```

### The Test Job

In this job, we will:
1. Define a node image container (we would use node v16 in this example, but we can use v18 and higher)
1. Check out code 
1. Install the `npm` 
1. Run `npm test`

```yaml
test:
  docker:
    - image: cimg/node:16.10
  steps:
    - checkout
    - node/install-packages:
        pkg-manager: npm
    - run: |
        echo "Running tests..."
        npm run test
```

### The Publish Job

In this job, we will:
1. Define a node image container (we would use node v16 in this example, but we can use v18 and higher)
1. Check out code 
1. Run `docker build`
1. Run `docker push`

```yaml
publish: #also known as the build-and-push
    executor: docker/docker #define the execution environment in which the steps of a job will run.
    steps:
      - setup_remote_docker
      - checkout
      - docker/check
      - docker/build: #build the image
          image: terencegaffudsu/education-space
          tag: v1.0.1
      - docker/push: #pushes the image to the specified account in the environment variables
          image: terencegaffudsu/education-space
          tag: v1.0.1
```
> Note: we have to prepare the following for publishing as well:
1. In config.yml, add `docker: circleci/docker@2.8.2` in the orbs section
2. In CircleCI, prepare the project settings in CircleCI by clicking on the 3 dots on the right side of the project to access the Porject Settings, go to "Environment Variables" and add 2 variables:
    a. DOCKER_LOGIN - docker username
    b. DOCKER_PASSWORD - docker password
3. Add the publish job in the workflow
4. Push the code to Github

### The Workflow

Now, we will tie all the jobs together using a workflow. It is also where we declare the relationships between the jobs.

In the workflow, we will:
1. Start running a `build` job.
2. Start running a `test` job ensuring that the `build` job passes.
3. Run the `publish` job after the `test` job to ensure that the image we will publish has passed all the tests.

```yaml
workflows:
  simple_workflow:
    jobs:
      - build
      - test:
          requires:
            - build
      - publish:
          requires:
            - test
```

This is how your config.yml should look like after setting up the jobs and workflows:

```yaml
version: 2.1

# orbs
orbs:
  node: circleci/node@5.0.1
  docker: circleci/docker@2.8.2

# jobs
jobs:
  build:
    docker:
      - image: cimg/node:16.10
    steps:
      - checkout
      - node/install-packages:
          pkg-manager: npm
      - run: |
          echo "Installing dependencies..."
          npm install
  test:
    docker:
      - image: cimg/node:16.10
    steps:
      - checkout
      - node/install-packages:
          pkg-manager: npm
      - run: |
          echo "Run tests..."
          npm run test
  publish:
    executor: docker/docker 
    steps:
      - setup_remote_docker
      - checkout
      - docker/check
      - docker/build: #builds the image, similar to docker build -t "name:tag" .
          image: terencegaffudsu/tamkeen-software
          tag: v1.0.3
      - docker/push: #pushes the image to specified account in the environment variables
          image: terencegaffudsu/tamkeen-software
          tag: v1.0.3


# workflow
workflows:
  # Name of the workflow is simple_workflow
  simple_workflow:
    jobs:
      - build
      - test:
          requires:
            - build
      - publish:
          requires:
            - test
```


### Exercise 1
Use the documentation to find out what each of the commands do:
- checkout
- run
- docker

### Exercise 2

This CI Pipeline config file will execute the build and test jobs. In the exercise, you are to work on the `publish` job where you will push a Docker image to Docker hub repository. 