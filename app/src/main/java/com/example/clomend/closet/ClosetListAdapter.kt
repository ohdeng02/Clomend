package com.example.clomend.closet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ClosetListAdapter(
    private val context: Context, private val dataList: ArrayList<DataVo>
) : RecyclerView.Adapter<ClosterListAdapter.ItemViewHolder>() {

    var mPosition = 0

    fun getPosition(): Int {
        return mPosition
    }

    private fun setPosition(position: Int) {
        mPosition = position
    }

    fun addItem(dataVo: DataVo) {
        dataList.add(dataVo)
        //갱신처리 반드시 해야함
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            //notifyItemRemoved(position)
            //갱신처리 반드시 해야함
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val clothes_img = itemView.findViewById<ImageView>(R.id.img_clothes)
        private val clothes_subject = itemView.findViewById<TextView>(R.id.txt_clothes_subject)

        fun bind(dataVo: DataVo, context: Context) {
            if (dataVo.photo != "") {
                val resourceId =
                    context.resources.getIdentifier(dataVo.photo, "drawable", context.packageName)

                if (resourceId > 0) {
                    userPhoto.setImageResource(resourceId)
                } else {
                    userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                }
            } else {
                userPhoto.setImageResource(R.mipmap.ic_launcher_round)
            }

            //TextView에 데이터 세팅
            userName.text = dataVo.name
            userPay.text = dataVo.pay.toString()
            userAddress.text = dataVo.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)

        holder.itemView.setOnClickListener { view ->
            setPosition(position)
            Toast.makeText(view.context, "$position 아이템 클릭!", Toast.LENGTH_SHORT).show()

            // open another activity on item click
            val intent = Intent(context, AnotherActivity::class.java)
            intent.putExtra("image_name", dataList[position].photo) // put image data in Intent
            context.startActivity(intent) // start Intent

        }

        holder.itemView.setOnLongClickListener { view ->
            setPosition(position)
            Toast.makeText(view.context, "$position 아이템 롱클릭!", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}