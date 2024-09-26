package ph.edu.auf.navigationdrawerlesson.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ph.edu.auf.navigationdrawerlesson.R
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentQuotesOfTheDayBinding
import ph.edu.auf.navigationdrawerlesson.helpers.QuotesGenerator

class QuotesOfTheDayFragment : Fragment() {

    private var _binding: FragmentQuotesOfTheDayBinding? = null

    private val binding get() = _binding!!
    private lateinit var quotesGenerator: QuotesGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        _binding = FragmentQuotesOfTheDayBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotesGenerator = QuotesGenerator.generateAllQuotes().build()

        binding.txtQuoteOfDay.text = quotesGenerator.getRandomQuote()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}