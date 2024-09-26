package ph.edu.auf.navigationdrawerlesson.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import ph.edu.auf.navigationdrawerlesson.R
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentFaveQuotesBinding
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager
import ph.edu.auf.navigationdrawerlesson.helpers.constants.SharedPrefKeys

class FaveQuotesFragment : Fragment() {

    private var _binding: FragmentFaveQuotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var faveQuotes: MutableSet<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFaveQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        faveQuotes = SharedPreferenceManager.getStringSet(SharedPrefKeys.FAVEQUOTE.key, emptySet()).toMutableSet()
        Log.d("FaveQuotesFragment", "Retrieved quotes: $faveQuotes")

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, faveQuotes.toMutableList())
        binding.listViewFaveQuotes.adapter = adapter

        binding.btnRemoveFave.setOnClickListener {
            removeSelectedQuotes()
        }
    }

    private fun removeSelectedQuotes() {
        val listView: ListView = binding.listViewFaveQuotes
        val selectedItems = listView.checkedItemPositions
        val quotesToRemove = mutableListOf<String>()

        for (i in 0 until selectedItems.size()) {
            val key = selectedItems.keyAt(i)
            if (selectedItems[key] && key < adapter.count) {
                quotesToRemove.add(adapter.getItem(key)!!)
            }
        }

        faveQuotes.removeAll(quotesToRemove)
        SharedPreferenceManager.putStringSet(SharedPrefKeys.FAVEQUOTE.key, faveQuotes)

        adapter.clear()
        adapter.addAll(faveQuotes.toMutableList())
        adapter.notifyDataSetChanged()

        Log.d("FaveQuotesFragment", "Updated quotes: $faveQuotes")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}