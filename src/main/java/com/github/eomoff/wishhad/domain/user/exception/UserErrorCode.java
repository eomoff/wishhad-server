package com.github.eomoff.wishhad.domain.user.exception;

import com.github.eomoff.wishhad.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
  USER_NOT_FOUND("U001", "사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
  DUPLICATE_EMAIL("U002", "이미 사용 중인 이메일입니다.", HttpStatus.CONFLICT),
  DUPLICATE_NICKNAME("U003", "이미 사용 중인 닉네임입니다.", HttpStatus.CONFLICT),
  DUPLICATE_PHONE_NUMBER("U004", "이미 사용 중인 전화번호입니다.", HttpStatus.CONFLICT);

  private final String code;
  private final String message;
  private final HttpStatus status;
}
