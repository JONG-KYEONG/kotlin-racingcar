package racingcar.domain

import kotlin.random.Random

class Car(val name : String, var position : Int = 0){
    init {
        require(name.length <= 5) { "자동차 이름은 5글자를 초과할 수 없습니다." }
        require(!name.contains(" ")) { "자동차 이름은 공백을 포함 할 수 없습니다." }
    }
    fun move(randomNum : Int){
        if(randomNum >= 4) position++
    }
    fun getRandomNumber(): Int{
        val numberRange = (0..9)
        val num = numberRange.random()
        return num
    }
}
