package com.tryden12.titanstabs.ui.main.view.fragments

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentScheduleBinding
import com.tryden12.titanstabs.databinding.FragmentTop5PopUpBinding


class Top5PopUpFragment : DialogFragment() {
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

       // navController = Navigation.findNavController(view)
        setWidthPercent(90)

    }

    // Set the width of the dialog to a percentage of the current screen width
    private fun DialogFragment.setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)

        // Set transparent background and no title
        if (dialog != null && dialog?.window != null) {
            dialog!!.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.custom_dialog_bg_top_5));
        }
    }
}