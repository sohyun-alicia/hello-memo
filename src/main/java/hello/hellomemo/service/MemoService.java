package hello.hellomemo.service;


import hello.hellomemo.domain.Memo;
import hello.hellomemo.repository.MemoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 회원가입
    public Long join(Memo memo) {

        validateDuplicateMemo(memo);    // 중복 회원 검증
        memoRepository.save(memo);
        return memo.getId();
    }

    private void validateDuplicateMemo(Memo memo) {
        memoRepository.findByName(memo.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Memo> findMemos() {
        return memoRepository.findAll();
    }

    public Optional<Memo> findOne(Long memoId) {
        return memoRepository.findById(memoId);
    }
}
