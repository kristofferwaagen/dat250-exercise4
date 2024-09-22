plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.hibernate.orm:hibernate-platform:6.6.0.Final"))
    implementation("org.hibernate.orm:hibernate-core")
    implementation("jakarta.transaction:jakarta.transaction-api")
    implementation("com.h2database:h2:2.2.220")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "no.hvl.dat250.jpa.tutorial.basicexample.Main"
}


tasks.named<Test>("test") {
    useJUnitPlatform()
}
