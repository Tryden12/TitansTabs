package com.tryden12.titanstabs.ui.main.view.fragments

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
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentMainBinding
import com.tryden12.titanstabs.adapter.Adapter
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel



class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMainBinding

    var navController : NavController? = null


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

    private fun initViewModel() {
        val viewModel: ViewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.getLiveDataObserver().observe(requireActivity(), Observer {


        })
        //viewModel.makeApiCall()
    }

    private fun initListeners() {
        binding.rosterIconImageView.setOnClickListener(this)
        binding.rosterTextview.setOnClickListener(this)
        binding.scheduleIconImageView.setOnClickListener(this)
        binding.scheduleTextview.setOnClickListener(this)

        binding.editIconImageView.setOnClickListener(this)
        binding.editIconTextview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            // To roster fragment
            R.id.roster_icon_imageView -> navController!!.navigate((R.id.action_mainFragment_to_rosterFragment))
            R.id.roster_textview -> navController!!.navigate((R.id.action_mainFragment_to_rosterFragment))
            R.id.schedule_icon_imageView -> navController!!.navigate(R.id.action_mainFragment_to_scheduleFragment)
            R.id.schedule_textview -> navController!!.navigate(R.id.action_mainFragment_to_scheduleFragment)


            // Edit button in dashboard
            R.id.edit_icon_imageView -> {
                var dialog = Top5PopUpFragment()

                dialog.show(childFragmentManager, "customDialog")
            }
            R.id.edit_icon_textview -> {
                var dialog = Top5PopUpFragment()
                /*
                Bundle().apply {
                    putInt(KEY, imageDrawable)
                }

                 */

                dialog.show(childFragmentManager, "customDialog")
            }
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