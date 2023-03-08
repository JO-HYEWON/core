package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {


    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 이것만 고치면 FixDiscount에서 RateDiscount로 변경 가능
    // 하지만 OCP, DIP 같은 객체지향 설계를 준수한 것은 아니다. DiscountPolicy와 RateDiscountPolicy 모두 의존하고 있기 때문
    // 추상클래스만 의존해야 하는데 구체클래스에도 의존하고 있다. DIP위반
    // 이 클래스에서 RateDiscountPolicy와 FixDiscountPolicy를 고쳐야 하는 것 자체가 문제가 되는 것. OCP위반
    // pdf 파일도 다시 읽어보자. 3번자료 4페이지부터

    // 이렇게 바꾸면 인터페이스에만 의존하게 된다. 하지만 이러면 NPE 발생.
    // private DiscountPolicy discountPolicy;

    // 문제를 해결하려면 클라이언트의 OrderserviceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야 한다. AppConfig 파일을 생성
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
