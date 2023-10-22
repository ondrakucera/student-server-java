package ondra.students.domain;

/**
 * Thrown when a {@link ondra.students.domain.jpa.Student Student} cannot be found.
 */
public class StudentNotFoundException extends RuntimeException {

	private long id;

	/**
	 * Creates a new instance.
	 *
	 * @param studentId the student ID
	 */
	public StudentNotFoundException(long studentId) {
		super(String.format("Student with id '%s' cannot be found", studentId));
		this.id = studentId;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StudentNotFoundException{" +
			"id=" + id +
			"} " + super.toString();
	}

}
