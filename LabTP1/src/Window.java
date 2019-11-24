import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Window() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		AntiaircraftGun gun = new AntiaircraftGun(100 + (int)(Math.random() * ((300 - 100) + 1)),1000 + (int)(Math.random() * ((2000 - 1000) + 1)), Color.GREEN, Color.GRAY, true,true,true);
		JPanel panel = new GunPanel(gun);
		panel.setBounds(12, 13, 550, 500);
				
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				frame.getContentPane().add(panel);
	            gun.SetPosition(10 + (int)(Math.random() * ((100 - 10) + 1)),10 + (int)(Math.random() * ((100 - 10) + 1)), 650, 550);
	            panel.repaint();
			}
		});
		btnCreate.setBounds(598, 47, 170, 54);
		frame.getContentPane().add(btnCreate);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveGun(Direction.Up);
				panel.repaint();
			}
		});
		btnUp.setBounds(648, 473, 72, 40);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveGun(Direction.Left);
				panel.repaint();
			}
		});
		btnLeft.setBounds(563, 526, 72, 40);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveGun(Direction.Right);
				panel.repaint();
			}
		});
		btnRight.setBounds(728, 526, 72, 40);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveGun(Direction.Down);
				panel.repaint();
			}
		});
		btnDown.setBounds(648, 526, 72, 40);
		frame.getContentPane().add(btnDown);
		
		JButton btnGuns2 = new JButton("2 guns");
		btnGuns2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.numberOfGuns(HardDirection.Two);			
			}
		});
		btnGuns2.setBounds(634, 132, 97, 25);
		frame.getContentPane().add(btnGuns2);
		
		JButton btnGuns4 = new JButton("4 guns");
		btnGuns4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.numberOfGuns(HardDirection.Four);
			}
		});
		btnGuns4.setBounds(634, 170, 97, 25);
		frame.getContentPane().add(btnGuns4);
		
		JButton btnGuns6 = new JButton("6 guns");
		btnGuns6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.numberOfGuns(HardDirection.Six);
			}
		});
		btnGuns6.setBounds(634, 208, 97, 25);
		frame.getContentPane().add(btnGuns6);
	}
}
