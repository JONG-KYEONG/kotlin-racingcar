package study.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car


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
    fun `자동차는 전진 또는 멈출 수 있다`() {
        //Given
        var car1 = Car("김종경")
        car1.move()

        var car2 = Car("양두영")
        car2.move()
        //Then
        assertThat(car1.position==0 && car2.position==1)
    }

}