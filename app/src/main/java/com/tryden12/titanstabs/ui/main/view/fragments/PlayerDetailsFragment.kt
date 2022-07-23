package com.tryden12.titanstabs.ui.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.PlayerDetailsFragmentBinding

class PlayerDetailsFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: PlayerDetailsFragmentBinding
    var navController: NavController? = null


    private var adapterPosition : Int? = null
    var playerName : String = ""
    var playerPosition : String = ""
    var playerNumber : String = ""
    var playerHeight : String = ""
    var playerWeight : String = ""
    var playerAge : String = ""
    var playerImage : String = ""
    var playerExperience : String = ""
    var playerCollege : String = ""
    var playerBio : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = PlayerDetailsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        buildPlayer()
        initListeners()
        //overrideOnBackPressed()
    }

    private fun buildPlayer() {

        // Get data from roster fragment to build player data
        adapterPosition = arguments?.getInt("position")
        playerName = arguments?.getString("playerName").toString()
        playerPosition = arguments?.getString("playerPosition").toString()
        playerNumber = arguments?.getString("playerNumber").toString()
        playerHeight = arguments?.getString("playerHeight").toString()
        playerWeight = arguments?.getString("playerWeight").toString()
        playerAge = arguments?.getString("playerAge").toString()
        playerImage = arguments?.getString("playerImage").toString()
        playerExperience = arguments?.getString("playerExperience").toString()
        playerCollege = arguments?.getString("playerCollege").toString()
        playerBio = arguments?.getString("playerBio").toString()

        // Bind to view
        binding.playerNameTextview.text = playerName
        binding.textViewPosition.text = playerPosition
        binding.textViewNumber.text = playerNumber
        binding.textViewHeight.text = playerHeight
        binding.textViewWeight.text = playerWeight
        binding.textViewAge.text = playerAge
        binding.textViewExperience.text = playerExperience
        binding.textViewCollege.text = playerCollege
        binding.textViewBio.text = playerBio
        // Load image to ImageView
        Picasso.get().load(playerImage).into(binding.imageviewPlayer)

    }

    private fun overrideOnBackPressed() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController!!.navigate((R.id.action_playerDetailsFragment_to_rosterFragment))
            }
        })
    }

    private fun initListeners() {
        binding.backBtn.setOnClickListener {
            navController!!.navigate(R.id.action_playerDetailsFragment_to_rosterFragment)
        }
    }

    override fun onClick(view: View?) {

    }


}