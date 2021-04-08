package com.test.condor.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.condor.databinding.CvTeamResumeBinding

class TeamResumeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = CvTeamResumeBinding.bind(view)
    fun bind (data: teamInfo){
        binding.tvTeamName.text = data.strTeam
        binding.tvTeamStadium.text = data.strStadium
        Picasso.get().load(data.strTeamBadge).into(binding.ivTeamBadge)
    }
}