package com.example.apifetch_23_09.Activity

import GridData
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apifetch_23_09.Adapter.GrideAdapter
import com.example.apifetch_23_09.Adapter.QuicktaskAdapter
import com.example.apifetch_23_09.Adapter.SingleSliderAdapter
import com.example.apifetch_23_09.Adapter.singleBigTaskAdapter
import com.example.apifetch_23_09.Adapter.taskListAdapter
import com.example.apifetch_23_09.Class.GridCallApi
import com.example.apifetch_23_09.Class.RequestClass
import com.example.apifetch_23_09.DatabaseHelper
import com.example.apifetch_23_09.Model.Data
import com.example.apifetch_23_09.Model.GridDataModel
import com.example.apifetch_23_09.Model.MainData
import com.example.apifetch_23_09.NetworkAccess
import com.example.apifetch_23_09.R
import com.google.android.material.navigation.NavigationView
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mainRCV: RecyclerView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var mainLayout: LinearLayout
    private lateinit var gridApi: GridCallApi
    lateinit var db: DatabaseHelper
    var isGridApiInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainLayout = findViewById(R.id.Main_layout)
        navigationView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.my_drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        db = DatabaseHelper(this)

        val checkForInternet = NetworkAccess(this)

        checkForInternet.observe(this) { isConnected ->
            if (isConnected) {
                if (!isGridApiInitialized) {
                    gridApi = GridCallApi(this)
                    isGridApiInitialized = true
                    Toast.makeText(this, "Internet Connection", Toast.LENGTH_SHORT).show()
                }
            } else {
                loadRewardFromDb()
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun grid_Data_set(
        type: String,
        GridData: List<GridData>,
        data: List<Data>,
        list: List<MainData>,
        maintitleyy: String,
    ) {
        Log.d("data======", "grid_Data_set: " + data)
        when (type) {
            "grid" -> {
                val layoutSet =
                    layoutInflater.inflate(R.layout.gride_recycleview, mainLayout, false)
                mainRCV = layoutSet.findViewById(R.id.rcvGrid)

                val adapter = GrideAdapter(
                    this@MainActivity,
                    GridData,
                    object : GrideAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            RequestClass().getScreen(this@MainActivity, GridData[position].screenNo)
                        }
                    })
                mainRCV.adapter = adapter
                mainRCV.layoutManager =
                    GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)
                mainLayout.addView(layoutSet)
            }

            "singleslider" -> {
                val layoutSet =
                    layoutInflater.inflate(R.layout.singleslider_recycleview, mainLayout, false)
                Log.d("data======", "grid_Data_set: " + data)
                mainRCV = layoutSet.findViewById(R.id.rcvSingleS)
                val adapter = SingleSliderAdapter(this@MainActivity, data)
                mainRCV.adapter = adapter
                mainRCV.layoutManager = LinearLayoutManager(this)
                mainLayout.addView(layoutSet)
            }

            "singleBigTask" -> {
                val layout =
                    layoutInflater.inflate(R.layout.singlebigtask_recycleview, mainLayout, false)
                val adapter = singleBigTaskAdapter(this@MainActivity, data)
                mainRCV = layout.findViewById(R.id.rcvSingleTask)
                val maintitle = layout.findViewById<TextView>(R.id.singleTaskMainTitle)
                maintitle.text = maintitleyy
                mainRCV.adapter = adapter
                mainRCV.layoutManager = LinearLayoutManager(this)
                mainLayout.addView(layout)
            }

            "taskList" -> {
                val layout =
                    layoutInflater.inflate(R.layout.tasklist_recycleview, mainLayout, false)
                mainRCV = layout.findViewById(R.id.taskRcv)
                val adapter = taskListAdapter(this@MainActivity, data)
                val maintitle = layout.findViewById<TextView>(R.id.taskListMainTitle)
                maintitle.text = maintitleyy
                mainRCV.adapter = adapter

                mainRCV.layoutManager = LinearLayoutManager(this)
                mainLayout.addView(layout)
            }

            "Quicktask" -> {
                val layout =
                    layoutInflater.inflate(R.layout.quicktask_recycleview, mainLayout, false)
                mainRCV = layout.findViewById(R.id.quickTaskRcv)
                val adapter = QuicktaskAdapter(this@MainActivity, data)
                val maintitle = layout.findViewById<TextView>(R.id.quickTaskMainTitle)
                maintitle.text = maintitleyy
                mainRCV.adapter = adapter
                mainRCV.layoutManager = LinearLayoutManager(this)
                mainLayout.addView(layout)
            }
        }
    }

    fun setdata(mainActivity: MainActivity, response: Response<GridDataModel>) {

        val list = response.body()?.mainDataList ?: emptyList()
        db.clearData()

        for (mainData in list) {

            val type = mainData.type
            val maintitle = mainData.title
            val gridlist = mainData.gridData ?: emptyList()
            val data = mainData.data ?: emptyList()

            grid_Data_set(type, gridlist, data, list, maintitle)

            // Insert main data
            db.insertMainData(mainData)

            // Insert grid data associated with main data
            for (gridItem in gridlist) {
                db.insertGridData(gridItem.fullImage, type)
            }

            // Insert second data associated with main data
          for (dataItem in data) {
              db.insertSecondData(dataItem.image,type)
          }
        }
    }

    private fun loadRewardFromDb() {
        mainLayout.removeAllViews()
        val allMainData = db.getAllMainData()
        if (allMainData.isNotEmpty()) {
//            Log.d("OfflineData", "Fetched offline data: $allMainData")
            for (mainData in allMainData) {
                val gridList = db.getGridData(mainData.type)
                val dataList = db.getSecondData(mainData.type )

                grid_Data_set(
                    mainData.type, gridList, dataList, listOf(mainData), mainData.title
                )
            }
        } else {
            Log.d("OfflineData", "No offline data available")
            Toast.makeText(this, "No offline data available", Toast.LENGTH_SHORT).show()
        }
    }
}