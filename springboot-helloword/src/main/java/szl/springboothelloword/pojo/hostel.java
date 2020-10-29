package szl.springboothelloword.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class hostel {

	private int id;
	private String name;
	private String administrator;
	private int maxpeople=500;
	private int existedpeople;


}
