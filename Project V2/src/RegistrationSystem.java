import java.util.ArrayList;

public class RegistrationSystem {

    private ArrayList<Course> courses;

    public RegistrationSystem() {

        courses = new ArrayList<>();

        courses.add(
                new Course(
                        "INT-205",
                        "Network",
                        3
                )
        );

        courses.add(
                new Course(
                        "INT-305",
                        "Database System",
                        3
                )
        );

        courses.add(
                new Course(
                        "JPN-201",
                        "Business Japanese",
                        3
                )
        );

        courses.add(
                new Course(
                        "ENL-221",
                        "English Business",
                        3
                )
        );

        courses.add(
                new Course(
                        "MSC-202",
                        "Math Programing",
                        3
                )
        );

        courses.add(
                new Course(
                        "ITE-210",
                        "Data Structure and algorithm",
                        3
                )
        );
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}