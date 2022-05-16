package com.tryden12.titanstabs.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel

class SearchResultsFragment : Fragment() {

    companion object {
        fun newInstance() = SearchResultsFragment()
    }

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.search_results_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}