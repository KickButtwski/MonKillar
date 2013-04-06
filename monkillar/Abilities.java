package monkillar;


import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;

public class Abilities extends Node {

	@Override
	public boolean activate() {
		return Players.getLocal().getInteracting() != null
				&& Players.getLocal().getInteracting().validate()
				&& !Players.getLocal().isMoving()&&!(Players.getLocal().getHealthPercent()<50);
	}

	@Override
	public void execute() {
		for (int i = 0; i < 12; i++) {
			if (Actionbar.getSlot(i).isAvailable()
					&& Actionbar.getAbilityAt(i) != null
					&& Actionbar.getAbilityAt(i).getAbilityType() == Actionbar.AbiltiyType.BASIC
					&& Actionbar.getSlotStateAt(i).equals(
							Actionbar.SlotState.ABILITY)
					&& !Actionbar.getSlot(i).getCooldownWidget().isOnScreen()) {
				
				Actionbar.getSlot(i).activate(true);
				Task.sleep(500);
				break;
			}
		}
	}}