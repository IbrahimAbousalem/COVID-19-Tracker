package com.iti.mobile.covid19tracker.utils

const val BASE_URL = "https://corona.lmao.ninja/v2/"
const val HTTP_CACHE_DIR = "okhttp_cache"
const val HTTP_CACHE_SIZE = 10 * 1024 * 1024 //10MB

//ROOM
const val SUBSCRIBED = 1
const val UN_SUBSCRIBED = 0
const val DATABASE_NAME = "Covid_Tracking_DB"

//shared_preference
const val SHARED_PREFERENCE_NAME = "shared_preference"
const val ALL_CASES = "all_cases"
const val ALL_DEATHS = "all_deaths"
const val ALL_RECOVERED= "all_recovered"
const val TODAY_CASES = "today_cases"
const val TODAY_DEATHS = "today_deaths"
const val UPDATED = "updated"
const val CRITICAL = "critical"

//WorkManager
const val WORK_MANAGER_KEY = "SyncWork"

//Notification
const val CHANNEL_NAME = "covid19"
const val CHANNEL_ID = "10000"
const val NOTIFICATION_ID = 5


