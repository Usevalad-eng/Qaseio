# Test cases:
#  Auth tests:
##  1.1 Login  with valid data:
### -go to Login page 
### -enter login and pass
### -click Sign in button
## Expected result: signed in to the app
### Severity: High
##  1.2 Login to   with not valid data:
### -go to Login page
### -enter empty login and pass
### -click Sign in button
## Expected result: not signed in to the  app
### Severity: Medium
##  1.3 Login  with not valid data:
### -go to Login page
### -enter empty login and pass with valid data
### -click Sign in button
## Expected result: not signed in to the app
### Severity: Medium
##  1.4 Login  with not valid data:
### -go to Login page
### -enter empty pass and login with valid data
### -click Sign in button
## Expected result: not signed in to the app
### Severity: Medium
#  Project tests:
## 2.1 Create a project:
### -log in to the app
### -go to Projects page
### -click Crate new project button
### -fill in project name and project code fields
### -click Create project button
## Expected result: project is created
### Severity: High
## 2.2 Delete a project:
### -log in to the app
### -go to Projects page
### -click Crate new project button
### -fill in project name and project code fields
### -click Create project button
### -go to Projects page
### -click 3 dots on the right side of the page near  created project
### -click Delete button
## Expected result: project is deleted
### Severity: Medium
#  Suite tests:
## 3.1 Create test suite:
### -log in to the app
### -go to Projects page
### -create a project
### -click Suite button(inside the created project)
### -fill in Suite name field
### -choose Parent suite
### -click Create button
## Expected result: test suit is created
### Severity: High
## 3.2 Delete test suite:
### -log in to the app
### -go to Projects page
### -create a project
### -click Suite button(inside the created project)
### -fill in Suite name field
### -choose Parent suite
### -click Create button
### -click Bucket button
## Expected result: test suit is deleted
### Severity: Medium
#  Test cases tests:
## 4.1 Create test case:
### -log in to the app
### -go to Projects page
### -click Project
### -click Case button
### -click Add steps button
### -fill in required fields
### -click Save button
## Expected result: test case is created
### Severity: High
## 4.2 Delete test case:
### -log in to the app
### -go to Projects page
### -click Project
### -click Case button
### -click Add steps button
### -fill in required fields
### -click Save button
### -choose the case clicking checkbox near the case
### -enter 'CONFIRM' in the form
### -click Delete button
## Expected result: test case is deleted
### Severity: Medium
#  Menu tests:
## 5.1 Exit from the app:
### -log in to the app
### -click user avatar button on the right side of the page
### -click Sign out
## Expected result: signed out
### Severity: Medium

