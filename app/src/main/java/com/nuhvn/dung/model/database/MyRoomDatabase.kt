package com.nuhvn.dung.model.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nuhvn.dung.model.data_model.*
import com.nuhvn.dung.model.database.dao.AccountDao
import com.nuhvn.dung.model.database.dao.GioHangDao
import com.nuhvn.dung.model.database.dao.SanPhamDao
import com.nuhvn.dung.model.database.dao.UserDao
import kotlinx.coroutines.*

@Database(
	entities = [
		AccountModel::class,
		GioHangModel::class,
		SanPhamModel::class,
		UserModel::class
	],
	version = 2
)
abstract class MyRoomDatabase : RoomDatabase() {
	abstract fun accountDao(): AccountDao
	abstract fun gioHangDao(): GioHangDao
	abstract fun sanPhamDao(): SanPhamDao
	abstract fun userModel(): UserDao
	
	companion object {
		private var INSTANCE: MyRoomDatabase? = null
		fun getInstance(context: Context): MyRoomDatabase {
			return INSTANCE ?: buildRoomDatabase(context).apply {
				INSTANCE = this
			}
		}
		
		private fun buildRoomDatabase(context: Context): MyRoomDatabase {
			return Room.databaseBuilder(
				context.applicationContext,
				MyRoomDatabase::class.java,
				"DungRose.db"
			).addCallback(object : Callback() {
				override fun onCreate(db: SupportSQLiteDatabase) {
					super.onCreate(db)
					Log.d("DATABASE", "Database create")
				}
				
				override fun onOpen(db: SupportSQLiteDatabase) {
					super.onOpen(db)
					Log.d("DATABASE", "Database open")
				}
				
				override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
					super.onDestructiveMigration(db)
					Log.d("DATABASE", "Database destruct")
				}
			}).build()
		}
	}
}