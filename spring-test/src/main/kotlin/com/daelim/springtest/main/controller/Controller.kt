package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.UserDto
import com.daelim.springtest.main.api.model.dto.UserRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/api")
class UserController {

    private val users = mutableListOf<UserDto>()

    @PostMapping("/signup")
    fun signUp(
        @RequestBody userDtoRequest: UserRequestDto
    ): ResponseEntity<String> {
        val newUser = UserDto(
            fullname = "",
            email = userDtoRequest.email,
            password = userDtoRequest.password
        )
        if (users.any { it.email == newUser.email }) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("400")
        }

        users.add(newUser)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body("200 ")
    }
}
