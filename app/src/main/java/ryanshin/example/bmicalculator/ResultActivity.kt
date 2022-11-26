package ryanshin.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ryanshin.example.bmicalculator.databinding.ActivityMainBinding
import ryanshin.example.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //전달받은 키와 몸무게
        val height = intent?.getStringExtra("height")?.toInt() ?:0
        val weight = intent?.getStringExtra("weight")?.toInt() ?:0

        //BMI 계산
        val bmi = weight / Math.pow ( height / 100.0 , 2.0)

        //결과 표시
        when {
            bmi >= 35 -> binding.resultTextView.text = "고도비만"
            bmi >= 30 -> binding.resultTextView.text = "2단계 비만"
            bmi >= 25 -> binding.resultTextView.text = "1단계 비만"
            bmi >= 23 -> binding.resultTextView.text = "과체중"
            bmi >= 18.5 -> binding.resultTextView.text = "정상"
            else -> binding.resultTextView.text = "저체중"
        }

        //이미지 표시
        when {
            bmi >= 23 -> binding.imageView.setImageResource(
                R.drawable.ic_baseline_sentiment_very_dissatisfied_24
            )
            bmi >= 18.5 -> binding.imageView.setImageResource(
                R.drawable.ic_baseline_sentiment_satisfied_alt_24
            )
            else -> binding.imageView.setImageResource(
                R.drawable.ic_baseline_sentiment_dissatisfied_24
            )
        }
        Toast.makeText(this,"$bmi", Toast.LENGTH_SHORT).show()
    }
}