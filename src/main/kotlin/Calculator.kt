class Calculator {
    companion object {
        // Словник співвідесення символів операцій функціям
        val operations: HashMap<Char, (Double, Double) -> Double> = hashMapOf(
            '+' to ::add,
            '-' to ::subtract,
            '*' to ::multiply,
            '/' to ::divide,
            '^' to ::power )

        // Додавання
        private fun add(number1: Double, number2: Double): Double {
            return number1 + number2
        }

        // Віднімання
        private fun subtract(number1: Double, number2: Double): Double {
            return number1 - number2
        }

        // Множення
        private fun multiply(number1: Double, number2: Double): Double {
            return number1 * number2
        }

        // Ділення
        private fun divide(number1: Double, number2: Double): Double {
            return number1 / number2
        }

        // Піднесення до степеня
        private fun power(number1: Double, number2: Double): Double {
            return Math.pow(number1, number2)
        }
    }
}