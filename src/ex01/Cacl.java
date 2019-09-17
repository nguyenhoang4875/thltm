package ex01;

public class Cacl {
    public static void main(String[] args) {
        String a = "5+23+121-100";
        System.out.println(a);
        String operators[]=a.split("[0-9]+");
        String operands[]=a.split("[+-/*]");
        int agregate = Integer.parseInt(operands[0]);
        for(int i=1;i<operands.length;i++){
            System.out.println("--------------------");
            System.out.println(operands[i]);
            System.out.println("--------------------");
            System.out.println(operands[i]);
            if(operators[i].equals("+"))
                agregate += Integer.parseInt(operands[i]);
            else
                agregate -= Integer.parseInt(operands[i]);
        }
        System.out.println(agregate);
    }
}
