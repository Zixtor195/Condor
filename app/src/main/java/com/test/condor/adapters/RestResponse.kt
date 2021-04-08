package com.test.condor.adapters

import android.os.Parcelable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

data class teamInfo(
    val idTeam: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strStadium : String,
    val strDescriptionEN: String,
    val intFormedYear: String,
    val strTeamJersey: String,
    val strWebsite:String,
    val strFacebook:String,
    val strTwitter:String,
    val strInstagram:String) : Serializable

class teamsResponse {var teams = ArrayList<teamInfo>()}

data class eventInfo(val strFilename: String) : Serializable

class eventsResponse {var events = ArrayList<eventInfo>()}

