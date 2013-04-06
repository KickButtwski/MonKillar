package monkillar;

import java.awt.Color;

import java.awt.image.BufferedImage;
 
import org.powerbot.game.bot.Context;
 
public class ImageUtil {
 
	public static BufferedImage getGame() {
		return Context.get().getBuffer();
	}
 
	public static Color getColorAt(final int x, final int y) {
		try {
			return new Color(getGame().getRGB(x, y));
		} catch (final Exception e) {
			return Color.BLACK;
		}
	}
}