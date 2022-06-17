public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("2"));
        System.out.println(Integer.parseInt("-11"));
        System.out.println(EvaluateReversePolishNotation.evalRPN(new String[] {"2", "-11", "-"}));
    }
}
