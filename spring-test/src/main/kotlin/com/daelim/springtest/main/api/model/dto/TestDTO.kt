package com.daelim.springtest.main.api.model.dto

data class UserDto(
    val fullname: String,
    val email:	String,
    val password:	String
)

data class UserRequestDto(
    val email: String,
    val password: String
)

data class LottoDto(
    val numbers : Int
)
data class LottoResult()
    numbers*	[integer($int32)]
    correctNumbers*	LottoResultRequestDto(
        numbers*	[integer($int32)]
        bonusNumber	integer($int32)
    )
    result*	string
    )

data class LottoResult(
    val numbers: List<Int>,
    val correctNumbers: LottoResultRequestDto + numbers: List<Int>
    val result: String
)



LottoResultRequestDto{
    numbers*	[integer($int32)]
    bonusNumber	integer($int32)
}

// LottoResultRequestDto.kt
data class LottoResultRequestDto(
    val numbers: List<Int>,
    val bonusNumber: Int
)


LottoResultResponseDto{
    index*	integer($int32)
    winningNumbers*	LottoResultRequestDto{
        numbers*	[integer($int32)]
        bonusNumber	integer($int32)
    }
    results*	[LottoResult{
        numbers*	[integer($int32)]
        correctNumbers*	LottoResultRequestDto{
            numbers*	[integer($int32)]
            bonusNumber	integer($int32)
        }
        result*	string
    }]
}



// LottoResultResponseDto.kt
data class LottoResultResponseDto(
    val index: Int,
    val winningNumbers: LottoResultRequestDto,
    val results: List<LottoResult>
)