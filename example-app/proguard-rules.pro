-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

-dontwarn dagger.**

# required to garantee that all Kotlin and Dagger classes will be avaiable for the Library once is loaded into the main APK
# this is what happens when you mess with the Zohan, I mean, ProGuard
-keep class kotlin.**, dagger.**, javax.inject.** { *; }
