plugins {
    java
    `jvm-test-suite`
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

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

tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events("passed", "failed")
    }
}

testing {
    suites {

        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project())
                implementation("org.springframework.boot:spring-boot-starter-web")
                implementation("org.springframework.boot:spring-boot-starter-test")
            }
        }

        register<JvmTestSuite>("systemTest") {
            dependencies {
                implementation(project())
                implementation("io.rest-assured:rest-assured:5.3.2")

            }
        }
    }
}