Some OutOutMemoryError Tests

This project uses maven.
This checkout is a valid ${jetty.base} directory too.

To build:

  $ mvn clean install

  This should have created a webapps/oome.war file for you

To run this `${jetty.base}` using an arbitrary jetty home:

  $ java -jar /path/to/jetty-home-9.4.8.v20171121/start.jar

To run with a limited amount of memory (to trigger OOME faster).

  $ java -Xmx64m -jar /path/to/jetty-home-9.4.8.v20171121/start.jar

To test the `-XX:OnOutOfMemoryError="kill -9 %p"` behavior.

  $ java -Xmx64m -XX:OnOutOfMemoryError="kill -9 %p" \
    -jar /path/to/jetty-home-9.4.8.v20171121/start.jar

To trigger OOME:

  $ curl http://localhost:8080/oome/


