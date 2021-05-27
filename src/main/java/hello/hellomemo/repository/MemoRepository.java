package hello.hellomemo.repository;

import hello.hellomemo.domain.Memo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MemoRepository {

    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    Optional<Memo> findByName(String name);
    Optional<Memo> findByData(String data);
    Optional<Memo> findByTime(String time);
    List<Memo> findAll();
}
