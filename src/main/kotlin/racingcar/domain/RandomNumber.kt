package racingcar.domain

class RandomNumber {
    private val MIN_NUMBER_RANGE = 0
    private val MAX_NUMBER_RANGE = 9
    fun getRandomNumber(): Int = (MIN_NUMBER_RANGE..MAX_NUMBER_RANGE).random()
}