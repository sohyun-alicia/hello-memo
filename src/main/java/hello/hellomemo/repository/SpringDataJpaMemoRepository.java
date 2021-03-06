package hello.hellomemo.repository;

import hello.hellomemo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface SpringDataJpaMemoRepository extends JpaRepository<Memo, Long>, MemoRepository {

    Optional<Memo> findByName(String name);

    Optional<Memo> findByData(String data);

    Optional<Memo> findByTime(String time);


}
