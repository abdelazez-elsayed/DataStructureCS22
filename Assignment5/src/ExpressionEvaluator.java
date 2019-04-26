import java.lang.*;
import java.util.Scanner;
public class ExpressionEvaluator implements IExpressionEvaluator {

    public String infixToPostfix(String expression){
        String postfix= new String();
        Stack stack=new Stack();
        stack.push('#');
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if (ch==' '){
                continue;
            }
            if(Character.isLetterOrDigit(ch)){
                postfix+=expression.charAt(i);
                if(Character.isDigit(ch)){
                    while(!(i+1>=expression.length())&&Character.isDigit(expression.charAt(i+1))){
                        postfix+=expression.charAt(i+1);
                        i++;
                    }
                }
                postfix+=' ';
            }else if(expression.charAt(i)=='(') stack.push(expression.charAt(i));
            else if(expression.charAt(i)==')') {
                while ((char)stack.peak()!='#' && (char) stack.peak() != '(') {
                    postfix += stack.pop();
                    postfix+=' ';
                }
                if ((char) stack.peak() == '(') {char h=(char)stack.pop();}
            } else {
                if(preced(ch)>preced((char)stack.peak()))
                    stack.push(ch);
                else {
                    while ((char)stack.peak()!='#'&&preced(ch)<=preced((char)stack.peak())) {
                        postfix += stack.pop();
                        postfix+=' ';
                    }
                    stack.push(ch);

                }


            }


        }
        while ((char)stack.peak()!='#'){
            postfix+=stack.pop();
            if((char)stack.peak()!='#')
            postfix+=' ';
        }


        return postfix;




    }

    /**
     * taking an operation and giving the right precision to it
     * @param ch the operation symbol
     * @return tne precision of the symbol in maths
     */
    static int preced(char ch){
        if(ch=='+' || ch=='-')
            return 1;
        else if(ch=='*'||ch=='/')
            return 2;
        else if(ch=='^')
            return 3;
        else
            return 0;
    }
    public int evaluate(String expression){

        Stack stk=new Stack();
        for(int i=0;i<expression.length();i++){
            char ch =expression.charAt(i);
            if(ch==' ')continue;
            if(Character.isDigit(ch)){
                int sum=Character.getNumericValue(ch);
                while(expression.charAt(i+1)!=' '&&i+1!=expression.length()){
                    sum=sum*10+Character.getNumericValue(expression.charAt(i+1));
                    i++;
                }

                stk.push(sum);
            }else {

                int m1= (int)stk.pop();
                int m2= (int)stk.pop();
                int sum=0;
                sum=operation(m2,m1,ch);
                stk.push(sum);
            }
        }

        return (int)stk.pop();
    }

    /**
     * taking two operands and operator and makes the operation
     * @param n1 first operand
     * @param n2 second operand
     * @param ch operation symbol
     * @return the result of the operation
     */
     int operation(int n1,int n2,char ch){
        if(ch=='+')return n1+n2;
        else if(ch=='-')return n1-n2;
        else if(ch=='*')return n1*n2;
        else if(ch=='/')return n1/n2;
        else throw new IllegalArgumentException();
    }
    /*public static void main (String[] argv){
         ExpressionEvaluator ex = new ExpressionEvaluator();

         String st=new String();
         Scanner scanner = new Scanner(System.in);
         st = scanner.nextLine();

         st=ex.infixToPostfix(st);
         int r=ex.evaluate(st);
         System.out.println(r);

    }*/

}
