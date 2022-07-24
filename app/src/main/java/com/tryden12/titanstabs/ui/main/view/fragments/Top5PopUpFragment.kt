package com.tryden12.titanstabs.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentScheduleBinding
import com.tryden12.titanstabs.databinding.FragmentTop5PopUpBinding


class Top5PopUpFragment : Fragment() {
    private lateinit var binding: FragmentTop5PopUpBinding
    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTop5PopUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }
}