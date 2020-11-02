package logic;

public interface IhangmanLogic {
    public void startNytSpil();
    public void gætBogstav(String bogstav);
    public void logStatus();
    public String getSynligtOrd();
    public String getOrdet();
    public int getAntalForkerteBogstaver();
    public boolean erSpilletVundet();
}
