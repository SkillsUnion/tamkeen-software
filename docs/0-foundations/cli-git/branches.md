# Branches

## Learning Objectives

1. Understand what branches are and what they can be used for
2. How to create a new branch
3. How to move between branches
4. How to merge a branch to another and resolve merge conflicts

## Introduction

A [Git Branch](https://www.w3schools.com/git/git_branch.asp) is an independent series of commits. Every Git repo starts with a single branch, typically `main`, which we can imagine to be a linear series of commits. 

Git Branches allow us to develop features independently of "production" code to avoid affecting what our teammates and users see before we are ready.

Single branch called "main":
![Every repo starts with the main branch by default](<./assets/0.2.1 - Branches - Single Branch.png>)

Using multiple branches allows software engineers to develop new features based on production code in `main` without affecting `main`, even after pushing to GitHub. We typically refer to non-`main` branches as "**feature branches**". Feature branches can be for changes as small as a typo to as large as new products.

Feature branches are independent series of commits that typically "branch" from `main` , and merge back into  `main` after we have completed and tested the new feature.

Feature branch
![Create and work on a feature branch when working on a new feature](<./assets/0.2.1 - Branches - Feature Branch.png>)

We can delete feature branches after merging them to `main`.

Branch merging
![Git state after merging feature branch to main. All commits from feature branch are copied to main, and Git adds an extra "merge commit" to resolve differences.](<./assets/0.2.1 - Branches - Merge Feature Branch.png>)

In large tech companies, thousands of engineers can be working on independent feature branches that branch from `main` and merge back to `main` at different points in time.

## Creating a branch

Create new branches with `git checkout -b`. `git checkout` is the command to switch, or "checkout" branches, and the `-b` flag creates a new branch and checks it out. Branch names use kebab-case (lowercase with hyphens between words) by default, and we will use `my-feature` as our example branch name.

```
git checkout -b my-feature
```

Verify we are on the new `my-feature` branch with `git branch`.

```
react % git checkout -b my-feature
Switched to a new branch 'my-feature'
react % git branch
  main
* my-feature
react %
```

Now we can make commits on `my-feature` that build on the state of `main` when we created `my-feature`. Changes on `my-feature` will not affect any other branch in our repo.

## Moving between branches

While working on feature branches, we may wish to periodically checkout other branches such as `main` to verify if our changes are still compatible with theirs. To change back to the `main` branch, run the command `git checkout main`. We may also wish to `git pull` when on `main` to pull any new changes from GitHub to `main`. Run `git checkout my-feature` to go back to the `my-feature` branch.

## Merging a feature branch to `main`

Once done with our changes on our feature branch, we can merge them to the `main` branch for our teammates and users to use. When working independently, we can perform the merge locally. But when working in a team, we typically perform the merge via GitHub to have the team review our changes through a "pull request".

### Merging locally

Here is the process for merging locally:

1. Checkout the branch we want to merge into. For example, if we want to merge changes on our feature branch to `main`, checkout `main`.
2. Run `git merge` followed by the source branch name, e.g. `git merge my-feature`.
3. Git will combine commits from both branches and create a "merge commit" to resolve any differences. Run `git log` to view the merge commit and verify merge success.
4. Delete the feature branch locally with `git branch -d` followed by the feature branch name, e.g. `git branch -d my-feature`.
5. Once ready, push latest changes in `main` to GitHub.

### Merging on GitHub

Here is the process for merging on Github:

1. Checkout and verify we are on our feature branch with `git branch`
2. Run `git push` to push latest commits from our feature branch to GitHub. If this is our first time pushing this feature branch to GitHub, we may have to run `git push --set-upstream origin` followed by our feature branch name, e.g. `git push --set-upstream origin my-feature`.
3. See instructions in Pull Requests lesson for how to create and merge a pull request in GitHub.

> Note: We may see the following error when pushing a feature branch to GitHub for the first time with `git push`. To resolve this, enter the command Git suggests: `git push --set upstream origin my-feature`, where `my-feature` is the name of our feature branch.

```
react % git push
fatal: The current branch my-feature has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin my-feature

react % git push --set-upstream origin my-feature
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0
remote:
remote: Create a pull request for 'my-feature' on GitHub by visiting:
remote:      https://github.com/SkillsUnion/react/pull/new/my-feature
remote:
To https://github.com/SkillsUnion/react.git
 * [new branch]          my-feature -> my-feature
Branch 'my-feature' set up to track remote branch 'my-feature' from 'origin'.
react %
```

`upstream` refers to where our code should be hosted. `origin` refers to our GitHub repo or where we cloned our repo from. `my-feature` tells Git to create a new branch called `my-feature` in GitHub and by default push changes from the local `my-feature` branch to the GitHub `my-feature` branch.

After setting the upstream once for a branch, we can run `git push` without arguments for subsequent pushes from this branch.

## Merging `main` branch to feature branch

In addition to merging feature branches to `main`, another common workflow is to merge latest changes from `main` into our feature branch. This minimises chances of merge conflicts when we merge our feature branch to `main`, especially if there have been big changes to `main` since we started our feature.

1. Checkout `main` with `git checkout main` and pull latest changes from GitHub with `git pull`.
2. Checkout our feature branch, e.g. `git checkout my-feature`.
3. Run `git merge main` to merge `main` into our feature branch. If there are no conflicts, Git will merge the changes automatically. If not, we will need to resolve merge conflicts manually.

## Merge Conflicts

{% include youtube.html id="56B7MOgm_CE" %}

### What are merge conflicts and why do they happen?

Merge conflicts are situations when Git cannot automatically merge changes from two branches, for example, if two branches change the same line of code differently. We can minimise merge conflicts by actively communicating with teammates to work on different files or functions, but generally merge conflicts are a standard feature of software engineering.

VS Code highlights differences in files with conflicts. The lines surrounded by `<<<<<<< HEAD` and `=======` are changes from the branch we are on, and the lines surrounded by `=======` and `>>>>>>> main` are changes from the incoming branch.

Example of a merge conflict
![Git will tell us where we have merge conflicts when we enter git status after merging. Within those files, VS Code will tell us which lines are in conflict, and we can click buttons above the conflict to resolve the conflicts.](<./assets/0.2.1 - Branches - Merge - Intro.png>)

### How to resolve merge conflicts

Once we have a merge conflict, we must resolve it before writing new code, such that each commit in our commit history continues to describe a specific change. If we are unable to resolve conflicts now or merged by accident, we can abort merge with `git merge --abort`, which will revert our repo state to just before we ran `git merge`.

After Git tells us we have merge conflicts, use `git status` to confirm which files have conflicts.

Open each file with conflicts and resolve conflicts in each file by removing lines starting with `<<<<<<<`, `=======` and `>>>>>>>` and updating the code to what it should be. We can use VS Code's Accept Current/Incoming/Both Changes buttons and/or manually edit the files.

VS Code conflict resolution
![VS Code gives us buttons above each conflict to conveniently resolve each conflict.](<./assets/0.2.1 - Branches - Merge - Resolve Conflict.png>)

Once we have resolved all conflicts, verify if our app still works as expected. Once satisfied with our changes, use `git add` to add the resolved files to the staging area for commit.

Conflict Resolution
![Once we have resolved the conflict in the file we can git add to stage the file with conflicts for commit. We need to make a new commit to mark the conflict resolved.](<./assets/0.2.1 - Branches - Merge - Resolve Conflict 2 (1).png>)

Commit changes to finalise Git's merge commit and complete merge.

Commiting conflict resolution
![Entering git commit after adding resolved files to staging area will open a commit message window. Save and close the file to complete commit.](<./assets/0.2.1 - Branches - Merge - Resolve Conflict (1).png>)

After committing, `git status` should no longer mention conflicts.

Checking status
![Once we save the commit message file, we should see the commit completed.](<./assets/0.2.1 - Branches - Merge - Resolve Conflict 2.png>)

We can verify merge success by checking commit history in Git Logs with `git log`.

Verifying successful merge
![We can verify successful merge by looking at Git Logs.](<./assets/0.2.1 - Branches - Merge - Resolve Conflict 3.png>)

## Exercises

### Create feature branch and merge to `main` without merge conflicts

1.  Create a new repo.

    ```
    mkdir poems
    cd poems
    git init
    ```
2. Create a poem about water in `water-poem.txt`. Commit this file to the repo.
3.  Create and checkout a new branch to edit the water poem.

    ```
    git checkout -b water-poem-edits
    ```
4. Edit the water poem and commit it to the new branch you just created.
5.  List all branches.

    ```
    git branch
    ```
6.  Checkout `main`.

    ```
    git checkout main
    ```
7. Verify `water-poem.txt` has reverted to the version on `main`.
8. Create a new poem about sandwiches in a new file and commit it.
9.  Checkout the water poem branch.

    ```
    git checkout water-poem-edits
    ```
10. Verify the sandwich poem does not exist in the water poem branch.
11. Checkout `main` and merge the water poem edits from the water poem branch.
12. Verify `water-poem.txt` contains changes from the water poem branch.
13. Delete the water poem branch with `git branch -d water-poem-edits`.

### Resolve Merge Conflicts

1. Start from the same repo as the previous exercise.
2.  Make a new branch for edits to the sandwich poem.

    ```
    git checkout -b sandwich-poem-edits
    ```
3. While on the sandwich branch, add a line to the poem and change the line that's currently there.
4. Commit the changes on the sandwich branch.
5. Checkout `main`. To create a merge conflict we will commit new changes to the same lines on the `main` branch.
6. Make a change to the sandwich poem and commit it.
7. Merge the sandwich branch into `main`.
8. We should observe a merge conflict.
9. Open the sandwich poem file to see merge conflict symbols from Git.
10. Resolve the merge conflict as per instructions above.
