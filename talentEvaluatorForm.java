import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class talentEvaluatorForm {

	private JFrame frmNbaTextEvaluator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					talentEvaluatorForm window = new talentEvaluatorForm();
					window.frmNbaTextEvaluator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public talentEvaluatorForm() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException  {
		frmNbaTextEvaluator = new JFrame();
		frmNbaTextEvaluator.setTitle("NBA Talent Evaluator");
		frmNbaTextEvaluator.getContentPane().setName("");
		frmNbaTextEvaluator.setPreferredSize(new Dimension(816, 489));
		frmNbaTextEvaluator.setSize(new Dimension(816, 489));
		frmNbaTextEvaluator.setBounds(100, 100, 555, 380);
		frmNbaTextEvaluator.setSize(816, 489);
		frmNbaTextEvaluator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNbaTextEvaluator.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("NBA Talent Evaluator");
		panel.setName("nbaTitleText1");
		panel.setSize(new Dimension(800, 66));
		panel.setLocation(new Point(0, 0));
		panel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 48));
		
		frmNbaTextEvaluator.getContentPane().add(panel);
		
		JLabel lblNbaTextEvaluator = new JLabel("NBA TALENT EVALUATOR");
		lblNbaTextEvaluator.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 48));
		panel.add(lblNbaTextEvaluator);
		
		JButton btnAnalyzeTeam = new JButton("Analyze Team");
		btnAnalyzeTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnalyzeTeamForm atf = new AnalyzeTeamForm();
					atf.main(null);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frmNbaTextEvaluator.dispose();
			}
		});
		btnAnalyzeTeam.setName("btnAnalyzeTeam");
		btnAnalyzeTeam.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 31));
		btnAnalyzeTeam.setSize(new Dimension(231, 76));
		btnAnalyzeTeam.setLocation(new Point(81, 159));
		btnAnalyzeTeam.setBounds(75, 137, 231, 76);
		frmNbaTextEvaluator.getContentPane().add(btnAnalyzeTeam);
		
		JButton btnAnalyzePlayer = new JButton("Analyze Player");
		btnAnalyzePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnalyzePlayerForm apf = new AnalyzePlayerForm();
					apf.main(null);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frmNbaTextEvaluator.dispose();
			}
		});
		btnAnalyzePlayer.setSize(new Dimension(231, 76));
		btnAnalyzePlayer.setName("btnAnalyzeTeam");
		btnAnalyzePlayer.setLocation(new Point(81, 159));
		btnAnalyzePlayer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 29));
		btnAnalyzePlayer.setBounds(413, 137, 231, 76);
		frmNbaTextEvaluator.getContentPane().add(btnAnalyzePlayer);
		
		JButton btnCompareTeam = new JButton("Compare Team");
		btnCompareTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CompareTeamForm ctf = new CompareTeamForm();
					ctf.main(null);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frmNbaTextEvaluator.dispose();
			}
		});
		btnCompareTeam.setSize(new Dimension(231, 76));
		btnCompareTeam.setName("btnAnalyzeTeam");
		btnCompareTeam.setLocation(new Point(81, 159));
		btnCompareTeam.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
		btnCompareTeam.setBounds(75, 278, 231, 76);
		frmNbaTextEvaluator.getContentPane().add(btnCompareTeam);
		
		JButton btnComparePlayer = new JButton("Compare Player");
		btnComparePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComparePlayersForm cpf = new ComparePlayersForm();
				cpf.main(null);
				frmNbaTextEvaluator.dispose();
			}
		});
		btnComparePlayer.setSize(new Dimension(231, 76));
		btnComparePlayer.setName("btnAnalyzeTeam");
		btnComparePlayer.setLocation(new Point(81, 159));
		btnComparePlayer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 27));
		btnComparePlayer.setBounds(413, 278, 231, 76);
		frmNbaTextEvaluator.getContentPane().add(btnComparePlayer);
		
		
	}
}
