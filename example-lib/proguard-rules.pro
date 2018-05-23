-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

-flattenpackagehierarchy ex_lib
-adaptresourcefilecontents META-INF/services/**
-keep,allowobfuscation class * extends @android.support.annotation.Keep *
