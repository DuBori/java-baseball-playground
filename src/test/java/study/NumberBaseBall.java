package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberBaseBall {

    public static void main(String[] args) {
        boolean isFinsh = true;
        do {
            BaseBallGame();
            isFinsh = requestAnswerMoreGame();
        } while (isFinsh);
    }

    private static void BaseBallGame() {
        List<String> randomNumber = crateRandomNumber();
        System.out.println(randomNumber);
        boolean isAnswer = false;
        String answer = randomNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("answer = " + answer);


        while (true){
            playGame(randomNumber, isAnswer, answer);
        }

    }

    private static boolean requestAnswerMoreGame() {
        System.out.println("you play Game more? yes : 1 / no : 2");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (!"1".equals(s) && "2".equals(s)){
            System.out.println("input 1 or 2");
            return false;
        }
        if ("2".equals(s)) {
            return false;
        }
        return true;
    }

    private static void playGame(List<String> randomNumber, boolean isAnswer, String answer) {
        while(!isAnswer){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            giveHint(input, randomNumber);

            if (answer.equals(input)){
                System.out.println("finish");
                isAnswer = true;
            }
        }
    }

    private static void giveHint(String input, List<String> answer) {
        int strike = 0;
        int ball = 0;

        String[] split = input.split("");
        for (int i=0; i<split.length; i++) {
            if (answer.get(i).equals(split[i])) {
                strike+=1;
            }
            if (!answer.get(i).equals(split[i]) && answer.contains(split[i]) ) {
                ball +=1;
            }
        }
        if (strike > 0) {
            System.out.println(strike+"strike");
        }
        if (ball > 0) {
            System.out.println(ball+"ball");
        }
    }

    private static List<String> crateRandomNumber() {
        Random random = new Random();
        List<String> answer = new ArrayList<>();
        for(int x = 0; x < 3; x++){
            answer.add(String.valueOf(random.nextInt(10)));
        }
        return answer;
    }
}
