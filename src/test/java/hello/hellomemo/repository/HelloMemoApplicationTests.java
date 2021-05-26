package hello.hellomemo.repository;

import hello.hellomemo.domain.Memo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemoRepositoryTest {

	MemoryMemoRepository repository = new MemoryMemoRepository();

	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		//given
		Memo member = new Memo();
		member.setName("spring");

		//when
		repository.save(member);

		//then
		Memo result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		//given
		Memo member1 = new Memo();
		member1.setName("spring1");
		repository.save(member1);
		Memo member2 = new Memo();
		member2.setName("spring2");
		repository.save(member2);

		//when
		Memo result = repository.findByName("spring1").get();

		//then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		//given
		Memo member1 = new Memo();
		member1.setName("spring1");
		repository.save(member1);
		Memo member2 = new Memo();
		member2.setName("spring2");
		repository.save(member2);
		//when
		List<Memo> result = repository.findAll();
		//then
		assertThat(result.size()).isEqualTo(2);
	}
}