import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class CompareTeamForm {

	private JFrame frame;
	//private TextReader tr;
	private TeamComparator tc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompareTeamForm window = new CompareTeamForm();
					window.frame.setVisible(true);
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
	public CompareTeamForm() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//tr = new TextReader();
		tc = new TeamComparator();
		
		JLabel lblTeamComparator = new JLabel("Team Comparator");
		lblTeamComparator.setForeground(Color.BLUE);
		lblTeamComparator.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblTeamComparator.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamComparator.setBounds(10, 11, 671, 60);
		frame.getContentPane().add(lblTeamComparator);
		
		JComboBox<String> comboBoxTeam1 = new JComboBox<String>();
		comboBoxTeam1.setModel(new DefaultComboBoxModel<String>(addTeamNames(comboBoxTeam1)));
		comboBoxTeam1.setBounds(113, 99, 170, 20);
		frame.getContentPane().add(comboBoxTeam1);
		
		JComboBox<String> comboBoxTeam2 = new JComboBox<String>();
		comboBoxTeam2.setModel(new DefaultComboBoxModel<String>(addTeamNames(comboBoxTeam2)));
		comboBoxTeam2.setBounds(113, 147, 170, 20);
		frame.getContentPane().add(comboBoxTeam2);
		
		JTextArea txtrTheWinningTeam = new JTextArea();
		txtrTheWinningTeam.setEditable(false);
		txtrTheWinningTeam.setText("");
		txtrTheWinningTeam.setBounds(10, 195, 671, 196);
		frame.getContentPane().add(txtrTheWinningTeam);
		
		JButton btnCompareTeams = new JButton("Compare Teams");
		btnCompareTeams.setForeground(Color.RED);
		btnCompareTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compareTeams(txtrTheWinningTeam, (String)comboBoxTeam1.getSelectedItem(),(String)comboBoxTeam2.getSelectedItem());
			}
		});
		btnCompareTeams.setBounds(325, 92, 170, 23);
		frame.getContentPane().add(btnCompareTeams);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.setForeground(Color.RED);
		btnReturnToMain.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					talentEvaluatorForm tef = new talentEvaluatorForm();
					tef.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnReturnToMain.setBounds(505, 92, 170, 23);
		frame.getContentPane().add(btnReturnToMain);
		
		JLabel lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(30, 93, 115, 33);
		frame.getContentPane().add(lblHomeTeam);
		
		JLabel lblAwayTeam = new JLabel("Away Team");
		lblAwayTeam.setBounds(30, 141, 115, 33);
		frame.getContentPane().add(lblAwayTeam);
		

	}
	
	
	private void compareTeams(JTextArea text, String team1, String team2) {
		if(!text.isVisible())
			text.setVisible(true);
		if(team1.equals(team2))
		{
			text.setText("These are the same team!");
			return;
		}
		text.setText(tc.compare(team1, team2));
		
	}
	
	private String[] addTeamNames(JComboBox<String> comboBox) throws IOException {
		Scanner scan = new Scanner(new FileReader("src/NBATeamNames.txt"));
		FileWriter fw = new FileWriter(new File("src/NBATeamNames2.txt"));
		ArrayList<String> tNames = new ArrayList<String>();
		while(scan.hasNextLine()) {
			String teamName = scan.nextLine();
			if(!tNames.contains(teamName))
			{
				tNames.add(teamName);
				fw.write(teamName+"\n");
			}
		}
		String[] names = new String[tNames.size()];
		int count = 0;
		for(String s : tNames) {
			names[count] = s;
			count++;
		}
		scan.close();
		fw.close();
		return names;
	}
}