package com.protoenergy.grocery.groceryDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.protoenergy.grocery.dao.GroceryDao
import com.protoenergy.grocery.model.GroceryItems

@Database(entities = [GroceryItems::class], version = 1)
abstract class GroceryDatabase : RoomDatabase() {

    abstract fun getGroceryDao() : GroceryDao

    companion object {
        @Volatile
        private var instance: GroceryDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { groceryDatabase ->
                instance = groceryDatabase
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, GroceryDatabase::class.java, "GroceryDatabase.db").build()


    }
}