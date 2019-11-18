
// AUTHOR: LOGAN FRANCE

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class analyzeTeamForm {

	private JFrame frmAnalyzeTeam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					analyzeTeamForm window = new analyzeTeamForm();
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
	public analyzeTeamForm() throws FileNotFoundException {
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
		
		JLabel lblNewLabel = new JLabel("Team Analyzer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 11, 780, 50);
		frmAnalyzeTeam.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NBA Team 1", "NBA Team 2", "NBA Team 3", "NBA Team 4", "NBA Team 5"}));
		comboBox.setSize(new Dimension(180, 20));
		comboBox.setEditable(true);
		comboBox.setName("comboBoxNBATeams1");
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(69, 103, 170, 20);
		frmAnalyzeTeam.getContentPane().add(comboBox);
		
		JLabel lblAveragePPG = new JLabel("Average Points Per Game (APPG): ");
		lblAveragePPG.setBounds(69, 165, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAveragePPG);
		
		JLabel lblAverageRPG = new JLabel("Average Rebounds Per Game (ARPG): ");
		lblAverageRPG.setBounds(69, 223, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageRPG);
		
		JLabel lblAverageAPG = new JLabel("Average Assists Per Game (APPG): ");
		lblAverageAPG.setBounds(69, 283, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageAPG);
		
		JLabel lblAverageFGP = new JLabel("Average Field Goal Percentage (AFGP): ");
		lblAverageFGP.setBounds(490, 165, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageFGP);
		
		JLabel lblAverageFTP = new JLabel("Average Free Throw Percentage (AFTP): ");
		lblAverageFTP.setBounds(490, 223, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAverageFTP);
		
		JLabel lblAveragePER = new JLabel("Average Player Efficiency Rating (APER): ");
		lblAveragePER.setBounds(490, 283, 263, 14);
		frmAnalyzeTeam.getContentPane().add(lblAveragePER);
		
		JButton btnSeeTeamStats = new JButton("See Team Stats");
		btnSeeTeamStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamData((String)comboBox.getSelectedItem(), lblAveragePPG, lblAverageRPG, lblAverageAPG, lblAverageFGP, lblAverageFTP, lblAveragePER);
			}
		});
		btnSeeTeamStats.setBounds(298, 102, 125, 23);
		frmAnalyzeTeam.getContentPane().add(btnSeeTeamStats);
		
	}
	/*
	 * Average Points Per Game (PPG)
	 * Average Rebounds Per Game (RPG)
	 * Average Assists Per Game (APG)
	 * Average Field Goal Percentage (FGP)
	 * Average Free Throw Percentage (FTP)
	 * Average Player Efficiency Rating (PER)
	 * */
	
	private void setTeamData(String str, JLabel lblAveragePPG, JLabel lblAverageRPG, JLabel lblAverageAPG, JLabel lblAverageFGP, JLabel lblAverageFTP, JLabel lblAveragePER) {
		double avgPPG = 0;
		double avgRPG = 0;
		double avgAPG = 0;
		double avgFGP = 0;
		double avgFTP = 0;
		double avgPER = 0;
		
		lblAveragePPG.setText(lblAveragePPG.getText().substring(0, lblAveragePPG.getText().indexOf(":")+1));
		lblAverageRPG.setText(lblAverageRPG.getText().substring(0, lblAverageRPG.getText().indexOf(":")+1));
		lblAverageAPG.setText(lblAverageAPG.getText().substring(0, lblAverageAPG.getText().indexOf(":")+1));
		lblAverageFGP.setText(lblAverageFGP.getText().substring(0, lblAverageFGP.getText().indexOf(":")+1));
		lblAverageFTP.setText(lblAverageFTP.getText().substring(0, lblAverageFTP.getText().indexOf(":")+1));
		lblAveragePER.setText(lblAveragePER.getText().substring(0, lblAveragePER.getText().indexOf(":")+1));
		
		switch(str) {
		case "NBA Team 1":
			avgPPG = 18.8;
			avgRPG = 8.3;
			avgAPG = 4.1;
			avgFGP = 52.1;
			avgFTP = 74.2;
			avgPER = 21.9;
			break;
		case "NBA Team 2":
			avgPPG = 17.7;
			avgRPG = 6.3;
			avgAPG = 2.4;
			avgFGP = 49.5;
			avgFTP = 84.8;
			avgPER = 22.6;
			break;
		case "NBA Team 3":
			avgPPG = 27.2;
			avgRPG = 7.4;
			avgAPG = 7.2;
			avgFGP = 50.4;
			avgFTP = 73.6;
			avgPER = 27.6;
			break;
		case "NBA Team 4":
			avgPPG = 23.5;
			avgRPG = 4.5;
			avgAPG = 6.6;
			avgFGP = 47.7;
			avgFTP = 90.5;
			avgPER = 23.8;
			break;
		case "NBA Team 5":
			avgPPG = 24.5;//24.5	5.2	6.2	44.2%	85.8%	24.5
			avgRPG = 5.2;
			avgAPG = 6.2;
			avgFGP = 44.2;
			avgFTP = 85.8;
			avgPER = 24.5;
			break;
		}
		
		lblAveragePPG.setText(lblAveragePPG.getText()+avgPPG);
		lblAverageRPG.setText(lblAverageRPG.getText()+avgRPG);
		lblAverageAPG.setText(lblAverageAPG.getText()+avgAPG);
		lblAverageFGP.setText(lblAverageFGP.getText()+avgFGP+"%");
		lblAverageFTP.setText(lblAverageFTP.getText()+avgFTP+"%");
		lblAveragePER.setText(lblAveragePER.getText()+avgPER);
	}
	
	private void addTeamNames(JComboBox comboBox) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/NBATeamNames.txt"));
		int count = 1;
		Object item;
		scan.nextLine();
		while(scan.hasNextLine()) {
			item = scan.nextLine();
			for(int i = 0;i<comboBox.getItemCount();i++) {
				//System.out.println(comboBox.getModel());
				if(item==comboBox.getItemAt(i)) {
					break;
				}
				else {
					comboBox.addItem(item);
					break;
				}
				
			}

			count++;
		}
		scan.close();
	}
}






