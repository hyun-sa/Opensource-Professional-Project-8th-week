/*
* 프로젝트명 : 명화 투표기
* 작성자 : 2019038004 조민우
* 작성일 : 2023. 4.29.
* 프로그램 설명 : 간단한 투표기
 */


package com.hyunsa.currentusing
//noinspection SuspiciousImport
import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "명화 선호도 투표"
        val voteCount = IntArray(9)
        for (i in 0..8) voteCount[i] = 0
        val image = arrayOfNulls<ImageView>(9)
        val imageId = arrayOf<Int>(
            R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
            R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9
        )
        val imgName = arrayOf(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
        )
        for (i in imageId.indices) {
            val index: Int
            index = i
            image[index] = findViewById<View>(imageId[index]) as ImageView
            image[index]!!.setOnClickListener { // TODO Auto-generated method stub
                voteCount[index]++
                Toast.makeText(
                    applicationContext,
                    imgName[index] + ": 총 " + voteCount[index] + " 표",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        val btnFinish = findViewById<View>(R.id.btnResult) as Button
        btnFinish.setOnClickListener {
            val intent = Intent(
                applicationContext,
                ResultActivity::class.java
            )
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}