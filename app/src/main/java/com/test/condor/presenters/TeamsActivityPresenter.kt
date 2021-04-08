package com.test.condor.presenters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.test.condor.interfaces.TeamsActivityContract.TeamsView
import com.test.condor.interfaces.TeamsActivityContract.TeamsModel
import com.test.condor.interfaces.TeamsActivityContract.TeamsPresenter
import com.test.condor.model.TeamsActivityModel

class TeamsActivityPresenter(_view: TeamsView) : TeamsPresenter {

    private var view: TeamsView = _view
    private var model: TeamsModel = TeamsActivityModel()

    override fun getTeams(context:Context, recyclerView: RecyclerView) {
        model.getTeams(context, recyclerView)
    }
}