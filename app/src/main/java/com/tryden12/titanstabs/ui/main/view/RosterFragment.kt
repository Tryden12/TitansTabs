package com.tryden12.titanstabs.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.adapter.Adapter
import com.tryden12.titanstabs.databinding.FragmentRosterBinding
import com.tryden12.titanstabs.interfaces.FragmentCommunicator
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel


class RosterFragment : Fragment(), FragmentCommunicator {

    private lateinit var binding: FragmentRosterBinding
    private lateinit var playerAdapter: Adapter
    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRosterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            playerAdapter = Adapter(this@RosterFragment)
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

            // Set player list
            if (it != null) {
                playerAdapter.setPlayerList(it)
                playerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    override fun passData(
        position: Int,
        playerName: String,
        playerPosition: String,
        playerNumber: String,
        playerHeight: String,
        playerWeight: String,
        playerAge: String,
        playerImage: String,
        playerExperience: String,
        playerCollege: String,
        playerBio: String
    ) {
        val bundle = Bundle()
        bundle.putInt("adapterPosition", position)
        bundle.putString("playerName", playerName)
        bundle.putString("playerPosition", playerPosition)
        bundle.putString("playerNumber", playerNumber)
        bundle.putString("playerHeight", playerHeight)
        bundle.putString("playerWeight", playerWeight)
        bundle.putString("playerAge", playerAge)
        bundle.putString("playerImage", playerImage)
        bundle.putString("playerExperience", playerExperience)
        bundle.putString("playerCollege", playerCollege)
        bundle.putString("playerBio", playerBio)

        val transaction = this.parentFragmentManager.beginTransaction()
        val playerDetailFrag = PlayerDetailsFragment()
        playerDetailFrag.arguments = bundle

        transaction.replace(R.id.frame_layout,playerDetailFrag)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}