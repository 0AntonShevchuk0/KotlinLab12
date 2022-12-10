class ExpressionsCalculator {
    // Функція працює незалежно, тому можна зробити її статичною
    companion object {
        fun getCoefs(number: Int): Array<Int> {
            // Якщо N < 3, розв'язків немає
            if (number < 3) {
                println("wrong number")
                return arrayOf()
            }

            // знаходимо мінімальне A
            val tmpCoef = number / 5 + 1
            // 2 Варіанти: мінімальне A, або мінімальне A + 1
            val firstExpressionNumber1 = (tmpCoef) * 5
            val firstExpressionNumber2 = (tmpCoef + 1) * 5
            // Якщо число, що треба відняти ділиться на 2, то все правильно
            if ((number - firstExpressionNumber1) % 2 == 0)  {
                return arrayOf(tmpCoef, (firstExpressionNumber1 - number) / 2)
            }
            else {
                return arrayOf(tmpCoef + 1, (firstExpressionNumber2 - number) / 2)
            }
        }
    }
}