package com.github.eomoff.wishhad.domain.user.dto;

import com.github.eomoff.wishhad.domain.user.entity.UserStatus;

public record SignupResponse(
    Long id,
    String email,
    String name,
    String nickname,
    String phoneNumber,
    UserStatus status
) {

}
