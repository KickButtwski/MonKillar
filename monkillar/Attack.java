package monkillar;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.SceneObject;


import monkillar.MainClass;



public class Attack extends Node {




	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MainClass.status="Attacking";
		if (Players.getLocal().getPlane() == 1) {
            // SceneEntities.getNearest(30863)
            SceneObject idiot = SceneEntities.getNearest(30863);
            // idiot.interact("Climb", "-down").click(true);
            idiot.interact("Climb-down");
        }
        if (!Walking.isRunEnabled() && Walking.getEnergy() > 50) {
            Walking.setRun(true);
        }
		if ((Players.getLocal().getHealthPercent()<50)) {
             return;
         }
        NPC Monk = NPCs.getNearest(new Filter<NPC>() {

            @Override
            public boolean accept(NPC n) {
                return n.getId() == 7727 && !n.isInCombat();// &&
               
            }

        });
       

        if (Monk != null && !(Players.getLocal().getHealthPercent()<50)) {
        	if(MainClass.bbones){
        		
        	MainClass.take=false;
        	
        	}
            if (Calculations.distance(Players.getLocal().getLocation(),
                    Monk.getLocation()) >= 14) {
            	 Mouse.click(Monk.getLocation().clickOnMap());
            	 //Mouse.click(Monk.getLocation().getMapPoint(), true);
            	 Task.sleep(Random.nextInt(500, 1200));
                //Monk.getLocation().clickOnMap();
            } else if (Monk.isOnScreen()) {
            	Camera.turnTo(Monk);
            	
                Monk.interact("Attack");
       
                
                MainClass.Staus = "Attacking";
                Task.sleep(Random.nextInt(1500, 2200));
                if(MainClass.bbones){
                	MainClass.take=true;
                	
                }
               
            } else {
                Camera.turnTo(Monk);
                
            }

        }

    }



	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !(PlayerUtil.getHealthPercentage()<50)//!Methods.hpLessThan50()
				&& Players.getLocal().getInteracting() == null
                && !Players.getLocal().isMoving() && !MainClass.needtobury &&!MainClass.take&&MainClass.talking==false;
	}


	}


