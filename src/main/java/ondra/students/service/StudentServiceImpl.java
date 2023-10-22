package ondra.students.service;

import ondra.students.domain.StudentNotFoundException;
import ondra.students.domain.jpa.Student;
import ondra.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for working with {@link Student}s.
 */
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAllByOrderByLastNameAscFirstNameAsc();
	}

	@Override
	public Student getStudent(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

}
