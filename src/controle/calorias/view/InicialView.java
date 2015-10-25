package controle.calorias.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InicialView extends JFrame {

	private static final long serialVersionUID = 1L;
	private PainelTop painelTop;
	private InicialPainelLeft painelLeft;
	private InicialPainelRight painelRight;
	private PainelBottom painelBottom;

	public InicialView() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("POO- Controle de Calorias");
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1024, 728);

		painelTop = new PainelTop();
		painelTop.setLocation(0, 0);
		this.add(painelTop);

		painelLeft = new InicialPainelLeft();
		painelLeft.setLocation(0, 20);
		this.add(painelLeft);

		painelRight = new InicialPainelRight();
		painelRight.setLocation(300, 20);
		this.add(painelRight);

		painelBottom = new PainelBottom();
		painelBottom.setLocation(0, 680);
		this.add(painelBottom);
	}

	public static void main(String[] args) {
		new InicialView();
	}
}

class InicialPainelLeft extends JPanel {
	private static final long serialVersionUID = 1L;

	public InicialPainelLeft() {
		this.setBackground(Color.BLUE);
		this.setSize(300, 660);
	}
}

class InicialPainelRight extends JPanel {
	private static final long serialVersionUID = 1L;

	public InicialPainelRight() {
//		this.setBackground(Color.DARK_GRAY);
		this.setSize(724, 660);
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.DARK_GRAY));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		String[] nomeImg = {
				"\\image\\img01.jpg",
				"\\image\\img02.jpg",
				"\\image\\img03.jpg",
				"\\image\\img04.jpg",
				"\\image\\img05.jpg",
				"\\image\\img06.jpg",
				"\\image\\img07.jpg",
				"\\image\\img08.jpg",
				"\\image\\img09.jpg",
				"\\image\\img10.png",
				"\\image\\img11.jpg",
				"\\image\\img12.jpg",
				"\\image\\img13.jpg",
				"\\image\\img14.jpg",
				"\\image\\img15.jpg",
				"\\image\\img16.png",
				"\\image\\img17.jpg",
				"\\image\\img18.jpg"
		};
		
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