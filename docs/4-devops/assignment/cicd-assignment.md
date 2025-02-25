# Assignment: CICD pipeline

## Learning Objectives
1. Create simple CICD pipeline that would automate the deployment process whenever code is pushed to Github

## Instructions

Following on the discussion for the CICD pipeline, modify the pipeline such that it would fulfill the following requirements:
1. Only run the CI Pipeline (Build, Test, Publish) if changes are pushed to the `main` branch.
2. Run the CICD Pipeline if only changes are pushed to a branch called `release` and no other branch.
3. Code scanning should run for pushes for both `main` and `release` branches.

## Optional Tasks
1. Use Github Actions to do the CICD pipeline.