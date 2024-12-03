package com.example.apifetch_23_09


import GridData
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.apifetch_23_09.Model.Data
import com.example.apifetch_23_09.Model.MainData


class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "GridData.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_MAIN_DATA = "MainData"
        const val TABLE_GRID_DATA = "GridData"
        const val TABLE_SECOND_DATA = "Data"

        const val MAIN_DATA_ID = "id"
        const val MAIN_TYPE = "type"

        const val GRID_DATA_ID = "id"
        const val GRID_FULL_IMAGE = "fullImage"
        const val TYPE_NAME = "type"

        const val SECOND_DATA_ID = "id"
        const val SECOND_IMAGE = "image"
        const val SECOND_TYPE = "type"


     }

    override fun onCreate(db: SQLiteDatabase?) {
        val MainData =
            "CREATE TABLE $TABLE_MAIN_DATA($MAIN_DATA_ID INTEGER  PRIMARY KEY AUTOINCREMENT, $MAIN_TYPE TEXT)"
        val GridData =
            "CREATE TABLE $TABLE_GRID_DATA($GRID_DATA_ID INTEGER  PRIMARY KEY AUTOINCREMENT, $GRID_FULL_IMAGE TEXT, $TYPE_NAME TEXT)"
        val SecondData =
            "CREATE TABLE $TABLE_SECOND_DATA($SECOND_DATA_ID INTEGER  PRIMARY KEY AUTOINCREMENT,$SECOND_IMAGE TEXT,$SECOND_TYPE TEXT)"

        db?.execSQL(MainData)
        db?.execSQL(GridData)
        db?.execSQL(SecondData)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_MAIN_DATA")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_GRID_DATA")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SECOND_DATA")
         onCreate(db)
    }

    fun insertMainData(mainData: MainData): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(MAIN_TYPE, mainData.type)
        }
        return db.insert(TABLE_MAIN_DATA, null, values)
    }

    fun insertGridData(fullImage: String, type: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(GRID_FULL_IMAGE, fullImage)
            put(TYPE_NAME, type)
        }
        return db.insert(TABLE_GRID_DATA, null, values)
    }

    fun insertSecondData(image: String, type: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(SECOND_IMAGE, image)
            put(SECOND_TYPE, type)
        }
        return db.insert(TABLE_SECOND_DATA, null, values)
    }

    /* fun getAllMainData(): List<MainData> {
         val db = this.readableDatabase

         val MainCursor = db.rawQuery("SELECT * FROM $TABLE_MAIN_DATA", null)
         val MainDataList = mutableListOf<MainData>()

         //Main Data
         if (MainCursor.moveToFirst()) {
             do {
                 val mainType = MainCursor.getString(MainCursor.getColumnIndexOrThrow(MAIN_TYPE))
                 val girdCursor = db.rawQuery(
                     "SELECT * FROM $TABLE_GRID_DATA WHERE $TYPE_NAME = ?",
                     arrayOf(mainType)
                 )
                 //grid data
                 val gridDataList = mutableListOf<GridData>()
                 if (girdCursor.moveToFirst()) {
                     do {

                         val gridFullImage =
                             girdCursor.getString(girdCursor.getColumnIndexOrThrow(GRID_FULL_IMAGE))
                         gridDataList.add(GridData(gridFullImage))
                     } while (girdCursor.moveToNext())
                 }
                 girdCursor.close()

                 val secondDataList = mutableListOf<Data>()
                 //second data
                 val secondCursor = db.rawQuery(
                     "SELECT * FROM $TABLE_SECOND_DATA WHERE $SECOND_TYPE = ?",
                     arrayOf(mainType)
                 )
                 if (secondCursor.moveToFirst()) {
                     do {
                         val secondImage =
                             secondCursor.getString(secondCursor.getColumnIndexOrThrow(SECOND_IMAGE))
                         secondDataList.add(Data(secondImage))
                     } while (secondCursor.moveToNext())
                 }
                 secondCursor.close()
                 MainDataList.add(MainData(mainType, gridDataList, secondDataList))

             } while (MainCursor.moveToNext())
         }
         MainCursor.close()
         Log.d("OfflineData", "Fetched from DB: $MainDataList")
         return MainDataList
     }*/

    fun getAllMainData(): MutableList<MainData> {
        val mainDataList = mutableListOf<MainData>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM MainData", null)

        if (cursor.moveToFirst()) {
            do {
                val type = cursor.getString(cursor.getColumnIndexOrThrow(MAIN_TYPE))
                val gridDataList = getGridData(type)
                val secondDataList = getSecondData(type)

                val mainData = MainData(
                    type = type,
                    gridData = gridDataList,
                    data = secondDataList,
                )
                Log.d("OfflineData=======", "data offline data=: ${secondDataList.size}")
                mainDataList.add(mainData)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return mainDataList
    }

    fun getGridData(type: String): MutableList<GridData> {
        val gridList = mutableListOf<GridData>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM GridData WHERE type = ?", arrayOf(type))

        if (cursor.moveToFirst()) {
            do {
                val gridData = GridData(
                    fullImage = cursor.getString(cursor.getColumnIndexOrThrow(GRID_FULL_IMAGE))
                )
                gridList.add(gridData)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return gridList
    }
  val position =0
    fun getSecondData(type: String): MutableList<Data> {
        val dataList = mutableListOf<Data>()
        val db = readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM $TABLE_SECOND_DATA WHERE $SECOND_TYPE = ?", arrayOf(type))

        if (cursor.moveToFirst()) {
            do {
//            for (i in 0..dataList.size) {

                val dataItem= Data(
                    image = cursor.getString(cursor.getColumnIndexOrThrow(SECOND_IMAGE))
                )

               // val dataItem = dataList[i].image
                dataList.add(dataItem)
//                Log.d("image---->>>>", "getSecondData: "+dataList[i].image)
                Log.d("array--->>>", "getSecondData: "+dataItem)

//            }
            } while (cursor.moveToNext())
            Log.d("OfflineData", "data offline data: ${dataList.size}")

        }
        Log.d("OfflineData", "data offline data: ${dataList.size}")
        cursor.close()
        return dataList
    }

    fun clearData() {
        val db = writableDatabase
        db.delete(TABLE_MAIN_DATA, null, null)
        db.delete(TABLE_GRID_DATA, null, null)
        db.delete(TABLE_SECOND_DATA, null, null)
    }
}
