package gs.apklib.example.module

interface MyService {

    fun generateData(): List<Data>

    data class Data(val text1: CharSequence, val text2: CharSequence)

}
