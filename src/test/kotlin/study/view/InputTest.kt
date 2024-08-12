package study.view

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.Input
import java.io.ByteArrayInputStream

class InputTest {
    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        // Given
        val input = "김종경,양두영,윤성원\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When
        val result = Input().readCarName()

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
        val result = Input().readTryNumber()

        // Then
        val expected = 5
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `시도할 횟수 입력 시 잘못된 입력을 받으면 IllegalArgumentException을 발생시켜야한다`() {
        val input = "김종경\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            Input().readTryNumber()
        }
    }

}