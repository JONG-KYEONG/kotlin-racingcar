package study.view

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.RandomNumber
import racingcar.view.Output
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    @Test
    fun `전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다`() {
        // given
        var car1 = Car("김종경")
        car1.move()
        var carlist = mutableListOf<Car>()
        carlist.add(car1)

        //when
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        Output().printExecutionResult(carlist)

        // then
        val expectedOutput = "김종경 : \n"
        Assertions.assertEquals(expectedOutput.trim(), outputStream.toString().trim())
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {
        // given
        var car1 = Car("김종경")
        car1.move()
        car1.move()
        var carlist = mutableListOf<Car>()
        carlist.add(car1)

        //when
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        Output().printExecutionResult(carlist)

        // then
        val expectedOutput = "김종경 : \n"
        Assertions.assertEquals(expectedOutput.trim(), outputStream.toString().trim())
    }
}