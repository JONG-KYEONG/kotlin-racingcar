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
    }

}