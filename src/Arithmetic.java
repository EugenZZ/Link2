import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arithmetic {

    public static void main(String[] args) {
        while(true) {
            System.out.println("请输入您要计算的表达式：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            line = line.trim();
            if (!arithmeticUnit.right(line)) {
                System.out.println("请输入正确的表达式");
                continue;
            }
            System.out.println(arithmeticUnit.getAnswer(line));
        }
    }
}
