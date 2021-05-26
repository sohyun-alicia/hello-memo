package hello.hellomemo.repository;

import hello.hellomemo.domain.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {

    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    Optional<Memo> findByName(String name);
    List<Memo> findAll();
}
