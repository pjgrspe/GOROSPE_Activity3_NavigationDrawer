package ph.edu.auf.navigationdrawerlesson.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentBasquiatQuotesBinding
import ph.edu.auf.navigationdrawerlesson.helpers.QuotesGenerator
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager
import ph.edu.auf.navigationdrawerlesson.helpers.constants.SharedPrefKeys

class BasquiatQuotesFragment : Fragment() {

    private var _binding: FragmentBasquiatQuotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var quotesGenerator: QuotesGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBasquiatQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotesGenerator = QuotesGenerator.generateBasquiatQuotes().build()

        binding.txtQuote.text = quotesGenerator.getRandomQuote()

        binding.btnSaveQuote.setOnClickListener {
            val quote = binding.txtQuote.text.toString()
            val savedQuotes = SharedPreferenceManager.getStringSet(SharedPrefKeys.FAVEQUOTE.key, emptySet()).toMutableSet()
            savedQuotes.add(quote)
            SharedPreferenceManager.putStringSet(SharedPrefKeys.FAVEQUOTE.key, savedQuotes)
            Toast.makeText(activity, "Quote saved!", Toast.LENGTH_SHORT).show()
        }

        binding.btnRandomizeQuote.setOnClickListener {
            binding.txtQuote.text = quotesGenerator.getRandomQuote()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}