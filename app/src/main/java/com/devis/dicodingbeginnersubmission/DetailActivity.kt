package com.devis.dicodingbeginnersubmission

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * Created by devis on 2019-11-11
 */

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    companion object {
        fun startThisActivity(context: Context, data: PlayerMdl) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("playerMdl", Gson().toJson(data))
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tv_toolbar_title.text = resources.getString(R.string.title_player_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val extra = intent.getStringExtra("playerMdl")
        val playerMdl = Gson().fromJson(extra, PlayerMdl::class.java)

        Glide.with(this)
            .load(playerMdl.nation)
            .into(iv_nation)

        Glide.with(this)
            .load(playerMdl.avatar)
            .into(iv_profile_picture)

        tv_player_name.text = playerMdl.name
        tv_player_date.text = playerMdl.date
        tv_career_wins.text = playerMdl.careerWins.toString()
        tv_world_rank.text = playerMdl.rank.toString()
        tv_world_tour_rank.text = playerMdl.tourRank.toString()
        tv_player_description.text = playerMdl.description
        tv_age.text = playerMdl.date?.convertToDate()?.getAge().toString()

        if (playerMdl.playHanded.equals(
                resources.getString(R.string.left_handed),
                ignoreCase = true)) {
            iv_player_hand.setImageDrawable(
                resources.getDrawable(R.drawable.ic_player_left_hand)
            )
        } else {
            iv_player_hand.setImageDrawable(
                resources.getDrawable(R.drawable.ic_player_right_hand)
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}