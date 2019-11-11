package com.devis.dicodingbeginnersubmission

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by devis on 2019-11-11
 */

class ListAdapter(val context: Context, var item: List<PlayerMdl>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playerMdl = item[position]
        holder.bind(context, holder, playerMdl)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val rank = itemView.findViewById<TextView>(R.id.tv_rank)
        private val nation = itemView.findViewById<ImageView>(R.id.iv_nation)
        private val name = itemView.findViewById<TextView>(R.id.tv_name)

        fun bind(context: Context, holder: ViewHolder, playerMdl: PlayerMdl) {
            holder.rank.text = playerMdl.rank.toString()
            holder.name.text = playerMdl.name

            Glide.with(context)
                .load(playerMdl.nation)
                .into(holder.nation)
        }
    }

}