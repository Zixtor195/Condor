package com.test.condor.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.condor.R
import com.test.condor.databinding.ActivityMainBinding
import com.test.condor.interfaces.TeamsActivityContract.TeamsView
import com.test.condor.presenters.TeamsActivityPresenter

class MainActivity : AppCompatActivity(), TeamsView {

    private lateinit var binding: ActivityMainBinding
    private var presenter: TeamsActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Condor)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = TeamsActivityPresenter(this)
        updateViewData()

    }

    override fun initView() {

    }

    override fun updateViewData() {
        presenter?.getTeams(this.applicationContext, binding.rvTeamsResume)

    }

}