package com.killasites.apiresponse.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.killasites.apiresponse.MainActivity
import com.killasites.apiresponse.R
import com.killasites.apiresponse.data.ApiCallsResponse
import com.killasites.apiresponse.data.Result

class ListingAdapter(private val listings : List<ApiCallsResponse>) : RecyclerView.Adapter<ListingAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_list, parent, false)
        view.setOnClickListener {
            val intent = Intent(parent.context, MainActivity :: class.java)
            parent.context.startActivity(intent)
        }
        return ViewHolder(view)

    }

    override fun getItemCount() = listings.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.title.text = listings[position].title
        //holder.locality.text = listings[position].locality
        holder.name.text = listings[position].name
        holder.title.text = listings[position].mass
        holder.locality.text = listings[position].url
        holder.locality.text = listings[position].height


    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.listingamount)
        val photo : ImageView = itemView.findViewById(R.id.listingimage)
        val title : TextView = itemView.findViewById(R.id.title_text)
        val locality : TextView = itemView.findViewById(R.id.listinglocality)

    }
}