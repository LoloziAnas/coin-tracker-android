package com.lolozianas.cryptotracker.ui.coinDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import com.lolozianas.cryptotracker.databinding.CoinDetailFragmentBinding
import com.lolozianas.cryptotracker.network.Coin

/**
 * This [Fragment] shows detailed information about a selected coin of CoinPaprika API.
 * Its sets this information in [CoinDetailViewModel], which it gets as Parcelable Coin
 * through Jetpack Navigation's SafeArgs.
 * */
class CoinDetailFragment : Fragment() {

    private var _binding: CoinDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var coin: Coin
    private val coinDetailViewModel: CoinDetailViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoinDetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            viewModel = coinDetailViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        //addChipGroup()
    }

    private fun addChipGroup() {
        val chipGroup = binding.tags
        val tags = binding.viewModel?.coinDetail?.value?.tags!!
        for (tag in tags) {
            val chip = Chip(context)
            chip.text = tag.name
            chipGroup.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}