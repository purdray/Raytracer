package PicChooser;

import java.io.File;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class represents a PicChooser
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public final class PicChooser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
	private String file;
	private BufferedImage img;
	private JLabel label;

	/**
	 * Main for launching
	 * @param args
	 */
	public static void main(String[] args) {
		new PicChooser();
	}

	/**
	 * Constructor for PicChooser-Object
	 */
	public PicChooser() {

		fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(fileChooser);
		file = fileChooser.getSelectedFile().getAbsolutePath();

		try {
			img = ImageIO.read(new File(file));
		} catch (Exception e) {
			e.printStackTrace();
		}

		label = new JLabel();
		label.setIcon(new ImageIcon(img));
		getContentPane().add(label);
		pack();
		setVisible(true);
	}

}