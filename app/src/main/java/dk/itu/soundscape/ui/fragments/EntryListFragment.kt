package dk.itu.soundscape.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.itu.soundscape.R
import dk.itu.soundscape.ui.EntryAdapter
import dk.itu.soundscape.viewmodel.EntryViewModel

class EntryListFragment : Fragment() {

    private val viewModel: EntryViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EntryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_entry_list, container, false)

        recyclerView = view.findViewById(R.id.entry_recycler_view)
        adapter = EntryAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observe LiveData
        viewModel.entries.observe(viewLifecycleOwner) { entries ->
            adapter.updateList(entries)
        }

        return view
    }
}
