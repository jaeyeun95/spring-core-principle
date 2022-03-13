package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /*
        return null 로그인 실패
     */
    public Member login(String longId, String password){
//        Optional<Member> findMemberOptional = memberRepository.findByLoginId(longId);
//        Member member = findMemberOptional.get();
//        if (member.getLoginId().equals(password)){
//            return member;
//        }else {
//            return null;
//        }
        return memberRepository.findByLoginId(longId)
                .filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
