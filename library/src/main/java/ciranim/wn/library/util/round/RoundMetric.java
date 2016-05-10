package ciranim.wn.library.util.round;


import ciranim.wn.library.util.Side;

public class RoundMetric {

    public Side mSide;//运动方向

    /**
     * Create new {@link RoundMetric} instance and do all calculations below
     * and finally return ready to use object
     */
    public static RoundMetric evaluate(float startX, float startY,
                                       Side side) {
        //TODO return ready to use object with have done computations
        RoundMetric arcMetric = new RoundMetric();
        arcMetric.mSide = side;
        return arcMetric;
    }

}
