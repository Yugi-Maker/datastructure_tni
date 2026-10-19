import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField studentIdField;
    private JTextField nameField;

    public LoginFrame() {

        setThaiFont();

        setTitle("เข้าสู่ระบบ - ระบบลงทะเบียนเรียน");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        createGUI();

        setVisible(true);
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
        UIManager.put("OptionPane.messageFont", thaiFont);
        UIManager.put("OptionPane.buttonFont", thaiFont);
    }


    private void createGUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 35, 25, 35
                )
        );


        JLabel titleLabel =
                new JLabel(
                        "ระบบลงทะเบียนเรียน",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Leelawadee UI",
                        Font.BOLD,
                        26
                )
        );


        JLabel subtitleLabel =
                new JLabel(
                        "Student Registration System",
                        SwingConstants.CENTER
                );

        subtitleLabel.setFont(
                new Font(
                        "Leelawadee UI",
                        Font.PLAIN,
                        14
                )
        );


        JPanel titlePanel =
                new JPanel(new GridLayout(2, 1));

        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);


        mainPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );


        JPanel formPanel =
                new JPanel(
                        new GridLayout(
                                4,
                                1,
                                5,
                                5
                        )
                );


        JLabel studentIdLabel =
                new JLabel("รหัสนักศึกษา");


        studentIdField =
                new JTextField();


        JLabel nameLabel =
                new JLabel("ชื่อ-นามสกุล");


        nameField =
                new JTextField();


        formPanel.add(studentIdLabel);
        formPanel.add(studentIdField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);


        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );


        JButton loginButton =
                new JButton("เข้าสู่ระบบ");


        JButton exitButton =
                new JButton("ออกจากโปรแกรม");


        loginButton.setFont(
                new Font(
                        "Leelawadee UI",
                        Font.BOLD,
                        14
                )
        );


        exitButton.setFont(
                new Font(
                        "Leelawadee UI",
                        Font.PLAIN,
                        14
                )
        );


        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                10
                        )
                );


        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);


        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );


        add(mainPanel);


        loginButton.addActionListener(e -> {

            String studentId =
                    studentIdField.getText().trim();

            String name =
                    nameField.getText().trim();


            // ตรวจสอบข้อมูล
            if (studentId.isEmpty() ||
                    name.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "กรุณากรอกรหัสนักศึกษาและชื่อ-นามสกุล",
                        "แจ้งเตือน",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            dispose();


            new Main(studentId, name);
        });


        exitButton.addActionListener(e -> {

            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "คุณต้องการออกจากโปรแกรมหรือไม่?",
                            "ยืนยัน",
                            JOptionPane.YES_NO_OPTION
                    );


            if (result ==
                    JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new LoginFrame();

        });
    }
}
