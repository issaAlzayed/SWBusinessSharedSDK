import com.android.testing.utils.isTvOrAutoSource
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    `maven-publish`
}

val libGroupId = "com.neomena.lulu-networking"
val libArtifactId = "lulu-networking"
val libVersion = "0.0.5"
val properties = Properties()
properties.load(FileInputStream(project.rootProject.file("local.properties")))

publishing {
    publications {
        group = libGroupId
        register<MavenPublication>("androidRelease") {
            from(components["kotlin"])
            groupId = libGroupId
            artifactId = "$libArtifactId-android"
            version = libVersion
        }
        register<MavenPublication>("iosRelease") {
            from(components["kotlin"])
            groupId = libGroupId
            artifactId = "$libArtifactId-ios"
            version = libVersion
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/alimkldneo/lulu-networking")

            credentials {
                username = properties.getProperty("gpr.user")
                password = properties.getProperty("gpr.token")
            }
        }
    }
}

kotlin {
    explicitApi()
    androidTarget {
        publishLibraryVariants("release")
        publishLibraryVariantsGroupedByFlavor = true
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosSimulatorArm64 {
        binaries {
            framework {
                baseName = "SWBusinessSharedSDK"
            }
        }
    }

    iosX64 {
        binaries {
            framework {
                baseName = "SWBusinessSharedSDK"
            }
        }
    }

    iosArm64 {
        binaries {
            framework {
                baseName = "SWBusinessSharedSDK"
            }
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.neomena.lulunetworking"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    publishing {
        setGroup(libGroupId)
        version = libVersion
    }
}