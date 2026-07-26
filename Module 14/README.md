# Module 14: Git Configuration, Operations, Git Ignore, Branching, Conflict Resolution & Remote Sync

This module covers Git setup, commits, status checks, ignoring unwanted files, branching & merging, conflict resolution, and pushing to a remote GitLab repository.

---

## Lab 1: Repository Setup & Basic Commands

### Objectives
- Git client setup and global configuration (`user.name`, `user.email`).
- Initializing a Git repository (`git init`).
- Tracking and committing files (`git add`, `git commit`).

### Steps Executed
1. Initialized repository inside `GitDemo/`.
2. Created `welcome.txt` with content: `Welcome to the version control`.
3. Staged and committed `welcome.txt`:
   ```bash
   git add welcome.txt
   git commit -m "Initial commit with welcome.txt"
   ```

---

## Lab 2: Implementing `.gitignore`

### Objectives
- Configure `.gitignore` to ignore specific file extensions (`.log`) and folders (`log/`).
- Verify that `git status` ignores specified files and folders.

### Steps Executed
1. Created a `.log` file: `app.log`.
2. Created a log folder and file: `log/system.log`.
3. Created [.gitignore](file:///c:/Users/91790/Desktop/JavaFSE/Module%2014/GitDemo/.gitignore) with patterns.
4. Staged and committed `.gitignore`.

---

## Lab 3: Branching & Merging

### Objectives
- Construct a branch, make changes, and merge it with the main trunk.

### Steps Executed
1. Created branch `GitNewBranch`: `git branch GitNewBranch`
2. Switched to branch and added [feature.txt](file:///c:/Users/91790/Desktop/JavaFSE/Module%2014/GitDemo/feature.txt).
3. Merged `GitNewBranch` into `main` and deleted the branch.

---

## Lab 4: Merge Conflict Resolution

### Objectives
- Simulate and resolve merge conflicts when both main and feature branches update the same file.

### Steps Executed
1. Created branch `GitWork` and added `hello.xml`.
2. Switched back to `main` and added `hello.xml` with different conflicting content.
3. Merged and resolved conflict in [hello.xml](file:///c:/Users/91790/Desktop/JavaFSE/Module%2014/GitDemo/hello.xml).
4. Added backup file patterns (`*.orig`, `*.bak`) to `.gitignore` and deleted `GitWork` branch.

---

## Lab 5: Clean Up & Push to Remote Git

### Objectives
- Verify clean state, pull from remote, and push local branch changes to remote Git repository.

### Steps Executed / Instructions
1. Verified clean status:
   ```bash
   git status
   ```
2. Listed all available branches:
   ```bash
   git branch -a
   ```
3. Pulled changes from remote:
   ```bash
   git pull origin main
   ```
4. Pushed pending commits to remote GitLab repository:
   ```bash
   git push -u origin main --force
   ```
5. Verified changes reflected on GitLab web interface.
