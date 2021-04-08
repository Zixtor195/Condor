package com.test.condor.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.condor.R
import com.test.condor.views.TeamDetailsActivity

class TeamResumeAdapter(val teamsResume:ArrayList<teamInfo>): RecyclerView.Adapter<TeamResumeViewHolder>() {

    override fun getItemCount(): Int = teamsResume.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamResumeViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return TeamResumeViewHolder(layoutInflater.inflate(R.layout.cv_team_resume,parent, false))
    }

    override fun onBindViewHolder(holder: TeamResumeViewHolder, position: Int) {
        val item:teamInfo = teamsResume[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            val profileIntent: Intent = Intent (it.context, TeamDetailsActivity::class.java).apply{
                putExtra("teamDetails", item)
            }
            holder.itemView.context.startActivity(profileIntent)
        }
    }



}