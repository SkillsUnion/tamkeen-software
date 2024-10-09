# Assignment: Instagram Routes

## Learning Objectives

1. Understand how to use React Router to build React apps with multiple URL paths
2. Understand how to split component logic to effectively have multiple pages served by the same React app
3. Understand how to refactor class components to be functional components with React Hooks
4. Understand how to deploy an app with Firebase Hosting
5. Know how to read documentation to apply a new technology

## Introduction

We will build on previous Instagram exercises to incorporate React Router and create standalone pages for each post with relevant URLs.

## Setup

1. Start with the code we wrote in the previous exercise in our forked and cloned copy of the <a href="https://github.com/SkillsUnion/instagram-base-app" target="_blank">Instagram starter repo</a>
2. Set up React Router in our repo as per the official <a href="https://reactrouter.com/en/6.18.0/start/overview#nested-routes" target="_blank">React Router documentation</a>
3. Practice safe sharing, create implement your .env so that you do not share your Firebase credentials online when pushing to GitHub.

>**We will deploy on Firebase Hosting instead of GitHub Pages**

## Base: Split `Home` and `AuthForm` pages into separate routes

In Instagram Auth we created an `AuthForm` component that renders instead of the `NewsFeed` component when our user wants to sign in. We will now create separate routes for `AuthForm` (`/authform`) and `NewsFeed` (`/`) components to make it easier for users to navigate to the auth form and news feed respectively. Consider referring back to the <a href="https://reactrouter.com/en/6.18.0/start/overview#client-side-routing" target="_blank">React Router Implementation section</a>..

Now that we will use Links and Routes to navigate between our auth form and news feed, we no longer need `shouldRenderAuthForm` state and the `toggleAuthForm` method to determine whether to render the auth form. We can remove all mentions of `shouldRenderAuthForm` and `toggleAuthForm` from `App`, and update `toggleAuthForm` usage to either a React Router `Link` to `/authform` or `useNavigate`/`navigate` to `/` after auth form submission.

You may remember that we cannot use React Hooks in class components. There is no need to rewrite all of our components to be functional components, but we will need to rewrite ones such as `AuthForm` that need the React Router `useNavigate` hook.

## Comfortable: Dedicated page and route for each post

Clicking on posts in the news feed navigates to a standalone page for the clicked post. The standalone page should have a URL that uniquely identifies that post, and a back button to get back to the news feed. Create a new component in a new file for pages for individual posts. We may find <a href="https://reactrouter.com/docs/en/v6/getting-started/tutorial#reading-url-params" target="_blank">Reading URL Params</a> in React Router helpful for creating and using a relevant URL for each post.

## More Comfortable: Navbar, chat page

Re-create our chat page from Instagram Chat as a separate component. Add a navigation bar to the app and allow users to toggle between news feed and chat pages via navigation links. Toggling between features updates the app URL for the relevant feature.

## Submission

Deploy your app to the internet, follow Vitejs GitHub Pages <a href="https://vitejs.dev/guide/static-deploy.html" target="_blank">deployment instructions here</a>. Note that you will need to add the repo name within React Router's to and path properties.

## Note

You may see the following warning from Chrome when visiting the reference deployment. This may be because we used "Instagram" as our app name and we have "instagram" in our URL. To visit the site anyway, click "Details" and "visit this unsafe site" like in the screenshots below.

![Chrome warns us of deceptive sites.](<../assets/instagram-routes-deceptive-site.png>)

![To visit the site anyway, click "visit this unsafe site".](<../assets/instagram-routes-deceptive-site-details.png>)
