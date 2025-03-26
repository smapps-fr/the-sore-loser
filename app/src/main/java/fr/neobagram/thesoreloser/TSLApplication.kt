package fr.neobagram.thesoreloser

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import fr.neobagram.thesoreloser.data.local.TSLDatabase

@HiltAndroidApp
class TSLApplication: Application() {

    companion object {
        lateinit var database: TSLDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            TSLDatabase::class.java,
            "tsl_db"
        ).build()
    }
}