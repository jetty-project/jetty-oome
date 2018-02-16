# HeapDumpOnOutOfMemoryError Example

The following project is laid out to demonstrate the combination of the `jvm` module and the
use of the JVM option `-XX:+HeapDumpOnOutOfMemoryError`

## How to Run Server

There are 2 main ways to run this server.
Both require you to have downloaded the jetty-home tarball (or zip)

You can find that here:

http://central.maven.org/maven2/org/eclipse/jetty/jetty-home/

Unpack the `jetty-home-<version>.tar.gz` (or zip) into a fresh location.

> NOTE: DO NOT CHANGE / EDIT / MODIFY / DELETE / UPDATE / ADD *any content* in this `jetty-home` location.

### Running from command line java

1) `cd` into your `${jetty.base}` directory (the same directory that this readme.md is located)
2) Run the server.

``` shell
$ java -jar /path/to/jetty-home/start.jar
2018-02-16 13:45:03.527:INFO::main: Logging initialized @404ms to org.eclipse.jetty.util.log.StdErrLog
2018-02-16 13:45:03.773:INFO::main: Console stderr/stdout captured to /home/examples/jetty-oome/examples/heapdump-oome-base/logs/2018_02_16.jetty.log
```

3) Using a different console window, trigger the request that will cause a server OOME (Out Of Memory Error)

``` shell
$ curl http://localhost:8080/oome/
```

4) Check your `logs/` directory, you'll see that the OOME occurred.
5) Check your `${jetty.base}` directory, you'll see that the `java_pid<pid>.hprof` was properly generated.
6) Use `Ctrl+C` to stop the server.

### Running from command line `bin/jetty.sh`

1) `cd` into your `${jetty.base}` directory (the same directory that this readme.md is located)
2) Setup the `JETTY_BASE` environment variable

``` shell
$ export JETTY_BASE=$(pwd)
```

3) Run the server.

``` shell
$ /path/to/jetty-home/bin/jetty.sh start
Starting Jetty: 2018-02-16 13:48:04.028:INFO::main: Logging initialized @403ms to org.eclipse.jetty.util.log.StdErrLog
2018-02-16 13:48:04.276:INFO::main: Console stderr/stdout captured to /home/examples/jetty-oome/examples/heapdump-oome-base/logs/2018_02_16.jetty.log
OK Fri Feb 16 07:48:06 STD 2018
```

4) Using a different console window, trigger the request that will cause a server OOME (Out Of Memory Error)

``` shell
$ curl http://localhost:8080/oome/
```

5) Check your `logs/` directory, you'll see that the OOME occurred.
6) Check your `${jetty.base}` directory, you'll see that the `java_pid<pid>.hprof` was properly generated.
7) When you are done, don't forget to stop the server. (use the same console that started the
   server, as it has the `JETTY_BASE` environment variable already setup)

``` shell
$ /path/to/jetty-home/bin/jetty.sh stop
Starting Jetty: 2018-02-16 13:48:04.028:INFO::main: Logging initialized @403ms to org.eclipse.jetty.util.log.StdErrLog
2018-02-16 13:48:04.276:INFO::main: Console stderr/stdout captured to /home/examples/jetty-oome/examples/heapdump-oome-base/logs/2018_02_16.jetty.log
OK Fri Feb 16 07:48:06 STD 2018
```
