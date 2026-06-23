package com.github.eomoff.wishhad.domain.user.mapper;

import com.github.eomoff.wishhad.domain.user.dto.SignupResponse;
import com.github.eomoff.wishhad.domain.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  SignupResponse toSignupResponse(User user);
}
