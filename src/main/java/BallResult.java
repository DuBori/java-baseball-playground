import java.util.List;

public class BallResult {
    private List<BallState> data;

    private int strike;
    private int ball;

    public BallResult() {
    }

    public BallResult(List<BallState> states) {
        data = states;
    }

    public int getStrike() {
        return strike;
    }

    public int getResult() {

        for (int i = 0; i < data.size(); i++) {
            BallState ballState = data.get(i);
            if ("STRIKE".equals(ballState.name())) {
                strike++;
            }
            if ("BALL".equals(ballState.name())) {
                ball++;
            }
        }
        if (strike > 0) {
            System.out.println(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.println(ball + " 볼");
        }

        if (ball < 1 && strike < 1) {
            System.out.println("noting");
        }
        return strike;
    }

}
