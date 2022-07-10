package com.tryden12.titanstabs.interfaces

interface FragmentCommunicator {

    fun passData(position: Int,
                      playerName: String, playerPosition: String,
                      playerNumber: String, playerHeight: String,
                      playerWeight: String, playerAge: String,
                      playerImage: String, playerExperience: String,
                      playerCollege: String, playerBio: String,
                          )
}