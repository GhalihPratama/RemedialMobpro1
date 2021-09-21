package com.d3if4202.emaildata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d3if4202.emaildata.databinding.ActivityMainBinding
import com.d3if4202.emaildata.db.EmailData
import com.d3if4202.emaildata.db.EmailDataDatabase
import com.d3if4202.emaildata.db.EmailDataRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var emaildataViewModel: EmailDataViewModel
    private lateinit var adapter: MyRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = EmailDataDatabase.getInstance(application).emaildataDAO
        val repository = EmailDataRepository(dao)
        val factory = EmailDataViewModelFactory(repository)
        emaildataViewModel = ViewModelProvider(this, factory).get(EmailDataViewModel::class.java)
        binding.myViewModel = emaildataViewModel
        binding.lifecycleOwner = this

        emaildataViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.emaildataRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter({ selectedItem: EmailData -> listItemClicked(selectedItem) })
        binding.emaildataRecyclerView.adapter = adapter
        displayEmailDatasList()
    }

    private fun displayEmailDatasList() {
        emaildataViewModel.getSavedEmailDatas().observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun listItemClicked(emaildata: EmailData) {
        emaildataViewModel.initUpdateAndDelete(emaildata)
    }
}