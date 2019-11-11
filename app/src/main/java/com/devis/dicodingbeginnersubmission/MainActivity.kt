package com.devis.dicodingbeginnersubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val FLAG_JAPAN_URL = "https://extranet.bwfbadminton.com/docs/flags/japan.png"
        const val FLAG_INDONESIA_URL = "https://extranet.bwfbadminton.com/docs/flags/indonesia.png"
        const val FLAG_TAIPEI_URL = "https://extranet.bwfbadminton.com/docs/flags/chinesetaipei.png"
        const val FLAG_CHINA_URL = "https://extranet.bwfbadminton.com/docs/flags/china.png"
        const val FLAG_DENMARK_URL = "https://extranet.bwfbadminton.com/docs/flags/denmark.png"
        const val FLAG_HONGKONG_URL = "https://extranet.bwfbadminton.com/docs/flags/hongkong.png"
        const val FLAG_INDIA_URL = "https://extranet.bwfbadminton.com/docs/flags/india.png"
    }

    private lateinit var mAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initRecyclerView()
    }

    private fun initToolbar() {
        tv_toolbar_title.text = "BWF World Ranking"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        mAdapter = ListAdapter(this, mPlayerList)
        rv_player_list.apply {
            this.layoutManager = layoutManager
            adapter = mAdapter
        }
        mAdapter.notifyDataSetChanged()
    }

    private val mPlayerList: ArrayList<PlayerMdl> get() {
        val listPlayer: ArrayList<PlayerMdl> = arrayListOf()
        val rankList = resources.getIntArray(R.array.rank_list)
        val nameList = resources.getStringArray(R.array.player_name)
        for (i in rankList.indices) {
            val playerMdl = PlayerMdl()
            playerMdl.rank = rankList[i]
            playerMdl.name = nameList[i]
            if (nameList[i].equals("kento momota", ignoreCase = true)) {
                playerMdl.nation = FLAG_JAPAN_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("chou tien chen", ignoreCase = true)) {
                playerMdl.nation = FLAG_TAIPEI_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("chen long", ignoreCase = true)
                || nameList[i].equals("shi yu qi", ignoreCase = true)) {
                playerMdl.nation = FLAG_CHINA_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("anders antonses", ignoreCase = true)
                || nameList[i].equals("viktor axelsen", ignoreCase = true)) {
                playerMdl.nation = FLAG_DENMARK_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("jonatan christie", ignoreCase = true)
                || nameList[i].equals("anthony s ginting", ignoreCase = true)) {
                playerMdl.nation = FLAG_INDONESIA_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("ng ka long a", ignoreCase = true)) {
                playerMdl.nation = FLAG_HONGKONG_URL
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("kidambi srikanth", ignoreCase = true)) {
                playerMdl.nation = FLAG_INDIA_URL
                listPlayer.add(playerMdl)
            }
        }

        return listPlayer
    }
}
