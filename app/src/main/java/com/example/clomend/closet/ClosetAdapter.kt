package com.example.clomend.closet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.community.CommunityAdapter

class ClosetAdapter(private val closetList : ArrayList<ClosetData>) : RecyclerView.Adapter<ClosetAdapter.ItemViewholder>(){

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }
    private lateinit var mOnItemClickListener: OnItemClickListener
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        mOnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosetAdapter.ItemViewholder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_closet,
                parent, false)
        return ItemViewholder(itemView)

    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val currentItem = closetList[position]
        holder.imgClosetImg.setImageResource(currentItem.imgRes)
        holder.tvClosetTitle.text = currentItem.clothesName
    }

    override fun getItemCount(): Int {
        return closetList.size
    }
    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgClosetImg: ImageView = itemView.findViewById(R.id.clothesImg)
        val tvClosetTitle: TextView = itemView.findViewById(R.id.clothes_title)
        init {
            itemView.setOnClickListener {
                val pos = adapterPosition
                if(pos != RecyclerView.NO_POSITION && mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(itemView, pos)
                }
            }
        }
    }
}