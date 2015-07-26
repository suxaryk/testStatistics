# testStatistics
The task is to create a program, which gather statistics about tests in some
Java project.
Input parameter for the program should be directory with tests. The
program should scan all files in that directory and its subdirectories and create list
of all files with name *Test.java
The program should run all found classes one by one using Ant. Ant target
“java” or “junit” can be used.
The results of the tests should be saved into database (PostgreSQLor
MySQL). Each row should correspond to one java class. Results should include the
following data:
- name of the java class with tests;
- date and time when tests in the class were run;
- tests result (passed or failed);
- duration of executing the tests (from Ant output);
- description. Should be empty if all tests in class succeeded; if one or
more tests failed then description should contain failures and/or error
messages.
As a source of the tests any own or opensource project with junit4 tests can
be used.Example: https://commons.apache.org/proper/commons-
codec/archives/1.9/testapidocs/src-html/org/apache/commons/codec/
