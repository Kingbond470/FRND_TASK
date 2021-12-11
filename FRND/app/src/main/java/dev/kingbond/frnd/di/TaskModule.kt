package dev.kingbond.frnd.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.kingbond.frnd.data.local.TaskDao
import dev.kingbond.frnd.data.local.TaskDatabase
import dev.kingbond.frnd.data.local.TaskDatabaseModel
import dev.kingbond.frnd.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TaskModule {

    // for api - call
    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // for accessing dao - room database
    @Provides
    @Singleton
    fun getItunesDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.getTaskDao()
    }

    // for accessing database - room database
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): TaskDatabase {
        val builder = Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "itunes_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

}