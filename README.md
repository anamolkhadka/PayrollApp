# Payroll Java Application

This is a Java Payroll Application that calculates payroll information for Full-time, Part-time, and Contract employees.

## Software Development Process
- Agile Unified Development.

## Software Design Patterns
- Controller, Expert, Visitor, and Iterator patterns.

## Introduction
Companies hire different types of employee including:

- Full-time employee. Full-time employees work 40 hours a week and are
typically paid on a salary basis (or gross income) that does not change
during the year. They may also have access to benefits provided by the
company, like healthcare coverage and 401(k). The payroll for a full-time
employee is computed by using the following formula:
Period pay=(gross income - healthcare deduction - 401(k) deduction) * (1
- tax withholding rate)
where gross income, healthcare deduction, 401(k) deduction and tax withholding
rate are different for different employees.

- Part-time employee. Part-time employees usually work less than 30 hours
per week and are paid hourly. The payroll for a part-time employee is
calculated as follows:
Period pay=hourly rate * hours worked * (1 - tax withholding rate)
where hourly rate, hours worked and tax withholding rate are different for
different employees.

- Contract employee. Contract employees are hired for a specified period
of time outlined in a contract. The number of work hours for a contract
employee may vary for each contract, but they are not limited to 40 hours
per week. The payroll for a contract employee is computed as follows:
Period pay=contract total/(contract period/length of pay interval)
where contract total and contract period are different for different contract
employees, and the length of pay interval is assumed to be monthly. For
example, if the contract total is $240,000 and the contract period is 2
years, then the period pay or monthly pay is
Period pay=$240,000 / (24 months / 1 month) = $10,000

This individual homework assignment requires the student to apply the controller
pattern, visitor pattern, the expert pattern, and the iterator pattern
to design a simple application. When the application is launched, it shows a
window with buttons and/or menu items for doing the following functions and
display the results. You can assume that a collection of all employees is created
and initialized when the application starts. The application must provide the
following functionalities:

- Show Payroll for all of the employees. That is, it computes and displays
the payroll for all of the employees. Hint: you apply the expert pattern
and iterator pattern here — that is, each employee object computes its
payroll.

- Show Payroll Averages for full-time, part-time and contract employees,
respectively. That is, it computes and displays three averages, one for fulltime,
one for part-time and one for contract employees. Hint: you apply
the visitor pattern and iterator pattern here. Although you could use one
visitor to do this and the next function, but the “separation of concerns”
design principle suggests that one should use separate visitors for different
functions; otherwise, the result would be a low-cohesion design.

- Show Payroll Ranges (i.e., minimal and maximal pays) for full-time, parttime
and contract employees, respectively. That is, it computes and displays
three payroll ranges, one for full-time, one for part-time and one for
contract employees. Hint: see the hint for the previous work item.

## What to Do, Product and Submit

This individual homework assignment requires the student to produce and submit
the following work items on Canvas by the deadline. The work items have
equal weights. Note: the GTA may require students to follow specific submission
instructions.

1. Domain-modeling brainstorming. Apply the 9 domain-modeling brainstorming
rules to the description provided in the Introduction section of
this document to identify domain-specific concepts for this application.
Submit the brainstorming result. The brainstorming result can be the
texts in the Introduction section with domain-specific phrases identified
and highlighted as shown in the class or book, or lists of domain-specific
phrases identified.

2. Classifying brainstorming result. Apply the domain-modeling classification
rules to classify the domain-specific phrases identified above into
classes, attributes of classes and relationships (inheritance, aggregation
and association) between the classes.
Submit the classification result. The classification result can be lists of
classes with attributes and relationships between the classes, or indications
of these in the texts with the phrases highlighted.

3. Converting the classification result to a domain model class diagram (DMCD).
Submit the DMCD.

4. Producing two expanded use cases, one for Show Payroll (for all employees),
and the other for Show Pay Ranges.

5. Producing a structural design to apply the expert and visitor patterns.
The structural design is a UML class diagram. Hint: to apply the visitor
pattern, you may copy and paste the structural design template of the
visitor patter, and replace the class names, attributes and methods with
this application-specific names, attributes and methods.

6. Producing scenarios for the nontrivial steps of above two expanded use
cases. Your scenarios must apply, whenever appropriate and applicable,
the controller, expert, iterator and visitor patterns. When applying the
expert and/or the visitor patterns, you need to refer to the pattern classes
in the structural design you produced above.

7. Converting above scenarios to informal sequence diagrams. Indicate the
patterns applied in the informal sequence diagrams.

8. Converting above informal sequence diagrams to design sequence diagrams.
Indicate the patterns applied in the design sequence diagram.

9. Deriving a design class diagram (DCD) from above design sequence diagrams.
    
10. Implement your design in Java. Create a collection of 9 different employees,
of which 3 are full-time, 3 are part-time and 3 are contract-employees.
Compute and display the payrolls as well as the payroll ranges for the collection
of employees. Submit the Java code as well as the computation
result.
