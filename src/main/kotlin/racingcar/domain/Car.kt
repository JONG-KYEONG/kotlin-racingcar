package racingcar.domain

class Car(val name : String, var position : Int = 0){
    init {
        require(name.length <= 5) { "자동차 이름은 5글자를 초과할 수 없습니다." }
        require(!name.contains(" ")) { "자동차 이름은 공백을 포함 할 수 없습니다." }
    }
}
