import java.io.*;
import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        for(int i : stack){
            System.out.println(i);
        }
        stack.push(9);
        stack.push(8);
        stack.push(10);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);

        sortStack(stack);
        for(int i : stack){
            System.out.println(i);
        }
     }
     
    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> result = new Stack<>();
        if(stack.isEmpty()){
            System.out.println("Stack is Empty");
        }else{
         while(!stack.isEmpty()){
             int temp = stack.pop();
             if(result.isEmpty()){result.push(temp);continue;}
             while(!result.isEmpty() && result.peek() < temp){
                 stack.push(result.pop());
             }
             result.push(temp);
         }
         while(!result.isEmpty()){
             stack.push(result.pop());
         }   
        }
    }
}
