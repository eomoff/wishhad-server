package com.github.eomoff.wishhad.global.common;

import com.github.eomoff.wishhad.global.exception.CommonErrorCode;
import com.github.eomoff.wishhad.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

  private final boolean success;
  private final String message;
  private final T data;
  private final String errorCode;

  private ApiResponse(boolean success, String message, T data, String errorCode) {
    this.success = success;
    this.message = message;
    this.data = data;
    this.errorCode = errorCode;
  }

  public static <T> ApiResponse<T> ok(T data) {
    return new ApiResponse<>(true, "OK", data, null);
  }

  public static <T> ApiResponse<T> created(T data) {
    return new ApiResponse<>(true, "Created", data, null);
  }

  public static ApiResponse<Void> error(ErrorCode errorCode) {
    return new ApiResponse<>(false, errorCode.getMessage(), null, errorCode.getCode());
  }

  public static ApiResponse<Void> error(ErrorCode errorCode, String message) {
    return new ApiResponse<>(false, message, null, errorCode.getCode());
  }
}
