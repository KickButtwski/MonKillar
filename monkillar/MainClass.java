package monkillar;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.core.event.listeners.PaintListener;

@Manifest(authors = {"GlassWall"},website="http://www.powerbot.org/community/topic/681319-monkillar-kills-monks-in-edgeville-monastry12k-experiencehour/",topic=681319, name = "MonKillar", description = "Kills Monks in the Edgevile Monastry with bones support", version = 2.1)
public class MainClass extends ActiveScript implements PaintListener, MouseListener{
	
	Rectangle close = new Rectangle(500, 281, 26, 25);
	Rectangle bbonesrec = new Rectangle(471, 339, 13, 10);
	Rectangle OptionsHide = new Rectangle(436, 374, 74, 11);
	public static int HeadMonk = 801;
	public static boolean talking;
	public static boolean hide = false;
	public static boolean hideoptions = false;
	public static boolean needtobury = false;
	public static int  bonesburried;
	public static boolean take = false;
	public static String Staus = "";
	public static boolean bbones = false;
	public static String status="";
	boolean  flag;
	public static long startTime=0;
	public Tile[] myTiles = new Tile[]{new Tile(3058, 3484, 0)};
	long startExp,startprayExp;
	long expGained;
	long prayxpGained;
	int expHour;
	int prayexpHour;	
	private Image getImag1(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	//private final Color c1 = new Color(255, 255, 255);

	//private final Font font11 = new Font("Arial", 1, 12);

	//private final Image img11 = getImag1("http://i1149.photobucket.com/albums/o592/AverageRS/Graphics/Paints/a4fc1b1f.png");
	private final Image img22 = getImag1("http://cdn3.droidmill.com/media/market-media/com.givewaygames.palettepainter_icon.png");
	// Added GUI REPLACEMENT

	private final Color c6 = new Color(0, 0, 0, 199);
	private final Color c2 = new Color(0, 0, 0);
	private final Color color33 = new Color(255, 255, 255);
	private final Color red = new Color(255, 0, 0);// red
	private final Color green = new Color(0, 204, 0);
	private final Color c5 = new Color(51, 51, 51);

	private final BasicStroke stroke11 = new BasicStroke(1);

	private final Font font44 = new Font("Arial", 1, 15);
	private final Font font22 = new Font("Arial", 1, 11);
	private final Font font443 = new Font("Arial", 0, 11);
    //START: Code generated using Enfilade's Easel
    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Color color1 = new Color(0, 0, 0, 244);
    private final Color color2 = new Color(255, 255, 255);
    private final Color color3 = new Color(204, 0, 0);

    private final BasicStroke stroke1 = new BasicStroke(1);

    private final Font font1 = new Font("Arial", 0, 8);
    private final Font font2 = new Font("Arial", 1, 18);
    private final Font font3 = new Font("Arial", 1, 11);

    private final Image img1 = getImage("http://i.imgur.com/ZyTuQGb.png");
    private final Image img2 = getImage("http://i.imgur.com/y2ysAoa.png");
    private final Image img3 = getImage("http://img593.imageshack.us/img593/301/bf793923c0996102465270d.png");
    private final Image img4 = getImage("http://img4.imageshack.us/img4/1264/aaad2b54189cde46660cf73.png");


    //END: Code generated using Enfilade's Easel
	public void onRepaint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		if (!hideoptions) {
			g.setColor(c6);
			g.fillRect(384, 302, 125, 66);
			g.setColor(c2);
			g.setStroke(stroke11);
			g.drawRect(384, 302, 125, 66);
			g.setFont(font44);
			g.setColor(color33);
			g.drawString("Options:", 417, 322);
			g.setFont(font22);
			g.drawString("Bury Bones?", 388, 348);
			if (bbones) {
				g.setColor(green);
			} else {
				g.setColor(red);
			}
			g.fillRect(471, 339, 13, 10);
			g.setColor(c2);
			g.drawRect(471, 339, 13, 10);
			g.setColor(c5);
			g.fillRect(436, 374, 74, 11);
			g.setColor(c2);
			g.drawRect(436, 374, 74, 11);
			g.setFont(font443);
			g.setColor(color33);
			g.drawString("Continue ->", 441, 384);//old hideoptions..
		} else if (!hide) {
			Point p = new Point(Mouse.getX(), Mouse.getY());
			prayxpGained=Skills.getExperience(Skills.PRAYER)-startprayExp;
			expGained = Skills.getExperience(Skills.ATTACK)
					+ Skills.getExperience(Skills.DEFENSE)
					+ Skills.getExperience(Skills.STRENGTH)
					+ Skills.getExperience(Skills.MAGIC)
					+ Skills.getExperience(Skills.RANGE) - startExp;
			prayexpHour=(int) ((int)((prayxpGained)) * 3600000D / (System
					.currentTimeMillis() - startTime));
			expHour = (int) ((expGained) * 3600000D / (System
					.currentTimeMillis() - startTime));
			Color Purple = new Color(255, 0, 0);
			Color LowPurple = new Color(0, 100, 0);
			Color Indigo = new Color(0, 0, 0);

			((Graphics2D) g).setRenderingHints(new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON));

			Graphics2D spinG = (Graphics2D) g.create();
			Graphics2D spinGRev = (Graphics2D) g.create();
			Graphics2D g2d = (Graphics2D) g;
			spinGRev.setColor(Purple);

			spinGRev.rotate(System.currentTimeMillis() % 2000d / 2000d
					* (-360d) * 2 * Math.PI / 180.0, p.x, p.y);
			spinGRev.setStroke(new BasicStroke(1));
			spinGRev.drawLine(p.x - 8, p.y, p.x + 8, p.y);
			
			spinGRev.drawLine(p.x, p.y - 8, p.x, p.y + 8);
			spinG.setColor(LowPurple);
			spinG.rotate(System.currentTimeMillis() % 2000d / 2000d * (360d)
					* 2 * Math.PI / 180.0, p.x, p.y);
			spinG.drawLine(p.x - 6, p.y, p.x + 6, p.y);
			spinG.drawLine(p.x, p.y - 6, p.x, p.y + 6);
			g2d.setColor(Indigo);
			g2d.drawOval(p.x - 10, p.y - 10, 20, 20);
		        g.setColor(color1);
		        g.fillRect(360, 179, 137, 128);
		        g.setColor(color2);
		        g.setStroke(stroke1);
		        g.drawRect(360, 179, 137, 128);
		        g.setFont(font1);
		        g.drawString("-By GlassWall", 439, 303);
		        g.setFont(font2);
		        g.drawString("Killar", 429, 202);
		        g.drawImage(img1, 371, 211, null);
		        g.drawImage(img2, 372, 239, null);
		        g.drawImage(img3, 374, 266, null);
		        g.setColor(color3);
		        g.drawString("Mon", 391, 202);
		        g.drawImage(img4, 501, 282, null);
		        g.setFont(font3);
		        g.setColor(color2);
		        g.drawString(Time.format(System.currentTimeMillis() - startTime), 402, 227);
		        g.drawString(""+expGained+"("+expHour+"/hr)", 403, 256);
		        g.drawString(""+status, 402, 284);
			/**g.drawImage(img22, 511, 511, null);
			g.drawImage(img11, -3, 334, null);
			g.setFont(font11);
			g.setColor(c1);

			g.drawString(Time.format(System.currentTimeMillis() - startTime),
					328, 434);
			g.drawString("" + expGained, 307, 447);
			g.drawString("" + expHour, 278, 460);
			g.drawString(""+prayxpGained, 349, 470);
			g.drawString(""+prayexpHour, 319, 482);
			g.drawString(""+bonesburried, 324, 495);
	*/
		} else {
			Point p = new Point(Mouse.getX(), Mouse.getY());

			expGained = Skills.getExperience(Skills.ATTACK)
					+ Skills.getExperience(Skills.DEFENSE)
					+ Skills.getExperience(Skills.STRENGTH)
					+ Skills.getExperience(Skills.MAGIC)
					+ Skills.getExperience(Skills.RANGE) - startExp;
			expHour = (int) ((expGained) * 3600000D / (System
					.currentTimeMillis() - startTime));
			Color Purple = new Color(255, 0, 0);
			Color LowPurple = new Color(0, 100, 0);
			// Color LowPurple = new Color(0, 100, 0);
			// Color Indigo = new Color(75, 0, 130);
			Color Indigo = new Color(0, 0, 0);
			g.drawImage(img4, 501, 282, null);
			((Graphics2D) g).setRenderingHints(new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON));

			Graphics2D spinG = (Graphics2D) g.create();
			Graphics2D spinGRev = (Graphics2D) g.create();
			Graphics2D g2d = (Graphics2D) g;
			spinGRev.setColor(Purple);

			spinGRev.rotate(System.currentTimeMillis() % 2000d / 2000d
					* (-360d) * 2 * Math.PI / 180.0, p.x, p.y);
			spinGRev.setStroke(new BasicStroke(1));
			spinGRev.drawLine(p.x - 8, p.y, p.x + 8, p.y);
			spinGRev.drawLine(p.x, p.y - 8, p.x, p.y + 8);
			spinG.setColor(LowPurple);
			spinG.rotate(System.currentTimeMillis() % 2000d / 2000d * (360d)
					* 2 * Math.PI / 180.0, p.x, p.y);
			spinG.drawLine(p.x - 6, p.y, p.x + 6, p.y);
			spinG.drawLine(p.x, p.y - 6, p.x, p.y + 6);
			g2d.setColor(Indigo);
			g2d.drawOval(p.x - 10, p.y - 10, 20, 20);

			g.drawImage(img22, 511, 511, null);
		}
	}
	private final Node[] array = new Node[] { new Attack(),new Abilities(),new Heal(),new AntiBan(),new BuryBones(),new CollectBones()};
	// END: Code generated using Enfilade's Easel

	public void onStart() {
		/* adds Mine and Drop to the list of the strategies */
		//Strategies.add(new Attack(),new Heal(),new CollectBones(),new BuryBones());
		bonesburried=0;
		 startTime = System.currentTimeMillis();
		startprayExp=Skills.getExperience(Skills.PRAYER);
		startExp = Skills.getExperience(Skills.ATTACK)
				+ Skills.getExperience(Skills.DEFENSE)
				+ Skills.getExperience(Skills.STRENGTH)
				+ Skills.getExperience(Skills.MAGIC)
				+ Skills.getExperience(Skills.RANGE);

	}

	@Override
	public int loop() {
		for (final Node node : array) {
			if (node.activate()) {
				node.execute();
			}
		
		}
		
		return 0;
	}
	/**public int loop() {
		

		for (Strategy strategy : Strategies.getStrategies()) {
			//System.out.println("checking Strategy " + strategy.getClass().getName());
			if (isAlive() && strategy.validate()) {
				//System.out.println("validated Strategy " + strategy.getClass().getName());
				strategy.execute();
				return Random.nextInt(250, 350);
						
				//System.out.println(strategy.getClass().getName() + " successfully exited");
				//Task.sleep(150, 200);
			}

			return 400;
		}

		/* sleeps for 1000ms if no suitable strategy exists 
		return 1000;
	}
*/
	public static boolean isIdle() {
		return Players.getLocal().getAnimation() == -1 && !Players.getLocal().isMoving();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point c = e.getPoint();
		if (close.contains(c) && !hide) {
			hide = true;
		} else if (close.contains(c) && hide) {
			hide = false;
		}
		if (OptionsHide.contains(c) && !hideoptions) {
			hideoptions = true;
			System.out.println("HideOptions..");
		} else if (OptionsHide.contains(c)) {
			hideoptions = false;
		}
		if (!hideoptions && bbonesrec.contains(c)) {
			System.out.println("Clicked");
			bbones = !bbones;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub


	}




}