package com.test.condor.model


import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.condor.adapters.TeamResumeAdapter
import com.test.condor.adapters.getRetrofit
import com.test.condor.adapters.teamInfo
import com.test.condor.adapters.teamsResponse
import com.test.condor.interfaces.APIservice
import com.test.condor.interfaces.TeamsActivityContract.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TeamsActivityModel: TeamsModel {

    private lateinit var adapter: TeamResumeAdapter
    private val teamData = mutableListOf<teamInfo>()

    override fun getTeams(context:Context, recyclerView: RecyclerView) {
        adapter = TeamResumeAdapter(teamData as ArrayList<teamInfo>)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val call = getRetrofit().create(APIservice::class.java).getAllTeamsInALeague("Spanish_La_Liga")
        call.enqueue(object : Callback<teamsResponse>{
            override fun onResponse(call: Call<teamsResponse>, response: Response<teamsResponse>) {
                val teamsList = response.body() as teamsResponse
                teamData.clear()
                teamData.addAll(teamsList.teams)
                adapter.notifyDataSetChanged()

                /*println ("CallBackWorking---------------------------> "+ teamsList.teams[0])*/
            }
            override fun onFailure(call: Call<teamsResponse>, t: Throwable) {
                println("Error ${t}")
            }

        })
    }

}