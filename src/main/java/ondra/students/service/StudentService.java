package ondra.students.service;

import jakarta.validation.constraints.NotNull;
import ondra.students.domain.jpa.Student;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Service for working with {@link Student}s.
 */
@Validated
public interface StudentService {

	/**
	 * Obtains a list of {@link Student}s. The list is sorted by {@code lastName} and then by {@code firstName}.
	 *
	 * @return the list of students
	 */
	@NotNull List<Student> getAllStudents();

	/**
	 * Obtains a {@link Student} by its ID. Throws
	 * {@link ondra.students.domain.StudentNotFoundException StudentNotFoundException} when the student cannot be
	 * found.
	 *
	 * @param id the ID
	 * @return the obtained student
	 * @throws ondra.students.domain.StudentNotFoundException when the student cannot be found
	 */
	@NotNull Student getStudent(long id);

	/**
	 * Persists a {@link Student}.
	 *
	 * @param student the student to be persisted
	 * @return the persisted student
	 */
	@NotNull Student saveStudent(@NotNull Student student);

	/**
	 * Deletes a {@link Student} by its ID.
	 *
	 * @param id the ID
	 */
	void deleteStudent(long id);

}
