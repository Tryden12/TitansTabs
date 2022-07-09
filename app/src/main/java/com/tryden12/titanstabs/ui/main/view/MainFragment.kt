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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.model.Player
import com.tryden12.titanstabs.databinding.FragmentMainBinding
import com.tryden12.titanstabs.ui.main.adapter.Adapter
import com.tryden12.titanstabs.ui.main.viewmodel.ViewModel
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.net.URL
import java.net.URLConnection


class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding

    var navController : NavController? = null
    private lateinit var viewModel: ViewModel
    private lateinit var adapter : Adapter
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

        //binding.textviewHeadingSearchPlayer.text = viewModel.fetchPlayer().strPlayer

        viewModel.liveItemData.observe(viewLifecycleOwner) {
            //binding.textViewTestingJson.text = it.strPlayer
        }

        initViewModel()
        initRecyclerView()
        //retrievePlayerDataTest()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.search_button).setOnClickListener(this)
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

    private fun initRecyclerView() {
        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            adapter = Adapter()
            val divider = DividerItemDecoration(
                context, (layoutManager as LinearLayoutManager).orientation
            )
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        val viewModel: ViewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            // TODO
        })

        viewModel.makeApiCall()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.search_button -> navController!!.navigate((R.id.action_mainFragment_to_searchResultsFragment2))
        }
    }

















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




}