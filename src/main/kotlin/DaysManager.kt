class DaysManager {
    // Функція працює незалежно, тому можна зробити її статичною
    companion object {
        // Знаходимо наступні дні за допомогою індексації в enum
        fun getNextDay(day: Weekd): Weekd {
            if (day != Weekd.Saturday) {
                return Weekd.values()[day.ordinal + 1]
            }
            else {
                return Weekd.Sunday
            }
        }
    }
}