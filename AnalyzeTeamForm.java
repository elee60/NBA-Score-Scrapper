import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnalyzeTeamForm {

	private JFrame frame;
	private TextReader tr;
	private TeamEvaluator te;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyzeTeamForm window = new AnalyzeTeamForm();
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
	public AnalyzeTeamForm() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tr = new TextReader();
		te = new TeamEvaluator();
		
		JLabel lblTeamAnalyzer = new JLabel("Team Analyzer");
		lblTeamAnalyzer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamAnalyzer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblTeamAnalyzer.setBounds(10, 11, 596, 70);
		frame.getContentPane().add(lblTeamAnalyzer);
		
		JComboBox comboBoxTeamName = new JComboBox();
		comboBoxTeamName.setModel(new DefaultComboBoxModel(addTeamNames(comboBoxTeamName)));
		comboBoxTeamName.setBounds(10, 92, 209, 20);
		frame.getContentPane().add(comboBoxTeamName);
		
		JTextArea txtrTeamPlayers = new JTextArea();
		txtrTeamPlayers.setText("");
		txtrTeamPlayers.setEditable(false);
		txtrTeamPlayers.setBounds(10, 140, 596, 154);
		frame.getContentPane().add(txtrTeamPlayers);
		
		JButton btnNewButton = new JButton("Analyze Team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeTeamPlayerRanks((String)comboBoxTeamName.getSelectedItem(),txtrTeamPlayers);
			}
		});
		btnNewButton.setBounds(233, 91, 161, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					talentEvaluatorForm tef = new talentEvaluatorForm();
					tef.main(null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnReturnToMain.setBounds(405, 92, 161, 23);
		frame.getContentPane().add(btnReturnToMain);
		
		
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
	
	private void seeTeamPlayerRanks(String teamName, JTextArea text) {
		text.setText("");
		ArrayList<String> team = te.evaluate(teamName);
		//String tn = (String)teamName;
		for(String s : team) {
			text.append(s+"\n");
		}
	}
}
