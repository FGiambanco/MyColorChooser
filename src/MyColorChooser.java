
//Francesco Giambanco MyColorChooser Assignment Due 4/25/17
// Professor Shahidullah
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class MyColorChooser extends JPanel {
	private JPanel panel;
	private JTextField redText;
	private JTextField greenText;
	private JTextField blueText;
	private JLabel redL;
	private JLabel greenL;
	private JLabel blueL;
	private JSlider redS;
	private JSlider greenS;
	private JSlider blueS;
	private Color color;

	public MyColorChooser() {
		JPanel panel = new JPanel();

		redL = new JLabel("Red: ");
		redS = new JSlider(JSlider.HORIZONTAL, 0, 255, 1);
		redText = new JTextField("0", 4);

		greenL = new JLabel("Green: ");
		greenS = new JSlider(JSlider.HORIZONTAL, 0, 255, 1);
		greenText = new JTextField("0", 4);

		blueL = new JLabel("Blue: ");
		blueS = new JSlider(JSlider.HORIZONTAL, 0, 255, 1);
		blueText = new JTextField("0", 4);

		panel.add(redL);
		panel.add(redS);
		panel.add(redText);
		panel.add(greenL);
		panel.add(greenS);
		panel.add(greenText);
		panel.add(blueL);
		panel.add(blueS);
		panel.add(blueText);

		setLayout(new GridLayout(3, 3));

		add(panel);

		redS.addChangeListener(new SliderListener());
		greenS.addChangeListener(new SliderListener());
		blueS.addChangeListener(new SliderListener());

		redText.addActionListener(new TextListener());
		greenText.addActionListener(new TextListener());
		blueText.addActionListener(new TextListener());
		color = Color.black;

	}

	public void setColor(Color c) {
		color = c;

		redS.setValue(c.getRed());
		redText.setText(String.valueOf(c.getRed()));

		greenS.setValue(c.getGreen());
		greenText.setText(String.valueOf(c.getGreen()));

		blueS.setValue(c.getBlue());
		blueText.setText(String.valueOf(c.getBlue()));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillRect(0, 0, 900, 600);
		g.drawString("Colors: " + g.getColor(), 150, 200);
		repaint();
	}

	private class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int r = redS.getValue();
			int b = blueS.getValue();
			int g = greenS.getValue();

			color = new Color(r, g, b);

			redText.setText(String.valueOf(r));
			blueText.setText(String.valueOf(b));
			greenText.setText(String.valueOf(g));
		}
	}

	private class TextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int r = Integer.parseInt(redText.getText());
			int g = Integer.parseInt(greenText.getText());
			int b = Integer.parseInt(blueText.getText());

			color = new Color(r, g, b);

			redS.setValue(r);
			greenS.setValue(g);
			blueS.setValue(b);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("My Color Chooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyColorChooser panel = new MyColorChooser();
		frame.add(panel);
		frame.setSize(920, 600);
		frame.setVisible(true);
		

	}

}
