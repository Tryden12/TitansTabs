package com.tryden12.titanstabs.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentMainBinding
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel


class MainFragment : Fragment(), View.OnClickListener {


    companion object {
        fun newInstance() = MainFragment()
    }

    var navController : NavController? = null
    private lateinit var viewModel: ViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)

       binding = FragmentMainBinding.inflate(layoutInflater)
       return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.playerLiveData.observe(viewLifecycleOwner) {
            //binding.textViewTestingJson.text = it.strPlayer
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.search_button).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.search_button -> navController!!.navigate((R.id.action_mainFragment_to_searchResultsFragment2))
        }
    }
}