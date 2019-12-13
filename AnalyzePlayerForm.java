import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AnalyzePlayerForm {

	private JFrame frmAnalyzeTeam;
	//private PlayerEvaluator pe;
	private TextReader tr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyzePlayerForm window = new AnalyzePlayerForm();
					window.frmAnalyzeTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public AnalyzePlayerForm() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frmAnalyzeTeam = new JFrame();
		frmAnalyzeTeam.getContentPane().setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		frmAnalyzeTeam.setSize(new Dimension(816, 489));
		frmAnalyzeTeam.setTitle("Analyze Team");
		frmAnalyzeTeam.setBounds(100, 100, 450, 300);
		frmAnalyzeTeam.setSize(816, 489);
		frmAnalyzeTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAnalyzeTeam.getContentPane().setLayout(null);
		
		//Initializes the player evaluator and the text reader
		//pe = new PlayerEvaluator();
		tr = new TextReader();
		
		JLabel lblNewLabel = new JLabel("Player Analyzer");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 11, 780, 50);
		frmAnalyzeTeam.getContentPane().add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(addPlayerNames(comboBox)));
		comboBox.setSize(new Dimension(180, 20));
		comboBox.setEditable(true);
		comboBox.setName("comboBoxNBATeams1");
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(10, 62, 170, 20);
		frmAnalyzeTeam.getContentPane().add(comboBox);
		
		JLabel lblAveragePPG = new JLabel("Average Points Per Game (APPG): ");
		lblAveragePPG.setBounds(10, 110, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAveragePPG);
		
		JLabel lblAverageRPG = new JLabel("Average Rebounds Per Game (ARPG): ");
		lblAverageRPG.setBounds(10, 152, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageRPG);
		
		JLabel lblAverageAPG = new JLabel("Average Assists Per Game (AAPG): ");
		lblAverageAPG.setBounds(10, 194, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageAPG);
		
		JLabel lblAverageFGP = new JLabel("Average Field Goal Percentage (AFGP): ");
		lblAverageFGP.setBounds(10, 236, 300, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageFGP);
		
		JLabel lblAverageFTP = new JLabel("Average Free Throw Percentage (AFTP): ");
		lblAverageFTP.setBounds(10, 278, 300, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageFTP);
		
		JLabel lblAveragePER = new JLabel("Average Player Efficiency Rating (APER): ");
		lblAveragePER.setBounds(10, 308, 300, 14);
		frmAnalyzeTeam.getContentPane().add(lblAveragePER);
		
		JLabel lblRank = new JLabel("Rank: ");
		lblRank.setBounds(499, 68, 76, 14);
		frmAnalyzeTeam.getContentPane().add(lblRank);
		
		JLabel lblPlayerPicture = new JLabel("");
		lblPlayerPicture.setBounds(403, 110, 200, 263);
		frmAnalyzeTeam.getContentPane().add(lblPlayerPicture);
		
		JButton btnSeeTeamStats = new JButton("See Player Stats");
		btnSeeTeamStats.setForeground(Color.RED);
		btnSeeTeamStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPlayerData((String)comboBox.getSelectedItem(), lblRank, lblAveragePPG, lblAverageRPG, lblAverageAPG, lblAverageFGP, lblAverageFTP, lblAveragePER, lblPlayerPicture);
			}
		});
		btnSeeTeamStats.setBounds(252, 61, 146, 23);
		frmAnalyzeTeam.getContentPane().add(btnSeeTeamStats);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.setForeground(Color.RED);
		btnReturnToMain.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					talentEvaluatorForm tef = new talentEvaluatorForm();
					tef.main(null);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				frmAnalyzeTeam.dispose();
			}
		});
		btnReturnToMain.setBounds(614, 11, 176, 23);
		frmAnalyzeTeam.getContentPane().add(btnReturnToMain);
		

		
	}
	/*
	 * Average Points Per Game (PPG)
	 * Average Rebounds Per Game (RPG)
	 * Average Assists Per Game (APG)
	 * Average Field Goal Percentage (FGP)
	 * Average Free Throw Percentage (FTP)
	 * Average Player Efficiency Rating (PER)
	 * */
	
	private void setPlayerData(String player,JLabel lblRank, JLabel lblAveragePPG, JLabel lblAverageRPG, JLabel lblAverageAPG, JLabel lblAverageFGP, JLabel lblAverageFTP, JLabel lblAveragePER, JLabel lblPicture) {
		String playerRank = tr.getPlayerStat(player, "RANK");
		String avgPPG = tr.getPlayerStat(player, "PPG");
		String avgRPG = tr.getPlayerStat(player, "RPG");
		String avgAPG = tr.getPlayerStat(player, "APG");
		String avgFGP = tr.getPlayerStat(player, "FGP");
		String avgFTP = tr.getPlayerStat(player, "FTP");
		String avgPER = tr.getPlayerStat(player, "PER");
		
		
		lblRank.setText("Rank: "+playerRank);
		lblAveragePPG.setText("Average Points Per Game (APPG): "+avgPPG);
		lblAverageRPG.setText("Average Rebounds Per Game (ARPG): "+avgRPG);
		lblAverageAPG.setText("Average Assists Per Game (AAPG): "+avgAPG);
		lblAverageFGP.setText("Average Field Goal Percentage (AFGP): "+avgFGP);
		lblAverageFTP.setText("Average Free Throw Percentage (AFTP): "+avgFTP);
		lblAveragePER.setText("Average Player Efficiency Rating (APER): "+avgPER);
		
		playerImageSet(lblPicture,player);
	}
	
	private String[] addPlayerNames(JComboBox<String> comboBox) {
		ArrayList<String> pNames = tr.getStat("PLAYER");
		String[] names = new String[pNames.size()];
		int count = 0;
		for(String s : pNames) {
			names[count] = s;
			count++;
		}
		return names;
	}
	
	private void playerImageSet(JLabel lblPicture, String playerName) {
		Image img = new ImageIcon(this.getClass().getResource("\\Players/"+playerName+".png")).getImage();
		//Image img = new ImageIcon(this.getClass().getResource("\\Players/Anthony Davis.png")).getImage();
		Image newImage = img.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_DEFAULT);
		lblPicture.setIcon(new ImageIcon(newImage));
	}
}
