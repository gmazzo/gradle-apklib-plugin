package gs.apklib.example.app

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerAppCompatActivity
import gs.apklib.example.lib.MyService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_item.view.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var myService: MyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        refresh.setOnRefreshListener { performRefresh() }
        recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onStart() {
        super.onStart()

        performRefresh()
    }

    private fun performRefresh() {
        recycler.adapter = DataAdapter(myService.generateData())
        refresh.isRefreshing = false
    }

    class DataAdapter(private val items: List<MyService.Data>) : RecyclerView.Adapter<DataViewHolder>() {

        override fun getItemCount() = items.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                DataViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_item, parent, false))

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.bind(items[position])
        }

    }

    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: MyService.Data) {
            itemView.text1.text = item.text1
            itemView.text2.text = item.text2
        }

    }

}
