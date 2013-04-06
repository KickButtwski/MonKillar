package monkillar;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
//import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.NPC;



public class Heal extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return (PlayerUtil.getHealthPercentage()<50);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MainClass.status="Healing";
		NPC hMonk = NPCs.getNearest(MainClass.HeadMonk);

		if (hMonk != null) {
			if(!hMonk.isOnScreen()){
				hMonk.getLocation().clickOnMap();
				Task.sleep(Random.nextInt(3000, 4000));
				if(!hMonk.isOnScreen()){
					Camera.turnTo(hMonk.getLocation()); 
				}  
			} else {
				//while(!(Players.getLocal().getHealthPercent()>75)){//Methods.hpGreaterThan75()) {

					MainClass.talking = true;
					
					hMonk.interact("Talk-to");
					while(!(PlayerUtil.getHealthPercentage()>76)) {

						MainClass.talking = true;
						hMonk.interact("Talk-to");
						Task.sleep(Random.nextInt(1000, 2000));
						if (Widgets.canContinue()) {
							Widgets.clickContinue();
							Task.sleep(Random.nextInt(500, 1250));
							Widgets.get(1188, 3).click(true);
							Task.sleep(Random.nextInt(1000, 2000));
							Widgets.clickContinue();
							Task.sleep(Random.nextInt(1000,2000));
							Widgets.clickContinue();
							Task.sleep(Random.nextInt(1000,2000));
							Widgets.clickContinue();
							Task.sleep(Random.nextInt(1000, 2000));
							Widgets.clickContinue();
							Task.sleep(Random.nextInt(900,1000));
							Widgets.clickContinue();
							MainClass.talking = false;
						}
					}
			}}/**	final Timer timer = new Timer(1000);
						while(timer.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						
					
						Widgets.clickContinue();
						
				//		Keyboard.sendKey(' ');
						
							final Timer timer2 = new Timer(200);
							while(timer2.isRunning() && !Widgets.get(1188, 3).validate()){
							if(Widgets.get(1188, 3).validate()){
							break;
							}
							Task.sleep(50);
							}
							} 
						
						Widgets.get(1188, 3).click(true);
						final Timer timer3 = new Timer(200);
						while(timer3.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						
					
						Widgets.clickContinue();
						final Timer timer4 = new Timer(200);
						while(timer4.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						Widgets.clickContinue();
						final Timer timer5 = new Timer(200);
						while(timer5.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						Widgets.clickContinue();
						final Timer timer6 = new Timer(200);
						while(timer6.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						Widgets.clickContinue();
						final Timer timer7= new Timer(200);
						while(timer7.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						Widgets.clickContinue();
						final Timer timer8 = new Timer(200);
						while(timer8.isRunning() && !Widgets.canContinue()){
						if(Widgets.canContinue()){
						break;
						}
						Task.sleep(50);
						}
						Widgets.clickContinue();
						MainClass.talking = false;
					*/
				}
			}
		
	
	

