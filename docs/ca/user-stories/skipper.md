# User Stories: Skipper

## SKI04

**Priority**: High

**Narrative**

As a Skipper I want to Log out of the system so that my account can be secure.

**Acceptance Criteria**

#### Scenario 1: Log out successful
**Given** the user is logged in as a Skipper.  
**When** the user selects the log out tab.  
**Then** the user is taken to the homepage, the user is successfully logged out, and the username is no longer displayed.

---

## SKI03

**Priority**: High

**Narrative**

As a Skipper I want to login to the system so that I can access my account.

**Acceptance Criteria**

#### Scenario 1: All login details are correct
**Given** the Skipper is registered on the system.  
**When** the Skipper has entered a valid user name, entered a correct password, and clicks "Login".  
**Then** the Skipper is taken to the Skippers landing page, the Skipper is logged in, and a message is shown "Skipper successfully logged in".

#### Scenario 2: Username is incorrect
**Given** the Skipper is registered on the system, has entered an incorrect user name, and entered a correct user password.  
**When** the Skipper enters the login information of an incorrect user name and correct password.  
**Then** the Skipper is not taken to the managers landing page, is not logged in, and the page refreshes prompting the user to try again.

#### Scenario 3: Password is incorrect
**Given** the Skipper is registered on the system, has entered a valid user name, and entered an incorrect user password.  
**When** the Skipper enters the login information of a valid user name and incorrect password.  
**Then** the Skipper is not taken to the Skippers landing page, is not logged in, and an error message of "Incorrect password" appears.

#### Scenario 4: User does not enter password
**Given** the Skipper is registered on the system and has entered a valid username.  
**When** the Skipper selects "Login".  
**Then** the Skipper receives a message "Password required".

#### Scenario 5: User does not enter username
**Given** the Skipper is registered on the system and has entered a valid password.  
**When** the Skipper selects "Login".  
**Then** the Skipper receives a message "username required".

#### Scenario 6: Manager leaves username and password fields blank
**Given** the Skipper is registered on the system and leaves username and password fields blank.  
**When** the Skipper selects "Login".  
**Then** the Skipper receives a message "username required" and "password required".