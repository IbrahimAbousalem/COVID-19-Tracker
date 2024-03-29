package com.iti.mobile.covid19tracker.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iti.mobile.covid19tracker.model.entities.Country
import com.iti.mobile.covid19tracker.model.room.daos.CountryDao

@Database(
    entities = [Country::class],
    version = 1,
    exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract val countryDao : CountryDao
}