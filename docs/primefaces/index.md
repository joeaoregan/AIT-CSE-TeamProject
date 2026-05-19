## PrimeFaces Integration and Usage Guide

### 1. Introduction to PrimeFaces

PrimeFaces is a popular third-party component library for JavaServer Faces (JSF). It runs with JSF2 and provides a collection of rich graphical user interface (GUI) elements used for handling both user input and data output. 

Instead of relying solely on standard JSF components, PrimeFaces allows you to introduce enhanced UI widgets such as:

* Sliders
* Tabbed panels
* Datepickers / Calendars
* Autocomplete inputs

The official website and documentation can be found at [http://primefaces.org/](http://primefaces.org/).

---

### 2. Setting Up PrimeFaces

#### Step 1: Add the Dependency
To get started with PrimeFaces, make certain that the library jar file is added to your project's web libraries folder.

* Download the `primefaces-5.0.jar` file.
* Place it directly into your project's `WEB-INF/lib` folder alongside your core JSF and JSTL jars.

#### Step 2: Declare the XML Namespace
To use PrimeFaces tags within your Facelets (`.xhtml`) pages, you must add the official XML namespace declaration to the root `<html>` element of your view template:

```xhtml
xmlns:p="[http://primefaces.org/ui](http://primefaces.org/ui)"
```

A complete root declaration setup should look like this:

```xhtml
<html xmlns="[http://www.w3.org/1999/xhtml](http://www.w3.org/1999/xhtml)"
      xmlns:h="[http://java.sun.com/jsf/html](http://java.sun.com/jsf/html)"
      xmlns:f="[http://java.sun.com/jsf/core](http://java.sun.com/jsf/core)"
      xmlns:p="[http://primefaces.org/ui](http://primefaces.org/ui)">

```

---

## 3. Core Component Explanations

### A. Calendar Component (`<p:calendar>`)

The `<p:calendar>` component provides an interactive popup or inline calendar widget used to select dates and times.

#### Key Server-Side Behaviour:

- **Automatic Type Conversion:** PrimeFaces input components handle data conversion seamlessly behind the scenes. The calendar component automatically converts the submitted textual date string into a standard Java `java.util.Date` object.

- **No Manual Conversion/Validation Needed:** Because the user selects dates from a pre-formatted calendar GUI layout, input errors are blocked, eliminating the need for custom validator components or error messages for incorrect text entry.

#### Key Attributes:

* `value`: Must point directly to a backing bean property of type `java.util.Date`.
* `mode`: Adjusts the display format. Setting it to `popup` (default value) opens the calendar when clicking the field, while `inline` keeps the calendar permanently visible on the page.
* `showButtonPanel`: A boolean switch (`true` or `false`) that controls whether the **Today** ("Current Date") and **Done** ("Close") operational buttons are displayed at the bottom of the widget.
* `navigator`: A boolean switch (`true` or `false`) that activates dropdown menus allowing users to quickly navigate across months and years instead of clicking arrow buttons.
* `pages`: An integer value specifying how many calendar months should be rendered simultaneously (defaults to `1`).
* `effect`: Specifies an animated transition style used when showing or hiding the component box (e.g., `slide`, `explode`, `fold`, `fadeIn`, `blind`, `bounce`, `drop`, `puff`, `shake`).

#### Collecting Times with Calendar:

The calendar element can also be configured to collect specific time inputs along with or instead of calendar dates:

* `pattern`: Defines a custom parsing rule to control what details are gathered (e.g., `pattern="MM/dd/yyyy HH:mm"` for 24-hour collection, or `pattern="MM/dd/yyyy hh:mm a"` for 12-hour AM/PM selection).
* `timeOnly`: Set this property to `true` if you only want the user to pick a time, completely hiding the date grid panel.
* `minHour` / `maxHour`: Restricts the selectable hourly timeframe options (e.g., limiting business hours between `9` and `18`).

---

### B. Spinner Component (`<p:spinner>`)

[spinners.xhtml](https://github.com/joeaoregan/AIT-CSE-TeamProject/blob/master/Primefaces/WebContent/spinners.xhtml)

A spinner provides an input textbox accompanied by small up and down toggle arrows used to increment or decrement numeric values sequentially.

#### Key Attributes & Behaviours:

* **Automatic Number Conversion:** Text submissions are translated automatically into primitive types or objects on the server side.
* `value`: Binds your layout component field to an explicit backing bean property of type `int`, `Integer`, `double`, or `Double`.
* `min` / `max`: Sets boundaries for the minimum and maximum numeric values permitted inside the control field.
* `stepFactor`: Dictates the stepping interval value change whenever a user clicks an increment/decrement arrow button (defaults to `1`).
* `prefix`: Appends a decorative label format to the front of the displayed string text area (such as a currency symbol like `$` or temperature notation `°F`) without affecting the raw numeric data values processed by Java.

---

### C. Rating Component (`<p:rating>`)

[rating.xhtml](https://github.com/joeaoregan/AIT-CSE-TeamProject/blob/master/Primefaces/WebContent/rating.xhtml)

The `<p:rating>` component represents numeric quantities visually as a horizontal row of clickable stars.

#### Key Attributes & Behaviours:

* **Bidirectional Usage:** Can be left editable to let users assign score ratings, or configured as a non-interactive output field to show predefined calculations.
* **Automatic Bounds Mapping:** Selections automatically map onto matching bounds spanning from `0` up to the max quantity of stars configured.
* `value`: Binds directly onto a bean property of type `int` or `Integer`.
* `stars`: An integer specifying the maximum total capacity of stars to display (defaults to `5`).
* `readonly`: A boolean switch that flags the component as read-only, preventing users from altering the star settings.

---

### D. Password Component (`<p:password>`)

The `<p:password>` widget replaces the standard `<h:inputSecret>` component, providing secure masking alongside helper visual tools.

#### Key Attributes:

* `value`: Binds securely to a plain text backing bean value string.
* `feedback`: A boolean switch (`true` or `false`) that enables an attached popup context window assessing password complexity strength as the user types.
* `promptLabel`, `weakLabel`, `goodLabel`, `strongLabel`: Custom descriptive configuration string messages used to modify the rating feedback gauge indicators.

---

### E. Layout Panels

#### Accordion Panels (`<p:accordionPanel>`)

[accordionpanel.xhtml](https://github.com/joeaoregan/AIT-CSE-TeamProject/blob/master/Primefaces/WebContent/accordionpanel.xhtml)

An accordion presents multi-section data where headers can be clicked to expand or collapse distinct content containers vertically.

* **Static Loading Rule:** In a standard setup, all sub-panel markup content inside the individual `<p:tab>` tags is fetched entirely during the initial page creation request. The text within sections remains frozen unless the root view explicitly gets reloaded.

#### Tab Views (`<p:tabView>`)

A tabbed container organises content sheets horizontally using tabular click options.

* **Implementation Note:** Except for changing the parent outer container block element tag from `<p:accordionPanel>` to `<p:tabView>`, the usage, inner `<p:tab>` sub-tag definitions, and general formatting patterns match exactly.

---

## 4. Modernizing Standard Elements

Every conventional `<h:input>` component has a superior matching choice under the PrimeFaces suite namespace. You can substitute standard items with PrimeFaces alternatives to achieve a richer, consistent look and feel across your application web forms:

| Standard JSF Component | PrimeFaces Enhanced Drop-in Component |
| --- | --- |
| `<h:inputText>` | `<p:inputText>` |
| `<h:commandButton>` | `<p:commandButton>` |
| `<h:inputTextarea>` | `<p:inputTextarea>` |
| `<h:inputSecret>` | `<p:password>` |
| `<h:selectOneMenu>` | `<p:selectOneMenu>` |
| `<h:selectManyMenu>` | `<p:selectManyMenu>` |
| `<h:selectOneRadio>` | `<p:selectOneRadio>` |
