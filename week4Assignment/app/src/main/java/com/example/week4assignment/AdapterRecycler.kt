package com.example.week4assignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.intellij.lang.annotations.JdkConstants

class AdapterRecycler(private val myContact: List<Contact>):RecyclerView.Adapter<AdapterRecycler.ViewHolder>(){
    private lateinit var nListener: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(postion:Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        nListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myView =LayoutInflater.from(parent.context).inflate(R.layout.contact_list_view,parent,false)
        return ViewHolder(myView, nListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = myContact[position]
        holder.playerImage.setImageResource(currentItem.image)
        holder.playerContact.text = currentItem.contactList

    }

    override fun getItemCount(): Int {
        return myContact.size

    }

     class ViewHolder(itemView:View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        var playerImage: ImageView = itemView.findViewById(R.id.ivImage2)
        var playerContact: TextView = itemView.findViewById(R.id.contact1)

      init {
          itemView.setOnClickListener {
              listener.onItemClick(adapterPosition)
          }
      }


    }


}