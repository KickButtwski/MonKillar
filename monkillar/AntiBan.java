package monkillar;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class AntiBan extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !(PlayerUtil.getHealthPercentage()<50);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		 MainClass.Staus = "Antiban";
		if(Players.getLocal().getInteracting()==null){
			Camera.turnTo(NPCs.getNearest(7727));
		}
	      if(Players.getLocal().getPlane()==1)
	  	{
	  	//SceneEntities.getNearest(30863)
	  		SceneObject idiot = SceneEntities.getNearest(30863);
	  		//idiot.interact("Climb", "-down").click(true);
	  		idiot.interact("Climb-down");
	  	}
	if (!Walking.isRunEnabled() && Walking.getEnergy() > 50) {
				Walking.setRun(true);
			}
	    	
	      switch (Random.nextInt(1, 20)) {
	      case 1:int pk=Random.nextInt(1, 5);
	      if(pk==2){
	    	  Camera.setAngle(Random.nextInt(1, 360));
	    	break;  
	      }
	    		  

	      case 2:int i=Random.nextInt(0, 30);
	    	  	if(i==23)
	      {        Camera.setAngle(Random.nextInt(1, 360));
	      break;}
	      case 3:


	  
	     

	     
	      case 7:Task.sleep(Random.nextInt(100, 240)); break;

	 

	      case 10:

	      }
	    }

	}


