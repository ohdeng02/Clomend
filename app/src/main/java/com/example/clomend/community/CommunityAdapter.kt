package com.example.clomend.community

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.databinding.ListItemCommunityBinding
import org.w3c.dom.Text

class CommunityAdapter(private val communityList: ArrayList<CommunityData>) : RecyclerView.Adapter<CommunityAdapter.ItemViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_community,
                parent, false)
        return ItemViewholder(itemView)

    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val currentItem = communityList[position]
        holder.imgCommunityImg.setImageResource(currentItem.imgRes)
        holder.tvCommunityTitle.text = currentItem.title
        holder.tvUploadTime.text = currentItem.writeT
        holder.tvWriter.text = currentItem.writer
        holder.tvScore.text = currentItem.score.toString()
        holder.tvViewCnt.text = currentItem.viewCnt.toString()
    }

    override fun getItemCount(): Int {
        return communityList.size
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCommunityImg: ImageView = itemView.findViewById(R.id.community_img)
        val tvCommunityTitle: TextView = itemView.findViewById(R.id.community_title)
        val tvWriter: TextView = itemView.findViewById(R.id.writer)
        val tvUploadTime: TextView = itemView.findViewById(R.id.uploadtime)
        val tvScore: TextView = itemView.findViewById(R.id.score)
        val tvViewCnt: TextView = itemView.findViewById(R.id.ViewCntNum)
    }
}