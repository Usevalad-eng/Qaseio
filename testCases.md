# **Test cases:**
#  Auth tests:
##  1.1 Login  with valid data:
Steps:
####   1. go to Login page 
####   2. enter login and pass
####   3. click Sign in button
## Expected result: signed in to the app
### Severity: High
##  1.2 Login  with not valid data(empty login and pass):
Steps:
##### 1. go to Login page
##### 2. enter empty login and pass
##### 3. click Sign in button
## Expected result: not signed in to the  app
### Severity: Medium
##  1.3 Login  with not valid data(empty login):
Steps:
#### 1. go to Login page
#### 2. enter empty login and pass with valid data
#### 3. click Sign in button
## Expected result: not signed in to the app
### Severity: Medium
##  1.4 Login  with not valid data(empty pass):
Steps:
#### 1. go to Login page
#### 2. enter empty pass and login with valid data
#### 3. click Sign in button
## Expected result: not signed in to the app
### Severity: Medium
#  Project tests:
## 2.1 Create a project:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Crate new project button
#### 4. fill in project name and project code fields
#### 5. click Create project button
## Expected result: project with expected name is created
### Severity: Blocker
## 2.2 Delete a project:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Crate new project button
#### 4. fill in project name and project code fields
#### 5. click Create project button
#### 6. go to Projects page
#### 7. click 3 dots on the right side of the page near  created project
#### 8. click Delete button
## Expected result: project with expected name is deleted
### Severity: Medium
## 2.3 Create a project with not valid data:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Crate new project button
#### 4. fill in project name and project code fields with digits only
#### 5. click Create project button
## Expected result: project with expected name is not created
### Severity: Medium
#  Suite tests:
## 3.1 Create test suite:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. create a project
#### 4. click Suite button(inside the created project)
#### 5. fill in Suite name field
#### 6. choose Parent suite
#### 7. click Create button
## Expected result: test suit with expected name is created
### Severity: High
## 3.2 Delete test suite:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. create a project
#### 4. click Suite button(inside the created project)
#### 5. fill in Suite name field
#### 6. choose Parent suite
#### 7. click Create button
#### 8. click Bucket button
## Expected result: test suit with expected name is deleted
### Severity: Medium
#  Test cases tests:
## 4.1 Create test case:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Project
#### 4. click Case button
#### 5. click Add steps button
#### 6. fill in required fields
#### 7. click Save button
## Expected result: test case with expected name is created
### Severity: High
## 4.2 Delete test case:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Project
#### 4. click Case button
#### 5. click Add steps button
#### 6. fill in required fields
#### 7. click Save button
#### 8. choose the case clicking checkbox near the case
#### 9. enter 'CONFIRM' in the form
#### 10. click Delete button
## Expected result: test case with expected name is deleted
### Severity: Medium
#  Menu tests:
## 5.1 Exit from the app:
Steps:
#### 1. log in to the app
#### 2. click user avatar button on the right side of the page
#### 3. click Sign out
## Expected result: signed out
### Severity: Medium

