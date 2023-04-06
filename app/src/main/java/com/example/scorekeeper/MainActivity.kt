package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    private var mScore1: Int = 0
    private var mScore2: Int = 0

    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2:TextView

    companion object {
        const val STATE_SCORE_1 = "Team 1 Score"
        const val STATE_SCORE_2 = "Team 2 Score"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            // Set the score text views.
            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
        }
    }

    fun decreaseScore(view: View) {
        val viewID = view.id;
        when(viewID){
            R.id.decreseTeam1 ->{
                mScore1--
                mScoreText1.text = mScore1.toString()
            }
            R.id.decreseTeam2 ->{
                mScore2--
                mScoreText2.text = mScore2.toString()
        }
        }
    }
    fun increaseScore(view: View) {
        val viewID = view.id;
        when(viewID){
            R.id.increaseTeam1 ->{
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            R.id.increaseTeam2 ->{
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        val nightModeMenu = menu.findItem(R.id.night_mode)

        nightModeMenu.setTitle(
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES)
                R.string.day_mode
            else
                R.string.night_mode
        )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.night_mode){
            val nightMode = AppCompatDelegate.getDefaultNightMode()

            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true;
    }
    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}