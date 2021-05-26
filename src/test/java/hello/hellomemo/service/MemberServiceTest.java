package hello.hellomemo.service;


import hello.hellomemo.domain.Memo;
import hello.hellomemo.repository.MemoryMemoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoService memberService;
    MemoryMemoRepository memberRepository;
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemoRepository();
        memberService = new MemoService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    public void 회원가입() throws Exception {
        //Given
        Memo member = new Memo();
        member.setName("hello");
        //When
         Long saveId = memberService.join(member);
         //Then
        Memo findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Memo member1 = new Memo();
        member1.setName("spring");
        Memo member2 = new Memo();
        member2.setName("spring");
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); } }