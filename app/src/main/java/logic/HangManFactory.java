package logic;

public class HangManFactory {


    public GameLogic getGameLogic(String gameType){
        GameLogic defaultGamelogic = new GameLogic();
        if(gameType.equalsIgnoreCase("normalVersion")){
            return new GameLogic();
        }
        if(gameType.equalsIgnoreCase("kidsVersion")){
            return null;
            //Her kunne man have en børne udgave af hangman
        }
        if(gameType.equalsIgnoreCase("mensaVersion")){
            return null;
            //Her kunne man have lavet en meget svær verison af galgeleg med forskellige krøller på hvordan spillet fungere.
        }
        return defaultGamelogic;
    }
}
