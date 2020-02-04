package datastructures;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //tryStack();
        tryQueue();
    }

    private static void tryStack() {
        //ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        LinkedListStack<Integer> stack = new LinkedListStack<>();
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

    private static void tryQueue() {
       // LinkedListQueue<String> queue = new LinkedListQueue<>();
        // UnorderedArrayPriorityQueue<String> queue = new UnorderedArrayPriorityQueue();
        BinaryHeapPriorityQueue<Integer> queue = new BinaryHeapPriorityQueue<>();
        System.out.println("To add an item into queue enter it. To get an item enter \"get\". To stop enter \"stop\". Your input: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.contentEquals("stop")) {
                break;
            } else if (next.contentEquals("get")) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("The item is: " + queue.getMax());
                }
            } else {
                queue.insert(Integer.parseInt(next));
            }
            System.out.println("Your input: ");
        }
    }
}
