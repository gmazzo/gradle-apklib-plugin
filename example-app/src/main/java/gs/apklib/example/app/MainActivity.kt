package gs.apklib.example.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        refresh.setOnRefreshListener { performRefresh() }
    }

    override fun onStart() {
        super.onStart()

        performRefresh()
    }

    private fun performRefresh() {
        TODO("perform refresh!")
    }

}
