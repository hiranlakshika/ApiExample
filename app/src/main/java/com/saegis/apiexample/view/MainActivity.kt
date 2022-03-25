package com.saegis.apiexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saegis.apiexample.R
import com.saegis.apiexample.model.User
import com.saegis.apiexample.view_model.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var users: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getUsersButton = findViewById<Button>(R.id.getUserButton)

        initViewModel()

        getUsersButton.setOnClickListener {
            loadUser()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun loadUser() {
        viewModel.getLoadUserObserver().observe(this, Observer<List<User>?> {
            if (it != null) {
                users = it
            }
        })

        viewModel.getUserList()
    }
}