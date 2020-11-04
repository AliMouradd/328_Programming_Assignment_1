import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Node storage;

        Scanner input = new Scanner(new File("input.txt"));
        String m = input.next();
        String n = input.next();

        BigInteger M = new BigInteger(m);
        BigInteger N = new BigInteger(n);

        Node left = new Node(BigInteger.ZERO, BigInteger.ONE);
        Node right = new Node(BigInteger.ONE, BigInteger.ZERO);

        Tree testTree = new Tree();
        testTree.treeBuild(M,N, left, right);
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(testTree.getA());
        writer.println(testTree.getB());
        writer.close();
    }
}

class Tree{
    BigInteger a;
    BigInteger b;

    public void treeBuild(BigInteger M, BigInteger N, Node left, Node right) {
        //creates child node of left and right nodes. (This is the focus node)
        Node middle = new Node(left.getA().add(right.getA()), left.getB().add(right.getB()));

//        System.out.println(middle.getA()+ "/"+ middle.getB());

        // calculates inequality

        BigInteger na2 = new BigInteger(String.valueOf(N.multiply(middle.getA().pow(2))));
        BigInteger mb2 = new BigInteger(String.valueOf(M.multiply(middle.getB().pow(2))));
        BigInteger inequality = new BigInteger(String.valueOf(na2.subtract(mb2).abs()));

//        System.out.println( inequality);

        if(inequality.compareTo(middle.getB()) < 0){
            a = new BigInteger(middle.getA().toString());
            b = new BigInteger(middle.getB().toString());
        }else if(middle.getA().pow(2).multiply(N).subtract(middle.getB().pow(2).multiply(M)).compareTo(BigInteger.ZERO) < 0){
//            System.out.println("Right");
            treeBuild(M, N, middle,right);
        }else{
//            System.out.println("Left");
            treeBuild(M, N, left, middle);
        }
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }
    }




class Node{
    BigInteger a;
    BigInteger b;
    Node left;
    Node right;

    public Node(BigInteger a, BigInteger b){
        this.a = a;
        this.b = b;
        right = null;
        left = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }
}
