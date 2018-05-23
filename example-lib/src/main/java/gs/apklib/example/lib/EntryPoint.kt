package gs.apklib.example.lib

import android.support.annotation.Keep

@Keep
interface EntryPoint {

    fun provideMyService(): MyService

}
