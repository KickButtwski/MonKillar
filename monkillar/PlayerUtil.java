package monkillar;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
 
import org.powerbot.game.api.methods.Widgets;
 
public class PlayerUtil {
 
	public static int getHealthPercentage() {
		final Rectangle bounds = Widgets.get(748, 3).getBoundingRectangle();
		final int midX = bounds.x + (bounds.width / 2);
		int length = 0;
		int successes = 0;
		final Point top = new Point(midX, bounds.y + 4);
		for (int i = 0; i < 5; i++) {
			length++;
			final Color color = ImageUtil.getColorAt(top.x, top.y + i);
			if (ColorUtil.dist(color, new Color(188, 8, 4)) <= 15 || ColorUtil.dist(color, new Color(21, 242, 48)) <= 15) {
				successes++;
			}
		}
		final Point side = new Point(midX + 9, bounds.y + 10);
		for (int i = 0; i < 10; i++) {
			length++;
			final Color color = ImageUtil.getColorAt(side.x, side.y + i);
			if (ColorUtil.dist(color, new Color(131, 2, 1)) <= 15 || ColorUtil.dist(color, new Color(10, 162, 35)) <= 15) {
				successes++;
			}
		}
		final Point bottom = new Point(midX, bounds.y + 22);
		for (int i = 0; i < 5; i++) {
			length++;
			final Color color = ImageUtil.getColorAt(bottom.x, bottom.y + i);
			if (ColorUtil.dist(color, new Color(138, 8, 4)) <= 15 || ColorUtil.dist(color, new Color(10, 162, 35)) <= 15) {
				successes++;
			}
		}
		return (successes * 100) / length;
	}
}