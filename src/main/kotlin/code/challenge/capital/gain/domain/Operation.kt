package code.challenge.capital.gain.domain

import code.challenge.capital.gain.domain.vo.Type

data class Operation(
    val type: Type,
    val unitCost: Double,
    val quantity: Int
)