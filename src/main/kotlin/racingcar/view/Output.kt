package racingcar.view

import racingcar.domain.Car

class Output {
    fun outputExecutionResult(carList : List<Car>){
        carList.forEach { car ->
            print(car.name + " : ")
            repeat(car.position) {
                print("-")
            }
            println()
        }
        println()
    }

    fun outputMessage(){
        println()
        println("실행 결과")
    }

    fun outputFinalResult(winnerList : List<Car>){
        print("최종 우승자: ")
        print(winnerList.joinToString(", ") { it.name })
    }

}