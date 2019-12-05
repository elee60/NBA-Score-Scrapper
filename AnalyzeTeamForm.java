import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
	 */
	public AnalyzeTeamForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 420);
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
		comboBoxTeamName.setModel(new DefaultComboBoxModel(addPlayerNames(comboBoxTeamName)));
		comboBoxTeamName.setBounds(20, 92, 175, 20);
		frame.getContentPane().add(comboBoxTeamName);
	}
	
	
	
	private Object[] addPlayerNames(JComboBox comboBox) {
		ArrayList pNames = tr.getStat("PLAYER");
		Object[] names = new Object[pNames.size()];
		int count = 0;
		for(Object o : pNames) {
			names[count] = o;
			count++;
		}
		return names;
	}
}
