package com.test.condor.interfaces

import android.content.Context
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.test.condor.adapters.eventsResponse
import com.test.condor.adapters.teamInfo
import retrofit2.Retrofit

interface TeamsActivityContract {

    interface TeamsView {
        fun initView()
        fun updateViewData()
    }

    interface TeamsPresenter {
        fun getTeams(context: Context, recyclerView: RecyclerView)
    }

    interface TeamsModel {
        fun getTeams(context: Context, recyclerView: RecyclerView)
    }

    interface TeamsDetailsView {
        fun initView()
    }

    interface TeamsDetailsPresenter {
        fun getNextEventTeam(context: Context, listView:ListView, idTeam: String)
        fun redirectToWebPage(context: Context, url:String)
    }

    interface TeamsDetailsModel {
        fun getTeamDetails(context: Context, listView:ListView,  idTeam:String)
        fun redirectToWebPage(context: Context, url:String)
    }
}