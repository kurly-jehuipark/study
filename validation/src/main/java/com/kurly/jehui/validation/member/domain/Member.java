package com.kurly.jehui.validation.member.domain;

import com.kurly.jehui.validation.validation.payload.Warning;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.kurly.jehui.validation.validation.SequentialValidationGroup.First;
import static com.kurly.jehui.validation.validation.SequentialValidationGroup.Second;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long seq;

  @Pattern(
      regexp = "[a-z0-9]{5,12}",
      message = "아이디는 소문자 or 숫자 5~12",
      payload = Warning.class,
      groups = First.class
  )
  private String loginId;

  private String password;

  @Size(
      min = 2,
      max = 9,
      message = "이름은 2~9자",
      payload = Warning.class
  )
  private String userName;

  @Positive(
      message = "나이는 음수일 수 없습니다.",
      payload = Warning.class
  )
  private int age;

  private LocalDateTime regDt;
  private LocalDateTime updDt;

  public void setPassword(final String password) {
    this.password = password;
  }


  @AssertTrue(groups = Second.class)
  public boolean isSecondCheck() {
    log.info("secondCheck");
    return true;
  }

  @AssertTrue
  public boolean isDefaultCheck() {
    log.info("defaultCheck");
    return true;
  }

  @AssertTrue(groups = First.class)
  public boolean isFirstCheck() {
    log.info("firstCheck");
    return true;
  }

}
