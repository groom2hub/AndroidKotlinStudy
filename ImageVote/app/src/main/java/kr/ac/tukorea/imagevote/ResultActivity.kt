package kr.ac.tukorea.imagevote

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var ivMostVoted: ImageView
    lateinit var tvMostVoted: TextView
    lateinit var btnReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        title = "투표 결과"

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName!!.size)

        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)
        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        var most_voted = 0

        ivMostVoted = findViewById<ImageView>(R.id.iv_most_voted)
        tvMostVoted = findViewById<TextView>(R.id.tv_most_voted)
        btnReturn = findViewById<Button>(R.id.btnReturn)

        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }

        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        for (i in voteResult.indices) {
            if (most_voted < voteResult[i].toInt()) {
                most_voted = voteResult[i].toInt()
                ivMostVoted.setImageResource(imageFileId[i])
                tvMostVoted.setText(imageName[i])
            }
        }

        btnReturn.setOnClickListener {
            finish()
        }

    }
}