import java.util.ArrayList;

public class Student {

    private String studentId;
    private String name;

    private ArrayList<Course> registeredCourses;

    private final int MAX_CREDIT = 18;

    public Student(String studentId, String name) {

        this.studentId = studentId;
        this.name = name;

        registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {

        for (Course c : registeredCourses) {

            if (c.getCourseId().equals(course.getCourseId())) {
                return false;
            }
        }

        if (getTotalCredits() + course.getCredit() > MAX_CREDIT) {
            return false;
        }

        registeredCourses.add(course);

        return true;
    }

    public boolean cancelCourse(String courseId) {

        for (int i = 0; i < registeredCourses.size(); i++) {

            if (registeredCourses.get(i)
                    .getCourseId()
                    .equals(courseId)) {

                registeredCourses.remove(i);

                return true;
            }
        }

        return false;
    }

    public int getTotalCredits() {

        int total = 0;

        for (Course course : registeredCourses) {
            total += course.getCredit();
        }

        return total;
    }
}