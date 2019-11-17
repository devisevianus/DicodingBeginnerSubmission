package com.devis.dicodingbeginnersubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_account -> {
                AboutActivity.startThisActivity(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        tv_toolbar_title.text = resources.getString(R.string.title_bwf_world_ranking)
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
        val pictureList = resources.getStringArray(R.array.player_picture)
        val birthdateList = resources.getStringArray(R.array.birthday_list)
        val careerWinsList = resources.getIntArray(R.array.wins_list)
        val tourRankList = resources.getIntArray(R.array.tour_rank)
        for (i in rankList.indices) {
            val playerMdl = PlayerMdl()
            playerMdl.rank = rankList[i]
            playerMdl.name = nameList[i]
            playerMdl.avatar = pictureList[i]
            playerMdl.date = birthdateList[i]
            playerMdl.tourRank = tourRankList[i]
            playerMdl.careerWins = careerWinsList[i]
            if (nameList[i].equals("kento momota", ignoreCase = true)) {
                playerMdl.nation = FLAG_JAPAN_URL
                playerMdl.playHanded = resources.getString(R.string.left_handed)
                playerMdl.description = resources.getString(R.string.text_description_kento_momota)
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("chou tien chen", ignoreCase = true)) {
                playerMdl.nation = FLAG_TAIPEI_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                playerMdl.description = resources.getString(R.string.text_description_chou)
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("chen long", ignoreCase = true)
                || nameList[i].equals("shi yu qi", ignoreCase = true)) {
                playerMdl.nation = FLAG_CHINA_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                if (nameList[i].contains("chen", ignoreCase = true)) {
                    playerMdl.description = resources.getString(R.string.text_description_chen_long)
                } else {
                    playerMdl.description = resources.getString(R.string.text_description_shi_yu_qi)
                }
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("anders antonsen", ignoreCase = true)
                || nameList[i].equals("viktor axelsen", ignoreCase = true)) {
                playerMdl.nation = FLAG_DENMARK_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                if (nameList[i].contains("antonsen", ignoreCase = true)) {
                    playerMdl.description = resources.getString(R.string.text_description_antonsen)
                } else {
                    playerMdl.description = resources.getString(R.string.text_description_axelsen)
                }
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("jonatan christie", ignoreCase = true)
                || nameList[i].equals("anthony s ginting", ignoreCase = true)) {
                playerMdl.nation = FLAG_INDONESIA_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                if (nameList[i].contains("christie", ignoreCase = true)) {
                    playerMdl.description = resources.getString(R.string.text_description_christie)
                } else {
                    playerMdl.description = resources.getString(R.string.text_description_ginting)
                }
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("ng ka long a", ignoreCase = true)) {
                playerMdl.nation = FLAG_HONGKONG_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                playerMdl.description = resources.getString(R.string.text_description_ngkalong)
                listPlayer.add(playerMdl)
            }
            if (nameList[i].equals("kidambi srikanth", ignoreCase = true)) {
                playerMdl.nation = FLAG_INDIA_URL
                playerMdl.playHanded = resources.getString(R.string.right_handed)
                playerMdl.description = resources.getString(R.string.text_description_kidambi)
                listPlayer.add(playerMdl)
            }
        }

        return listPlayer
    }
}
