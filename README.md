

# OpenApi Generator Kotlin-Example

Usage of openapi-generator to create kotlin-spring interfaces and dtos
from an open-api specification. This method guarantees that your endpoints stick to your openapi definition (documentation-code gap). Additionally, you save some time by just writing the .yaml file.

To generate the classes from the .yaml file use:

```
./gradlew openApiGenerate
```

The generated classes can be found in the `generated` package - [Link](https://github.com/maschnetwork/openapi-code-generator/tree/master/src/main/kotlin/com/maschnetwork/generator/generated).

For more information on how the code-generation is triggered please refer to the gradle build file.
