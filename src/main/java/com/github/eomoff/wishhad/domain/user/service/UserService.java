package com.github.eomoff.wishhad.domain.user.service;

import com.github.eomoff.wishhad.domain.user.dto.SignupRequest;
import com.github.eomoff.wishhad.domain.user.dto.SignupResponse;
import com.github.eomoff.wishhad.domain.user.entity.User;
import com.github.eomoff.wishhad.domain.user.exception.UserErrorCode;
import com.github.eomoff.wishhad.domain.user.mapper.UserMapper;
import com.github.eomoff.wishhad.domain.user.repository.UserRepository;
import com.github.eomoff.wishhad.global.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public SignupResponse signup(SignupRequest request) {

    validateEmailNotDuplicate(request.email());
    validatePhoneNumberNotDuplicate(request.phoneNumber());
    validateNicknameNotDuplicate(request.nickname());

    User user = User.register(
        request.email(),
        passwordEncoder.encode(request.password()),
        request.name(),
        request.nickname(),
        request.phoneNumber());

    User savedUser = userRepository.save(user);

    return userMapper.toSignupResponse(savedUser);
  }


  private void validateEmailNotDuplicate(String email) {
    if (userRepository.existsByEmail(email)) {
      throw new BusinessException(UserErrorCode.DUPLICATE_EMAIL);
    }
  }

  private void validatePhoneNumberNotDuplicate(String phoneNumber) {
    if (userRepository.existsByPhoneNumber(phoneNumber)) {
      throw new BusinessException(UserErrorCode.DUPLICATE_PHONE_NUMBER);
    }
  }

  private void validateNicknameNotDuplicate(String nickname) {
    if (userRepository.existsByNickname(nickname)) {
      throw new BusinessException(UserErrorCode.DUPLICATE_NICKNAME);
    }
  }

}
