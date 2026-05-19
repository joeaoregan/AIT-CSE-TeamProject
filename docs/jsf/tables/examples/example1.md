## Example#1 with tables – A simple table displaying data with style sheet.

```java title="TableData.java" linenums="1"
package com.ait.tables;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TableData {

    private ArrayList<Name> names;

    @PostConstruct
    public void init() {
        names = new ArrayList<Name>();
        Name firstName = new Name("William", "Dupont");
        names.add(firstName);
        Name secondName = new Name("Harry", "Styles");
        names.add(secondName);
        Name thirdName = new Name("Jon", "BonJovi");
        names.add(thirdName);
    }

    public ArrayList<Name> getNames() {
        return names;
    }
}
```

| Last Name | First Name |
| --- | --- |
| Dupont, | Williams, |
| Styles, | Harry, |
| BonJovi, | Jon, |

```java title="Name.java" linenums="1"
package com.ait.tables;

public class Name {
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
```

```xhtml title="tables.xhtml" linenums="1"
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">

<h:head>
    <h:outputStylesheet library="css" name="styles.css" /> </h:head>
<body>
    <h:form>
        <h:dataTable value="#{tableData.names}" var="name"
                     styleClass="nameTable"
                     headerClass="nameTableHeader"
                     rowClasses="nameTableOddRow,nameTableEvenRow">
            <h:column>
                <f:facet name="header">Last Name</f:facet>
                #{name.last},
            </h:column>
            <h:column>
                <f:facet name="header">First Name</f:facet>
                #{name.first},
            </h:column>
        </h:dataTable>
    </h:form>
</body>
</html>
```

```css title="styles.css" linenums="1"
.nameTable{
    border-collapse:collapse;
    border:1px solid #000000;
}

.nameTableHeader{
    text-align:center;
    background:#B5B5B5;
    border-bottom:1px solid #000000;
    padding:2px;
}

.nameTableOddRow{
    text-align:center;
    background: #FFFFFF;
}

.nameTableEvenRow{
    text-align:center;
    background:#D3D3D3;
}
```