import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
		
		JButton btnAnalyzeTeam = new JButton("Analyze Team");
		btnAnalyzeTeam.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					AnalyzeTeamForm atf = new AnalyzeTeamForm();
					atf.main(null);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmNbaTextEvaluator.dispose();
			}
		});
		btnAnalyzeTeam.setForeground(Color.RED);
		btnAnalyzeTeam.setName("btnAnalyzeTeam");
		btnAnalyzeTeam.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnAnalyzeTeam.setSize(new Dimension(231, 76));
		btnAnalyzeTeam.setLocation(new Point(81, 159));
		btnAnalyzeTeam.setBounds(26, 252, 180, 53);
		frmNbaTextEvaluator.getContentPane().add(btnAnalyzeTeam);
		
		JButton btnAnalyzePlayer = new JButton("Analyze Player");
		btnAnalyzePlayer.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
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
		btnAnalyzePlayer.setForeground(Color.RED);
		btnAnalyzePlayer.setSize(new Dimension(231, 76));
		btnAnalyzePlayer.setName("btnAnalyzeTeam");
		btnAnalyzePlayer.setLocation(new Point(81, 159));
		btnAnalyzePlayer.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnAnalyzePlayer.setBounds(219, 252, 180, 53);
		frmNbaTextEvaluator.getContentPane().add(btnAnalyzePlayer);
		
		JButton btnCompareTeam = new JButton("Compare Team");
		btnCompareTeam.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					CompareTeamForm ctf = new CompareTeamForm();
					ctf.main(null);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmNbaTextEvaluator.dispose();
			}
		});
		btnCompareTeam.setForeground(Color.RED);
		btnCompareTeam.setSize(new Dimension(231, 76));
		btnCompareTeam.setName("btnAnalyzeTeam");
		btnCompareTeam.setLocation(new Point(81, 159));
		btnCompareTeam.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCompareTeam.setBounds(26, 320, 180, 53);
		frmNbaTextEvaluator.getContentPane().add(btnCompareTeam);
		
		JButton btnComparePlayer = new JButton("Compare Player");
		btnComparePlayer.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				ComparePlayersForm cpf = new ComparePlayersForm();
				cpf.main(null);
				frmNbaTextEvaluator.dispose();
			}
		});
		btnComparePlayer.setForeground(Color.RED);
		btnComparePlayer.setSize(new Dimension(231, 76));
		btnComparePlayer.setName("btnAnalyzeTeam");
		btnComparePlayer.setLocation(new Point(81, 159));
		btnComparePlayer.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnComparePlayer.setBounds(219, 320, 180, 53);
		frmNbaTextEvaluator.getContentPane().add(btnComparePlayer);
		
		JLabel lblNBALogo = new JLabel();
		lblNBALogo.setSize(100, 153);
		lblNBALogo.setBounds(0,0,784,401);
		Image img = new ImageIcon(this.getClass().getResource("/NBALogo.png")).getImage();
		Image newImage = img.getScaledInstance(lblNBALogo.getWidth(), lblNBALogo.getHeight(), Image.SCALE_DEFAULT);
		lblNBALogo.setIcon(new ImageIcon(newImage));
		frmNbaTextEvaluator.getContentPane().add(lblNBALogo);
	}
}