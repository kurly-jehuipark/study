package com.kurly.jehui.validation.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  @Override
  <S extends Member> S save(S entity);
}
