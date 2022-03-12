package com.lolozianas.cryptotracker.ui.coinDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lolozianas.cryptotracker.databinding.CoinDetailFragmentBinding

class CoinDetailFragment : Fragment() {

    private var _binding: CoinDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var coinId: String
    private val coinDetailViewModel: CoinDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coinId = arguments?.getString("coinId").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoinDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coinDetailViewModel.getCoinById(coinId)
        binding.apply {
            viewModel = coinDetailViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}