# GitHub

## Learning Objectives

1. Know what Github is and what is used for
2. Know how to fork and clone a repo on GitHub
3. Know how to push and pull changes to GitHub
4. Know how to view repo commit history in GitHub

## Introduction

[GitHub](https://github.com) is a code-hosting website that hosts Git repos for individuals or teams to review and collaborate on. Team members can easily review latest code changes and commit history, making software development more transparent and thorough.

## GitHub Workflow Summary

In order for us to work with repositories in Github, we must follow the typical Github workflow:

1. **Fork** repos we do not have edit access to suggest changes or maintain our own copy
2. **Clone** repos to download local copies of GitHub repos to our local machine
3. Once we have committed the changes we want locally,  **push** the changes to GitHub to share them with others. Refresh the GitHub repo page to see those changes.
4. If we are working with teammates and wish to download their code while keeping local changes, **pull** their code from GitHub after committing our local changes.

## GitHub Fork

A GitHub ["fork"](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) is a copy of another GitHub repo. Developers typically "fork" repos they do not have edit access to either to make improvements to merge back into original repos, or to create and maintain independent versions of repos. We will fork exercise repos to complete and submit assignments.

We can fork a repo by clicking the Fork button on a GitHub repo page. Once forked, we can change our copy of the repo without affecting the original.

How to fork a repo:
![Click the Fork button to fork a repo](<./assets/0.3 - GitHub - 1) Fork.png>)

Fork menu:
![Fork menu; We typically keep the same repo name for clarity](<./assets/0.3 - GitHub - Fork - 2) Fork menu.png>) 

How a forked repo looks like:
![Forked repo; Notice the repo is now under my account](<./assets/0.3 - GitHub - Fork - 3) Forked repo.png>)

## Git Clone

Once we have edit access to the repo we want to edit, either by forking an existing repo or [creating a new repo](https://docs.github.com/en/get-started/quickstart/create-a-repo), we can "clone" (i.e. download) that repo to our local machine to make changes to it.

Click the copy button in the Code dropdown menu on the GitHub page of the repo we wish to edit.

Cloning options:
![Click the copy button in the Code dropdown to copy the repo link to use with git clone](<./assets/0.3 - GitHub - Clone.png>)

Then go to terminal, `cd` to the relevant folder and enter the command `git clone <repo-url>`, where `<repo-url>` is the URL we just copied from GitHub. This will create a new folder named after the repo with the repo's contents inside.

```
bootcamp % git clone https://github.com/SkillsUnion/react.git
Cloning into 'react'...
remote: Enumerating objects: 203678, done.
remote: Total 203678 (delta 0), reused 0 (delta 0), pack-reused 203678
Receiving objects: 100% (203678/203678), 173.82 MiB | 5.85 MiB/s, done.
Resolving deltas: 100% (144768/144768), done.
bootcamp %
```

Once we've cloned the repo we can make edits to it and track our changes with Git.

## Git Push

`git push` allows us to share local changes by "pushing" local commits to GitHub for others to view. 

Here is a video [demonstration](https://youtu.be/BJojbCFfOHU) of how to push local changes to GitHub.

## Git Pull

`git pull` allows us to download changes in a shared GitHub repo (e.g. by teammates) while keeping our local changes. Git will automatically merge downloaded and local changes, and let us know if there are "merge conflicts", for example if downloaded and local changes edit the same lines of code. 

## How to view commit history in GitHub

GitHub provides an easy way to view past changes to a repo. For example, if we are wondering which commit changed a line of code that caused a bug, we can easily find which commits changed that line, who made those commits and what other changes were in those commits.

View commits:
![Click the number of commits on a repo's GitHub page to view a list of all its commits](<./assets/0.3 - GitHub - 1) View Commits.png>)

Commit List:
![Click on any commits in the repo's commit history to view the details of that commit](<./assets/0.3 - GitHub - 2) Commit List.png>)

Commit contents:
![We can review complete details of each commit in GitHub](<./assets/0.3 - GitHub - 3) Commit Contents.png>)

## Additional Resources

1. [Git and GitHub in Plain English](https://blog.red-badger.com/2016/11/29/gitgithub-in-plain-english) (blog post)
2. [Git and GitHub by The Coding Train](https://youtube.com/playlist?list=PLRqwX-V7Uu6ZF9C0YMKuns9sLDzK6zoiV) (video playlist)
3. [Intro to GitHub](https://www.youtube.com/watch?v=dn7r4333c4g)
4. [GitHub Fork video](https://youtu.be/uMNcnLWTmZU) 
> Note that `git push origin master` was used, but now we use `git push origin main`
5. [GitHub Repo Browsing video](https://youtu.be/a-flBCpOmBU)

