public class HelloWorld{

     public static void main(String []args){
        MultiStack stacks = new MultiStack(2,3);
        System.out.println(stacks.isFull(0));
        System.out.println(stacks.isFull(1));
        System.out.println(stacks.isEmpty(0));
        System.out.println(stacks.isEmpty(1));
        stacks.push(12,0);
        stacks.push(1,0);
        stacks.push(3,0);
        stacks.push(4,0);
        stacks.display();
        stacks.pop(0);
        stacks.display();
        stacks.push(32,0);
        stacks.push(12,1);
        stacks.push(1,1);
        stacks.push(3,1);
        stacks.push(4,1);
        stacks.display();
     }
     
     public static class MultiStack{
         int[] values;
         int[] sizes;
         int capacityOfEach;    
         
         public MultiStack(int numberOfStacks,int capacity){
            int totalSize = numberOfStacks * capacity;
            capacityOfEach = capacity;
            values = new int[totalSize];
            sizes  = new int[numberOfStacks];
         }
         
         public boolean isFull(int stackNumber){
             return sizes[stackNumber] == capacityOfEach;
         }
         
         public int getTopOfStack(int stackNumber){
             int top = (stackNumber * capacityOfEach) + sizes[stackNumber] - 1; 
             return top;
         }
         
         public boolean isEmpty(int stackNumber){
             return sizes[stackNumber] == 0;
         }
         
         public void push(int data, int stackNumber){
             if(stackNumber > sizes.length){
                 System.out.println("Wrong stackNumber Entered!!");
                
             }
             if(isFull(stackNumber)){
                 System.out.println("OverFlow Stack " + stackNumber + " is full!!" );
             }else{
             sizes[stackNumber]++;
             values[getTopOfStack(stackNumber)] = data;    
             }
             
         }
         
         public int pop(int stackNumber){
             if(isEmpty(stackNumber)){
                  System.out.println("Stack is Empty");
                  return -1;
             }
             int top = getTopOfStack(stackNumber);
             int data = values[top];
             values[top] = 0;// reset value
             sizes[stackNumber]--;
             return data;
         }
         
         public int peek(int stackNumber){
              if(isEmpty(stackNumber)){
                  System.out.println("Stack is Empty");
                 return -1;
             }
             int top = getTopOfStack(stackNumber);
             return values[top];
         }
         public void display(){
             for(int i : values){
                 System.out.println(i);
             }
         }
         
     }
}
