package com.hyunsa.currentusing

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        val intent = intent
        val voteResult = intent.getIntArrayExtra("VoteCount")
        val imageName = intent.getStringArrayExtra("ImageName")
        val imageFileId = arrayOf<Int>(
            R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
            R.drawable.pic9
        )

        // 1등 그림 이름과 그림 파일을 보여준다.
        val tvTop = findViewById<View>(R.id.tvTop) as TextView
        val ivTop = findViewById<View>(R.id.ivTop) as ImageView
        var maxEntry = 0
        for (i in 1 until voteResult!!.size) {
            if (voteResult[maxEntry] < voteResult[i]) maxEntry = i
        }
        tvTop.text = imageName!![maxEntry]
        ivTop.setImageResource(imageFileId[maxEntry])

        // 9개의 TextView, RatingBar 객체배열
        val tv = arrayOfNulls<TextView>(
            imageName.size
        )
        val rbar = arrayOfNulls<RatingBar>(
            imageName.size
        )

        // 9개의 TextView, RatingBar ID 배열
        val tvID = arrayOf<Int>(
            R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
            R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9
        )
        val rbarID = arrayOf<Int>(
            R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
            R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9
        )

        // TextView, RatingBar 개체 찾기.
        for (i in voteResult.indices) {
            tv[i] = findViewById<View>(tvID[i]) as TextView
            rbar[i] = findViewById<View>(rbarID[i]) as RatingBar
        }

        // 각 TextVeiw 및 RatingBar에 넘겨 받은 값을 반영.
        for (i in voteResult.indices) {
            tv[i]!!.text = imageName[i]
            rbar[i]!!.rating = voteResult[i].toFloat()
        }
        val btnReturn = findViewById<View>(R.id.btnReturn) as Button
        btnReturn.setOnClickListener { finish() }
    }
}