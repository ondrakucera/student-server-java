package ondra.students.converter;

import ondra.students.domain.jpa.Student;
import ondra.students.restapi.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter between a {@link Student} and a {StudentDto}.
 */
@Component
public class StudentConverter {

	/**
	 * Converts a {@link StudentDto} to {@link Student}.
	 *
	 * @param studentDto the student DTO
	 * @return the converted student
	 */
	public Student fromDto(StudentDto studentDto) {
		Student student = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		return student;
	}

	/**
	 * Converts a {@link Student} to a {@link StudentDto}.
	 *
	 * @param student the student
	 * @return the converted student DTO
	 */
	public StudentDto toDto(Student student) {
		return new StudentDto()
			.id(student.getId())
			.firstName(student.getFirstName())
			.lastName(student.getLastName());
	}

	/**
	 * Converts a list of {@link Student}s to a list of {@link StudentDto}.
	 *
	 * @param students the students
	 * @return the converted student DTOs
	 */
	public List<StudentDto> toDtos(List<Student> students) {
		if (students == null) {
			return Collections.emptyList();
		}
		return students.stream().map(this::toDto).collect(Collectors.toList());
	}

}
