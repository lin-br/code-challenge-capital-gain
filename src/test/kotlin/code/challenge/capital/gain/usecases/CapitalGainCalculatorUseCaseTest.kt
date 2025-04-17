package code.challenge.capital.gain.usecases

import code.challenge.capital.gain.domain.Operation
import code.challenge.capital.gain.domain.vo.Type.BUY
import code.challenge.capital.gain.domain.vo.Type.SELL
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CapitalGainCalculatorUseCaseTest : ShouldSpec({
    should("get taxes in the first case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 100),
            Operation(SELL, 15.00, 50),
            Operation(SELL, 15.00, 50)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00)
    }

    should("get taxes in the second case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(SELL, 20.00, 5000),
            Operation(SELL, 5.00, 5000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 10000.00, 0.00)
    }

    should("get taxes in the third case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(SELL, 5.00, 5000),
            Operation(SELL, 20.00, 3000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 1000.00)
    }

    should("get taxes in the fourth case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(BUY, 25.00, 5000),
            Operation(SELL, 15.00, 10000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00)
    }

    should("get taxes in the fifth case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(BUY, 25.00, 5000),
            Operation(SELL, 15.00, 10000),
            Operation(SELL, 25.00, 5000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00, 10000.00)
    }

    should("get taxes in the sixth case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(SELL, 2.00, 5000),
            Operation(SELL, 20.00, 2000),
            Operation(SELL, 20.00, 2000),
            Operation(SELL, 25.00, 1000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00, 0.00, 3000.00)
    }

    should("get taxes in the seventh case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(SELL, 2.00, 5000),
            Operation(SELL, 20.00, 2000),
            Operation(SELL, 20.00, 2000),
            Operation(SELL, 25.00, 1000),
            Operation(BUY, 20.00, 10000),
            Operation(SELL, 15.00, 5000),
            Operation(SELL, 30.00, 4350),
            Operation(SELL, 30.00, 650)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00, 0.00, 3000.00, 0.00, 0.00, 3700.00, 0.00)
    }

    should("get taxes in the eighth case") {
        val inputData = listOf(
            Operation(BUY, 10.00, 10000),
            Operation(SELL, 50.00, 10000),
            Operation(BUY, 20.00, 10000),
            Operation(SELL, 50.00, 10000)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 80000.00, 0.00, 60000.00)
    }

    should("get taxes in the ninth case") {
        val inputData = listOf(
            Operation(BUY, 5000.00, 10),
            Operation(SELL, 4000.00, 5),
            Operation(BUY, 15000.00, 5),
            Operation(BUY, 4000.00, 2),
            Operation(BUY, 23000.00, 2),
            Operation(SELL, 20000.00, 1),
            Operation(SELL, 12000.00, 10),
            Operation(SELL, 15000.00, 3)
        )

        val taxes = CapitalGainCalculatorUseCase().calculateTaxes(inputData)

        taxes shouldBe listOf(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 1000.00)
    }
})