package dk.itu.soundscape.viewmodel

import android.app.Application
import androidx.lifecycle.*
import dk.itu.soundscape.data.db.EntryRepository
import dk.itu.soundscape.data.db.EntryDatabase
import dk.itu.soundscape.data.db.EntryEntity
import dk.itu.soundscape.data.model.Entry
import kotlinx.coroutines.launch

class EntryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EntryRepository

    private val _entries = MediatorLiveData<List<Entry>>()
    val entries: LiveData<List<Entry>> get() = _entries

    init {
        val dao = EntryDatabase.getDatabase(application).entryDao()
        repository = EntryRepository(dao)

        // Transform EntryEntity → Entry for UI
        _entries.addSource(repository.allEntries) { entityList ->
            _entries.value = entityList.map {
                Entry(it.mood, it.song, it.timestamp, it.location)
            }
        }
    }

    fun addEntry(entry: Entry) {
        viewModelScope.launch {
            val entity = EntryEntity(
                mood = entry.mood,
                song = entry.song,
                timestamp = entry.timestamp,
                location = entry.location
            )
            repository.insert(entity)
        }
    }
}
