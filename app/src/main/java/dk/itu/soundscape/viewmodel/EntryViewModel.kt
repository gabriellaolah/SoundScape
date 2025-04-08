package dk.itu.soundscape.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.itu.soundscape.data.model.Entry

class EntryViewModel : ViewModel() {

    private val _entries = MutableLiveData<List<Entry>>(emptyList())
    val entries: LiveData<List<Entry>> get() = _entries

    fun addEntry(entry: Entry) {
        val currentList = _entries.value?.toMutableList() ?: mutableListOf()
        currentList.add(entry)
        _entries.value = currentList
    }
}

