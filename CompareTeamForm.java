import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CompareTeamForm {

	private JFrame frame;
	private TextReader tr;
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
	 * @throws FileNotFoundException 
	 */
	public CompareTeamForm() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tr = new TextReader();
		tc = new TeamComparator();
		
		JLabel lblTeamComparator = new JLabel("Team Comparator");
		lblTeamComparator.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblTeamComparator.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamComparator.setBounds(10, 11, 671, 60);
		frame.getContentPane().add(lblTeamComparator);
		
		JComboBox comboBoxTeam1 = new JComboBox();
		comboBoxTeam1.setModel(new DefaultComboBoxModel(addTeamNames(comboBoxTeam1)));
		comboBoxTeam1.setBounds(50, 93, 170, 20);
		frame.getContentPane().add(comboBoxTeam1);
		
		JComboBox comboBoxTeam2 = new JComboBox();
		comboBoxTeam2.setModel(new DefaultComboBoxModel(addTeamNames(comboBoxTeam2)));
		comboBoxTeam2.setBounds(50, 156, 170, 20);
		frame.getContentPane().add(comboBoxTeam2);
		
		JTextArea txtrTheWinningTeam = new JTextArea();
		txtrTheWinningTeam.setEditable(false);
		txtrTheWinningTeam.setText("");
		txtrTheWinningTeam.setBounds(10, 195, 671, 196);
		frame.getContentPane().add(txtrTheWinningTeam);
		
		JButton btnCompareTeams = new JButton("Compare Teams");
		btnCompareTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compareTeams(txtrTheWinningTeam, (String)comboBoxTeam1.getSelectedItem(),(String)comboBoxTeam2.getSelectedItem());
			}
		});
		btnCompareTeams.setBounds(271, 92, 170, 23);
		frame.getContentPane().add(btnCompareTeams);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
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
		btnReturnToMain.setBounds(472, 92, 170, 23);
		frame.getContentPane().add(btnReturnToMain);
		

	}
	
	
	private void compareTeams(JTextArea text, String team1, String team2) {
		if(!text.isVisible())
			text.setVisible(true);
		if(team1.equals(team2))
		{
			text.setText("These are the same team!");
			return;
		}
		//text.setText("");
		text.setText(tc.compare(team1, team2));
		
	}
	
	private Object[] addTeamNames(JComboBox comboBox) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileReader("src/NBATeamNames.txt"));
		
		ArrayList tNames = new ArrayList();
		while(scan.hasNextLine()) {
			Object teamName = scan.nextLine();
			if(!tNames.contains(teamName))
				tNames.add(teamName);
		}
		Object[] names = new Object[tNames.size()];
		int count = 0;
		for(Object o : tNames) {
			names[count] = o;
			count++;
		}
		return names;
	}
}
