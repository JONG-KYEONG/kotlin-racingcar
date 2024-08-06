package racingcar.view

class Input {
    fun inputCarName(): List<String>? {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readLine()
        val list = input?.split(",")
        return list
    }

    fun inputTryNumber() : Int?{
        println("시도할 횟수는 몇 회인가요?")
        val input = readLine()
        return try {
            input?.toInt() ?: throw IllegalArgumentException()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }
}