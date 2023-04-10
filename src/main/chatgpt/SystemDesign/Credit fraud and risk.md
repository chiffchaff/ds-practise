> Credit Fraud and Risk Technology

Credit fraud and risk technology refers to the set of tools, techniques, and strategies used by financial institutions and other organizations to prevent and detect fraudulent activity related to credit and financial transactions. This can include analyzing data related to credit card usage, monitoring for suspicious transactions or patterns, and using machine learning and other advanced analytics to identify potential fraudsters. The goal of credit fraud and risk technology is to protect both the financial institution and the consumer from financial loss due to fraudulent activity.

> What is business rules management system (BRMS)

A Business Rules Management System (BRMS) is a software system that enables organizations to define, manage, and automate business rules and decisions. Business rules are the guidelines and criteria that organizations use to make decisions about how to operate their business, such as which products to offer, how to price them, and how to handle customer complaints.
A BRMS allows organizations to capture and manage these business rules in a centralized repository, making it easier to change and update rules without having to modify the underlying application code. This can result in faster time-to-market for new products and services, improved operational efficiency, and better compliance with regulations and policies.
A BRMS typically consists of several components, including a rule repository, a rule engine, and a rule authoring tool. The rule repository is a centralized location for storing and managing business rules. The rule engine evaluates the rules at runtime and makes decisions based on the input data. The rule authoring tool allows business analysts to create and manage rules using a graphical interface, without requiring programming knowledge.
Overall, a BRMS can help organizations to improve decision-making, automate processes, and reduce costs by enabling them to manage and automate their business rules in a more efficient and flexible manner.

> What is IBM ODM (Operational Decision Manager)

IBM ODM (Operational Decision Manager) is a business rules management system (BRMS) that enables organizations to define, manage, and automate business rules and decisions. ODM allows organizations to separate decision logic from the application code, making it easier to change business rules without having to modify the underlying code.
ODM consists of several components, including a rule designer, rule engine, and decision center. The rule designer allows business analysts to create and manage business rules using a graphical interface. The rule engine evaluates the rules at runtime and makes decisions based on the input data. The decision center provides a central repository for managing and deploying the rules.
ODM can be used in a variety of industries and applications, such as finance, insurance, healthcare, and supply chain management. It can help organizations to improve operational efficiency, reduce costs, and mitigate risks by automating and optimizing key business decisions. ODM also supports integration with other IBM products and third-party applications, making it a flexible and scalable solution for businesses of all sizes.

> Rule Designer and Rule Execution Server

Rule Designer and Rule Execution Server are components of IBM ODM that help businesses design, develop, and deploy decision services[1]. Rule Designer is an Eclipse-based development environment that allows developers to edit and debug Java code and rules alongside each other[2]. It is used to begin the development of a decision service by defining a XOM and setting up a vocabulary so that developers can author and orchestrate business rules[2]. Rule Execution Server, on the other hand, provides the runtime environment for running and monitoring decision services[1]. A RuleApp is a deployment and management unit for Rule Execution Server, containing one or more rulesets[3]. RuleApps can be deployed from a decision service deployment configuration[3]. To install Rule Designer and other components of IBM ODM, you must first download and expand the installation files, then select the files in IBM Installation Manager and install the components and associate them with an application server[4].

> What is XOM

In IBM ODM, XOM stands for Execution Object Model. It is the model against which rules are run and references the application objects and data[1][2]. The XOM is the base implementation of the Business Object Model (BOM), which is used to represent the business entities and their relationships[3]. The rule engine can access application objects and methods through the XOM, which can be Java objects, XML data, or data structures[1][2]. When designing a BOM for an XML model, a BOM can be generated directly from the Dynamic XOM[3]. If you want to extend the BOM with business classes and methods, you can then map these business elements to XOM elements by using BOM-to-XOM[3]. When modifying the XOM, the corresponding BOM can be updated by removing the XOM reference from the Business Object Model and Java Execution Object Model, then adding it again[4].
what is the difference between BOM and XOM in IBM ODM
In IBM ODM, BOM stands for Business Object Model, while XOM stands for Execution Object Model. The XOM is the model against which rules are run and references the application objects and data[1][2]. It is the base implementation of the BOM[1][2]. Rule projects reference the XOM, and through the XOM, the rule engine can access application objects and methods, which can be Java objects, XML data, or data structures[1][2]. The BOM, on the other hand, is used to represent the business entities and their relationships[1][2]. If you want to extend the BOM with business classes and methods, you can map these business elements to XOM elements by using BOM-to-XOM[1]. When modifying the XOM, the corresponding BOM can be updated by removing the XOM reference from the Business Object Model and Java Execution Object Model, then adding it again[3].
what is the purpose of BOM and XOM in IBM ODM
The purpose of BOM and XOM in IBM ODM is to provide a way to represent and run rules against business entities and their relationships. The XOM is the model against which rules are run and references the application objects and data, and is the base implementation of the BOM[1][2]. Rule projects reference the XOM, and through the XOM, the rule engine can access application objects and methods, which can be Java objects, XML data, or data structures[2]. The BOM, on the other hand, is used to represent the business entities and their relationships[1][2]. If you want to extend the BOM with business classes and methods, you can map these business elements to XOM elements by using BOM-to-XOM[1]. When modifying the XOM, the corresponding BOM can be updated by removing the XOM reference from the Business Object Model and Java Execution Object Model, then adding it again[3].
![Rules Execution](https://www.ibm.com/docs/en/SS7J8H/com.ibm.odm.dserver.rules.designer.author/designing_bom_images/diag_xom2bom_xml.jpg)
[IBM Operational Decision Manager](https://www.ibm.com/docs/en/odmoc?topic=models-overview-bom-execution-object-model-xom)

> [How does BOM and execution object model (XOM) work](https://www.ibm.com/docs/en/odmoc?topic=models-overview-bom-execution-object-model-xom)
The XOM is the model used to run the rules.

You can build the XOM from different data sources.

The execution object model (XOM) is the model against which you run rules. It references the application objects and data, and is the base implementation of the business object model (BOM). Rule projects reference the XOM.

Through the XOM, the rule engine can access application objects and methods, which can be Java™ objects, XML data, or data from other sources. At run time, rules that were written against the BOM are run against the XOM.
![img_1.png](https://www.ibm.com/docs/en/SS7J8H/com.ibm.odm.dserver.rules.designer.author/designing_bom_images/diag_bom2xom.jpg)