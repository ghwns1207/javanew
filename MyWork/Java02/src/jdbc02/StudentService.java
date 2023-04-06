package jdbc02;

import java.util.List;

public class StudentService {

	StudentDAO dao = new StudentDAO();

	// ** SelectList
	public List<StudentVO> selectList() {
		return dao.selectList();
	}
	
	// ** SelectOne Detail 
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}
	
	// ** Insert
	public int insert(StudentVO vo) {
		return dao.insert(vo);
	}
	
	// ** Update
	public int update(StudentVO vo) {
		return dao.update(vo);
	}
	
	// ** Detete

	public int delete(StudentVO vo) {
		return dao.delete(vo);
	}
	
}
