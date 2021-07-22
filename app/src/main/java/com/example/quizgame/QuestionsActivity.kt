package com.example.quizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionsList = Constants.getQuestions()
        Log.i("Question size", "${questionsList.size}")

      /*  for(i in questionsList.size-1 downTo 0){

            progressBar.progress = i
            numericalProgress.text = "$i"+"/"+progressBar.max
            question_image.setImageResource(questionsList[i].image)
            question_text.text = questionsList[i].questions
            text_optionOne.text = questionsList[i].optionOne
            text_optionTwo.text = questionsList[i].optionTwo
            text_optionThree.text = questionsList[i].optionThree
            text_optionFour.text = questionsList[i].optionFour


        } */  // Lots of errors are there when I tried to run loop on Arraylist.

        val currentPosition = 1
        val question:Questions? = questionsList[currentPosition-1]

        progressBar.progress = currentPosition
        numericalProgress.text = "$currentPosition"+"/"+progressBar.max

        question_text.text = question!!.questions
        question_image.setImageResource(question.image)
        text_optionOne.text = question.optionOne
        text_optionTwo.text = question.optionTwo
        text_optionThree.text = question.optionThree
        text_optionFour.text = question.optionFour

    }
}