package dk.itu.soundscape.data.model

data class Entry(
    val mood: String,
    val song: String,
    val timestamp: Long = System.currentTimeMillis(),
    val location: String? = null // fill this in later with GPS
)