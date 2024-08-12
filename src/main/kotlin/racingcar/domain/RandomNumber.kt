package racingcar.domain

class RandomNumber {
    fun getRandomNumber(): Int = (MIN_NUMBER_RANGE..MAX_NUMBER_RANGE).random()
    companion object {
        private const val MIN_NUMBER_RANGE = 0
        private const val MAX_NUMBER_RANGE = 9
    }
}