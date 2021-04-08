package com.test.condor.model

import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity
import com.test.condor.adapters.eventsResponse
import com.test.condor.adapters.getRetrofit
import com.test.condor.interfaces.APIservice
import com.test.condor.interfaces.TeamsActivityContract.TeamsDetailsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TeamDetailsActivityModel: TeamsDetailsModel {

    private lateinit var adapter: ArrayAdapter<String>


    override fun getTeamDetails(context: Context, listView: ListView, idTeam: String) {

        val call = getRetrofit().create(APIservice::class.java).getLastFiveEventsByIdTeam("$idTeam")
        call.enqueue(object : Callback<eventsResponse> {
            override fun onResponse(
                call: Call<eventsResponse>,
                response: Response<eventsResponse>
            ) {
                val eventsList = response.body() as eventsResponse

                println("CallBackWorking---------------------------> " + eventsList.events)

                val List: ArrayList<String> = ArrayList()
                for (event in eventsList.events) {
                    List.add(event.strFilename)

                }
                adapter = ArrayAdapter(context, R.layout.simple_list_item_1, List)
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<eventsResponse>, t: Throwable) {
                println("Error ${t}")
            }
        })
    }

    override fun redirectToWebPage(context: Context, url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url))
        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(browserIntent)

    }
}