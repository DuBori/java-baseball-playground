import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    // computer one ball compare user ball test
    @Test
    @Disabled
    void Noting(){
        Ball com = new Ball(0, 1);
        assertThat(com.Play(new Ball(0,2))).isEqualTo(BallState.NOTHING);
    }

    @Test
    @Disabled
    void Ball() {
        Ball com = new Ball(0, 1);
        assertThat(com.Play(new Ball(1,1))).isEqualTo(BallState.BALL);
    }
    @Test
    void strike() {
        Ball com = new Ball(0, 1);
        assertThat(com.Play(new Ball(0,1))).isEqualTo(BallState.STRIKE);
    }


}