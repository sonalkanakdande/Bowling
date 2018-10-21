package bowling;

public class Game {
   private int roll = 0;
   private int [] rolls = new int[21];

    public void roll(int ... pinsDown) {
       rolls = pinsDown;
    }

    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int  score() {
        int score = 0;
        int curser =0;

        for (int frame=0 ; frame <10 ; frame ++){
            if (isaStrike(rolls[curser])){
                score += 10 + rolls [curser+1] + rolls [curser+2];
                curser +=1;
            }else if (isaSpare(curser)){
                score += 10 + rolls [curser+2];
                curser +=2;

            }else {
                score += rolls[curser] + rolls [curser+1];
                curser +=2;
            }

        }

        return score;
    }

    private boolean isaStrike(int roll) {
        return roll ==10;
    }

    private boolean isaSpare(int curser) {
        return rolls[curser] + rolls [curser+1] == 10;
    }
}
