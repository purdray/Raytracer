package Raytracer;

import java.awt.image.BufferedImage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Kamera.Camera;

import Welt.World;

/**
 * This Class creates the scene and GUI for the application.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Raytracer extends JFrame {

	/**
	 * Current Version of the class Raytracer?
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private final BufferedImage imageT;
	private final JLabel label;
	private final JPanel panel;
	private final ImageIcon icon;
	private final JMenuBar menuBar;

	public int breite;
	public int hoehe;
	public int start;
	public Camera Camera;
	public World world;
	public Raytracer raytracer;

	/**
	 * Menues
	 */
	private final JMenu menu1;
	private final JMenu menu2;
	private final JMenu menu3;

	/**
	 * Dropdown menu and menuitems
	 */
	private final JMenuItem but0;
	private final JMenuItem but1;
	private final JMenuItem but2;
	private final JMenuItem but3;
	private final JMenuItem but4;
	private final JMenuItem but5;
	private final JMenuItem but6;
	private final JMenuItem but7;
	private final JMenuItem safe;
	private final JMenuItem schliessen;

	/**
	 * Constructor for Raytracer-object
	 * 
	 * @param imageT - BufferedImage for presenting it on a scene.
	 * 
	 */
	public Raytracer(BufferedImage imageT) {

		if (imageT == null) {
			throw new IllegalArgumentException("Null not allowed! Please check your inputs!");
		}

		this.imageT = imageT;

		/**
		 * Panel
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		safe = new JMenuItem("Speichern");
		schliessen = new JMenuItem("Schlieﬂen");

		menu1 = new JMenu("Datei");

		menu2 = new JMenu("Entwicklungs-Timeline");
		menu3 = new JMenu("Kameraoptionen");

		but0 = new JMenuItem("Ohne Zusatz");
		but1 = new JMenuItem("Texturanfang");
		but2 = new JMenuItem("Stillleben");
		but3 = new JMenuItem("Volle Texturen");
		but4 = new JMenuItem("Perspectivische Kamera");
		but5 = new JMenuItem("Orthographische Kamera");
		but6 = new JMenuItem("Erde bei nacht");
		but7 = new JMenuItem("Sauron");

		menu1.add(safe);
		menu1.add(schliessen);

		menu2.add(but0);
		menu2.add(but1);
		menu2.add(but2);
		menu2.add(but3);
		menu2.add(but6);
		menu2.add(but7);
		menu3.add(but4);
		menu3.add(but5);

		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);

		safe.addActionListener(new ActionListener() {

			/**
			 * ActionHandler for saving
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				final File f = new File("Raytracersave.png");

				try {
					ImageIO.write(imageT, "png", f);
				} catch (final IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		schliessen.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for closing
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);
			}
		});

		icon = new ImageIcon(imageT);
		label = new JLabel(icon);
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.add(label);
		getContentPane().add(panel);
		setSize(1000 + 20, 800 + 70);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		but0.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button0 "Ohne Zusatz"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 0;
				new GeoController(modus);
			}
		});

		but1.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button1 "Textur anfang"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 1;
				new GeoController(modus);
			}
		});

		but2.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button2 "Stillleben"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 2;
				new GeoController(modus);
			}
		});

		but3.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button3 "Volle Textur"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 3;
				new GeoController(modus);
			}
		});

		but4.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button4 "Perspective"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 3;
				new GeoController(modus);
			}
		});

		but5.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button5 "Orthogrpahic"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 4;
				new GeoController(modus);
			}
		});

		but6.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button6 "Erde bei nacht"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 6;
				new GeoController(modus);
			}
		});

		but7.addActionListener(new ActionListener() {
			/**
			 * ActionHandler for button7 "Sauron"
			 */
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

				int modus = 7;
				new GeoController(modus);
			}
		});
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Raytracer [imageT=" + imageT + ", label=" + label + ", panel=" + panel + ", icon=" + icon + ", menuBar="
				+ menuBar + ", breite=" + breite + ", hoehe=" + hoehe + ", start=" + start + ", Camera=" + Camera
				+ ", world=" + world + ", raytracer=" + raytracer + ", menu1=" + menu1 + ", menu2=" + menu2 + ", menu3="
				+ menu3 + ", but0=" + but0 + ", but1=" + but1 + ", but2=" + but2 + ", but3=" + but3 + ", but4=" + but4
				+ ", but5=" + but5 + ", but6=" + but6 + ", but7=" + but7 + ", safe=" + safe + ", schliessen="
				+ schliessen + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Camera == null) ? 0 : Camera.hashCode());
		result = prime * result + breite;
		result = prime * result + ((but0 == null) ? 0 : but0.hashCode());
		result = prime * result + ((but1 == null) ? 0 : but1.hashCode());
		result = prime * result + ((but2 == null) ? 0 : but2.hashCode());
		result = prime * result + ((but3 == null) ? 0 : but3.hashCode());
		result = prime * result + ((but4 == null) ? 0 : but4.hashCode());
		result = prime * result + ((but5 == null) ? 0 : but5.hashCode());
		result = prime * result + ((but6 == null) ? 0 : but6.hashCode());
		result = prime * result + ((but7 == null) ? 0 : but7.hashCode());
		result = prime * result + hoehe;
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((imageT == null) ? 0 : imageT.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((menu1 == null) ? 0 : menu1.hashCode());
		result = prime * result + ((menu2 == null) ? 0 : menu2.hashCode());
		result = prime * result + ((menu3 == null) ? 0 : menu3.hashCode());
		result = prime * result + ((menuBar == null) ? 0 : menuBar.hashCode());
		result = prime * result + ((panel == null) ? 0 : panel.hashCode());
		result = prime * result + ((raytracer == null) ? 0 : raytracer.hashCode());
		result = prime * result + ((safe == null) ? 0 : safe.hashCode());
		result = prime * result + ((schliessen == null) ? 0 : schliessen.hashCode());
		result = prime * result + start;
		result = prime * result + ((world == null) ? 0 : world.hashCode());
		return result;
	}

	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Raytracer other = (Raytracer) obj;
		if (Camera == null) {
			if (other.Camera != null) {
				return false;
			}
		} else if (!Camera.equals(other.Camera)) {
			return false;
		}
		if (breite != other.breite) {
			return false;
		}
		if (but0 == null) {
			if (other.but0 != null) {
				return false;
			}
		} else if (!but0.equals(other.but0)) {
			return false;
		}
		if (but1 == null) {
			if (other.but1 != null) {
				return false;
			}
		} else if (!but1.equals(other.but1)) {
			return false;
		}
		if (but2 == null) {
			if (other.but2 != null) {
				return false;
			}
		} else if (!but2.equals(other.but2)) {
			return false;
		}
		if (but3 == null) {
			if (other.but3 != null) {
				return false;
			}
		} else if (!but3.equals(other.but3)) {
			return false;
		}
		if (but4 == null) {
			if (other.but4 != null) {
				return false;
			}
		} else if (!but4.equals(other.but4)) {
			return false;
		}
		if (but5 == null) {
			if (other.but5 != null) {
				return false;
			}
		} else if (!but5.equals(other.but5)) {
			return false;
		}
		if (but6 == null) {
			if (other.but6 != null) {
				return false;
			}
		} else if (!but6.equals(other.but6)) {
			return false;
		}
		if (but7 == null) {
			if (other.but7 != null) {
				return false;
			}
		} else if (!but7.equals(other.but7)) {
			return false;
		}
		if (hoehe != other.hoehe) {
			return false;
		}
		if (icon == null) {
			if (other.icon != null) {
				return false;
			}
		} else if (!icon.equals(other.icon)) {
			return false;
		}
		if (imageT == null) {
			if (other.imageT != null) {
				return false;
			}
		} else if (!imageT.equals(other.imageT)) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (menu1 == null) {
			if (other.menu1 != null) {
				return false;
			}
		} else if (!menu1.equals(other.menu1)) {
			return false;
		}
		if (menu2 == null) {
			if (other.menu2 != null) {
				return false;
			}
		} else if (!menu2.equals(other.menu2)) {
			return false;
		}
		if (menu3 == null) {
			if (other.menu3 != null) {
				return false;
			}
		} else if (!menu3.equals(other.menu3)) {
			return false;
		}
		if (menuBar == null) {
			if (other.menuBar != null) {
				return false;
			}
		} else if (!menuBar.equals(other.menuBar)) {
			return false;
		}
		if (panel == null) {
			if (other.panel != null) {
				return false;
			}
		} else if (!panel.equals(other.panel)) {
			return false;
		}
		if (raytracer == null) {
			if (other.raytracer != null) {
				return false;
			}
		} else if (!raytracer.equals(other.raytracer)) {
			return false;
		}
		if (safe == null) {
			if (other.safe != null) {
				return false;
			}
		} else if (!safe.equals(other.safe)) {
			return false;
		}
		if (schliessen == null) {
			if (other.schliessen != null) {
				return false;
			}
		} else if (!schliessen.equals(other.schliessen)) {
			return false;
		}
		if (start != other.start) {
			return false;
		}
		if (world == null) {
			if (other.world != null) {
				return false;
			}
		} else if (!world.equals(other.world)) {
			return false;
		}
		return true;
	}

}
