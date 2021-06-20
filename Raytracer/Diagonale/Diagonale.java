//package Diagonale;
//
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.awt.image.ColorModel;
//import java.awt.image.WritableRaster;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//
///**

// */
//public class Diagonale extends JFrame {
//
//	private BufferedImage image;
//	private JLabel label;
//	private JPanel panel;
//	private ImageIcon icon;
//	private JMenuBar menuBar;
//	private JMenu menu;
//	private JMenuItem safe;
//	private int breite;
//	private int hoehe;
//
//	/**
//	 * Constructor for "Diagonal".
//	 * 
//	 * @param breite - Window width
//	 * @param hoehe  - Window height
//	 */
//	public Diagonale(final int breite, final int hoehe) {
//		this.breite = breite;
//		this.hoehe = hoehe;
//		menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		menu = new JMenu("Datei");
//		menuBar.add(menu);
//		safe = new JMenuItem("Speichern");
//		safe.addActionListener(new ActionListener() {
//
//			/**
//			 * Overriding actionPerformed for creating an ActionEvent.
//			 * 
//			 */
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				File f = new File("saved.png");
//
//				try {
//					ImageIO.write(image, "png", f);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			}
//
//		});
//
//		menu.add(safe);
//		final int offset = 20;
//		zeichneBild(breite, 1000, 0);
//		icon = new ImageIcon(image);
//		label = new JLabel(icon);
//		panel = new JPanel();
//		panel.setBackground(Color.BLACK);
//		panel.add(label);
//		getContentPane().add(panel);
//		setSize(breite + offset, hoehe);
//		setVisible(true);
//
//	}
//
//	/**
//	 * Method for drawing the black background and the red diagonal line.
//	 * 
//	 * @param breite - width in pixels
//	 * @param hoehe  - height in pixels
//	 * @param start  - starting point in pixels
//	 */
//	private void zeichneBild(final int breite, final int hoehe, final int start) {
//		this.image = new BufferedImage(breite, hoehe, BufferedImage.TYPE_INT_ARGB);
//
//		final WritableRaster raster = image.getRaster();
//		final ColorModel model = image.getColorModel();
//
//		/*
//		 * Drawing the Background.
//		 */
//		final int blackRGB = Color.BLACK.getRGB();
//
//		Object pixelSCHWARZ = model.getDataElements(blackRGB, null);
//
//		for (int i = start; i < breite + start; i++) {
//			for (int j = start; j < hoehe + start; j++) {
//				raster.setDataElements(i, j, pixelSCHWARZ);
//			}
//
//		}
//		/*
//		 * Drawing the red line, where both for-loops have the same position. Each
//		 * for-loop for vertical drawing and for horizontal drawing.
//		 */
//		final int redRGB = Color.RED.getRGB();
//
//		Object pixelROT = model.getDataElements(redRGB, null);
//
//		for (int i = start; i < breite; i++) {
//			for (int j = start; j < hoehe; j++) {
//				if (i == j) {
//					raster.setDataElements(i, j, pixelROT);
//				}
//			}
//
//		}
//	}
//
//	/**
//	 * Overriding hashCode for correct use within this class.
//	 * 
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + breite;
//		result = prime * result + hoehe;
//		return result;
//	}
//
//	/**
//	 * Overriding equals for correct use within this class.
//	 * 
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		Diagonale other = (Diagonale) obj;
//		if (breite != other.breite) {
//			return false;
//		}
//		if (hoehe != other.hoehe) {
//			return false;
//		}
//		return true;
//	}
//
//	/**
//	 * Main is only needed for starting the Application.
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		new Diagonale(640, 480);
//	}
//
//}
