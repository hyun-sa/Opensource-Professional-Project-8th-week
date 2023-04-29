/*
* 프로젝트명 : 영화포스터보기
* 작성자 : 2019038004 조민우
* 작성일 : 2023. 4.29.
* 프로그램 설명 : 영화포스터 조회
 */


package com.hyunsa.currentusing

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

//noinspection SuspiciousImport


class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "갤러리 영화 포스터(개선)"
        val gallery = findViewById<View>(R.id.gallery1) as Gallery
        val galAdapter: MyGalleryAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(var context: Context) : BaseAdapter() {
        var posterID = arrayOf<Int>(
            R.drawable.mov11, R.drawable.mov12,
            R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
            R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20
        )
        var posterTitle = arrayOf(
            "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10"
        )

        override fun getCount(): Int {
            // TODO Auto-generated method stub
            return posterID.size
        }

        override fun getItem(arg0: Int): Any? {
            // TODO Auto-generated method stub
            return null
        }

        override fun getItemId(position: Int): Long {
            // TODO Auto-generated method stub
            return 0
        }

        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
            val imageview = ImageView(context)
            imageview.layoutParams = Gallery.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)
            imageview.setImageResource(posterID[position])
            imageview.setOnTouchListener { v, event ->
                val ivPoster =
                    findViewById<View>(R.id.ivPoster) as ImageView
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterID[position])
                val toast = Toast(applicationContext)
                val toastView = View.inflate(
                    applicationContext, R.layout.toast, null
                ) as View
                val toastText = toastView
                    .findViewById<View>(R.id.textView1) as TextView
                toastText.text = posterTitle[position]
                toast.view = toastView
                toast.show()
                false
            }
            return imageview
        }
    }
}
