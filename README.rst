========================
mvn hack
========================

Introduction
-----------------

mvnhack can download libraries from maven2 repositories without maven2.
download mvnhack `here <http://werkzeugkasten.googlecode.com/files/mvnhack-0.0.3.jar>`_.


Requirements
--------------------

JavaSE 6(tested by 1.6.0_17) or more


Usage
---------
    java -jar mvnhack.jar [groupId] [artifactId] [version] flat=[on/off] dest=[path]

* groupId
    * if groupId and artifactId has same id, you skip this.
* artifactId
    * target library's artifactId.
* version
    * target library's version
* flat
    * default is *on*.
    * if you want to get own your local repository only. switch to *off*.
* dest
    * destination directry.
    * default is execution directory.


    java -jar mvnhack.jar [yml]

* yaml
    * get libraries based on yaml. skip this and current dir contains dependencies.yml then use that file.


More Options
==============

VM Arguments
----------------------


