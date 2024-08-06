package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.domain.Car


class CarTest {
    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        //Given
        var car = Car("김종경")
        //Then
        assertThat(car.name).isEqualTo("김종경")
    }

}