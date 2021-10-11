package com.greatlearning.labsession;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the expression to be verified");
        String input = scanner.next();
        boolean isValid = isValidBrackets(input);
        String message = isValid ? "The entered String has Balanced Brackets" : "The entered Strings do not contain Balanced Brackets";
        System.out.println(message);
    }

    private static boolean isValidBrackets(String input) {

        Stack<Character> characterStack = new Stack();
        boolean isValid = true;

        for (Character c : input.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(': {
                    characterStack.push(c);
                    break;
                }

                case ']': {
                    if (characterStack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    Character value = characterStack.pop();
                    isValid = value == '[';
                    break;
                }

                case '}': {
                    if (characterStack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    Character value = characterStack.pop();
                    isValid = value == '}';
                    break;
                }


                case ')': {
                    if (characterStack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    Character value = characterStack.pop();
                    isValid = value == ')';
                    break;
                }
            }
        }

        return isValid && characterStack.isEmpty();
    }
}
