package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RandomNumber
import racingcar.view.Input
import racingcar.view.Output

class RacingCarController {
    fun startGame(){
        val carList = createNewCars()
        val repeatTime = Input().readTryNumber()
        Output().outputMessage()
        repeat(repeatTime!!) {
            progressGame(carList)
            Output().outputExecutionResult(carList) }
        val winnerList = getWinners(carList)
        Output().outputFinalResult(winnerList)
    }
    fun createNewCars(): List<Car> {
        val nameList = Input().readCarName()
        return nameList!!.map { name -> Car(name) }
    }
    fun progressGame(carList : List<Car>) {
        carList.forEach { car ->
            car.move(RandomNumber().getRandomNumber())
        }
    }
    fun getWinners(carList: List<Car>) : List<Car>{
        val maxDistance = carList.maxOfOrNull { it.position }
        return carList.filter { car -> car.position == maxDistance }
    }
}