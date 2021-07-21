package com.example.quizgame

object Constants {

    fun getQuestions():ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        val question1 = Questions(id = 1,questions = "What country this flag belongs to?",
        image = R.drawable.ic_flag_of_argentina, optionOne = "Argentina", optionTwo = "Belgium",
        optionThree = "Armenia", optionFour = "Austria", correctAnswer = 1)

        questionsList.add(question1)
        val que2 = Questions(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        val que3 = Questions(
                3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        val que4 = Questions(
                4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        val que5 = Questions(
                5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Gabon", "France",
                "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        val que6 = Questions(
                6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1
        )

        questionsList.add(que6)

        val que7 = Questions(
                7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        val que8 = Questions(
                8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "Ireland", "Iran",
                "Hungary", "India", 4
        )

        questionsList.add(que8)

        val que9 = Questions(
                9, "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Australia", "New Zealand",
                "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        val que10 = Questions(
                10, "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Kuwait", "Jordan",
                "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        return questionsList

    }
}