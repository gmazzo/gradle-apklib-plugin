package gs.apklib.example.module

import android.support.annotation.Keep

@Keep
interface EntryPoint {

    fun provideMyService(): MyService

}
