import java.util.Stack;

public class LabStack01 {

    public static void main(String[] args) {

        String tc1 = "SUM([A1+B1]*{C1-D1})";
        String tc2 = "IF((a>0, [b*2)], c)";
        String tc3 = "Hello ((world)";
        String tc4 = "Malee (2613510002)";

        System.out.println("Testcase 1 = " + (isBalance(tc1) ? "Balance" : "Not Balance"));
        System.out.println("Testcase 2 = " + (isBalance(tc2) ? "Balance" : "Not Balance"));
        System.out.println("Testcase 3 = " + (isBalance(tc3) ? "Balance" : "Not Balance"));
        System.out.println("Testcase 4 = " + (isBalance(tc4) ? "Balance" : "Not Balance"));
    }

    public static boolean isBalance(String message) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if (ch == ')' && top != '(')
                    return false;

                if (ch == ']' && top != '[')
                    return false;

                if (ch == '}' && top != '{')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
