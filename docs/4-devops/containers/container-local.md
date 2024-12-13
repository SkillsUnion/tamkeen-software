# Containerization - Local

## Learning Objectives
1. Explain what is a container and why is it used
2. Explain what is an image and why is it used
3. What is Docker and how is it used

## Containerization

Containers are lightweight packages of your application code together with dependencies such as specific versions of programming language runtimes and libraries required to run your software services.

<img src="https://middleware.io/wp-content/uploads/2021/12/containerization-explained.jpg" width="50%">

### Containers vs Virtual Machines

Containers and virtual machines are deployment technologies that make applications independent from infrastructure resources.

Containers essentially are packaged application images that contain all the necessary files and dependencies to run the application.

Virtual machines, on the other hand, involves creating an guest operating system as well as virtualizing the underlying physical infrastructure.

<img src="https://s7280.pcdn.co/wp-content/uploads/2018/08/containers-vs-virtual-machines-810x413.png">

### Benefits of Containerization

Containerization can provide these benefits for applications:
- Portability - Allows "write once, run anywhere" by packaging the application with its dependencies.
- Efficiency - Improves efficiency by using all available resources and minimizing overhead.
- Agility - Allows for rapid deployment to any environment. 
- Faster delivery - Containerization can divide a large application into discrete parts using microservices.
- Improved security - Improves security by isolation, wherein even if a container is compromised, other containers on the same host remain secure.
- Faster app startup - Containers are lightweight so startup times are virtually instantaneous.
- Easier management - Container images can easily be managed using Docker Desktop and other tools such as Kubernetes
- Flexibility - Microservices can become flexible such that certain elements can be hosted on bare metal or deployed to virtual cloud environments.

### Containerization Use Cases

Containerization can be used for different use cases, here are some of them: 

1. Migration from Monolithic applications to Microservices
2. Setting up and standardization of development environments
3. Infrastructure as Code
4. Hybrid cloud setups
5. Disaster Recovery

## Docker

For containerization, we will be using Docker. Install Docker Desktop for Windows via this [link](https://docs.docker.com/desktop/install/windows-install/) or for Mac via this [link](https://docs.docker.com/desktop/install/mac-install/)

### What is Docker?

[Docker](https://docs.docker.com/) is a software platform that allows you to build, test, and deploy applications quickly. Docker packages software into standardized units called containers that have everything the software needs to run including libraries, system tools, code, and runtime. Using Docker, you can quickly deploy and scale applications into any environment and know your code will run.

### When to use Docker?

Docker can be used for the following:

- Microservices - Build and scale distributed application architectures by taking advantage of standardized code deployments using Docker containers.
- CICD - Accelerate application delivery by standardizing environments and removing conflicts between language stacks and versions.
- Data Processing - Provide big data processing as a service. Package data and analytics packages into portable containers that can be executed by non-technical users.
- Containers as a Service - Build and ship distributed applications with content and infrastructure that is IT-managed and secured.

### Writing Dockerfiles

Docker can build images automatically by reading the instructions from a **`Dockerfile`**. A `Dockerfile` is a text document that contains all the commands a user could call on the command line to create an image.

The format of a dockerfile is as follows:

```dockerfile
#comment
INSTRUCTION arguments
```

>Note: The instruction is not case-sensitive. However, convention is to make them UPPERCASE to distinguish them from arguments.

A sample React Application that you can fork and clone is included in this repository [here](https://github.com/SkillsUnion/se-sample-container).

Follow the respective steps to create a `Dockerfile` where you will use to create an image and run the image as container locally.

Step 1: Create `Dockerfile` file within the root folder of the project.

Step 2: Fill the file content with the following:

```dockerfile
FROM node:16-alpine

WORKDIR /app

ENV PORT=3000

COPY ["package.json", "package-lock.json*", "./"]

RUN npm install

COPY . .

CMD ["npm", "start"]
```

Step 3: Create `.dockerignore` file and add `node_modules` to the content.

*Note: The `.dockerignore` is similar to `.gitignore` wherein it disregards any file and directory included in the file.*

To understand the syntax of the Dockerfile, see this reference [link](https://docs.docker.com/engine/reference/builder/).

Here is a quick summary of the instructions:

|Keyword|Purpose|
|-------|-------|
|`FROM`|The FROM instruction initializes a new build stage and sets the Base Image for subsequent instructions.|
|`WORKDIR`|The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY and ADD instructions that follow it.|
|`ENV`|The ENV instruction sets the environment variable <key> to the value <value>.|
|`COPY`|The COPY instruction copies new files or directories.|
|`RUN`|The RUN instruction will execute any commands in a new layer on top of the current image and commit the results.|
|`CMD`|There can only be one CMD instruction in a Dockerfile. If you list more than one CMD then only the last CMD will take effect. The main purpose of a CMD is to provide defaults for an executing container. |

## Images and Containers

**Images** and **Containers** are some of the objects that Docker provides:

**Image** - An image is a read-only template with instructions for creating a Docker container. Often, an image is based on another image, with some additional customization. 

To build your own image, you create a Dockerfile with a simple syntax for defining the steps needed to create the image and run it. Each instruction in a Dockerfile creates a layer in the image.

**Container** - A container is a runnable instance of an image. You can create, start, stop, move, or delete a container using the Docker API or CLI. 

A container is defined by its image as well as any configuration options you provide to it when you create or start it. When a container is removed, any changes to its state that aren't stored in persistent storage disappear.

We will use the CLI to build an image and run it as container. In summary, these are the commands we would touch on.

|Commands|Description|
|-|-|
|`docker image ls`| List all images that are being created|
|`docker image rm <image id>`| Remove specific image by ID|
|`docker build <options>`| Build an image from the Dockerfile.|
|`docker ps`| List all running container|
|`docker stop <container id>`| Stop a running container|
|`docker rm <container id>`|Remove a container|
|`docker run <options> <image id>`| Run an image as container|

Follow these steps to create an image and launch the container:

Step 1: Launch the Terminal/Powershell

Step 2: `cd` to the `sample-app` directory

Step 3: Run `docker build -t "mysampleapp" .` to build an image with the repository name `mysampleapp`

Step 4: Run `docker image ls` to list all images. You should see a table with `IMAGE ID` as one of the column. You will need that to run image as container in the next step.

Step 5: Run `docker run -d -p 3000:3000 <image id>` to start the container

Step 6: Navigate to [http://localhost:3000](http://localhost:3000) to view the sample app.

> The `-p 3000:3000` option refers to binding the host's port `3000` to the container's port `3000`. If the command is modified to `3001:3000` you are binding host's port `3001` to container's port `3000`. And the react app URL has to be changed to port `3001`.

### Activity 
Use the docker commands to stop the running container and deleting the container.

## Part 4 - Multi-stage Builds

Multi-stage builds are useful in maintaining a single Dockerfile that contains stages of builds. An example of this in Java is using a Maven build for the first stage and using that build for create a `.jar` file.

With multi-stage builds, multiple `FROM` statements can be used in the Dockerfile. Each FROM instruction can use a different base image, and each of them begins a new stage of the build. Artifacts from one stage can be copied to another, building for the final image.

The code below shows an example of how to do a 2-stage build for Java that builds and creates a slim image:

```Dockerfile
FROM maven:3.9.6-eclipse-temurin-17 AS build
ENV PORT=8081
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests

# Second stage: create a slim image
FROM eclipse-temurin:17
ENV PORT=8081
COPY --from=build /app/target/simple-crm-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Naming build stages

By default, the stages aren't named, and can refer to by their index, starting with 0 for the first `FROM` instruction. Docker, however, can name use stages using the `AS` keyword together with the build name you want.

```Dockerfile
# The first instruction is named "build"
FROM maven:3.9.6-eclipse-temurin-17 AS build
```

After creating the name (also called alias) for the build, it can be referred to by the other stages using its name

```Dockerfile
# The build here is the artifact that is produced by the first stage
COPY --from=build /app/target/simple-crm-0.0.1-SNAPSHOT.jar /app.jar
```

### Running multi-stage builds

Running a mult-stage build is similar to running a single stage build using the docker build command:
`docker build -t <image name> .`

### Docker logs

Running containers can be monitored using the `docker log` command. It allows us to view log for each container. Try the command with the following options and see what the logs would show:

| Commands | Descriptions |
|-|-|
| --details | Show extra details provided to logs |
| --since | Show logs since timestamp (need to provide a timestamp value) |
| --tail | Number of lines to show from the end of the logs (need to provide n number of lines) |
| --timestamps | Show timestamps |
| --until | Show logs before a timestamp (need to provide a timestamp value) | 
