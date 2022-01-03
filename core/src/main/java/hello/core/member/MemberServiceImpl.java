package hello.core.member;

public class MemberServiceImpl implements MemberService{
//      이렇게 사용하는 것은 공연시 남자 배우가 여자배우를 지정하는 것과 같은 이치
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    때문에 생성자를 통해서 구현체를 명확하게 해준다
    private final MemberRepository memberRepository;

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
