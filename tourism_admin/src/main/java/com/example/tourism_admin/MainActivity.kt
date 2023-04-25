package com.example.tourism_admin



import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourism_admin.databinding.ActivityMainBinding
import com.google.firebase.database.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var databaseReference: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<DataClass>()
    private lateinit var adapter: locationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerView

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this);

        addDataToList()
        adapter = locationsAdapter(mList)
        recyclerView.adapter = adapter

        //Setting onclick on recyclerView each item
        adapter.setOnItemClickListner(object : locationsAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
            }

        })


        /*val gridLayoutManager = GridLayoutManager(this@MainActivity, 1)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.search.clearFocus()

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()

        dataList = ArrayList()
        adapter = MyAdapter(this@MainActivity, dataList)
        binding.recyclerView.adapter = adapter
        //databaseReference = FirebaseDatabase.getInstance().getReference("Todo List")
        dialog.show()

        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataClass::class.java)
                    if (dataClass != null) {
                        dataList.add(dataClass)
                    }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }
        })

        binding.fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, UploadActivity::class.java)
            startActivity(intent)
        })

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })
    }
    fun searchList(text: String) {
        val searchList = ArrayList<DataClass>()
        for (dataClass in dataList) {
            if (dataClass.locationTitle?.lowercase()
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }*/
    }

    private fun addDataToList() {
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))
        mList.add(DataClass("", "Sigiriya", " csjhc jhsd jvk", "4",))

    }

}
