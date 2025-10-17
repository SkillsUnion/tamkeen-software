# Web Security

## Learning Objectives
1. Explain what is DevSecOps is
2. Understand what secrets and vulnerabilities are
3. Identify what kind of data are considered "secrets".
4. Implement vulnerability scanning in the CI phase using Snyk.

## Introducing Security to DevOps (DevSecOps)

By now, we can see how CICD Pipeline has automated the integration aspects of Development and how Deployment is made simple/portable with Containerization. When we add `security` into DevOps, the DevSecOps carries the same principles in introducing security automation as early as possible into the DevOps practices. 

### What is DevSecOps?

DevSecOps stands for *development, security, and operations*. It's an approach to culture, automation, and platform design that integrates security as a shared responsibility throughout the entire IT lifecycle.

DevSecOps means thinking about application and infrastructure security from the start. It also means automating some security gates to keep the DevOps workflow from slowing down.

There are many ways to introduce security into DevOps, but in this lesson, we will be covering:

1. The importance of **Secret Management** to handle secrets
2. The Image **Vulnerability Scan** to scan for vulnerabilities

## Secrets and Secret Management

### What are secrets?

Secrets are private information that act as a method to unlock protected resources or sensitive information.

Here are some common types of Secrets:
- Auto-generated passwords
- User passwords
- System-to-system passwords
- Database passwords
- Private encryption keys
- Authorization tokens
- Application keys and APIs
- SSH Keys
- Private certificates (SSL, TLS, etc)
- One-time passwords


### Secret Lifecycle

Secrets have a lifecycle to follow from its creation to its revocation. The lifecycle consists of 4 main stages:
1. Creation - Secrets are created depending on the need of the end user
2. Storage - Secrets are stored in encrypted and secure locations
3. Rotation - Secrets are to be changed on a set schedule
4. Revocation - Secrets are removed when user is no longer part of the system

### Secret Management

Secrets management is the practice of securely storing and managing secrets and helps to ensure security at three levels:
- Infrastructure security – Protect user and application accounts, devices, and other network elements from intrusions.
- Cloud service security – Limit and manage access to cloud accounts and important cloud-based services.
- Data security – Protect critical systems, storages, databases, and other resources from data compromise.

### Challenges to Secret Management

There are challenges in managing secrets and here are some of them:
- Lack of visibility - Lack of knowledge on what secrets are in the company
- No secrets management policy - Lack of preparation on how to manage secrets
- Manual management - Secrets are managed manually and physically

On top of this, many users and developers even follow certain **secret anti-patterns** that compromise the security. It is up to developers and users to be aware of these anti-patterns and avoid them. 

Here are some anti-patterns that are commonly encountered or done by users:
- Using weak / default / hard-coded passwords
- Not revoking secrets in time
- Storing secrets in plain text
- Never rotating secrets
- Sharing passwords
- Reusing secrets

### Secret Management Solutions

In order to protect secrets, approaches and practices can be introduced to the team to ensure that resources across the platforms and environments are secure. Here are some of the common approach and practices used by teams:

- Principle of least privilege - a user is given the minimum levels of access or permissions needed to perform job functions.
- Role-based access control (RBAC) - create roles for specific functions for each user.
- Secret Rotation - Change secrets on a regular interval to prevent reuse.
- Auditing - perform regular auditing to make sure that anti-patterns are caught. 
- Automate secret management - use cloud secret management tools to automate secret management

There are several tools available online that allow teams to implement secret management in the cloud, here are the some of the more popular ones:

- AWS Secrets Manager 
- Azure Key Vault
- Google Cloud Secrets Manager
- HashiCorp Vault 

These solutions provide centralized management of secrets, automate their rotation, and provide granular access control to them. But do take note that most of these services are paid so there will be some costs if your team would consider using these.

## Vulnerability Scan

### What are vulnerabilities?

Vulnerabilities are **security weaknesses** that can be exploited by malicious actors to gain **unauthorized access** to a computer system. After exploiting a vulnerability, the attacker can run malicious code, install malware, and even steal sensitive data.

Hence, there is a need for check the system for any vulnerabilities through the use of vulnerability scans. 

### What is a Vulnerability Scan

Vulnerability scanning is the process of *discovering, analyzing, and reporting on security flaws and vulnerabilities*.
This can be achieved through the use of automated vulnerability scanning tools that would identify potential risk exposures across an organization’s systems.

Benefits of Vulnerability Scans include:
- Proactive approach to close any gaps and maintain strong security for systems, data, employees, and customers. 
- Identify and eliminate the security gaps
- Compliance to cybersecurity regulations
- Take restorative actions before hackers can exploit any security vulnerabilities.

There are many types of vulnerability scans but they typically fall in three main categories depending on their use case:
- External Vulnerability Scans
- Internal Vulnerability Scans
- Environmental Scans

After vulnerabilities have been identified, they are categorized based on their severity: 
- Critical 
- High
- Medium
- Low
Here is a good categorization for severities from [Atlassian](https://www.atlassian.com/trust/security/security-severity-levels) to understand how to categorize vulnerabilites. The severity would help the developers in their plans in resolving said vulnerabilities.

## Vulnerability Scan Demonstration

### Image Vulnerability Scan using Snyk

Snyk would be used for this demonstration. 

Snyk is a platform allowing you to scan, prioritize, and fix security vulnerabilities in your code, open source dependencies, container images, and Infrastructure as Code (IaC) configurations.

Preparation:
- Create account at snyk.io
- Obtain the access token and set environmental variable in CircleCI `SNYK_TOKEN`. (Account Settings (at the bottom of sidebar) -> General -> Auth Token)
- At CircleCI, go to `Organization Setting > Security` to allow third party Orbs

Scan Job:

```yml
orbs:
  node: circleci/node@5.0.1
  docker: circleci/docker@2.1.4
  snyk: snyk/snyk@1.5.0
jobs:
    scan:
        docker:
            - image: cimg/node:16.10
        environment:
            IMAGE_NAME: <your dockerhub account>/education-space
        steps:
            - checkout
            - setup_remote_docker      
            - docker/check
            - run: docker build -t $IMAGE_NAME .
            - snyk/scan: 
                docker-image-name: $IMAGE_NAME
```

Add to workflow:

```yml
workflows:
  simple_workflow:
    jobs:
      - build:
          filters:
            branches:
              only: main
      - test:
          requires:
            - build 
          filters:
            branches:
              only: main    

    # The scan job
      - scan:
          requires:
            - build
          filters:
            branches:
              only: main
```

### Static Code Analysis using Snyk

Run static code analysis to detect vulnerabilities within your code

Scan Job:

```yml
jobs:
  codescan:
    docker:
      - image: cimg/node:16.10
    environment:
      IMAGE_NAME: <your dockerhub account>/education-space
    steps:
      - checkout
      - setup_remote_docker
      - docker/check
      - run: docker build -t $IMAGE_NAME .
      - snyk/install
      - run: |
          snyk code test
```

Add to workflow:

```yml
workflows:
  simple_workflow:
    jobs:
      - build:
          filters:
            branches:
              only: main
      - test:
          requires:
            - build 
          filters:
            branches:
              only: main    
      - scan:
          requires:
            - build
          filters:
            branches:
              only: main
      - codescan:
          requires:
            - build
          filters:
            branches:
              only: main
```


After running the scan job, pipeline will fail due to Snyk finding a vulnerability.
Some vulnerabilities can be left alone as they do not pose any real threat and would act like a warning. It is up to the development team to filter these kinds of vulnerabilities and resolve the ones that need to be resolved.

### Activity - Filtering vulnerabilities

The Snyk orb has capabilities to filter out vulnerabilities based on severity. As practice, research how to filter vulnerabilities such that the scan would only flag **HIGH and CRITICAL severities.**