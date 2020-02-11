package datastructures;

import edu.princeton.cs.algs4.In;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        //tryStack();
        //tryQueue();
        tryBinarySearchTree();
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

    private static void tryBinarySearchTree() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        System.out.println("To add an item into the tree enter two ints. To get an item enter \"get\". To stop enter \"stop\". Your input: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.contentEquals("stop")) {
                break;
            } else if (next.matches("get\\d+")) {
                if (tree.size() == 0) {
                    System.out.println("Tree is empty");
                } else {
                    Matcher matcher = Pattern.compile("\\d+").matcher(next);
                    matcher.find();
                    int key = Integer.parseInt(matcher.group());
                    System.out.println("The item is: " + tree.get(key));
                }
            } else {
                int key = Integer.parseInt(next);
                tree.put(key, key);
            }
            System.out.println("Your input: ");
        }
    }

}
