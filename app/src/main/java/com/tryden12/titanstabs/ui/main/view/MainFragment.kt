package com.tryden12.titanstabs.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
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
import com.tryden12.titanstabs.data.adapter.Adapter
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
        initRecyclerView()
        initViewModel()
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

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.search_button -> navController!!.navigate((R.id.action_mainFragment_to_searchResultsFragment2))
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

/*
     fun retrievePlayerDataTest() {
        try {
            // Create coroutine for download job
            val downloadJob = CoroutineScope(Dispatchers.IO).launch {

                val url = URL("https://www.thesportsdb.com/api/v1/json/50130162/searchplayers.php?t=Tennessee%Titans")
                val connection : URLConnection = url.openConnection()
                connection.connect()

                var jsonStr = ""
                val bufferedInputStream = BufferedInputStream(connection.getInputStream())
                val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

                val stringBuffer = StringBuffer()
                for(line in bufferedReader.lines()) {
                    stringBuffer.append(line)
                }

                bufferedReader.close()



                val fullJson: String = stringBuffer.toString()

                val jsonObjectPlayers = JSONObject(fullJson)
                val jsonArray : JSONArray = jsonObjectPlayers.getJSONArray("player")
                val jsonObjectPlayer : JSONObject = jsonArray.getJSONObject(0)

                val playerName : String = jsonObjectPlayer.getString("strPlayer")
                val playerPosition: String = jsonObjectPlayer.getString("strPosition")
                val playerHeight : String = jsonObjectPlayer.getString("strHeight")
                val playerWeight : String = jsonObjectPlayer.getString("strWeight")
                val playerBorn : String = jsonObjectPlayer.getString("dateBorn")
                val playerImage : String = jsonObjectPlayer.getString("strThumb")
                val playerDesc : String = jsonObjectPlayer.getString("strDescriptionEN")

                withContext(Dispatchers.Main) {

                    for (i in 0 until jsonArray.length()) {
                        val playerItemModel = Player()
                        val jsonObjectItem     = jsonArray.getJSONObject(i)
                        Log.i("DEBUG_JSON", "$jsonObjectItem")




                        playerItemModel.strPlayer    = "" + playerName
                        playerItemModel.strPosition = "" + playerPosition
                        playerItemModel.strThumb    = "" + playerImage



                        playerModelArrayList!!.add(playerItemModel)

                    } // for
                    /*
                    if (playerModelArrayList != null) {
                        adapter!!.dataChanged(playerModelArrayList!!)
                    }

                     */
                }

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }



 */


}