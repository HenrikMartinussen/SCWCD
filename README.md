# README #

This README to some extent document whatever steps are necessary to get going experimenting with Servlets/JSP.

### What is this repository for? ###

* Examples and experiments for learning enough Servlet and JSP to pass the SCWCD test
* Experiments, demonstrations, etc. with api's, technologies and other issues in the Servlet JSP domain

### How do I get set up? ###

* You'll obviously need Java - I recently started using jdk version 1.7.0_71. Most examples are configured to use version 1.5 or 1.6
* Most examples are Maven 2/3 based, a few uses gradle, so you'll definitely need latest maven version, and latest gradle version.
* A few experiments use Ant for creating, starting, populating databases, so you'll probably need that too.
* Most projects don't rely on any specific IDE. Even though i mostly use Eclipse, maven or gradle buildfiles should be able to be used as is, or as basis for generated project files
* A few projects use databases, Sql Server express is my preferred "heavy duty" RDBMS - some experiments use HSQLDB in various versions. Sql Server must be set up by hand - HSQLDB experiments use in memory or "install-while-build" databases. Details are in the various local readme's
* Also in the various local readme's are examples of build/test commands and URL's to hit for results.

### Contribution guidelines ###

* You are free to copy any and all code you find useful. 
* If you have an opinion on anything (code, tests, builds, documentation etc.) don't be shy...
* If you have hints to get any of the incomplete dead-end projects/experiments going, I would be happy to hear from you.

### Who do I talk to? ###

* Henrik Martinussen