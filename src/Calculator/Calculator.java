package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

      Scanner scannerString = new Scanner(System.in);
      String input = scannerString.nextLine();

            try {
                String calc = calc(input);
                System.out.println(calc);
            } catch (Exception e) {
                System.out.println( e.getMessage());

            }

        }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s+", "");

        String [] parts = input.split("[+\\-*/]");

        if (parts.length != 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int firstNumber = Integer.parseInt(parts[0]);
        int secondNumber = Integer.parseInt(parts[1]);
        if (firstNumber > 10 || secondNumber > 10){
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }

        if (input.contains("+")){
            return String.valueOf(firstNumber + secondNumber);
        }else  if (input.contains("-")) {
            return String.valueOf(firstNumber - secondNumber);
        }else if (input.contains("*")){
            return String.valueOf(firstNumber * secondNumber);
        } else if (input.contains("/")){
            if (secondNumber == 0){
                throw new Exception("Деление на ноль невозможно");
            }
            return String.valueOf(firstNumber / secondNumber);
        }else {
            throw new Exception("строка не является математической операцией");
        }

    }
}