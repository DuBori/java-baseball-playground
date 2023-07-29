public class Ball {

    private int index;
    private int  number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
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
