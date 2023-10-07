package com.company.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDTO(

        val id: String,
        val balance: BigDecimal? = BigDecimal.ZERO,
        val transactions: Set<TransactionDTO>?,
        val creationDate: LocalDateTime

)
