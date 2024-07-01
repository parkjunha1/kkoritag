package org.naranpoba.kkoritag.repository;

import java.util.Optional;

import org.naranpoba.kkoritag.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<MemberEntity, Long>{
	//이메일로 회원 정보 조회(select * from member_table where member_email=?)
	Optional<MemberEntity>findByMemberEmail(String memberEmail);
}
