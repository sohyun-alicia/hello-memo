package hello.hellomemo;


import hello.hellomemo.repository.JpaMemoRepository;
import hello.hellomemo.repository.MemoRepository;
import hello.hellomemo.repository.MemoryMemoRepository;
import hello.hellomemo.service.MemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemoService memoService() {
        return new MemoService(memoRepository());
    }


    @Bean
    public MemoRepository memoRepository() {
        return new JpaMemoRepository(em);
    }
}
