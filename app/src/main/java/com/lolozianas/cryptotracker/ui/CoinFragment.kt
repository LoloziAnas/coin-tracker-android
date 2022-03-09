package com.lolozianas.cryptotracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.lolozianas.cryptotracker.databinding.CoinFragmentBinding

class CoinFragment : Fragment() {

    /**
     *  Binding object instance corresponding to the fragment_overview.xml layout
     * This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
     * when the view hierarchy is attached to the fragment
     */
    private var _binding: CoinFragmentBinding? = null
    private val binding get() = _binding!!

    // Initialize a shared view model object by using 'by viewModels()' kotlin property
    // delegate from the fragment-ktx library.
    private val coinViewModel: CoinViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoinFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            // Allows Data Binding to observe LiveData with the lifecycle of this fragment
            lifecycleOwner = viewLifecycleOwner

            // Giving the the binding access to the OverviewViewModel
            viewModel = coinViewModel

            // Sets the adapter of Overview RecyclerView
            recyclerViewCoins.adapter = CoinListAdapter()

        }
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}