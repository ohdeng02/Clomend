package com.example.clomend.coordi_book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R

class CoordibookAdapter(private val coordiList: ArrayList<CoordibookData>):RecyclerView.Adapter<CoordibookAdapter.ItemViewholder>() {

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }
    private lateinit var mOnItemClickListener: OnItemClickListener
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        mOnItemClickListener = onItemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordibookAdapter.ItemViewholder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_coordi,
                parent, false)
        return ItemViewholder(itemView)
    }
    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val currentItem = coordiList[position]
        holder.imgCoordiImg.setImageResource(currentItem.img)
        holder.tvCoordiTitle.text = currentItem.coordiTitle
        holder.tvCoordiGenDate.text=currentItem.gen_date
    }

    override fun getItemCount(): Int {
        return coordiList.size
    }
    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCoordiImg: ImageView = itemView.findViewById(R.id.coordi_img)
        val tvCoordiTitle: TextView = itemView.findViewById(R.id.coordi_title)
        val tvCoordiGenDate: TextView = itemView.findViewById(R.id.coordi_gen_date)
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