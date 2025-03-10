# Branching Strategies

## Learning Objectives
1. Understand the whys and hows of branching strategies
2. Use three different branching strategies: GitFlow, GitHub Flow, and Trunk-based strategies
3. Explain how these strategies affect the way we configured CICD Pipeline

## What is a branching strategy?

In modern software development, speed and agility are crucial when it comes to developing and releasing software. In large development teams working simultaneously, branching and merging code can become messy. Hence, there is a need to have a process in place to implement multiple changes at once. This is where having an efficient branching strategy becomes a priority for these teams.

A branching strategy is the strategy that software development teams adopt when writing, merging and deploying code when using a version control system.

Recall that branches are used as a means for teams to develop features giving them a separate workspace for their code. These branches are usually merged back to the main branch upon completion of work.

In this way, features (and any bug and bug fixes) are kept apart from each other allowing you to fix mistakes more easily.

This means that branches protect the mainline of code and any changes made to any given branch don’t affect other developers.

Benefits of branching strategies:
- Enhance productivity by ensuring proper coordination among developers
- Enable parallel development
- Help organize a series of planned, structured releases
- Map a clear path when making changes to software through to production
- Maintain a bug-free code where developers can quickly fix issues and get these changes back to production without disrupting the development workflow

There are different branching strategies, and the most commonly used are the following:
- GitFlow
- GitHub Flow
- Trunk Based Development

## GitFlow vs GitHub Flow vs Trunk Based Development

### GitFlow

Gitflow is an alternative Git branching model that involves the use of feature branches and multiple primary branches. 

Gitflow has numerous, longer-lived branches and larger commits. Under this model, developers create a feature branch and delay merging it to the main trunk branch until the feature is complete.

Gitflow can be used for projects that have a scheduled release cycle and for the DevOps best practice of continuous delivery. 

Branches:
1. Main - Stores the official release history.
2. Develop - Serves as an integration branch for features.
3. Feature - Each new feature should reside in its own branch. Feature branches use `develop` as their parent branch instead of `main`. When a feature is complete, it gets merged back into `develop`. Features should never interact directly with `main`.
4. Release - Created once the `develop` branch has enough features for a release or a release date is approaching. No new features can be added after this point—only bug fixes, documentation generation, and other release-oriented tasks should go in this branch.

Once it's ready to ship, the `release` branch gets merged into `main` and tagged with a version number. In addition, it should be merged back into `develop`, which may have progressed since the release was initiated.

How to do GitFlow
1. Start development by branching out a `feature` branch from the `develop` branch
1. Complete and test new feature in the `feature` branch
1. Merge `feature` branch into the `develop` branch to solve potential conflicts
1. Create a `release` branch from the `develop` branch
1. Perform fixes on `release` branch
1. Once stable, merge `release` branch into the `main` branch
1. Merge `main` branch into `develop` branch to kickstart new features

<img src='https://wac-cdn.atlassian.com/dam/jcr:8f00f1a4-ef2d-498a-a2c6-8020bb97902f/03%20Release%20branches.svg?cdnVersion=535' width='50%' />


### GitHub Flow

Github Flow is a simpler alternative to GitFlow that is ideal for smaller teams as they don’t need to manage multiple versions and it is ideal when there is a need to maintain a single production version.

Unlike GitFlow, it doesn't have any `develop` and `release` branches. The team start off with the `main` branch then developers create `feature` branches that stem directly from `main`, to isolate their work which are then merged back into `main`. The feature branch is then deleted.

Branches:
1. Main branch - Contains code that is always deployable.
2. Feature branch - Each new feature should reside in its own branch. Feature branches branch out from `main`. When a feature is complete, it gets merged back into `main`.

> Do everything without a `develop` and `release` branch.
1. Start development by branching out a `feature` branch from the `main` branch
1. Complete and test new feature in the `feature` branch
1. Create a pull request from the `feature` branch to the `main` branch
1. Merge `feature` branch into the `main` branch to solve potential conflicts

<img src="https://i0.wp.com/build5nines.com/wp-content/uploads/2018/01/GitHub-Flow.png" width="50%" />

### Trunk Based Development

Trunk-based development is a branching strategy wherein developers merge small, frequent updates to a core "trunk" or main branch. It helps CI/CD by streamlining merging and integration phases.

Developers can create short-lived branches with a few small commits compared to other long-lived feature branching strategies.

> All developments must be small batch iterations and is directly pushed into the `main` (trunk) branch. 

<img src="https://trunkbaseddevelopment.com/trunk1a.png">

> Note: The main branch is labelled as "master" but this is an outdated naming convention. The main branch is now the proper term for the branch.