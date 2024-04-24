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
            .body("200")
    }

    @RestController
    @RequestMapping("/api")
    class UserController {


        private lateinit var userRepository: UserRepository

        private lateinit var passwordEncoder: PasswordEncoder

        @PostMapping("/login")
        fun login(@RequestBody loginRequestDto: LoginRequestDto): ResponseEntity<String> {
            val user = userRepository.findByEmail(loginRequestDto.email)
                ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("등록되지 않은 이메일입니다.")

            if (!passwordEncoder.matches(loginRequestDto.password, user.password)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("비밀번호가 일치하지 않습니다.")
            }

            return ResponseEntity.ok("로그인 성공")
        }
    }
    @Repository
    interface UserRepository : JpaRepository<User, Long> {
        fun findByEmail(email: String): User?
    }

}
