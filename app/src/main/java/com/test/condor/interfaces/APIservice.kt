package com.test.condor.interfaces

import com.test.condor.adapters.eventsResponse
import com.test.condor.adapters.teamsResponse
import com.test.condor.model.TeamsActivityModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIservice {

    @GET("search_all_teams.php")
    fun getAllTeamsInALeague(@Query("l") league: String): Call<teamsResponse>


    @GET("eventslast.php")
    fun getLastFiveEventsByIdTeam(@Query("id") id: String): Call<eventsResponse>
}