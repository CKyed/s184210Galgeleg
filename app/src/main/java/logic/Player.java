package logic;

public class Player {
    private final String nickName;
    private final int age;
    private final String skillLevel;
    private final int highScore;
    private final String highScoreWord;
    private final int numberOfGames;

    private Player(PlayerBuilder builder){
        this.nickName=builder.nickName;
        this.age=builder.age;
        this.skillLevel=builder.skillLevel;
        this.highScore=builder.highScore;
        this.highScoreWord=builder.highScoreWord;
        this.numberOfGames=builder.numberOfGames;
    }

    public static class PlayerBuilder{
        private final String nickName;
        private final int age;
        private final String skillLevel;
        private int highScore;
        private String highScoreWord;
        private int numberOfGames;

        public PlayerBuilder(String nickName, int age, String skillLevel){
            this.nickName = nickName;
            this.age = age;
            this.skillLevel = skillLevel;
        }

        public PlayerBuilder highScore(int highScore){
            this.highScore = highScore;
            return this;
        }

        public PlayerBuilder highScoreWord(String highScoreWord){
            this.highScoreWord = highScoreWord;
            return this;
        }

        public PlayerBuilder numberOfGames(int numberOfGames){
            this.numberOfGames = numberOfGames;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }
}

