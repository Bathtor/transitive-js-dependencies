
*ARCHIVED: Invalid issue. See correct example in `fixed-version` branch.*

# Transitive Scala.js js-dependencies Example

In this project the [library-part](library-part/) contains a file with native Javascript code included with [jsdependencies](https://github.com/scala-js/jsdependencies) and a Scala.js facade class for it. The test case shows that readin the version string from the Javascript code works within the project.

In [application-part](application-part) we are trying to use [library-part](library-part/) as a dependency.
~~Trying to access the Javascript value here fails with the same test setup. Furthermore, when running `fastOptJS` no dependency file is generated.~~ *Update: The `fixed-version` branch contains a correct example of how to do this. The [jsdependencies](https://github.com/scala-js/jsdependencies) plugin must be present in the application-part, too!*

## Steps to Reproduce

1. `cd library-part` and then `sbt`
2. `test` (this works)
3. `publishLocal`
4. `exit` sbt
5. `cd ../application-part` and then `sbt`
6. `test` (this fails)
7. `fastOptJS` (succeeds, but does not generate file with dependencies to include in `index-dev.html`)
