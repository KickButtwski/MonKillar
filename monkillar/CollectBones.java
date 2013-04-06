package monkillar;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.GroundItem;

public class CollectBones extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return MainClass.bbones && Players.getLocal().getInteracting() == null && MainClass.take==true && Players.getLocal().getAnimation()==-1;

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if((Players.getLocal().getHealthPercent()<50)){

			return;
		}
		// TODO Auto-generated method stub

		GroundItem B = GroundItems.getNearest(526);
		if (!Players.getLocal().isInCombat()) {
			if (B.isOnScreen()) {
				try {
					B.interact("Take", "Bones");
					MainClass.take=false;

					Task.sleep(Random.nextInt(590, 1000));

				} catch (Exception e) {
				}
				if(B.isOnScreen()==false){
					MainClass.take=false;
				}
			}
			if(Inventory.getCount()==28){
				MainClass.needtobury = true;
			}
			MainClass.Staus = "Getting bones";
			Task.sleep(100, 200);
		}

	}


}

