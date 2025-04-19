package dk.itu.soundscape.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dk.itu.soundscape.R
import dk.itu.soundscape.data.model.Entry
import dk.itu.soundscape.viewmodel.EntryViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController



class AddEntryFragment : Fragment() {

    private val viewModel: EntryViewModel by activityViewModels {
        ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_add_entry, container, false)

        val moodInput = view.findViewById<EditText>(R.id.mood_input)
        val songInput = view.findViewById<EditText>(R.id.song_input)
        val saveButton = view.findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener {
            val mood = moodInput.text.toString().trim()
            val song = songInput.text.toString().trim()
            if (mood.isNotEmpty() && song.isNotEmpty()) {
                val entry = Entry(mood = mood, song = song)
                viewModel.addEntry(entry)
                moodInput.text.clear()
                songInput.text.clear()

                findNavController().navigate(R.id.action_addEntryFragment_to_entryListFragment)

            }
        }

        return view
    }
}


