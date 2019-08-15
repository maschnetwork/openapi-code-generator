import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springVersion by extra("2.1.6.RELEASE")
val baseKotlinDir = "src/main/kotlin"
val openApiOutput = "$buildDir/generated/"

group = "com.maschnetwork"

plugins {
    val kotlinVersion = "1.3.41"
    id("org.springframework.boot") version "2.1.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("org.openapi.generator") version "4.0.3"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}

apply(plugin = "maven")
apply(plugin = "java")
apply(plugin = "kotlin")
apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.rest-assured:rest-assured:4.0.0")
    testImplementation("io.rest-assured:rest-assured-all:4.0.0")
}


//Add generated classes to the classpath, otherwise you cannot access them
sourceSets {
    main {
        withConvention(KotlinSourceSet::class) {
            kotlin.setSrcDirs(listOf("src/main/kotlin", openApiOutput + baseKotlinDir))
        }
    }
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    packageName.set("com.maschnetwork.generator.generated")
    outputDir.set(openApiOutput)
    inputSpec.set("./docs/openapi.yaml")
    ignoreFileOverride.set("./docs/.openapi-generator-ignore")
    modelNameSuffix.set("DTO")
    configOptions.set(mapOf(
        "enumPropertyNaming" to "UPPERCASE",
        "interfaceOnly" to "true"
    ))
    systemProperties.set(
        mapOf(
            "models" to "",
            "apis" to ""))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
    //generateOpenApi Objects at compile-time
    dependsOn(tasks.openApiGenerate)
}
