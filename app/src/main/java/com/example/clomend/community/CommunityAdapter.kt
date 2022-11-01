package com.example.clomend.community


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R


class CommunityAdapter(private val communityList: ArrayList<CommunityData>) : RecyclerView.Adapter<CommunityAdapter.ItemViewholder>() {

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }
    private lateinit var mOnItemClickListener: OnItemClickListener
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        mOnItemClickListener = onItemClickListener
    }

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

    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCommunityImg: ImageView = itemView.findViewById(R.id.community_img)
        val tvCommunityTitle: TextView = itemView.findViewById(R.id.community_title)
        val tvWriter: TextView = itemView.findViewById(R.id.writer)
        val tvUploadTime: TextView = itemView.findViewById(R.id.uploadtime)
        val tvScore: TextView = itemView.findViewById(R.id.score)
        val tvViewCnt: TextView = itemView.findViewById(R.id.ViewCntNum)
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
