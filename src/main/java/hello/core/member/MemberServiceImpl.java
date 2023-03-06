package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 인터페이스만 가지고 있으면 NPE가 발생하기 때문에 구현체가 필요함.
    // 그래서 MemberMemoryRepository 구현 객체를 선택해준다.
    // 하지만 DIP 위반, 왜냐하면 실제 할당은 구현체인 MemoryMEmberRepository지만
    // 추상체인 MemberRepository도 의존하고 있기 때문
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    // 위에서 new MemoryMemberRepository을 지우고 생성자를 만든다.
    // 그리고 AppConfig에 가서 memberService 메서드에 리턴값 파라미터에 new MemoryMemberRepository 입력
    // 이걸 생성자 주입이라고 함

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
