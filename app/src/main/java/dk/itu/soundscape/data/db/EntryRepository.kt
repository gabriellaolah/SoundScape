package dk.itu.soundscape.data.db

import androidx.lifecycle.LiveData
import dk.itu.soundscape.data.db.EntryDao
import dk.itu.soundscape.data.db.EntryEntity

class EntryRepository(private val entryDao: EntryDao) {

    val allEntries: LiveData<List<EntryEntity>> = entryDao.getAllEntries()

    suspend fun insert(entry: EntryEntity) {
        entryDao.insert(entry)
    }
}
