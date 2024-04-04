plugins {
	java
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.freefair.lombok") version "6.3.0"

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
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.4")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("org.mapstruct:mapstruct:1.4.2.Final")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.4.2.Final")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder = "paketobuildpacks/builder-jammy-base:latest"
}
