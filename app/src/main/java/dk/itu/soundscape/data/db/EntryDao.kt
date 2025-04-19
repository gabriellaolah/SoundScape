package dk.itu.soundscape.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EntryDao {

    @Insert
    suspend fun insert(entry: EntryEntity)

    @Query("SELECT * FROM entries ORDER BY timestamp DESC")
    fun getAllEntries(): LiveData<List<EntryEntity>>
}
