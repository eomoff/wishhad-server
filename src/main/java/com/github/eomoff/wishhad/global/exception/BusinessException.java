package com.github.eomoff.wishhad.global.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final CommonErrorCode errorCode;

  public BusinessException(CommonErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public BusinessException(CommonErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
