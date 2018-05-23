package gs.apklib.example.app

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dalvik.system.DexClassLoader
import gs.apklib.example.lib.EntryPoint
import java.io.File
import java.util.*

@Module
class MyServiceModule {

    @Provides
    @Reusable
    fun provideMyService(entryPoint: EntryPoint) =
            entryPoint.provideMyService()

    @Provides
    @Reusable
    fun provideEntryPoint(context: Context): EntryPoint {
        val file = File(context.cacheDir, BuildConfig.APKLIB_FILENAME).apply {
            outputStream().use {
                context.assets.open(BuildConfig.APKLIB_FILENAME).copyTo(it)
            }
        }

        Thread.currentThread().let { thread ->
            val parent = thread.contextClassLoader

            try {
                thread.contextClassLoader = DexClassLoader(
                        file.absolutePath,
                        File(context.cacheDir, "dex").absolutePath,
                        null, parent)

                return ServiceLoader.load(EntryPoint::class.java).iterator().next()

            } finally {
                thread.contextClassLoader = parent
            }
        }
    }

}
