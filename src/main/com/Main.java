package main.com;

import main.com.services.ArgumentsService;
import main.com.services.GameService;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        GameService gm = new GameService();
        ArgumentsService as = new ArgumentsService(1, 100, 5);

        System.out.println("Привет, я загадал число от " + as.getMin()
                + " до " + as.getMax() +". Попробуй угадать его за "+
                as.getAmountOfAttempts() + " попыток!");

        int number = random.nextInt(as.getMax() -
                -as.getMin() + 1);
        number += as.getMin();
        System.out.println(number);

        int count = 1;
        int[] helpArray = new int[as.getAmountOfAttempts()];
        boolean bool = true;

        while(bool){
            System.out.println(Arrays.toString(helpArray));
            System.out.print("Ваше число: ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("exit")){
                bool = false;
            }
            else {
                if ((number+"").equalsIgnoreCase(answer)){
                    System.out.println(gm.startGame(number, answer, count, as.getAmountOfAttempts(), helpArray));
                    bool = false;
                }
                else if(count == as.getAmountOfAttempts()){
                    System.out.println(gm.startGame(number, answer, count, as.getAmountOfAttempts(), helpArray));
                    bool = false;
                }
                else {
                    System.out.println(gm.startGame(number, answer, count, as.getAmountOfAttempts(), helpArray));
                    count++;
                }

            }
        }
    }
}
