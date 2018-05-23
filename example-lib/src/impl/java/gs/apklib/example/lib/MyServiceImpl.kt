package gs.apklib.example.lib

import java.util.*
import javax.inject.Inject

internal class MyServiceImpl @Inject constructor() : MyService {
    private val random = Random()

    override fun generateData() =
            (0 until (random.nextInt(8) + 4))
                    .map { MyService.Data("text#$it", random.nextLong().toString(16)) }
                    .toList()

}
