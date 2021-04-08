package com.test.condor.presenters

import android.content.Context
import android.widget.ListView
import com.test.condor.adapters.eventsResponse
import com.test.condor.interfaces.TeamsActivityContract.*
import com.test.condor.model.TeamDetailsActivityModel
import com.test.condor.views.TeamDetailsActivity

class TeamDetailsActivityPresenter (_view: TeamsDetailsView) : TeamsDetailsPresenter {

    private lateinit var view: TeamsDetailsView
    private var model: TeamsDetailsModel = TeamDetailsActivityModel()


    override fun getNextEventTeam(context: Context, listView: ListView, idTeam: String) {
        model.getTeamDetails(context, listView,  idTeam)
    }

    override fun redirectToWebPage(context: Context, url: String) {
        model.redirectToWebPage(context, url)
    }
}