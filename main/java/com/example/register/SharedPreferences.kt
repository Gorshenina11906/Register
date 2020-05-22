package com.example.register

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SharedPreferences (context : Context) : SQLiteOpenHelper (context, spname, factory, version) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (id integer primary key autoincrement," +
        "name varchar(30), email varchar(100), passvord varchar(20)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUserData (name: String, email: String, password: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name", name)
        values.put("email", email)
        values.put("password", password)

        db.insert("user", null, values)
        db.close()
    }

    fun userPresent (email: String, password: String): Boolean {
        val db = writableDatabase
        val query = "выбрать пользователя, email которого - $email, а пароль - $password"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    companion object {
        internal val spname = "userSP"
        internal val factory = null
        internal val version = 1
    }
}