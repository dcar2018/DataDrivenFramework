# DataDrivenFramework
DataDrivenFramework in Java 


## git Commands

## Step 1 : 

#### Adding an existing project to GitHub using the command line

###### 1. Create a new repository on GitHub. To avoid errors, do not initialize the new repository with README file
###### 2. Open Git Bash.
###### 3. Change the current working directory to your local project.
###### 4. Initialize the local directory as a Git repository.
    $ git init
###### 5. Add the files in your new local repository. This stages them for the first commit.
    $ git add .
    // Adds the files in the local repository and stages them for commit. To unstage a file, use 'git reset HEAD YOUR-FILE'.
###### 6. Commit the files that you've staged in your local repository.
     $ git commit -m "First commit"
    // Commits the tracked changes and prepares them to be pushed to a remote repository. To remove this commit and modify the file, use 'git reset --soft HEAD~1' and commit and add the file again.
###### 7. Copy remote repository URL field
At the top of your GitHub repository's Quick Setup page, click to copy the remote repository URL. 
###### 8. In the Command prompt, add the URL for the remote repository where your local repository will be pushed.
    $ git remote add origin https://github.com/dcar2018/DataDrivenFramework.git
    // Sets the new remote
    $ git remote -v
    // Verifies the new remote URL
###### 9.Push the changes in your local repository to GitHub.
    $ git push origin master
    // Pushes the changes in your local repository up to the remote repository you specified as the origin


## Step 2 : 

#### Get latest code from remote repository to local

###### 1. When no conflicts with new-online version
    $ git fetch origin
    $ git status
    $ git pull origin master
   
###### 
## Step 3

#### Work with branching for day to day work - Sample git workflow


###### create a new local branch named after the current story
    $ git checkout -b SS-123
###### create a remote branch which our local one will track
    $ git push -u origin SS-123
###### do some work... then add your files ??
    $ git add . / git add -all / git add <filename>
###### commit your changes
    $ git commit -m 'SS-123 Fixed bug where expiry date not correct'
###### push to your remote branch
    $ git push origin SS-123
###### update your local repo with changes from the remote
    $ git fetch origin
###### rebase onto master
    $ git rebase origin/master
###### push your rebased branch up to your remote
    $ git push origin SS-123 -f

###### create a new local branch based on an existing remote branch
    $ git checkout -b SS-123 origin/SS-123
    // Most other tasks will be performed directly via the github interface


######
## Step 4

#### Some more GIT commands


###### to add missing folders and files
    $ git add * -f
###### unstage all the files mistakenly added
    $ git reset
###### How to exit git editmsg mode
    Press i to enter inline insert mode. Type the description at the very top,
    press esc to exit insert mode, then type :x!
######
######
###### --------------------------------------------------------------------------------------------------------------

## Tips to find locators in Chrome
######
###### Chrome > Right click > Inspect elements
###### ctrl+l >> clear
###### To fid css locator - $$("") >>
######
######

###### --------------------------------------------------------------------------------------------------------------

## Tips for Jenkins
######
        to stop: jenkins.exe stop
        to start: jenkins.exe star
        to restart: jenkins.exe restart
######
###### Strat Jenkins with below command to see the reports in proper html format
        java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war
###### Make sure that HTML publisher plugin installed to jenkins and
###### Post build action configured to view the results reports
######
###### Parameterizing
        Configure > Add parameter > Choice parameter >> Eg. Name : browser Choices : chrome, firefox
        in java, read the value as System.getenv("browser")
######
![alt text](https://github.com/dcar2018/DataDrivenFramework/blob/master/readmeImgs/jenkins1.png)


###### --------------------------------------------------------------------------------------------------------------

###### -------------------------------- END -------------------------------------------------------------------------
