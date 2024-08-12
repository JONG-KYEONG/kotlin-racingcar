package racingcar.domain

import kotlin.random.Random

class Car(val name : String){
    var position : Int = 0
        private set
    init {
        require(name.length <= 5) { "자동차 이름은 5글자를 초과할 수 없습니다." }
        require(!name.contains(" ")) { "자동차 이름은 공백을 포함 할 수 없습니다." }
    }
    fun move(num : Int){
        if(num >= CAR_MOVE_CONDITION) position++
    }
    companion object {
        private const val CAR_MOVE_CONDITION = 4
    }
}
