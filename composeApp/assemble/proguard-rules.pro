-keep class io.ktor.** { *; }
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }
-keep class kotlinx.coroutines.** { *; }
-keep class org.jetbrains.skia.** { *; }
-keep class org.jetbrains.skiko.** { *; }

-dontwarn kotlinx.**
-dontwarn org.slf4j.**
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn java.lang.management.ManagementFactory
-dontwarn java.lang.management.RuntimeMXBean

-keep,includedescriptorclasses class com.example.testapp.**$$serializer { *; }
-keepclassmembers class com.example.testapp.** {
    *** Companion;
}
-keepclasseswithmembers class com.example.testapp.** {
    kotlinx.serialization.KSerializer serializer(...);
}
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}
-if @kotlinx.serialization.Serializable class ** {
    static **$* *;
}
-keepclassmembers class <2>$<3> {
    kotlinx.serialization.KSerializer serializer(...);
}
-if @kotlinx.serialization.Serializable class ** {
    public static ** INSTANCE;
}
-keepclassmembers class <1> {
    public static <1> INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-dontnote kotlinx.serialization.SerializationKt
