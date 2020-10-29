package szl.springboothelloword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import szl.springboothelloword.mapper.hostelMapper;
import szl.springboothelloword.service.DiaryServiceImp;
import szl.springboothelloword.service.HostelServiceImp;
import szl.springboothelloword.service.StudentServiceImp;

@SpringBootTest
class SpringbootHellowordApplicationTests {

	@Autowired
	private DiaryServiceImp diaryServiceImp;

	@Test
	void contextLoads() {

		System.out.println(diaryServiceImp.selectDiary("2020/10/25"));

	}

}
