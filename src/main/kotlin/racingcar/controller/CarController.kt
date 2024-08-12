package racingcar.controller

import racingcar.domain.CarService
import racingcar.view.Input
import racingcar.view.Output

class CarController {
    fun startGame(){
        val carList = CarService().createNewCars()
        val repeatTime = Input().readTryNumber()
        Output().printMessage()
        repeat(repeatTime!!) {
            CarService().progressGame(carList)
            Output().printExecutionResult(carList) }
        val winnerList = CarService().getWinners(carList)
        Output().printFinalResult(winnerList)
    }
}