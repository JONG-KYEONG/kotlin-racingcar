package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarService
import racingcar.domain.RandomNumber
import racingcar.view.Input
import racingcar.view.Output

class RacingCarController {
    fun startGame(){
        val carList = CarService().createNewCars()
        val repeatTime = Input().readTryNumber()
        Output().outputMessage()
        repeat(repeatTime!!) {
            CarService().progressGame(carList)
            Output().outputExecutionResult(carList) }
        val winnerList = CarService().getWinners(carList)
        Output().outputFinalResult(winnerList)
    }
}