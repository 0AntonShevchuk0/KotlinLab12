class CharacterRecognizer {

    // Функції працюють незалежно, тому можна зробити їх статичними
    companion object {
        // розпізнаємо цифру за допомогою REGEX
        fun recognizeNumber(character: Char) : Boolean {
            val numberRegex = Regex("^[0-9]$")
            if (numberRegex.matches(character.toString()))
                return true;
            return false;
        }

        // розпізнаємо малі латинські літери за допомогою REGEX
        fun recognizeSmallLatinCharacter(character: Char) : Boolean {
            val numberRegex = Regex("^[a-z]$")
            if (numberRegex.matches(character.toString()))
                return true;
            return false;
        }

        // розпізнаємо всі латинські літери за допомогою REGEX, ігноруючи регістр
        fun recognizeLatinCharacter(character: Char) : Boolean {
            val numberRegex = Regex("^[a-z]$", RegexOption.IGNORE_CASE)
            if (numberRegex.matches(character.toString()))
                return true;
            return false;
        }
    }
}