package com.example.quizgame

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import kotlinx.android.synthetic.main.activity_questions.*
import org.w3c.dom.Text

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers:Int = 0
    private var mUserName:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        text_optionOne.setOnClickListener(this)
        text_optionTwo.setOnClickListener(this)
        text_optionThree.setOnClickListener(this)
        text_optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        // Log.i("Question size", "${questionsList.size}")

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



    }

    private fun setQuestion(){

        val question= mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        numericalProgress.text = "$mCurrentPosition"+"/"+progressBar.max

        question_text.text = question!!.questions
        question_image.setImageResource(question.image)
        text_optionOne.text = question.optionOne
        text_optionTwo.text = question.optionTwo
        text_optionThree.text = question.optionThree
        text_optionFour.text = question.optionFour

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,text_optionOne)
        options.add(1,text_optionTwo)
        options.add(2,text_optionThree)
        options.add(3,text_optionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.text_optionOne -> {
                selectedOptionView(text_optionOne,1)
            }
            R.id.text_optionTwo-> {
                selectedOptionView(text_optionTwo,2)
            }
            R.id.text_optionThree -> {
                selectedOptionView(text_optionThree,3)
            }
            R.id.text_optionFour -> {
                selectedOptionView(text_optionFour,4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        } else ->{
                          //  Toast.makeText(this,"You have successfully completed the Quiz", Toast.LENGTH_SHORT ).show()
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                } else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    } else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)


    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 -> {
                text_optionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                text_optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                text_optionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                text_optionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}