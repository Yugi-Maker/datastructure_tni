import java.util.ArrayList;
import java.util.Arrays;

public class Lab202 {

    public static void main(String[] args) {

        int lastDigit = 5;

        Integer[] initial_numbers = {
                10,11,12,13,14,15,16,17,18,19
        };

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(initial_numbers));

        System.out.println("ข้อมูลเริ่มต้น");
        System.out.println(numbers);

        numbers.add(lastDigit);
        System.out.println("\nหลังเพิ่มข้อมูลท้ายสุด");
        System.out.println(numbers);

        numbers.add(lastDigit, 100);
        System.out.println("\nหลังแทรกเลข 100 ที่ตำแหน่ง " + lastDigit);
        System.out.println(numbers);

        numbers.remove(lastDigit);
        System.out.println("\nหลังลบตำแหน่ง " + lastDigit);
        System.out.println(numbers);

        int today = 9;

        numbers.set(lastDigit, today);
        System.out.println("\nหลังอัปเดตตำแหน่ง " + lastDigit);
        System.out.println(numbers);

        System.out.println("\nข้อมูลสุดท้ายใน ArrayList");
        System.out.println(numbers);
    }
}