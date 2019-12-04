package com.kurly.jehui.validation.member.domain;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  public void 회원정보저장_나이오류() {
    Member member = Member.builder()
        .loginId("testuser")
        .password("password")
        .userName("name")
        .age(0)
        .build();

    try {
      memberRepository.save(member);
      fail();
    } catch (ConstraintViolationException expected) {
      log.info("expected error");
    }
  }

  @Test
  public void 회원정보저장_이름오류() {
    Member member = Member.builder()
        .loginId("testuser")
        .password("password")
        .userName("nameㄹㅁㄹㅁㄹㅁㄹㅁㄹ")
        .age(10)
        .build();

    try {
      memberRepository.save(member);
      fail();
    } catch (ConstraintViolationException expected) {
      log.info("expected error");
    }
  }

  @Test
  public void 회원정보저장_정상() {
    Member member = Member.builder()
        .loginId("testuser")
        .password("password")
        .userName("name")
        .age(1)
        .build();

    memberRepository.save(member);

    System.out.println(member.getSeq());
  }
}