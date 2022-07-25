package com.tryden12.titanstabs.ui.main.view.fragments

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.databinding.FragmentTop5PopUpBinding


class Top5PopUpFragment : DialogFragment(), View.OnClickListener {
    private val TAG: String = Top5PopUpFragment::class.java.name;
    private lateinit var binding: FragmentTop5PopUpBinding
    var navController: NavController? = null

    var iconPos0: String = ""
    var iconPos1: String = ""
    var iconPos2: String = ""
    var iconPos3: String = ""
    var iconPos4: String = ""


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

        // Set icon list with correct drawable
        retrieveIconList()
        setIconList(retrieveIconList())

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

    private fun retrieveIconList(): MutableList<String> {
        // Retrieve icon data
        iconPos0 = arguments?.getString("0").toString()
        iconPos1 = arguments?.getString("1").toString()
        iconPos2 = arguments?.getString("2").toString()
        iconPos3 = arguments?.getString("3").toString()
        iconPos4 = arguments?.getString("4").toString()

        Log.d(TAG, "iconPos0 = " + iconPos0) // returning null, should return "Roster"
        // Create list of active icons
        var iconList = mutableListOf<String>()
        // Add to list
        iconList.add(iconPos0!!)
        iconList.add(iconPos1!!)
        iconList.add(iconPos2!!)
        iconList.add(iconPos3!!)
        iconList.add(iconPos4!!)

        Log.d(TAG, "iconlist[0] = " + iconList[0]) // returning null
        return iconList
    }


    private fun setIconList(iconList: MutableList<String>){

        if (iconList.contains(getString(R.string.roster))) {
            binding.radioButtonRosterPick.setBackgroundResource(R.drawable.icon_helmet_blue_bg)
        }
        if (iconList.contains(getString(R.string.schedule))) {
            binding.radioButtonSchedulePick.setBackgroundResource(R.drawable.icon_schedule_blue_bg)
        }
        if (iconList.contains(getString(R.string.depth_chart))) {
            binding.radioButtonDepthChart.setBackgroundResource(R.drawable.icon_depth_chart_blue_bg)
        }
        if (iconList.contains(getString(R.string.stats))) {
            binding.radioButtonStatsPick.setBackgroundResource(R.drawable.icon_stats_blue_bg)
        }
        if (iconList.contains(getString(R.string.photos))) {
            binding.radioButtonPhotosPick.setBackgroundResource(R.drawable.icon_photos_blue_bg)
        }
        if (iconList.contains(getString(R.string.roster_moves))) {
            binding.radioButtonRosterMovesPick.setBackgroundResource(R.drawable.icon_roster_moves_blue_bg)
        }
        if (iconList.contains(getString(R.string.shop))) {
            binding.radioButtonShopPick.setBackgroundResource(R.drawable.icon_shop_blue_bg)
        }
        if (iconList.contains(getString(R.string.podcasts))) {
            binding.radioButtonPodcastPick.setBackgroundResource(R.drawable.icon_podcast_blue_bg)
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}