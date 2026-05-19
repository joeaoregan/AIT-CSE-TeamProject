# User Stories: Front Desk

## FRO01

**Priority**: High

**Narrative**

As a Front desk user I want to login to the system so that I can access my account.

**Acceptance Criteria**

#### Scenario 1: All login details are correct
**Given** the FD is registered on the system.  
**When** the FD has entered a valid user name, entered a correct password, and clicks "Login".  
**Then** the FD is taken to the front desk landing page and the FD is successfully logged in.

#### Scenario 2: Username is incorrect
**Given** the FD is registered on the system, has entered an incorrect user name, and entered a correct user password.  
**When** the FD enters the login information of an incorrect user name and correct password.  
**Then** the FD is not taken to the FD landing page, the page refreshes to prompt the User to try again, and the user is not successfully logged in.

#### Scenario 3: Password is incorrect
**Given** the user is registered on the system, has entered a valid user name, and entered an incorrect user password.  
**When** the user enters the login information of a valid user name and incorrect password and selects "Login".  
**Then** the FD is not taken to the FD landing page, the page refreshes to prompt the User to try again, and the user is not successfully logged in.

#### Scenario 4: User leaves both fields blank
**Given** the FD is registered on the system and the FD leaves username and password fields blank.  
**When** the FD selects "Login".  
**Then** the FD receives a message "username required" and "password required".

---

## FRO02

**Priority**: High

**Narrative**

As a Front desk user I want to Log out of the system so that my account can be secure.

**Acceptance Criteria**

#### Scenario 1: Log out successful
**Given** the user is logged in as a Staff.  
**When** the user selects the log out tab.  
**Then** the user is taken to the homepage, the user is successfully logged out, and the username is no longer displayed.