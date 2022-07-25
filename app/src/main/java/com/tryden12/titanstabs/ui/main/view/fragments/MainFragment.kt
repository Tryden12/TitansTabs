package com.tryden12.titanstabs.ui.main.view.fragments

import android.nfc.Tag
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
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMainBinding

    var navController : NavController? = null

    private val TAG: String = MainFragment::class.java.name;

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
                // Send list of icons current on dashboard
                newInstance(populateIconList())

                // Open Top5PopUpFragment dialog
                var dialog = Top5PopUpFragment()
                dialog.show(childFragmentManager, "customDialog")
            }
            R.id.edit_icon_textview -> {
                // Send list of icons current on dashboard
                newInstance(populateIconList())

                // Open Top5PopUpFragment dialog
                var dialog = Top5PopUpFragment()
                dialog.show(childFragmentManager, "customDialog")
            }
        }
    }

    private fun populateIconList() : MutableList<String> {
        var iconList = mutableListOf<String>()

        // Roster icon
        if (roster_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.roster))
        } else {
            if (iconList.contains(getString(R.string.roster))) {
                iconList.remove(getString(R.string.roster))
            }
        }

        // Schedule icon
        if (schedule_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.schedule))
        } else {
            if (iconList.contains(getString(R.string.schedule))) {
                iconList.remove(getString(R.string.schedule))
            }
        }

        // Depth Chart icon
        if (depth_chart_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.depth_chart))
        } else {
            if (iconList.contains(getString(R.string.depth_chart))) {
                iconList.remove(getString(R.string.depth_chart))
            }
        }

        // Stats icon
        if (stats_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.stats))
        } else {
            if (iconList.contains(getString(R.string.stats))) {
                iconList.remove(getString(R.string.stats))
            }
        }

        // Photos icon
        if (photos_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.photos))
        } else {
            if (iconList.contains(getString(R.string.photos))) {
                iconList.remove(getString(R.string.photos))
            }
        }

        // Roster Moves icon
        if (roster_moves_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.roster_moves))
        } else {
            if (iconList.contains(getString(R.string.roster_moves))) {
                iconList.remove(getString(R.string.roster_moves))
            }
        }

        // Shop icon
        if (shop_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.shop))
        } else {
            if (iconList.contains(getString(R.string.shop))) {
                iconList.remove(getString(R.string.shop))
            }
        }

        // Podcasts icon
        if (podcast_dash_layout.visibility == View.VISIBLE) {
            iconList.add(getString(R.string.podcasts))
        } else {
            if (iconList.contains(getString(R.string.podcasts))) {
                iconList.remove(getString(R.string.podcasts))
            }
        }

        Log.d(TAG, "iconlist = $iconList")
        return iconList
    }

    // send data to popup frag
    fun newInstance(iconList: MutableList<String>): Top5PopUpFragment? {

        val fragment = Top5PopUpFragment()

        // Supply list of icons to fragment
        val args = Bundle().apply {
            putString("0", iconList[0])
            putString("1", iconList[1])
            putString("2", iconList[2])
            putString("3", iconList[3])
            putString("4", iconList[4])
        }

        fragment.arguments = args

        Log.d(TAG, "iconlist[0] = " + iconList[0])
        Log.d(TAG, "iconlist[1] = " + iconList[1])
        return fragment
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