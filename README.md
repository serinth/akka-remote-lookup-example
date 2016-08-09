# akka-remote-lookup-example

There are two "main" programs in here that can be run.

1. Services.EmailSystem
2. RemoteLookup

Simply run with `sbt run` and make the selection.

# Services.EmailSystem

This will start an Akka Actor that listens for an email operation on **127.0.0.1:2552**. Modify the `creator.conf` file to change this.

# RemoteLookup

This will start an Akka Actor that sends an email operation to a remote EmailSystem (Running on a different Host/JVM) on a random port.

Starting both programs in separate terminals should demonstrate this.
