import java.util.*;

public class PlayerComparator extends Comparator{
  
  public PlayerComparator(){}
  
  public void compare(String player1, String player2, String statCategory){
    String result = "";
    Textreader john = new TextReader();
    ArrayList<String> player1Array = john.getPlayerStat(player1, statCategory);
    ArrayList<String> player2Array = john.getPlayerStat(player2, statCategory);
    double player1Stat = Double.parseDouble(player1Array.get(0));
    double player2Stat = double.parseDouble(player2Array.get(0));
    
    if (player1Stat > player2Stat){
      result += player1 + " averages more " + statCategory + " than " + player2 + ".";}
    else if (player2Stat > player1Stat){
      result += player2 + " averages more " + statCategory + " than " + player1 + ".";}
    else if (player1Stat == player2Stat){
      result += player1 + " and " + player2 + " average the same " + statCategory + ".";}
    
    return result;

    }
    
  
  }