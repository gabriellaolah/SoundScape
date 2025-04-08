package dk.itu.soundscape.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dk.itu.soundscape.R
import dk.itu.soundscape.data.model.Entry

class EntryAdapter(
    private var entries: List<Entry>
) : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val moodText: TextView = itemView.findViewById(R.id.mood_text)
        val songText: TextView = itemView.findViewById(R.id.song_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entry, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.moodText.text = "Mood: ${entry.mood}"
        holder.songText.text = "Song: ${entry.song}"
    }

    override fun getItemCount(): Int = entries.size

    fun updateList(newEntries: List<Entry>) {
        entries = newEntries
        notifyDataSetChanged()
    }
}
