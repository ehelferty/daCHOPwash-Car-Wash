# Git / GitHub for The Project
This document has basically everything needed on using git collaboratively. I know one or two of you had said you hadn't really used it much, so let's try and follow this guideline for this project:
https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow

If anyone has any trouble with it feel free to ask Graham, I'm pretty comfortable with it.

## The Main Idea
Our project is divided into two main remote (shared) branches: `main` and `develop`. `main` is what we will hand in: and it is the code that has been verified by all of us to work correctly. `main` can never be broken.
`develop` is our work-in-progress. It should be updated any time you make a meaningful change that you want to share with others. Keep pushing your work to `develop` as you do it, so that we avoid merge conflicts later on.

## The Steps
So you want to do some work on your portion of the project. To do that, best practice is to first make sure that your local develop is in sync with the remote (shared) develop. To do this:

### Sync Before Working
1. `git checkout develop` <-- make sure you're actually on your local develop branch.
2. `git status` <-- make sure you don't have any changes that are still-to-be committed. If you haven't done any work yet, you shouldn't. 
3. `git fetch` <-- download any changes made by others.
If you're up to date, you can move on to the next step. If not:
4. `git pull` <-- this applies the changes you previously fetched to your local work.
Now you're up to date. Next, you want to do your work. In order to do this without causing trouble for yourself down the line:
### Create a Separate Branch 
1. `git checkout -b <branchname>` The branch name can be whatever you want, this is local to you only so it doesn't have to be anything super serious. Still recommend to keep it professional in case you accidentally push this branch or something.

Once you are on another branch, you can work away. Make changes, when you're happy with your changes and reached a logical "save" point, do a commit.
### Commit Process
Commiting is another way of thinking of "saving" - but instead of saving/overwriting like you would with a normal file, you're saving groups of files and their progression through time. At any point you can roll back to a previous commit, undo a commit, or delete a commit. It's just a logical stopping point.
For your own sanity, you shouldn't commit broken code. If it's broken when you're done for the day, just leave it broken and it'll be there for you tomorrow to fix.

When you've got some working code you're ready to commit, you should:

1. `git status` <- Check the files that have changed, and make sure it's what you'd expect. If you see lots of changes, or something doesn't seem right, now's the time to fix that file before you move on.
2. `git add <filename>` <- Here you can specify a single file or a group of files. If you want to add everything, just run the command `git add .` which points to the current directory, and everything beneath it. If you're at the top level of the project (which you probably should be) then it'll add everything.
3. `git commit -m "<message>"` <- (Note the quotes). A simple message to explain what you did in the commit. Useful for debugging later so it's best you actually describe what you did rather than just write "commit".

### Merging your branch into (local) develop.
When you've completed a small chunk of code that you're happy with and that works (this might be one commit, or might be 10 - depending on what you were doing), it's time to move your feature branch into your local develop. In order to do this:
1. `git checkout develop` <- move from the branch you were working on, to develop.
2. `git fetch` <- Do this first, in case someone has worked on something to keep your code in sync. If someone has pushed changes since you last fetched, you'll need to run another `git pull`.
Once you've verified your `develop` is in sync with the remote (shared) `develop`, it's time to merge your feature branch into your local develop.
3. `git merge <feature-branch-name>` <- This is the same throwaway name you used earlier.

**Note:** If someone else worked on the same code you worked on, and git can't figure it out, you'll get a merge conflict. They probably won't happen and it's out of the scope of this document, but if you do get one, follow [this article](https://www.atlassian.com/git/tutorials/using-branches/merge-conflicts) to fix it. If you still can't figure it out, ask Graham and he'll help you out.
### Pushing your changes to the remote repository.
After your changes have been made and you merged them into your local `develop`, you need to share them with the rest of the group. In order to do this, you'll push it to remote. Since you already verified everything was in sync in the previous step, this should be as simple as:
1. `git push`

There are quite a few things that could go wrong in this step, and it might prompt you to use the `-f` flag to force your push on the repo. Unless you're 100% sure what you're doing, don't do that. Just reach out to the group instead and we can see what went wrong.

If the `git push` worked, then congrats - you shared your work with everyone. Next time someone does a `git fetch` they'll see your changes and pull it down, and the whole project will move smoothly.