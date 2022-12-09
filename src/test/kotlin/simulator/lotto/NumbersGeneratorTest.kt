package simulator.lotto

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class NumbersGeneratorTest {
    @Test
    fun `최솟값과 최댓값 사이에서 요청 갯수에 맞춰서 숫자 리스트를 반환한다`() {
        val generator = NumberGenerator(1, 6, 6)
        val expectNumbers = listOf(1, 2, 3, 4, 5, 6)
        generator.generate() shouldContainExactlyInAnyOrder expectNumbers
    }

    @Test
    fun `최솟값과 최댓값까지의 숫자 갯수는 반환될 숫자갯수보다 같거나 커야한다`() {
        assertThrows<IllegalArgumentException> {
            NumberGenerator(1, 5, 6).generate()
        }.shouldHaveMessage("최솟값과 최댓값까지의 숫자 갯수가 랜덤으로 추출할 숫자 갯수보다 작을순 없습니다.")
    }
}