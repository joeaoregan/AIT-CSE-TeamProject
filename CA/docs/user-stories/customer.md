# User Stories: Customers

## CUS09

**Priority**: High

**Narrative**

As a Customer I want to Search the site so that I can see what boats are available, prices and available dates.

**Acceptance Criteria**

### Scenario 1: Customer successfully searched for a boat
**Given** the Customer is not registered or logged in, and the Customer is on the site Homepage.  
**When** in "Search for Boat", the Customer types in "Cruiser".  
**Then** a message is shown "Boat Found", and the Customer can view the boats of the type "cruiser".

### Scenario 2: Customer successfully searched for a boat that doesn’t exist
**Given** the Customer is not registered or logged in, and the Customer is on the site Homepage.  
**When** on "Search for Boat", the Customer types in "anyboat".  
**Then** the Customer receives an error message "Boat Not Found".

---

## CUS10

**Priority**: High

**Narrative**

As a Customer I want to Register on the site so that I can make bookings and return to the system where my details are saved.

**Acceptance Criteria**

#### Scenario 1: User successfully registered
**Given** the Customer is not registered and the Customer is on the Homepage.  
**When** the Customer selects the "Register" tab, enters all their relevant details, and selects "Add User".  
**Then** the Customer is registered on the site, and a message indicates the user has been successfully registered.

#### Scenario 2: User not successfully registered
**Given** the Customer is not registered and the Customer is on the Homepage.  
**When** the Customer selects the "Register" tab, does not enter all their relevant details, and selects "Add User".  
**Then** the Customer is shown an error message "(Field is required)", and the Customer is not successfully registered.

#### Scenario 3: User already registered
**Given** the Customer username is already registered.  
**When** the Customer selects the "Register" tab, enters a pre-existing username along with all other details, and selects "Add User".  
**Then** the Customer is not successfully registered.

#### Scenario 4: Confirm Password does not match
**Given** the Customer is not registered and the Customer is on the Homepage.  
**When** the Customer selects the "Register" tab, enters all relevant details with a new password, enters a wrong password into the "Confirm Password" field, and selects "Add User".  
**Then** the Customer receives an error message "Password 1 should match with Password 2", and the Customer is not registered.

#### Scenario 5: Password is less than 4 characters
**Given** the Customer is not registered and the Customer is on the Homepage.  
**When** the Customer selects the "Register" tab, enters all relevant details with a new password that is less than 4 characters, and selects "Add User".  
**Then** the Customer receives an error message "Password must be 4 or more characters", and the Customer is not registered.

---

## CUS11

**Priority**: High

**Narrative**

As a Customer I want to Login to the site so that I can book a boat.

**Acceptance Criteria**

#### Scenario 1: Customer successfully logged in
**Given** the Customer is registered and on the Homepage.  
**When** the Customer selects the "Login" tab, enters a valid username and password, and selects "Login".  
**Then** the Customer is taken to the customer landing page and is successfully logged in.

#### Scenario 2: Customer username invalid
**Given** the Customer is registered and on the Homepage.  
**When** the Customer selects the "Login" tab, enters an invalid username and a valid password, and selects "Login".  
**Then** the page refreshes to prompt the User to try again, and the user is not successfully logged in.

#### Scenario 3: Password is incorrect
**Given** the Customer is registered and on the Homepage.  
**When** the Customer selects the "Login" tab, enters a valid username and an invalid password, and selects "Login".  
**Then** the page refreshes to prompt the User to try again, and the user is not successfully logged in.

---

## CUS01

**Priority**: High

**Narrative**

As a Customer I want to select a boat so that I can book a boat for any number of days.

**Acceptance Criteria**

#### Scenario 1: One Boat type successfully selected
**Given** the Customer is logged in.  
**When** the Customer selects "Book Online", chooses the "Cruiser" button, enters 1 in "Quantity Required", enters 1 in "Number of Days", and clicks "Select Boat".  
**Then** the Customer successfully adds 1 Cruiser to their cart for 1 day, and one boat type is successfully selected.

#### Scenario 2: User selects multiples of one boat type successfully
**Given** the Customer is logged in.  
**When** the Customer selects "Book Online", chooses the "Cruiser" button, enters 1 in "Quantity Required", enters 3 in "Number of Days", and clicks "Select Boat".  
**Then** the Customer successfully adds 3 Cruisers to their cart for 1 day, and the boat types are successfully selected.

#### Scenario 3: User selects a boat type but no quantity
**Given** the Customer is logged in.  
**When** the user selects "Book a Boat", chooses "Yacht", sets a quantity of 0, and clicks "Add to cart".  
**Then** the user is shown the message "please select a quantity", and the boat is not successfully selected.

---

## CUS07

**Priority**: High

**Narrative**

As a Customer I want to Pay a deposit so that I can confirm my booking.

**Acceptance Criteria**

#### Scenario 1: Deposit successfully paid
**Given** the user is logged in as a customer and the user has selected a boat, quantity, and number of days via "Book on line".  
**When** the user selects "Select Boat" and enters correct payment information on the shopping cart landing page displaying the total and deposit amount due.  
**Then** the deposit is successfully paid.

#### Scenario 2: Deposit not successfully paid
**Given** the user is logged in as a customer and the user has selected a boat, quantity, and number of days via "Book on line".  
**When** the user selects "Select Boat", clicks "Confirm my booking", and enters incorrect payment information on the shopping cart landing page showing the total and deposit amount due.  
**Then** the deposit is not successfully paid.

---

## CUS12

**Priority**: High

**Narrative**

As a Customer I want to Log out of the system so that no one can access my details.

**Acceptance Criteria**

#### Scenario 1: Log out successful
**Given** the user is logged in as a customer.  
**When** the user selects log out.  
**Then** the user is taken to the homepage, the user is successfully logged out, and the username is no longer displayed.
