# User Stories: Manager

## STM28

**Priority**: High

**Narrative**

As a Manager, I want to login to the system, so that I can access my account.

**Acceptance Criteria**

#### Scenario 1: All Login details are correct

**Given** the manager is registered on the system.   
**When** the manager has entered a valid user name, entered a correct password, and clicks "Login".   
**Then** the Manager is taken to the managers landing page, the manager is logged in, and a message is shown "Manager successfully logged in"

#### Scenario 2: Username is incorrect

**Given** the manager is registered on the system, has entered an incorrect user name, and entered a correct password.  
**When** the Manager enters the login information of an incorrect user name and correct password.  
**Then** the manager is not taken to the managers landing page, is not logged in, and receives an error message.

#### Scenario 3: Password is incorrect
**Given** the Manager is registered on the system, has entered a valid user name, and entered an incorrect password.  
**When** the Manager enters the login information of a valid user name and incorrect password.  
**Then** the Manager is not taken to the managers landing page, is not logged in, and an error message of "Incorrect password" appears.

#### Scenario 4: User does not enter password
**Given** the Manager is registered on the system and has entered a valid username.  
**When** the Manager selects "Login".  
**Then** the Manager receives a message "Password required".

#### Scenario 5: User does not enter username
**Given** the Manager is registered on the system and has entered a valid password.  
**When** the Manager selects "Login".  
**Then** the Manager receives a message "username required".

#### Scenario 6: Manager leaves username and password fields blank
**Given** the Manager is registered on the system and leaves username and password fields blank.  
**When** the Manager selects "Login".  
**Then** the Manager receives a message "username required" and "password required".

---

## STM06

**Priority**: High

**Narrative**

As a Manager, I want to Add boats to inventory, so that I can create lists of Boats for users to view.

**Acceptance Criteria**

#### Scenario 1: Boat successfully added to inventory
**Given** the Manager is logged in.  
**When** the Manager selects "Manage Inventory", enters all fields of boat information on the inventory page, and clicks "Add New Boat".  
**Then** the Boat is successfully added to the Current Inventory table.

#### Scenario 2: Boat information not complete
**Given** the Manager is logged in.  
**When** the Manager selects "Manage Inventory", does not fill all fields of boat information on the inventory page, and selects the "Add New Boat" button.  
**Then** a message "(Field name) is required" appears, and the boat is not added to inventory.

#### Scenario 3: Boat information already exists
**Given** the Manager is logged in and the boat information is already added to the inventory list.  
**When** the Manager selects "Manage Inventory", fills all fields of boat information with details of a boat already listed, and selects the "Add boat to inventory" button.  
**Then** the boat is not added to inventory.

---

## STM08

**Priority**: High

**Narrative**

As a Manager, I want to view boats in inventory, so that I can see what boats are listed.

**Acceptance Criteria**

#### Scenario 1: Successfully view boats added to inventory
**Given** the Manager is logged in and boats have been added to the inventory.  
**When** the Manager selects "Manage Inventory" and scrolls to "Current Boat Inventory".  
**Then** the Manager can view the current Boat Inventory.

#### Scenario 2: Boat inventory empty
**Given** the Manager is logged in and no boats have been added to the inventory.  
**When** the Manager deletes default Boats stored in Inventory and scrolls to "Current Boat Inventory".  
**Then** the "Current Boat Inventory" list is empty.

---

## STM14

**Priority**: High

**Narrative**

As a Manager I want to Add prices to boats/inventory so that I can update prices for customers.

**Acceptance Criteria**

#### Scenario 1: Successfully update prices
**Given** the Manager is logged in.  
**When** the Manager selects "Manage Pricing", fills all required fields on the Manage Pricing page, and selects "Add Pricing Structure".  
**Then** the Manager can see the boat and price added to the "Current Pricing Structures" table.

#### Scenario 2: Boat inventory empty and no prices to show
**Given** the Manager is logged in and no boats have been added to the inventory.  
**When** the Manager selects "Manage Pricing" and clicks the Boat Name dropdown list.  
**Then** no boats are shown.

---

## STM16

**Priority**: High

**Narrative**

As a Manager I want to View prices added to boats/inventory so that I can view prices visible to our customers.

**Acceptance Criteria**

#### Scenario 1: Successfully view updated prices
**Given** the Manager is logged in and boats have been added to the inventory.  
**When** the Manager selects "Manage Pricing".  
**Then** the Manager is taken to the "Manage Pricing" page and can view the boat and price added to the "Current Pricing Structures" table.

#### Scenario 2: View No Boats in Inventory
**Given** the Manager is logged in and no boats have been added to the inventory.  
**When** the Manager selects "Manage Pricing" and clicks the Boat Name dropdown list.  
**Then** no boats are shown.

---

## STM01

**Priority**: High

**Narrative**

As a Manager I want to Create employee accounts so that they can login.

**Acceptance Criteria**

#### Scenario 1: Employee account successfully created
**Given** the Manager is logged in.  
**When** the Manager selects "Manage Users", fills in all relevant information on the employee, and selects "Add User".  
**Then** the Manager views the New User in the table below.

#### Scenario 2: Employee already exists
**Given** the Manager is logged in and the employee username has already been added to the system.  
**When** the Manager selects "Manage Users" and enters an employee username that is already in use.  
**Then** the employee account is not created.

#### Scenario 3: Employee details not filled
**Given** the Manager is logged in.  
**When** the Manager selects "Manage Users" and does not complete all fields in the form.  
**Then** the user is shown a message with the relevant field that is incomplete: "(Field name) is required", and the employee account is not created.

---

## STM07

**Priority**: High

**Narrative**

As a Manager I want to Delete a boat so that I can remove boats no longer necessary from the boat inventory.

**Acceptance Criteria**

#### Scenario 1: Boat successfully deleted
**Given** the user is logged in as a Manager.  
**When** the Manager selects "Manage Inventory" and chooses a boat and selects "Remove".  
**Then** the boat is deleted from the current boat inventory.

#### Scenario 2: No boats to delete
**Given** the user is logged in as a Manager.  
**When** the Manager selects "Manage Inventory" and selects "Remove boat" until all boats are removed.  
**Then** the table of boats is empty.

---

## STM09

**Priority**: High

**Narrative**

As a Manager I want to edit boat details so that I can be certain the information is correct.

**Acceptance Criteria**

#### Scenario 1: Boat type successfully changed
**Given** the user is logged in as a Manager and boats have been added to the inventory.  
**When** the user selects "Manage Inventory", selects "Edit" in Boat Inventory, and adds or removes boats as desired.  
**Then** the boat type is successfully changed as shown in the Inventory table.

#### Scenario 2: Boat quantity successfully changed
**Given** the user is logged in as a Manager and boats have been added to the inventory.  
**When** the user selects "Edit Boat", edits the "Boat Quantity", and selects "Save Changes".  
**Then** the boat quantity is successfully changed and shown in the table.

---

## STM15

**Priority**: High

**Narrative**

As a Manager I want to Delete boat prices so that I can remove incorrect prices.

**Acceptance Criteria**

#### Scenario 1: Manager deletes boat pricing successfully
**Given** the Manager is logged in and the Manager has added a pricing structure.  
**When** the Manager selects "Manage Pricing" and selects "Remove" from the current prices structure table.  
**Then** the current price structure table is updated.

---

## STM17

**Priority**: High

**Narrative**

As a Manager I want to Edit pricing so that I can make certain prices are up to date.

**Acceptance Criteria**

#### Scenario 1: Edit pricing structure currently on site
**Given** the user is logged in as a Manager and pricing structures have been added to the site.  
**When** the user selects "Manage Pricing" and adjusts the pricing structures as necessary.  
**Then** the pricing structure is successfully changed as shown in the table.

#### Scenario 2: Edit pricing structure not currently on site
**Given** the user is logged in as a Manager and pricing structures have not been added to the site.   
**When** the user selects "Manage Pricing".  
**Then** the "Current Pricing Structure" table is empty.

---

## STM29

**Priority**: High

**Narrative**

As a Manager I want to Log out of the system so that my account can be secure.

**Acceptance Criteria**

#### Scenario 1: Log out successful
**Given** the user is logged in as a Manager.  
**When** the user selects the log out tab.  
**Then** the user is taken to the homepage, the user is successfully logged out, and the username is no longer displayed.
