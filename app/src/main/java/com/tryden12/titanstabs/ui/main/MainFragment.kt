package com.tryden12.titanstabs.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.data.model.Players
import com.tryden12.titanstabs.databinding.FragmentMainBinding
import com.tryden12.titanstabs.ui.main.adapter.Adapter
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel


class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding

    var navController : NavController? = null
    private lateinit var viewModel: ViewModel
    lateinit var adapter : Adapter
    var playerModelArrayList: MutableList<Player>? = ArrayList()

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

        // Disable back button
        disableOnBackPressed()


        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.playerLiveData.observe(viewLifecycleOwner) {
            //binding.textViewTestingJson.text = it.strPlayer
        }


        // Setup Layout Manager
        val layoutManager = LinearLayoutManager(context)
        binding.myRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.myRecyclerView!!.itemAnimator = DefaultItemAnimator()
        binding.myRecyclerView.adapter = Adapter(context, playerModelArrayList)
        // Add divider
        val divider = DividerItemDecoration(
            context, layoutManager.orientation
        )
        binding.myRecyclerView.addItemDecoration(divider)

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

    fun disableOnBackPressed() {

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