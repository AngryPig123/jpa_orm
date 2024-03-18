package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.vo.Address;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    void save() {

        Address address = new Address("서울", "105-041", "104");
        Member member = new Member("홍길동", address);
        Assertions.assertDoesNotThrow(() -> memberRepository.save(member));
        Member findMember = memberRepository.findOne(member.getId());
        Assertions.assertNotNull(findMember);

    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findName() {
    }
}