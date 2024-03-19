// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Stack;
class Evaluate {
    public static void main(String[] args) {
        String str="9-5+3*4/6";
        System.out.println(Infix(str));
    }
    static int Infix(String str){
        Stack<Integer> vl=new Stack<>();
        Stack<Character> op=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(ch>='0'&&ch<='9'){
                vl.push(ch-'0');
            }
            else if(op.isEmpty())   op.push(ch);
            else{
                if(ch=='+' || ch=='-'){
                    int v2=vl.pop();
                    int v1=vl.pop();
                    if(op.peek()=='+') vl.push(v2+v1);
                    if(op.peek()=='-') vl.push(v1-v2); 
                    if(op.peek()=='*') vl.push(v2*v1); 
                    if(op.peek()=='/') vl.push(v1/v2);
                    op.pop();
                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    int v2=vl.pop();
                    int v1=vl.pop();
                    if(op.peek()=='*') vl.push(v2*v1); 
                    if(op.peek()=='/') vl.push(v1/v2);
                    op.pop();
                    op.push(ch);
                    
                }else op.push(ch);
            }
        }
        while(vl.size()>1){
            int v2=vl.pop();
                    int v1=vl.pop();
                    if(op.peek()=='+') vl.push(v2+v1);
                    if(op.peek()=='-') vl.push(v1-v2); 
                    if(op.peek()=='*') vl.push(v2*v1); 
                    if(op.peek()=='/') vl.push(v1/v2);
                    op.pop();
                    
        }
        return vl.peek();
    }
}