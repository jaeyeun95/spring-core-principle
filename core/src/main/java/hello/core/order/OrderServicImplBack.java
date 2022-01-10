//package hello.core.order;
//
//import hello.core.discount.DiscountPolicy;
//import hello.core.member.Member;
//import hello.core.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class OrderServicImplBack implements OrderService {
//    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
//
////    아래와 같이 하면 인터페이스와 구현 클래스 둘다에 의존하게 되는 것이다. -> DIP 위반
////    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
////    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//
//    // 생성자 주입
//    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;
//
//    // setter 주입(수정자 주입)
////    @Autowired
////    public void setMemberRepository(MemberRepository memberRepository){
////        System.out.println("member");
////        this.memberRepository = memberRepository;
////    }
////
////    @Autowired
////    public void setDiscountPolicy(DiscountPolicy discountPolicy){
////        System.out.println("discount");
////        this.discountPolicy = discountPolicy;
////    }
//
////    롬복 사용
////    롬북에서 제공해주는 @RequiredArgsConstructor 어노테이션을 사용하면 아래의 코드를 자동으로 생성해준다.
//
////    생성자가 1개일 경우는 @Autowired 생략이 가능
////    @Autowired
////    public OrderServicImplBack(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
////        System.out.println("생성자 주입");
////        this.memberRepository = memberRepository;
////        this.discountPolicy = discountPolicy;
////    }
//
//
//    @Override
//    public Order createOrder(Long memberId, String itemName, int itemPrice) {
//        Member member = memberRepository.findById(memberId);
//        int discountPrice = discountPolicy.discount(member, itemPrice);
//
//        return new Order(memberId, itemName, itemPrice, discountPrice);
//    }
//
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
//}
