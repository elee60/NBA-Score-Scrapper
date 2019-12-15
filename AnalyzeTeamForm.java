import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnalyzeTeamForm {

	private JFrame frame;
	//private TextReader tr;
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
	 * @throws IOException 
	 */
	public AnalyzeTeamForm() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//tr = new TextReader();
		te = new TeamEvaluator();
		
		JLabel lblTeamAnalyzer = new JLabel("Team Analyzer");
		lblTeamAnalyzer.setForeground(Color.BLUE);
		lblTeamAnalyzer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamAnalyzer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblTeamAnalyzer.setBounds(10, 11, 596, 70);
		frame.getContentPane().add(lblTeamAnalyzer);
		
		JComboBox<String> comboBoxTeamName = new JComboBox<String>();
		comboBoxTeamName.setModel(new DefaultComboBoxModel<String>(addTeamNames(comboBoxTeamName)));
		comboBoxTeamName.setBounds(20, 68, 554, 20);
		frame.getContentPane().add(comboBoxTeamName);
		
		JLabel label = new JLabel("");
		label.setBounds(450, 0, 143, 142);
		
		//label.setComponentZOrder(null, 0);
		//txtrTeamPlayers.add(label);
		//txtrTeamPlayers.setComponentZOrder(label, 0);
		//frame.getContentPane().add(label);
		
		JTextArea txtrTeamPlayers = new JTextArea();
		txtrTeamPlayers.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtrTeamPlayers.setForeground(Color.BLACK);
		txtrTeamPlayers.setBackground(Color.WHITE);
		txtrTeamPlayers.setText("");
		txtrTeamPlayers.setEditable(false);
		txtrTeamPlayers.setBounds(10, 140, 596, 154);
		txtrTeamPlayers.add(label);
		frame.getContentPane().add(txtrTeamPlayers);
		

		
		JButton btnNewButton = new JButton("Analyze Team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeTeamPlayerRanks((String)comboBoxTeamName.getSelectedItem(),txtrTeamPlayers,label);
				//setTeamLogo(label);
			}
		});
		btnNewButton.setBounds(20, 89, 292, 23);
		btnNewButton.setForeground(Color.RED);
		//btnNewButton.setBackground(Color.GRAY);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.setForeground(Color.RED);
		btnReturnToMain.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
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
		btnReturnToMain.setBounds(313, 89, 261, 23);
		frame.getContentPane().add(btnReturnToMain);
		

		
		
	}
	
	private String[] addTeamNames(JComboBox<String> comboBox) throws IOException {
		Scanner scan = new Scanner(new FileReader("src/NBATeamNames.txt"));
		ArrayList<String> tNames = new ArrayList<String>();
		while(scan.hasNextLine()) {
			String teamName = scan.nextLine();
			if(!tNames.contains(teamName))
			{
				tNames.add(teamName);
			}
		}
		String[] names = new String[tNames.size()];
		int count = 0;
		for(String o : tNames) {
			names[count] = o;
			count++;
		}
		scan.close();
		return names;
	}
	
	private void seeTeamPlayerRanks(String teamName, JTextArea text,JLabel label) {
		text.setText("");
		ArrayList<String> team = te.evaluate(teamName);
		for(String s : team) {
			text.append(s+"\n");
		}
		setTeamLogo(label, teamName);
	}
	private void setTeamLogo(JLabel lblLogo, String teamName) {
		Image img = new ImageIcon(this.getClass().getResource("\\Teams/"+teamName+".png")).getImage();
		Image newImage = img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT);
		lblLogo.setIcon(new ImageIcon(newImage));
	}
	
}