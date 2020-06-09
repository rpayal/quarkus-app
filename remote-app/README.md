# remote-app project

This is run as separate application. Need to compile it in native mode.

## Running the application in dev mode

You can run your application as:
```
./remote-app-1.0-SNAPSHOT-runner -Xmx8m -Xms8m -Xmn8m
```

## Packaging and running the application in native mode
You can compile and packaged to native using GraalVM;
```
mvn package -Pnative
```
It produces the `remote-app-1.0-SNAPSHOT-runner` file in the `/target` directory.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: mvn package -Pnative -Dquarkus.native.container-build=true.


You can run your application as:
```
./remote-app-1.0-SNAPSHOT-runner -Xmx8m -Xms8m -Xmn8m
```