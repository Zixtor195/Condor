package com.test.condor.views

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.condor.adapters.eventsResponse
import com.test.condor.adapters.teamInfo
import com.test.condor.databinding.ActivityTeamDetailsBinding
import com.test.condor.interfaces.TeamsActivityContract.TeamsDetailsView
import com.test.condor.presenters.TeamDetailsActivityPresenter


class TeamDetailsActivity : AppCompatActivity(), TeamsDetailsView {
    private lateinit var binding: ActivityTeamDetailsBinding
    private lateinit var teamDetails : teamInfo
    private var presenter: TeamDetailsActivityPresenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = TeamDetailsActivityPresenter(this)
        val bundle: Bundle? = intent.extras
        teamDetails = (bundle?.getSerializable("teamDetails") as teamInfo?)!!

        initView()
    }

    override fun initView() {
        binding.tvDetailsTeamName.setText(teamDetails.strTeam)
        binding.tvDetailsTeamDescription.setText(teamDetails.strDescriptionEN)
        binding.tvDetailsTeamFoundation.setText("Foundation Date: " + teamDetails.intFormedYear)
        Picasso.get().load(teamDetails.strTeamJersey).into(binding.ivDetailTeamJersey)
        Picasso.get().load(teamDetails.strTeamBadge).into(binding.ivDetailsTeamBadge)

        presenter?.getNextEventTeam(this.applicationContext, binding.lvDetailsNextEvents, teamDetails.idTeam)

        val List: ArrayList<String> = ArrayList()

        List.add(teamDetails.strWebsite)
        List.add(teamDetails.strFacebook)
        List.add(teamDetails.strTwitter)
        List.add(teamDetails.strInstagram)

        var adapter = ArrayAdapter(this, R.layout.simple_list_item_1, List)
        binding.lvDetailsSocialNetworks.adapter = adapter

        binding.lvDetailsSocialNetworks.setOnItemClickListener{ parent, view, position, id ->
            val element = adapter.getItem(position) as String
            presenter?.redirectToWebPage(this.applicationContext, element)
        }


    }
}