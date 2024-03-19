import java.util.Queue;
import java.util.LinkedList;
public class Implementation{
    static int size=0;
    public static class Node{

        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
        }
    }
    static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" -> ");
        if(root.left!=null) System.out.print(root.left.val+" ");
        if(root.right!=null)  System.out.print(root.right.val);
        System.out.println();
        display(root.left);
        display(root.right);
    }
    static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        // size++;
        preorder(root.left);
        preorder(root.right);
    }
    static void inorder(Node root){
        if(root==null) return;
        
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static void postorder(Node root){
        if(root==null) return;
        
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.val+" ");
    }
    static void nthlevel(Node root,int n){
        if(root==null) return;
       if(n==1) System.out.print(root.val+" ");
        nthlevel(root.left,n-1);
        nthlevel(root.right,n-1);
    }
    static int size(Node root){
        if(root==null) return 0;
        return size(root.left)+size(root.right)+1;
    }
    static int sum(Node root){
        if(root==null) return 0;
        return sum(root.left)+sum(root.right)+root.val;
    }
    static int Max(Node root){
        if(root==null) return 0;
        int a=root.val;
        int b=Max(root.left);
        int c=Max(root.right);
        return Math.max(a,Math.max(b,c));
    }
    static int height(Node root){
        if(root==null) return -1;
        //leaf node use to return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    static void BFS(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
        Node temp=q.peek();
        if(temp.left!=null) q.add(temp.left);
        if(temp.right!=null) q.add(temp.right);
        System.out.print(temp.val+" ");
        q.remove();
    }}
    public static void main(String[] args) {
        Node root=new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b;
        Node c=new Node(4);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        Node e=new Node(6);
        b.left=e;
        Node f=new Node(7);
        b.right=f;
        // Node g=new Node(8);
        // f.right=g;

        // System.out.println(root);
        // System.out.println(root.val);
        // System.out.println(root.left);
        // display(root);
        // System.out.println("preorder  traversal :");
        //  preorder(root);

        //  System.out.println("size= "+size(root));
        //  System.out.println("sum= "+sum(root));
        //  System.out.println("Max= "+Max(root));
        //  System.out.println("height= "+height(root));

        // preorder(root);
        // inorder(root);
        //    postorder(root);
        // nthlevel(root, 3);

        // int level=height(root)+1;
        // for(int i=1;i<=level;i++){
        //     nthlevel(root, i);
        //     System.out.println();
        // }
                BFS(root);

    }
}
