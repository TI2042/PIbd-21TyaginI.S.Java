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
	private Transport gun;
	private IGuns guns;
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
				
	
		GunPanel panel = new GunPanel();
		panel.setBounds(12, 13, 550, 500);
				
		JButton btnCreate = new JButton("Create A-Gun");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				frame.getContentPane().add(panel);
				gun = new AntiaircraftGun(100 + (int)(Math.random() * ((300 - 100) + 1)), Color.GREEN, Color.GRAY, true,true,true, guns);
				panel.setGun(gun);
				panel.setGuns(guns);
				gun.SetPosition(10 + (int)(Math.random() * ((100 - 10) + 1)),10 + (int)(Math.random() * ((100 - 10) + 1)), 650, 550);
				guns.SetPos(gun.Get_StartPosX(), gun.Get_StartPosY());
				panel.repaint();
			}
		});
		btnCreate.setBounds(598, 47, 170, 54);
		frame.getContentPane().add(btnCreate);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		btnUp.setBounds(648, 473, 72, 40);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		btnLeft.setBounds(563, 526, 72, 40);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		btnRight.setBounds(728, 526, 72, 40);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		btnDown.setBounds(648, 526, 72, 40);
		frame.getContentPane().add(btnDown);
		
		JButton buttonBTR = new JButton("Create BTR");
		buttonBTR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gun = new BTRGun(100 + (int)(Math.random() * ((300 - 100) + 1)),Color.GREEN);
				panel.setGun(gun);
				gun.SetPosition(10 + (int)(Math.random() * ((100 - 10) + 1)),10 + (int)(Math.random() * ((100 - 10) + 1)), 650, 550);
	            panel.repaint();
			}
		});
		buttonBTR.setBounds(598, 246, 170, 54);
		frame.getContentPane().add(buttonBTR);
	}
}
