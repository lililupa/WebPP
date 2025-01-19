package com.example.webpp.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
@Service
public class CalculateFromTextFile {

    static String pathIn = "src/main/resources/in.txt";

    private static void extracted(String line, List<String> list) {
        char[] chars = line.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 48) && (chars[i] <= 57)) {
                result += chars[i];
            } else {
                if (!result.equals("")) {
                    list.add(result);
                }
                list.add(String.valueOf(chars[i]));

                result = "";
            }
        }
        if (!result.isEmpty()) {
            list.add(result);
        }
    }

    private String calculateReversePolishNotation(String line) {
        List<String> list = new ArrayList<>();
        extracted(line, list);
        Deque<String> numbers = new ArrayDeque<>();
        Deque<String> operations = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            try {
                int parseInt = Integer.parseInt(list.get(i));
                numbers.addLast(String.valueOf(parseInt));

            } catch (NumberFormatException e) {
                if (Objects.equals(list.get(i), "+") || Objects.equals(list.get(i), "-")) {
                    String last = operations.peekLast();//peek прочитать без изменений, подсмотреть
                    if (operations.peekLast() != null) {
                        numbers.addLast(operations.pollLast());
                    }

                }
                if (Objects.equals(list.get(i), "*") || Objects.equals(list.get(i), "/")) {
                    String last = operations.peekLast();
                    if (Objects.equals(last, "*") || Objects.equals(last, "/")) {
                        if (operations.peekLast() != null) {
                            numbers.addLast(operations.pollLast());
                        }
                    }
                }
                if (Objects.equals(list.get(i), "(")) {
                    operations.addFirst("(");
                    continue;
                }
                if (Objects.equals(list.get(i), ")")) {
                    while (operations.peekFirst() != "(") {
                        if(operations.peekFirst().equals("(")){
                            operations.pollFirst();
                            break;
                        }
                        String s = operations.pollFirst();
                        numbers.addLast(s);
                    }
                    operations.pollFirst();//уничтожили (
                    break;
                }

                System.out.println();
                operations.addFirst(list.get(i));
            }
        }
        Deque<String> polishNotation = new ArrayDeque<>();
        while (numbers.peek() != null) {
            polishNotation.addLast(numbers.pollFirst());
        }
        while (operations.peek() != null) {
            polishNotation.addLast((operations.pollLast()));
        }
        Deque<Integer> calculate = new ArrayDeque<>();
        while (polishNotation.size() != 0) {
            String element = polishNotation.pollFirst();
            if (element.equals("+")) {
                int a = calculate.pollLast();
                int b = calculate.pollLast();
                calculate.addLast(a + b);
                continue;
            }
            if (element.equals("-")) {
                int a = calculate.pollLast();
                int b = calculate.pollLast();
                calculate.addLast(b - a);
                continue;
            }
            if (element.equals("*")) {
                int a = calculate.pollLast();
                int b = calculate.pollLast();
                calculate.addLast(a * b);
                continue;
            }
            if (element.equals("/")) {
                int a = calculate.pollLast();
                int b = calculate.pollLast();
                calculate.addLast(b / a);
                continue;
            }
            calculate.addLast(Integer.valueOf(element));
        }
        return calculate.pollLast().toString();
    }

    public String transformInformationToFile(String path) {
        BufferedReader reader = null;
        String s = "";
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            s = s + line + "=";
            while (line != null) {
                s = s + calculateReversePolishNotation(line) + "\n";
                line = reader.readLine();
                if (line != null) {
                    s = s + line + "=";
                }
//                s = s + line + "=";

            }

        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
        return s;
    }
}
