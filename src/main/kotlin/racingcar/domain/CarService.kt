package racingcar.domain

import racingcar.view.Input

class CarService {
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