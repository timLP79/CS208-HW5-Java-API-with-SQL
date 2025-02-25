package cs208;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.standard.Media;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
public class RegisteredStudentsController
{

    /**
     * GET /registered_students
     *
     * @return a list of registered students (extracted from a join between
     * registered_students, students and classes tables in the database) as JSON
     */
    @GetMapping(value = "/registered_students", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<RegisteredStudentJoinResult> registered_students()
    {
        ArrayList<RegisteredStudentJoinResult> listOfRegisteredStudentJoinResults = Main.database.listAllRegisteredStudents();

        return listOfRegisteredStudentJoinResults;
    }

    /**
     * POST /add_student_to_class
     * with the following form parameters:
     *      studentId
     *      classId
     *
     * The parameters passed in the body of the POST request will be inserted
     * into the registered_students table in the database.
     */
    @PostMapping(value = "/add_student_to_class")
    public ResponseEntity<Map<String, Object>> create(
            @RequestParam("studentID") int studentID,
            @RequestParam("classID") int classID
            )
    {
        System.out.println("studentID: " + studentID);
        System.out.println("classID: " + classID);

        Map<String, Object> response = new HashMap<>();

        try
        {
            Main.database.addStudentToClass(studentID, classID);
            response.put("status", "success");
            response.put("message", "Student with id = " + studentID + " added to class with id = " + classID);
            return ResponseEntity.ok(response);
        }
        catch (SQLException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * DELETE /drop_student_from_class
     * with the following form parameters:
     *      studentId
     *      classId
     *
     * Deletes the student with id = {studentId} from the class with id = {classId}
     * from the registered_students in the database.
     *
     * @throws ResponseStatusException: a 404 status code if the student with id = {studentId} does not exist
     * @throws ResponseStatusException: a 404 status code if the class with id = {classId} does not exist
     */
    @DeleteMapping(value = "/drop_student_from_class")
    public ResponseEntity<Map<String, Object>> delete(
            @RequestParam("studentID") int studentID,
            @RequestParam("classID") int classID
    )
    {
        System.out.println("studentID: " + studentID);
        System.out.println("classID: " + classID);

        Map<String, Object> response = new HashMap<>();

        try
        {
            Main.database.dropStudentFromClass(studentID, classID);
            response.put("status", "success");
            response.put("message", "Student with id = " + studentID + " deleted from class with id = " + classID);
            return ResponseEntity.ok(response);
        }
        catch (SQLException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    /**
     * GET /students_taking_class/{classCode}
     *
     * @return a list of registered students (extracted from a join between
     * registered_students, students and classes tables in the database) as JSON
     * that are taking the class {classCode}
     */
    // TODO: implement this route



    /**
     * GET /classes_in_which_student_is_enrolled/{studentId}
     *
     * @return a list of all classes (extracted from a join between
     * registered_students, students and classes tables in the database) as JSON
     * in which the student with id = {studentId} is enrolled
     *
     * @throws ResponseStatusException: a 404 status code if the student with id = {studentId} does not exist
     */
    // TODO: implement this route

}
