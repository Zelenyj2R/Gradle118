plugins {
    id("java")
}
group = "gradle"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.9")
}
tasks.test {
    useJUnitPlatform()
}
tasks.jar {
    archiveFileName.set("myname.jar")
    destinationDirectory.set(file("$rootDir/"))
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    from(configurations.runtimeClasspath.get().filter { it.isDirectory() }.map { it.toPath() })
}
repositories {
    mavenCentral()
}
tasks.test {
    useJUnitPlatform()
}