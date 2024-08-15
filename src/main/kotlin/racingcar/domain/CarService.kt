package racingcar.domain

class CarService {
    fun createNewCars(names: List<String>?): List<Car> {
        return names!!.map { name -> Car(name) }
    }
    fun progressGame(carList : List<Car>) {
        carList.forEach { car ->
            if(RandomNumber().getRandomNumber() >= CAR_MOVE_CONDITION)
            car.move()
        }
    }
    fun getWinners(carList: List<Car>) : List<Car>{
        val maxDistance = carList.maxOfOrNull { it.position }
        return carList.filter { car -> car.position == maxDistance }
    }
    companion object {
        private const val CAR_MOVE_CONDITION = 4
    }
}