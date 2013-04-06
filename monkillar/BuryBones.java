package monkillar;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;

public class BuryBones extends Node{

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && !(PlayerUtil.getHealthPercentage()<50) && MainClass.bbones &&MainClass.needtobury &&Players.getLocal().getAnimation()==-1;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MainClass.status="Burrying Bones";
		if(Players.getLocal().getHealthPercent()<50){
    		
    		return;
    	}
    	if(Tabs.getCurrent() !=Tabs.INVENTORY){
    		Tabs.INVENTORY.open();
    		
    	}
        for (Item i : Inventory.getItems()) {
            if (i.getId() == 526)// 526 bone id
            {	
                i.getWidgetChild().interact("Bury", "Bones");
                Task.sleep(Random.nextInt(140, 200));
                
				MainClass.bonesburried++;
                Task.sleep(100);
            }
        }
        MainClass.needtobury=false;
    }
	
		
	

}
