package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberBaseBall {

    public static void main(String[] args) {
        boolean playGameMore;
        Scanner sc = new Scanner(System.in);
        do {
            BaseBallGame();
            playGameMore = isPlayGameMore(sc);
        } while (playGameMore);
        System.out.println("thanks play the Game");
    }

    private static boolean isPlayGameMore(Scanner sc) {
        boolean playGameMore =true;
        while (true){
            System.out.println("more Game? yes : 1, no : 2");
            String input = sc.nextLine();
            if ("1".equals(input)) {
                playGameMore = true;
            }
            if ("2".equals(input)) {
                playGameMore = false;
            }
            if ("1".equals(input) || "2".equals(input)){
                break;
            }
            System.out.println("plz push 1 or 2");
        }
        return playGameMore;
    }

    private static void BaseBallGame() {
        List<Integer> randomNumber = crateRandomNumber();

        String answer = randomNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("answer = " + answer);

        playGame(randomNumber, answer);
    }

    private static List<Integer> crateRandomNumber() {
        Random random = new Random();
        List<Integer> answer = new ArrayList<>();

        for (int x = 0; x < 3; x++) {
            while (true) {
                int randomNumber = random.nextInt(10) + 1;
                if (!answer.contains(randomNumber) && randomNumber < 10) {
                    answer.add(randomNumber);
                    break;
                }
            }
        }

        return answer;
    }

    private static void playGame(List<Integer> randomNumber, String answer) {

        boolean isAnswer = false;

        while (!isAnswer) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            giveHint(input, randomNumber);

            if (answer.equals(input)) {
                System.out.println("finish");
                isAnswer = true;
            }
        }

    }

    private static void giveHint(String input, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        String[] split = input.split("");
        for (int i = 0; i < split.length; i++) {
            int inputNumber = Integer.parseInt(split[i]);
            if (answer.get(i) == inputNumber) {
                strike += 1;
            }
            if (answer.get(i) != inputNumber && answer.contains(inputNumber)) {
                ball += 1;
            }
        }
        if (strike > 0) {
            System.out.println(strike + "strike");
        }
        if (ball > 0) {
            System.out.println(ball + "ball");
        }
    }
}
