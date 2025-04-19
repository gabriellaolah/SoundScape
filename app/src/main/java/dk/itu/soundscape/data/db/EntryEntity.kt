package dk.itu.soundscape.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entries")
data class EntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mood: String,
    val song: String,
    val timestamp: Long,
    val location: String? = null
)