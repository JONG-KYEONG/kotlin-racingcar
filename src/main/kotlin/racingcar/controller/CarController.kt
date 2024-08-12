package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarService
import racingcar.view.Input
import racingcar.view.Output

class CarController {
    fun setGame(){
        val carList = CarService().createNewCars()
        val repeatTime = Input().readTryNumber()
        startGame(carList,repeatTime)
        endGame(carList)
    }
    fun startGame(carList : List<Car>, repeatTime : Int){
        Output().printMessage()
        repeat(repeatTime!!) {
            CarService().progressGame(carList)
            Output().printExecutionResult(carList) }
    }
    fun endGame(carList : List<Car>){
        val winnerList = CarService().getWinners(carList)
        Output().printFinalResult(winnerList)
    }
}