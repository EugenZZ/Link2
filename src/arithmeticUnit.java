import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class arithmeticUnit {
    //运算优先级

    private static final Pattern pattern = Pattern.compile("\\d+\\.?\\d?");
    private static final Pattern pattern2 = Pattern.compile("^(\\-?\\d+[\\.\\+\\-\\*\\/]?)*\\-?\\d+$\n");
    private static Set<Character> rightChar = new HashSet<Character>();
    private static Map<String, Integer> priority = new HashMap<>();
    private static Map<String, String> replace = new HashMap<>();
    static {
        replace.put("（", "(");
        replace.put("）", ")");
    }
    public static String getAnswer(String x){
        return execute(x);
    }
    static {
       rightChar.add('+');
       rightChar.add('-');
       rightChar.add('*');
       rightChar.add('/');
       rightChar.add('0');
       rightChar.add('1');
       rightChar.add('2');
       rightChar.add('3');
       rightChar.add('4');
       rightChar.add('5');
       rightChar.add('6');
       rightChar.add('7');
       rightChar.add('8');
       rightChar.add('9');
       rightChar.add('(');
       rightChar.add(')');
       rightChar.add('）');
       rightChar.add('（');

    }



    static {
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("", -1);
    }
    private static final String[] Operator = {"+", "-", "*", "/"};

    private static myStack stack=new myStack();
    public static boolean right(String x){
       for(int i=0; i<x.length(); i++){ ;
           if(!rightChar.contains(x.charAt(i))){
              System.out.println(x.charAt(i));
              return false;
          }
       }
       return true;
    }

    public static String execute(String x) {
        return processSecond(processFirst(trim(x)));
    }
    private static String trim(String x) {
        String result = x.trim();
        for (Map.Entry<String, String> entry : replace.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public static String processFirst(String x) {
        //stack.clear();
        //System.out.println(x);
        StringBuilder pre = new StringBuilder(x);
        StringBuilder now = new StringBuilder();
        String index;
        String emp;
        while (pre.length() > 0) {
            //System.out.println(pre.length());
            index = getElement(pre);
            //System.out.print(index);
            if (isNumber(index)) {
                now.append(index).append(" ");
            } else if (")".equals(index)) {
                emp = stack.pop();
                while (!"(".equals(emp)) {
                    now.append(emp).append(" ");
                    emp = stack.pop();
                }
            } else if ("(".equals(index) || priority.get(index) >= priority.get(getHighestOperator())) {
                stack.push(index);
            } else {
                emp = stack.pop();
                now.append(emp).append(" ").append(index).append(" ");
            }
        }
        while(stack.size()>0){
            now.append(stack.pop()).append(" ");
        }
        return now.toString();
    }

    private static String processSecond(String x){
        String[] pre=x.split(" ");
        stack.clear();
        double num1=0,num2=0;
        String temp="";
        for(int i=0;i<pre.length;i++){
            if(isNumber(pre[i])) {
                stack.push(pre[i]);
            }
            else{
                num2=Double.parseDouble(stack.pop());
                num1=Double.parseDouble(stack.pop());
                temp=calculate(num1,num2,pre[i]);
                if("除数为零".equals(temp)){
                    throw new ArithmeticException("被除数不能为0");
                }else{
                    stack.push(temp);
                }
            }
        }
        return stack.pop();
    }
    private static String calculate(double num1, double num2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) { // 除数为0
                    return "除数为零";
                }
                result = 1.0 * num1 / num2;
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }

    private static boolean isNumber(char c) {
        if ( (c >= '0' && c <= '9') || c == '.' ) {
            return true;
        }
        return false;
    }
    private static boolean isNumber(String str) {
        // 通过Matcher进行字符串匹配
        Matcher m = pattern.matcher(str);
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return m.matches();
    }

    public static boolean isRight(String str) {
        // 通过Matcher进行字符串匹配
        Matcher m = pattern2.matcher(str);
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return m.matches();
    }

    private static String getHighestOperator() {
        String tmp = "";
        for (int i = 0;i<= stack.size()-1; i++) {
            tmp = stack.get(i);
            if ("(".equals(tmp)) {
                break;
            } else if (isOperator(tmp)) {
                return tmp;
            }
        }
        return "";
    }
    private static boolean isOperator(String str) {

        for (int i = 0; i < Operator.length; i++) {
            if (Operator[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
    private static String getElement(StringBuilder expression) {
        StringBuilder result = new StringBuilder();
        char c = expression.charAt(0);
        expression.deleteCharAt(0);
        result.append(c);

        if (isNumber(c)) {
            // 如果第一次取到的是数字，则继续检查
            while ( expression.length() >0 && isNumber(c = expression.charAt(0))) {
                expression.deleteCharAt(0);
                result.append(c);
            }
        }

        return result.toString();
    }
}













