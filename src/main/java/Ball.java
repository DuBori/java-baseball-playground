public class Ball {

    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;
    private int index;
    private int  number;

    public int getNumber() {
        return number;
    }

    public Ball(int index, int number) {
        this.index = index;
        this.number = initNumber(number);
    }

    private int initNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER){
            new IllegalAccessError("input number 1 to 9 plz");
        }
        return number;
    }

    public BallState Play(Ball inputBall) {

        if (this.equals(inputBall)) {
            return BallState.STRIKE;
        }

        if (isBall(inputBall)) {
            return BallState.BALL;
        }

        return BallState.NOTHING;
    }

    private boolean isBall(Ball inputBall) {
        return this.number == inputBall.number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ball ball = (Ball) obj;
        return this.index == ball.index && this.number == ball.number;
    }
}
