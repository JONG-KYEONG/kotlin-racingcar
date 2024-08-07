package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.view.Input
import racingcar.view.Output
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.StringWriter


class CarTest {
    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        //Given
        var car = Car("김종경")
        //Then
        assertThat(car.name).isEqualTo("김종경")
    }

    @Test
    fun `init 자동차 이름은 5자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Car("김종경자동차")
        }
    }

    @Test
    fun `init 자동차 이름은 공백을 포함할 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Car("김 종경")
        }
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        // Given
        val input = "김종경,양두영,윤성원\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When
        val result = Input().inputCarName()

        // Then
        val expected = listOf("김종경", "양두영", "윤성원")
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `시도할 횟수를 입력할 수 있어야 한다`() {
        // Given
        val input = "5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When
        val result = Input().inputTryNumber()

        // Then
        val expected = 5
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `시도할 횟수 입력 시 잘못된 입력을 받으면 IllegalArgumentException을 발생시켜야한다`() {
        val input = "김종경\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            Input().inputTryNumber()
        }
    }

    @Test
    fun `자동차는 전진 또는 멈출 수 있다`() {
        //Given
        var car1 = Car("김종경")
        car1.move(3)

        var car2 = Car("양두영")
        car2.move(6)
        //Then
        assertThat(car1.position==0 && car2.position==1)
    }

    @Test
    fun `전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다`() {
        // given
        var car1 = Car("김종경")
        car1.move(3)
        var carlist = mutableListOf<Car>()
        carlist.add(car1)

        //when
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        Output().outputExecutionResult(carlist)

        // then
        val expectedOutput = "김종경 : \n"
        assertEquals(expectedOutput.trim(), outputStream.toString().trim())
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {
        // given
        var car1 = Car("김종경")
        car1.move(car1.getRandomNumber())
        car1.move(car1.getRandomNumber())
        var carlist = mutableListOf<Car>()
        carlist.add(car1)

        //when
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        Output().outputExecutionResult(carlist)

        // then
        val expectedOutput = "김종경 : \n"
        assertEquals(expectedOutput.trim(), outputStream.toString().trim())
    }
}