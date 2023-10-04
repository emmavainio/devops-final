plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
    id("jacoco")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

jacoco {
    toolVersion = "0.8.10"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.rest-assured:rest-assured:5.3.2")
}

sourceSets {
    create("integrationTest") {
        java.srcDir("src/integrationTest/java")
        compileClasspath += sourceSets["main"].output + sourceSets["test"].output
        runtimeClasspath += sourceSets["main"].output + sourceSets["test"].output
    }
    create("systemTest") {
        java.srcDir("src/systemTest/java")
    }
}

configurations {
    named("integrationTestImplementation") {
        extendsFrom(configurations["testImplementation"])
    }
    named("integrationTestRuntimeOnly") {
        extendsFrom(configurations["testRuntimeOnly"])
    }
    named("systemTestImplementation") {
        extendsFrom(configurations["testImplementation"])
    }
    named("systemTestRuntimeOnly") {
        extendsFrom(configurations["testRuntimeOnly"])
    }
}

tasks.register<Test>("integrationTest") {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath
}

tasks.register<Test>("systemTest") {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
    testClassesDirs = sourceSets["systemTest"].output.classesDirs
    classpath = sourceSets["systemTest"].runtimeClasspath
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
    finalizedBy("jacocoTestReport")
}

tasks.named<JacocoReport>("jacocoTestReport") {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}
