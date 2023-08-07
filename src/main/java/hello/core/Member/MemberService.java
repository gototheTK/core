package hello.core.Member;

public interface MemberService {

    void join(Member member);

    Member findManager(Long memberId);

}
