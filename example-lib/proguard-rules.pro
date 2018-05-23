-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

-flattenpackagehierarchy ex_lib
-adaptresourcefilecontents
-keep,allowobfuscation class * extends @android.support.annotation.Keep *
