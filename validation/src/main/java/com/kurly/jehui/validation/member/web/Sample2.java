package com.kurly.jehui.validation.member.web;

import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
class Sample2 {
  long memberSeq;

  @Pattern(
      regexp = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$",
      message = "sample2 password 오류"
  )
  String password;
}
