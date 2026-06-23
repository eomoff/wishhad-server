package com.github.eomoff.wishhad.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
  String getCode();
  String getMessage();
  HttpStatus getStatus();
}
