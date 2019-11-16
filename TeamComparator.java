/** class TeamComparator is a concrete subclass of the abstract class Comparator.
  * It implements the abstract method compare() */

import java.util.*;

public class TeamComparator extends Comparator{
  
  // Default constructor
  public TeamComparator(){}
  
  /** The following method is an implementation of the abstract method inherited from the Comparator class.
    * @param homeTeam is the String name of the home team
    * @param awayTeam is the String name of the away team
    * @return result, which is a String stating which team is favored to win along with the calcualted odds. */
  
  public String compare(String homeTeam, String awayTeam){
    int homeTeamTotalTalentScore = 0;
    int awayTeamTotalTalentScore = 0;
    TextReader t = new TextReader();
    ArrayList<String> homeTeamPlayers = t.getPlayersByTeam(homeTeam);
    ArrayList<String> awayTeamPlayers = t.getPlayersByTeam(awayTeam);
    
    for (String player: homeTeamPlayers){
      int rank = t.getPlayerStat(player, "RANK");
      int playerTalentScore = 1 - rank;
      homeTeamTotalTalentScore += playerTalentScore;}
    
    for (String player: awayTeamPlayers){
      int rank = t.getPlayerStat(player, "RANK");
      int playerTalentScore = 1 - rank;
      awayTeamTotalTalentScore += playerTalentScore;}
    
    int sum = homeTeamTotalTalentScore + awayTeamTotalTalentScore;
    int homeTeamOdds = (int) (100 * homeTeamTotalTalentScore/sum);
    homeTeamOdds += 5;
    
    
    // In the real world, the odds of winning are never truly 100%. 
    // If 100% is the calculated result, 99% will be returned instead. 
    
    if (homeTeamOdds >= 100){
     homeTeamOdds = 99; 
    }
    
    awayTeamOdds = 100 - homeTeamOdds;
    
    String favorite = "";
    int oddsDifference = homeTeamOdds - awayTeamOdds;
    if (oddsDifference < 0){
      oddsDifference = awayTeamOdds - homeTeamOdds;
      favorite = awayTeam;
    }
    else{
      favorite = homeTeam;}
    
    String result = "Likelihood of Winning" + "\n";
    result += "-----------------------------------------";
    result += homeTeam + ": " + homeTeamOdds + " %" + "\n";
    result += awayTeam + ": " + awayTeamOdds + " %" + "\n"; 
    result += "The " + favorite + " are favored to win by " + oddsDifference + " %.";
    
    return result;
    
  }
  
  
}