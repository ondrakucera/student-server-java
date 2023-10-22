package ondra.students.repository;

import jakarta.validation.constraints.NotNull;
import ondra.students.domain.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Repository for working with {@link Student}s.
 */
@Validated
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	/**
	 * Obtains a list of {@link Student}s. The list is sorted by {@code lastName} and then by {@code firstName}.
	 *
	 * @return the list of students
	 */
	@NotNull List<Student> findAllByOrderByLastNameAscFirstNameAsc();

}
