package cs208;

/**
 * The RegisteredStudentJoinResult represents a row from the table resulted from the
 * multiple SQL join statements between
 *      registered_students,
 *      students and
 *      classes
 * tables in the database.
 *
 * The reason why we stored the result of the joins in this class, is because the results of the
 * joins are not a Student object, nor a Class object, nor a RegisteredStudent object,
 * but a combination of all.
 *
 * Finally, we need this object to be able to return a list of RegisteredStudentJoinResult objects
 * as JSON.
 */
public class RegisteredStudentJoinResult
{
    private int studentId;
    private String studentFullName;
    private String code;
    private String title;

    public RegisteredStudentJoinResult(int studentId, String studentFullName, String code, String title)
    {
        this.studentId = studentId;
        this.studentFullName = studentFullName;
        this.code = code;
        this.title = title;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public String getStudentFullName()
    {
        return studentFullName;
    }

    public String getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString()
    {
        return "RegisteredStudentJoinResult{" +
                "studentId=" + studentId +
                ", studentFullName='" + studentFullName + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
