# Intro to DevOps

## Learning Objectives
1. Explain what DevOps is and what problem is it solving.
2. Explain what CI / CD are.
3. Name a few technological tools that are used in the CICD Pipeline.

## What is DevOps?

DevOps is the combination of **cultural philosophies, practices, and tools** that increases an organization’s ability to deliver applications and services at high velocity: evolving and improving products at a faster pace than organizations using traditional software development and infrastructure management processes. This speed enables organizations to better serve their customers and compete more effectively in the market.

<img src="https://stackify.com/wp-content/uploads/2018/01/devops-process-1.png" width="50%"/>

### Is DevOps same as Agile?

DevOps and agile practices are complementary approaches in the software delivery lifecycle. They both bring efficiency and predictability to the lifecycle.

Agile is iterative and focuses on collaboration, rapid software releases and stakeholder feedback. It is a mindset and a cultural philosophy that aims to have everyone work towards continuous improvement and delivering value to customers.

DevOps, on the other hand, is a delivery approach that removes the silos between the development and operations teams by using tools to automate processes.

### Principles behind DevOps

1. Maintain version control on all production artifacts. - Artifacts must be placed in a centralized version control system that is part of the CI/CD pipelines.
2. Implement CI/CD. - Teams deliver software updates and patches continuously, rather than on a calendar-driven deadline.
3. Automate acceptance testing of specifications of the system. - Teams should write and automate testing for the functionalities of the application
4. Enforce peer review processes. - Teams must review production changes collaboratively via a documented and systematic approach.
5. Create a culture of high trust. - No one should be afraid to ask hard questions, get into debates and take accountability. It gives teams the freedom to experiment with new tools and processes that can improve product delivery without fear of failure
6. Instate proactive monitoring practices - Create tailored reporting and alerts based on the configuration of the monitoring tools.
7. Foster win-win relationships across the organization. - Everybody is on one team, as neither development nor IT operations can succeed on its own.

### DevOps phases

1. **Planning** - The stage where development and IT operations teams -- along with other stakeholders -- determine the features desired, accompanied by an iteration value and criteria for each project phase.
2. **Code and build** - In the coding phase, developers perform their assigned coding work. When they complete their tasks, they check their work into a centralized source code repository which serve as the single source of truth for code. The build phase entails software code retrieval from the centralized repository and compiles the software code into a binary artifact, executes functional tests and publishes the artifact into a shared centralized repository.
3. **Testing** - Automation enables developers to achieve continuous testing to test multiple codebases in parallel. An automated testing strategy also ensures there are no flaws in an application's functionality.
4. **Continuous Integration** - The heart of the entire DevOps life cycle. It is a software development practice in which the developers require to commit changes to the source code more frequently.
5. **Continuous Deployment** - This is the stage where the code is deployed to the production servers. It is also important to ensure that the code is correctly deployed on all the servers.
6. **Continuous Monitoring** - This is the stage where vital information about the use of the software is recorded. This information is processed to recognize the proper functionality of the application. The system errors such as low memory, server not reachable, etc are resolved in this phase.

DevOps involves the organizational culture, practices and the relevant technological tools to achieve high application delivery velocity. The core of DevOps is the automation of Continuous Integration and Continuous Deployment.

### Benefits

DevOps brings a variety of benefits for a team to be able to deliver 
- Speed - DevOps enables teams to move with high velocity by automating integration and deployment
- Rapid Delivery - DevOps can increase the frequency and pace of releases
- Reliability - Ensure the quality of application updates and infrastructure changes by testing each change to be functional and safe
- Scale - DevOps can help manage complex or changing systems efficiently and with reduced risk through automation and consistency
- Improved Collaboration - Development and operations teams collaborate closely, share many responsibilities, and combine their workflows. This reduces inefficiencies and saves time
- Security - DevOps can retain control and preserve compliance through automated compliance policies and fine-grained controls

## Technological Tools

DevOps requires the use of multiple technological tools to make automation possible. Each software has its unique requirements and release strategies. Therefore, DevOps needs to garner the different technological tools to make automation possible.

<img src="https://shalb.com/wp-content/uploads/2019/11/Devops1-2048x1338.jpeg" width="50%"/>

For this course, we will be using the following tools:
1. Git and Github - Version Control System
2. Docker - Containerization
3. CircleCI - DevOps Pipeline
4. Snyk - Vulnerability Scan
5. Render - Hosting Platform

There are other tools such as Github Actions, Jenkins, Kubernetes, Splunk, and Prometheus as well as hosting platforms such as AWS and Google Cloud Platform. DevOps is an infinite loop of continuous feedback and improvement through these tools.

In summary, DevOps is the combination of **cultural philosophies, practices, and tools** that increases an organization’s ability to deliver applications and services at high velocity.
