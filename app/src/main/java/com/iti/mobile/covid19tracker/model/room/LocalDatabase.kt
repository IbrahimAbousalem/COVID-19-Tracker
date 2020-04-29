package com.iti.mobile.covid19tracker.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iti.mobile.covid19tracker.model.entities.Country
import com.iti.mobile.covid19tracker.model.room.daos.CountryDao
import com.iti.mobile.covid19tracker.utils.DateConverter
import java.util.concurrent.Executors

@Database(
    entities = [Country::class],
    version = 1,
    exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
   abstract val countryDao : CountryDao
}