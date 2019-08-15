

# OpenApi Generator Kotlin-Example

Usage of openapi-generator to create kotlin-spring interfaces and dtos
from an open-api specification. This method guarantees that your endpoints stick to your openapi definition (documentation-code gap). Additionally, you save some time by just writing the .yaml file.

To generate the classes from the .yaml file use:

```
./gradlew openApiGenerate
```

The generated classes can be found in the build/generated folder.

For additional information about how to set code-generation in your project check the gradle build file.
