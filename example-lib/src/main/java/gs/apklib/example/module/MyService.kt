package gs.apklib.example.module

import android.support.annotation.Keep

@Keep
interface MyService {

    fun generateData(): List<Data>

    @Keep
    data class Data(val text1: CharSequence, val text2: CharSequence)

}
