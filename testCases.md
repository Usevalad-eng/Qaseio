# **Test cases:**
#  UI tests:
##  Auth tests:
##  1.1 Login  with valid data:
Steps:
####   1. go to Login page 
####   2. enter login and pass
####   3. click Sign in button
## Expected result: signed in to the app
### Severity: Blocker
##  1.2 Login  with not valid data(empty login and pass):
Steps:
##### 1. go to Login page
##### 2. enter empty login and pass
##### 3. click Sign in button
## Expected result: not signed in to the  app
### Severity: Normal
##  1.3 Login  with not valid data(empty login):
Steps:
#### 1. go to Login page
#### 2. enter empty login and pass with valid data
#### 3. click Sign in button
## Expected result: not signed in to the app
### Severity: Normal
##  1.4 Login  with not valid data(empty pass):
Steps:
#### 1. go to Login page
#### 2. enter empty pass and login with valid data
#### 3. click Sign in button
## Expected result: not signed in to the app
### Severity: Normal
#  Project tests:
## 2.1 Create a project:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Crate new project button
#### 4. fill in project name and project code fields(with valid data)
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
### Severity: Normal
## 2.3 Create a project with not valid data:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. click Crate new project button
#### 4. fill in project name and project code fields with only one character
#### 5. click Create project button
## Expected result: project with expected name is not created
### Severity: Normal
#  Suite tests:
## 3.1 Create test suite:
Steps:
#### 1. log in to the app
#### 2. go to Projects page
#### 3. create a project
#### 4. click Suite button(inside the created project)
#### 5. fill in Suite name field(with valid data)
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
#### 6. fill in required fields (with * character)
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
#### 6. fill in required fields (with * character)
#### 7. click Save button
#### 8. choose the case clicking checkbox near the case
#### 9. enter 'CONFIRM' in the form
#### 10. click Delete button
## Expected result: test case with expected name is deleted
### Severity: Medium

#  API tests:
##  Project tests:
## 1.1 Create a project:
## Expected result: project with expected name is created
### Severity: Blocker
## 1.2 Delete a project:
## Expected result: project with expected name is deleted
### Severity: Normal
## 1.3 Create a project with not valid data:
## Expected result: project with expected name is not created
### Severity: Normal
## 1.4 Get list of  projects in a json format:
## Expected result: have a list of projects
### Severity: Blocker
#  Suite tests:
## 2.1 Create test suite:
## Expected result: test suit with expected name is created
### Severity: High
## 2.2 Delete test suite:
## Expected result: test suit with expected name is deleted
### Severity: Medium
#  Test cases tests:
## 3.1 Create test case:
## Expected result: test case with expected name is created
### Severity: High
## 3.2 Delete test case:
## Expected result: test case with expected name is deleted
### Severity: Medium

