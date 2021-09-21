package com.d3if4202.emaildata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.d3if4202.emaildata.databinding.ListItemBinding
import com.d3if4202.emaildata.db.EmailData

class MyRecyclerViewAdapter(private val clickListener: (EmailData) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val emaildatasList = ArrayList<EmailData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return emaildatasList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(emaildatasList[position], clickListener)
    }

    fun setList(emaildatas: List<EmailData>) {
        emaildatasList.clear()
        emaildatasList.addAll(emaildatas)

    }

}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(emaildata: EmailData, clickListener: (EmailData) -> Unit) {
        binding.nameTextView.text = emaildata.name
        binding.emailTextView.text = emaildata.email
        binding.listItemLayout.setOnClickListener {
            clickListener(emaildata)
        }
    }
}