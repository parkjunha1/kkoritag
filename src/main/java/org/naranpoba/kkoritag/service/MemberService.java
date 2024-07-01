package org.naranpoba.kkoritag.service;

import java.util.Optional;

import org.naranpoba.kkoritag.dto.MemberDTO;
import org.naranpoba.kkoritag.entity.MemberEntity;
import org.naranpoba.kkoritag.repository.MemberRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	public void save(MemberDTO memberDTO) {
		
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
		memberRepository.save(memberEntity);
		
	}
	public MemberDTO login(MemberDTO memberDTO) {
		/*
		 * 1.회원이 입력한 이메일로 db에서 조회를 함
		 * 2.db에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
		 */
		Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
		if (byMemberEmail.isPresent()) {
			MemberEntity memberEntity = byMemberEmail.get();
			if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
				//비밀번호 일치
				//entity -> dto 변환 후 리턴
				MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
				return dto;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

}
