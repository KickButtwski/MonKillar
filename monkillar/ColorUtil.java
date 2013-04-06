package monkillar;

import java.awt.Color;

public class ColorUtil {
 
	public static boolean tolerant(final Color c1, final Color c2, final int rdist, final int gdist, final int bdist) {
		return Math.abs(c1.getRed() - c2.getRed()) <= rdist && Math.abs(c1.getGreen() - c2.getGreen()) <= gdist && Math.abs(c1.getBlue() - c2.getBlue()) <= bdist;
	}
 
	public static int percent(final Color c1, final Color c2) {
		final int r = Math.abs(c1.getRed() - c2.getRed());
		final int g = Math.abs(c1.getGreen() - c2.getGreen());
		final int b = Math.abs(c1.getBlue() - c2.getBlue());
		return ((r / 255) + (g / 255) + (b / 255)) / 3 * 100;
	}
 
	public static int dist(final Color c1, final Color c2) {
		final int r = Math.abs(c1.getRed() - c2.getRed());
		final int g = Math.abs(c1.getGreen() - c2.getGreen());
		final int b = Math.abs(c1.getBlue() - c2.getBlue());
		return (r + g + b) / 3;
	}
 
	public static int colorToSq(final Color c) {
		return c.getRGB() & 0xFFFFFF;
	}
 
	public static int sqdist(final int c1, final int c2) {
		final int r = ((c1 >> 16) & 0xFF) - ((c2 >> 16) & 0xFF);
		final int g = ((c1 >> 8) & 0xFF) - ((c2 >> 8) & 0xFF);
		final int b = (c1 & 0xFF) - (c2 & 0xFF);
		return r * r + g * g + b * b;
	}
}