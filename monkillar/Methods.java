package monkillar;


import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

public class Methods {
    
    public static boolean checked = false;
  
	
    public static boolean hpLessThan50() {
        
		return (int) (Double.parseDouble(Widgets.get(748).getChild(8).getText()) * 100)	/ (Skills.getRealLevel(Skills.CONSTITUTION) * 10) <= 35 + (Random.nextInt(-3, 3));
	

}
	public static boolean hpGreaterThan75(){
	return (int) (Double.parseDouble(Widgets.get(748).getChild(8).getText()) * 100)	/ (Skills.getRealLevel(Skills.CONSTITUTION) * 10) >= 75 + (Random.nextInt(-3, 3));
}


}
