package hello.hellomemo.repository;

import hello.hellomemo.domain.Memo;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class JpaMemoRepository implements MemoRepository{
    private final EntityManager em;

    public JpaMemoRepository(EntityManager em) {
        this.em = em;
    }

    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        Memo memo = em.find(Memo.class, id);
        return Optional.ofNullable(memo);
    }

    @Override
    public List<Memo> findAll() {
        return em.createQuery("select m from Memo m", Memo.class)
                .getResultList();
    }

    @Override
    public Optional<Memo> findByName(String name) {
        List<Memo> result = em.createQuery("select m from Memo m where m.name = :name", Memo.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Memo> findByData(String data) {
        List<Memo> result = em.createQuery("select m from Memo m where m.data = :data", Memo.class)
                .setParameter("data", data)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Memo> findByTime(String time) {
            List<Memo> result = em.createQuery("select m from Memo m where m.time = :time", Memo.class)
                .setParameter("time", time)
                .getResultList();
        return result.stream().findAny();
    }
}
