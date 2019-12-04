package com.kurly.jehui.validation.member.web;

import com.kurly.jehui.validation.validation.payload.Error;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@SuppressWarnings({"unused", "WeakerAccess"})
class Sample1 {

  @Pattern(
      regexp = "[a-z0-9]{5,12}",
      message = "sample1 loginId 오류",
      payload = Error.class
  )
  private String loginId;

  @Pattern(
      regexp = "^(?=.*\\d)(?=.*[~`!@#$%^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$",
      message = "sample1 password 오류",
      payload = Error.class
  )
  private String password;

  @Size(
      min = 2,
      max = 9,
      message = "sample1 username length: {min}~{max}",
      payload = Error.class
  )
  private String username;

  @Positive(
      message = "sample1 age > 0",
      payload = Error.class
  )
  private Integer age;

  public String getLoginId() {
    return loginId;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public Integer getAge() {
    return age;
  }


  @Override
  public String toString() {
    return "CreateRequest{" +
        "loginId='" + loginId + '\'' +
        ", password='" + password + '\'' +
        ", username='" + username + '\'' +
        ", age=" + age +
        '}';
  }
}
