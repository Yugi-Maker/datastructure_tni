import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {

    // ระบบ
    private RegistrationSystem system;

    // นักศึกษา
    private Student student;

    // ช่องกรอกข้อมูล
    private JTextField studentIdField;
    private JTextField nameField;

    // ตาราง
    private JTable courseTable;
    private JTable registeredTable;

    // Model ของตาราง
    private DefaultTableModel courseModel;
    private DefaultTableModel registeredModel;

    // แสดงหน่วยกิต
    private JLabel creditLabel;

    // แสดงสถานะ
    private JLabel statusLabel;


    public Main(String studentId, String name) {

        setThaiFont();

        // สร้าง Student จากข้อมูล Login
        student =
                new Student(
                        studentId,
                        name
                );

        system =
                new RegistrationSystem();

        setTitle("ระบบลงทะเบียนเรียน");

        setSize(1000, 650);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();

        setVisible(true);
    }


    private void createGUI() {

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );


        // =====================================================
        // TITLE
        // =====================================================

        JLabel titleLabel = new JLabel(
                "ระบบลงทะเบียนเรียน",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        28
                )
        );

        mainPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        JLabel studentInfoLabel =
                new JLabel(
                        "นักศึกษา: "
                                + student.getStudentId()
                                + "  "
                                + student.getName()
                );

        studentInfoLabel.setFont(
                new Font(
                        "Leelawadee UI",
                        Font.BOLD,
                        16
                )
        );


        // =====================================================
        // STUDENT PANEL
        // =====================================================

        JPanel studentPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        10,
                        10
                )
        );

        studentPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "ข้อมูลนักศึกษา"
                )
        );


        JLabel idLabel =
                new JLabel("รหัสนักศึกษา:");

        studentIdField =
                new JTextField(12);


        JLabel nameLabel =
                new JLabel("ชื่อ:");

        nameField =
                new JTextField(15);


        JButton startButton =
                new JButton("เริ่มใช้งาน");


        studentPanel.add(idLabel);
        studentPanel.add(studentIdField);

        studentPanel.add(nameLabel);
        studentPanel.add(nameField);

        studentPanel.add(startButton);


        // =====================================================
        // COURSE TABLE
        // =====================================================

        courseModel =
                new DefaultTableModel(
                        new Object[]{
                                "รหัสวิชา",
                                "ชื่อวิชา",
                                "หน่วยกิต"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };


        courseTable =
                new JTable(courseModel);


        courseTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );


        loadCourses();


        JScrollPane courseScrollPane =
                new JScrollPane(courseTable);


        JPanel coursePanel =
                new JPanel(new BorderLayout());

        coursePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "รายวิชาที่เปิดให้ลงทะเบียน"
                )
        );

        coursePanel.add(
                courseScrollPane,
                BorderLayout.CENTER
        );


        // =====================================================
        // REGISTERED TABLE
        // =====================================================

        registeredModel =
                new DefaultTableModel(
                        new Object[]{
                                "รหัสวิชา",
                                "ชื่อวิชา",
                                "หน่วยกิต"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };


        registeredTable =
                new JTable(registeredModel);


        registeredTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );


        JScrollPane registeredScrollPane =
                new JScrollPane(registeredTable);


        JPanel registeredPanel =
                new JPanel(new BorderLayout());


        registeredPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "รายวิชาที่ลงทะเบียน"
                )
        );


        registeredPanel.add(
                registeredScrollPane,
                BorderLayout.CENTER
        );


        // =====================================================
        // CENTER PANEL
        // =====================================================

        JPanel centerPanel =
                new JPanel(new GridLayout(1, 2, 10, 10));


        centerPanel.add(coursePanel);
        centerPanel.add(registeredPanel);


        // =====================================================
        // BUTTON PANEL
        // =====================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                10
                        )
                );


        JButton registerButton =
                new JButton("ลงทะเบียน");


        JButton cancelButton =
                new JButton("ยกเลิกวิชา");


        JButton clearButton =
                new JButton("ล้างข้อมูล");


        creditLabel =
                new JLabel(
                        "หน่วยกิตทั้งหมด: 0"
                );


        creditLabel.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        16
                )
        );


        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(creditLabel);


        // =====================================================
        // STATUS
        // =====================================================

        statusLabel =
                new JLabel(
                        "สถานะ: กรุณากรอกข้อมูลนักศึกษา"
                );


        statusLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 10, 5, 10
                )
        );


        // =====================================================
        // ADD PANEL
        // =====================================================

        JPanel topPanel =
                new JPanel(new BorderLayout());


        topPanel.add(
                studentPanel,
                BorderLayout.CENTER
        );


        mainPanel.add(
                topPanel,
                BorderLayout.PAGE_START
        );


        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );


        JPanel bottomPanel =
                new JPanel(new BorderLayout());


        bottomPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );


        bottomPanel.add(
                statusLabel,
                BorderLayout.SOUTH
        );


        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        add(mainPanel);


        // =====================================================
        // BUTTON EVENTS
        // =====================================================


        // ปุ่มเริ่มใช้งาน
        startButton.addActionListener(e -> {

            String studentId =
                    studentIdField.getText().trim();

            String name =
                    nameField.getText().trim();


            if (studentId.isEmpty() ||
                    name.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "กรุณากรอกรหัสนักศึกษาและชื่อ",
                        "แจ้งเตือน",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            student =
                    new Student(
                            studentId,
                            name
                    );


            registeredModel.setRowCount(0);

            updateCredit();


            statusLabel.setText(
                    "สถานะ: พร้อมลงทะเบียนสำหรับ "
                            + name
            );


            JOptionPane.showMessageDialog(
                    this,
                    "สร้างข้อมูลนักศึกษาเรียบร้อยแล้ว"
            );
        });


        // ปุ่มลงทะเบียน
        registerButton.addActionListener(e ->
                registerCourse()
        );


        // ปุ่มยกเลิก
        cancelButton.addActionListener(e ->
                cancelCourse()
        );


        // ปุ่มล้างข้อมูล
        clearButton.addActionListener(e -> {

            studentIdField.setText("");
            nameField.setText("");

            registeredModel.setRowCount(0);

            student = null;

            updateCredit();

            statusLabel.setText(
                    "สถานะ: กรุณากรอกข้อมูลนักศึกษา"
            );
        });
    }


    // =========================================================
    // LOAD COURSES
    // =========================================================

    private void loadCourses() {

        courseModel.setRowCount(0);

        for (Course course :
                system.getCourses()) {

            courseModel.addRow(
                    new Object[]{
                            course.getCourseId(),
                            course.getCourseName(),
                            course.getCredit()
                    }
            );
        }
    }


    // =========================================================
    // REGISTER COURSE
    // =========================================================

    private void registerCourse() {

        // ต้องมีข้อมูลนักศึกษาก่อน
        if (student == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "กรุณากรอกข้อมูลนักศึกษาและกดเริ่มใช้งานก่อน",
                    "แจ้งเตือน",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        // ตรวจสอบการเลือกวิชา
        int selectedRow =
                courseTable.getSelectedRow();


        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "กรุณาเลือกวิชาที่ต้องการลงทะเบียน",
                    "แจ้งเตือน",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        // ดึงรหัสวิชา
        String courseId =
                courseModel.getValueAt(
                        selectedRow,
                        0
                ).toString();


        Course selectedCourse = null;


        // ค้นหาวิชา
        for (Course course :
                system.getCourses()) {

            if (course.getCourseId()
                    .equals(courseId)) {

                selectedCourse = course;

                break;
            }
        }


        if (selectedCourse == null) {
            return;
        }


        // ลงทะเบียน
        boolean success =
                student.registerCourse(
                        selectedCourse
                );


        if (!success) {

            // เช็กว่าวิชาซ้ำหรือหน่วยกิตเต็ม
            boolean duplicate = false;


            for (Course course :
                    student.getRegisteredCourses()) {

                if (course.getCourseId()
                        .equals(courseId)) {

                    duplicate = true;

                    break;
                }
            }


            if (duplicate) {

                JOptionPane.showMessageDialog(
                        this,
                        "ไม่สามารถลงทะเบียนได้\n"
                                + "คุณลงทะเบียนวิชานี้แล้ว",
                        "ไม่สามารถลงทะเบียน",
                        JOptionPane.WARNING_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "ไม่สามารถลงทะเบียนได้\n"
                                + "หน่วยกิตรวมเกิน 18 หน่วยกิต",
                        "ไม่สามารถลงทะเบียน",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            return;
        }


        // เพิ่มลงตาราง
        registeredModel.addRow(
                new Object[]{
                        selectedCourse.getCourseId(),
                        selectedCourse.getCourseName(),
                        selectedCourse.getCredit()
                }
        );


        updateCredit();


        statusLabel.setText(
                "สถานะ: ลงทะเบียน "
                        + selectedCourse.getCourseName()
                        + " สำเร็จ"
        );
    }


    // =========================================================
    // CANCEL COURSE
    // =========================================================

    private void cancelCourse() {

        if (student == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "กรุณาเริ่มใช้งานก่อน",
                    "แจ้งเตือน",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        int selectedRow =
                registeredTable.getSelectedRow();


        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "กรุณาเลือกวิชาที่ต้องการยกเลิก",
                    "แจ้งเตือน",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        String courseId =
                registeredModel
                        .getValueAt(
                                selectedRow,
                                0
                        )
                        .toString();


        boolean success =
                student.cancelCourse(courseId);


        if (success) {

            registeredModel.removeRow(
                    selectedRow
            );


            updateCredit();


            statusLabel.setText(
                    "สถานะ: ยกเลิกวิชา "
                            + courseId
                            + " เรียบร้อยแล้ว"
            );
        }
    }


    // =========================================================
    // UPDATE CREDIT
    // =========================================================

    private void updateCredit() {

        int credit = 0;


        if (student != null) {

            credit =
                    student.getTotalCredits();
        }


        creditLabel.setText(
                "หน่วยกิตทั้งหมด: "
                        + credit
                        + " / 18"
        );
    }

    private void setThaiFont() {

        Font thaiFont = new Font(
                "Leelawadee UI",
                Font.PLAIN,
                14
        );

        UIManager.put("Label.font", thaiFont);
        UIManager.put("Button.font", thaiFont);
        UIManager.put("TextField.font", thaiFont);
        UIManager.put("Table.font", thaiFont);
        UIManager.put("TableHeader.font", thaiFont);

        // สำหรับ JOptionPane
        UIManager.put("OptionPane.font", thaiFont);
        UIManager.put("OptionPane.messageFont", thaiFont);
        UIManager.put("OptionPane.buttonFont", thaiFont);

        // สำหรับช่อง TextArea ถ้ามี
        UIManager.put("TextArea.font", thaiFont);
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

        });
    }
}