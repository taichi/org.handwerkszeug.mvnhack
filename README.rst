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

==========
More Options
==========

VM Arguments
----------------------
* proxy
    * Proxy URL. auto detect HTTP or SOCKS proxy.
    * cf. [http://java.sun.com/j2se/1.5.0/docs/guide/net/properties.html Networking Properties]
* repository
    * comma separated maven2 remote/local additional repository URLs.

Implicit Repositories
-----------------------------
* if execution directory has directory that name is *repository*, use as local repository.
* if directory of *user.home* has m2/repository, use it.
* [http://repo1.maven.org/maven2/ maven central repository]

==========
Examples 
==========
    java -jar mvnhack-0.0.2.jar commons-httpclient 2.0.2

you get commons-httpclient-2.0.2.jar ,commons-logging-1.0.3.jar and some source.jars into execution directory.
in this case,

* *groupId* is skipped
* *artifactId* is commons-httpclient
* *version* is 2.0.2
* you will be get two kind of artifacts, because commons-httpclient depends commons-logging.

------------

    java -jar mvnhack-0.0.2.jar org.slf4j slf4j-simple 1.4.3 flat=off dest=./foo

you get slf4j-simple-1.4.3.jar ,slf4j-api-1.4.3.jar and some source.jars into execution directory.

in this case,
* *groupId* is org.slf4j
* *artifactId* is slf4j-simple
* *version* is 1.4.3
* *flat* is off
* *destination* jars are under ./foo with repository structures.
* you will be get two kind of artifacts, because slf4j-simple depends slf4j-api.

------------

    java -Dproxy=http://proxy.example.com:8080 -Drepository=http://public.planetmirror.com/pub/maven/, -jar mvnhack-0.0.2.jar commons-httpclient 2.0.2

this case, use HTTP proxy access to remote repositories and use addtional repository.

------------

dependencies.yml example.


    flatten : true
    destination : ./lib
    proxy : http://proxy.example.com:8080
    http.nonProxyHosts : localhost

    repositories :
      - http://repository.codehaus.org/
      - https://repository.jboss.org/nexus/content/repositories/releases/

    dependencies :
      - org.yaml snakeyaml 1.8
