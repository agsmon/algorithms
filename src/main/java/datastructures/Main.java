package datastructures;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        System.out.println("To put an item into stack enter it. To pop an item enter \"pop\". To stop enter \"stop\". Your input: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.contentEquals("stop")) {
                break;
            } else if (next.contentEquals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty");
                } else {
                    System.out.println("The item is: " + stack.pop());
                }
            } else if (next.matches("\\d+")) {
                stack.push(Integer.parseInt(next));
            } else {
                System.out.println("Invalid input");
            }
            System.out.println("Your input: ");
        }

    }

}
