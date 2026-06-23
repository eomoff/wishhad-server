package com.github.eomoff.wishhad.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignupRequest(
    @NotBlank @Email String email,
    @NotBlank String password,
    @NotBlank String name,
    @NotBlank @Size(min = 2, max = 20) String nickname,
    @NotBlank @Pattern(regexp = "^01[016789]-?\\d{3,4}-?\\d{4}$", message = "유효하지 않은 번호입니다.")
    String phoneNumber
) {

}
