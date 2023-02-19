
plugins {
    application // <1>
}

repositories {
    mavenCentral() // <2>
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1") // <3>

    implementation("com.google.guava:guava:31.1-jre") // <4>
}

application {
    mainClass.set("jdbcpracticeprograms.App") // <5>
}

tasks.named<Test>("test") {
    useJUnitPlatform() // <6>
}
