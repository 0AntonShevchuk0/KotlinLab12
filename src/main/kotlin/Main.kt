import java.lang.Exception

// Початок програми
fun main(args: Array<String>) {
    // Показуємо меню
    showMenu()
    // Отримуємо команду ві користувача
    var input = readln()
    // Можна вводити безліч команд без перезапуску програми
    while (input.lowercase() != "q") {
        // Перевірка символу
        if (input == "1") {
            // Зчитуємо та перевіряємо кожен символ за допомогою REGEX
            println("Enter characters: ")
            val dataInput = readln()
            for (char: Char in dataInput) {
                if (CharacterRecognizer.recognizeNumber(char))
                    println("\"$char\" is a number")
                else if (CharacterRecognizer.recognizeSmallLatinCharacter(char))
                    println("\"$char\" is a small latin character")
                else if (CharacterRecognizer.recognizeLatinCharacter(char))
                    println("\"$char\" is a latin character")
                else {
                    println("\"$char\" is not a number or latin character")
                }
            }
            println()
        }
        // Визначаємо день тижня починаючи з неділі і визначаємо наступний день
        else if (input == "2") {
            println("Enter a number (1-7): ")
            val dataInput = readln()

            //перевірка - заміна try catch
            val dayNumberRegex = Regex("^[1-7]$")
            if (dayNumberRegex.matches(dataInput)) {
                val dayNumber = dataInput.toInt()
                // Знаходимо день тижня за допомогою масиву значень enum
                val day = Weekd.values()[dayNumber - 1]
                println(day)
                println("Next day - ${DaysManager.getNextDay(day)}")
            }

            else {
                println("Wrong input")
            }
            println()
        }
        // Калькулятор
        else if (input == "3") {
            //
            println("Enter a first number: ")
            val number1Input = readln()
            println("Enter a second number: ")
            val number2Input = readln()
            println("Enter 1 of operations + - * / ^ : ")
            val operationInput = readln()

            // Вхідні дані можуть бути не цифрами, тому перевіряємо їх
            try {
                val number1 = number1Input.toDouble()
                val number2 = number2Input.toDouble()

                if (Calculator.operations.containsKey(operationInput[0])) {
                    // Безпечний виклик функції за допомогою let
                    println(Calculator.operations[operationInput[0]]?.let { it(number1, number2) })
                }
                else {
                    println("Wrong input (operation)")
                }
            }
            // Різні типи помилок
            catch (e: NumberFormatException) {
                println("You entered not a number")
            }
            catch (e: Exception) {
                println("Wrong input")
            }
            println()
        }
        // Пошук мінімальних коефіцієнтів у виразі 5A - 2B = N для числа N
        else if (input == "4") {
            println("Enter an integer number (more than 2): ")
            val numberInput = readln()
            try {
                val number = numberInput.toInt()
                val numbers = ExpressionsCalculator.getCoefs(number)
                // Перевірка вигляду масиву
                if (numbers.size == 2) {
                    println("A = ${numbers[0]} B = ${numbers[1]}")
                }
            }
            catch (e: NumberFormatException) {
                println("You entered not an integer number")
            }
            catch (e: Exception) {
                println("Wrong input")
            }
            println()
        }
        else {
            println("Wrong command\n")
        }
        showMenu()
        input = readln()
    }
}

// Функція показу меню
fun showMenu() {
    println("PROGRAM MENU")
    println("1 - check character")
    println("2 - get day by number and next day")
    println("3 - calculator")
    println("4 - expression")
    println("q - quit")
}