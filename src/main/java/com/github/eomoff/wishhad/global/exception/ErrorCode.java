package com.github.eomoff.wishhad.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  INVALID_INPUT("C001", "잘못된 입력값입니다.", HttpStatus.BAD_REQUEST),
  RESOURCE_NOT_FOUND("C002", "요청한 리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
  UNAUTHORIZED("C003", "인증이 필요합니다.", HttpStatus.UNAUTHORIZED),
  FORBIDDEN("C004", "접근 권한이 없습니다.", HttpStatus.FORBIDDEN),
  DUPLICATE_RESOURCE("C005", "이미 존재하는 리소스입니다.", HttpStatus.CONFLICT),
  INTERNAL_SERVER_ERROR("C006", "서버 내부 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

  USER_NOT_FOUND("U001", "사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

  private final String code;
  private final String message;
  private final HttpStatus status;
}
