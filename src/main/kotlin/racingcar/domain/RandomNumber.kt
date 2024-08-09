package racingcar.domain

class RandomNumber {
    private val MIN_NUMBER_RANGE = 0
    private val MAX_NUMBER_RANGE = 9
    fun getRandomNumber(): Int{
        val numberRange = (MIN_NUMBER_RANGE..MAX_NUMBER_RANGE)
        val num = numberRange.random()
        return num
    }
}