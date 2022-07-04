package com.rafael.businesscard

import android.app.Application
import com.rafael.businesscard.data.AppDatabase
import com.rafael.businesscard.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}