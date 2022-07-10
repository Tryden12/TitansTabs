package com.tryden12.titanstabs.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentMainBinding
import com.tryden12.titanstabs.adapter.Adapter
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel



class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMainBinding

    var navController : NavController? = null
    private lateinit var playerAdapter : Adapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding = FragmentMainBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        //initRecyclerView()
        //initViewModel()
        initListeners()
        disableOnBackPressed()
        view.findViewById<Button>(R.id.search_button).setOnClickListener(this)
    }



    private fun initRecyclerView() {
        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            playerAdapter = Adapter()
            adapter = playerAdapter
            val divider = DividerItemDecoration(
                context, (layoutManager as LinearLayoutManager).orientation
            )
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        val viewModel: ViewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.getLiveDataObserver().observe(requireActivity(), Observer {


        })
        //viewModel.makeApiCall()
    }

    private fun initListeners() {
        binding.rosterIconImageView.setOnClickListener(this)
        binding.rosterTextview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.roster_icon_imageView -> navController!!.navigate((R.id.action_mainFragment_to_rosterFragment))
            R.id.roster_textview -> navController!!.navigate((R.id.action_mainFragment_to_rosterFragment))
        }
    }

    private fun disableOnBackPressed() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // Handle the back button even
                    Log.d("BACKBUTTON", "Back button clicks")
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}