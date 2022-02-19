package com.lolozianas.cryptotracker.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lolozianas.cryptotracker.databinding.OverviewFragmentBinding

/**
 * [OverviewFragment] shows the status of request to the web service
 * and List of cryptocurrencies in the trading market
 * */
class OverviewFragment : Fragment() {

    // Binding object instance corresponding to the fragment_overview.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment
    private var _binding: OverviewFragmentBinding? = null
    private val binding get() = _binding!!

    // Initialize a shared view model object by using 'by viewModels()' kotlin property
    // delegate from the fragment-ktx library.
    private val overviewViewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OverviewFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            // Allows Data Binding to observe LiveData with the lifecycle of this fragment
            lifecycleOwner = viewLifecycleOwner

            // Giving the the binding access to the OverviewViewModel
            viewModel = overviewViewModel

            // Sets the adapter of Overview RecyclerView
            //recyclerViewOverview.adapter = OverviewAdapter()

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