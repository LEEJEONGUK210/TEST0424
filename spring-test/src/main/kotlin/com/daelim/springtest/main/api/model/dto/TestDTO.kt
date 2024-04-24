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

data class LottoResult(
    val numbers: List<Int>,
    val correctNumbers: LottoResultRequestDto,
    val result: String
)

data class LottoResultRequestDto(
    val numbers: List<Int>,
    val bonusNumber: Int
)


data class LottoResultResponseDto(
    val index: Int,
    val winningNumbers: LottoResultRequestDto,
    val results: List<LottoResult>
)