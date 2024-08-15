package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarService
import racingcar.view.Input
import racingcar.view.Output

class CarController {
    fun setGame(){
        val names = Input().readCarName()
        val cars = CarService().createNewCars(names)
        val repeatTime = Input().readTryNumber()
        startGame(cars,repeatTime)
        endGame(cars)
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