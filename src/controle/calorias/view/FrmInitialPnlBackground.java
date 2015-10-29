package controle.calorias.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FrmInitialPnlBackground extends JPanel {
	private static final long serialVersionUID = 1L;

	public FrmInitialPnlBackground() {
		this.setSize(724, 660);
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0,
				Color.DARK_GRAY));
	}

	@Override
	protected void paintComponent(Graphics g) {
		String[] nomeImg = { "\\image\\img01.jpg", "\\image\\img02.jpg",
				"\\image\\img03.jpg", "\\image\\img04.jpg",
				"\\image\\img05.jpg", "\\image\\img06.jpg",
				"\\image\\img07.jpg", "\\image\\img08.jpg",
				"\\image\\img09.jpg", "\\image\\img10.png",
				"\\image\\img11.jpg", "\\image\\img12.jpg",
				"\\image\\img13.jpg", "\\image\\img14.jpg",
				"\\image\\img15.jpg", "\\image\\img16.png",
				"\\image\\img17.jpg", "\\image\\img18.jpg" };

		Random random = new Random();
		int i = random.nextInt(18);

		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResourceAsStream(nomeImg[i]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
}