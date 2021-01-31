# Courgette-JVM with Custom Class Path Example

In Windows operating systems, you may come across the following error when using Courgette:

````
java.io.IOException: Cannot run program "java": CreateProcess error=206, The filename or extension is too long
````

There is a 32k command length limit for the `CreateProcess` on Windows operating systems that causes Courgette to fail with the above exception. 

When your project includes a lot of dependencies, these dependencies are added to the class path which may exceed the 32k command length limit that causes the `CreateProcess` error to be thrown.

Read more [here](https://devblogs.microsoft.com/oldnewthing/?p=41553)

## Courgette Class Path Option

Courgette now includes a `classPath` option to workaround the 32k length limit on Windows. 

This option would allow you to provide a custom class path that Courgette would use to run your Cucumber tests instead of using the `java.class.path` provided by the JVM.

This will reduce the class path for the project and _should_ workaround the Windows limitation.

## How to set up your project?

1. Configure your Courgette runner to use a custom class path by setting the `classPath` Courgette option.
   

2. Copy all project dependencies (JARs) to a directory (_preferably the build directory_)
   

3. Courgette will then use the JARs in the directory above to build a custom class path before running the Cucumber tests.

````java
@CourgetteOptions(
      ...  
      classPath = { "path-to-project-jars", "path-to-test-classes" },
      cucumberOptions = @CucumberOptions(
           // cucumber options here
      )
)
````

## Gradle Example

Run the following Gradle task in the `courgette-jvm-gradle` project:

````
 gradle runTest
````

This task will copy the project dependencies to the `build\libs` directory and then invoke the Courgette runner.


## Maven Example

Run the following Maven goal in the `courgette-jvm-maven` project:

````
 mvn test
````

This goal uses the `maven-dependency-plugin` to copy the project dependencies to the `target\libs` directory and then uses the `maven-surefire-plugin` to invoke the Courgette runner.

