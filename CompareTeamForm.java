import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class CompareTeamForm {

	private JFrame frame;

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
	 */
	public CompareTeamForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeamComparator = new JLabel("Team Comparator");
		lblTeamComparator.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
		lblTeamComparator.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamComparator.setBounds(10, 11, 671, 60);
		frame.getContentPane().add(lblTeamComparator);
		
		JComboBox comboBoxTeam1 = new JComboBox();
		comboBoxTeam1.setBounds(106, 93, 170, 20);
		frame.getContentPane().add(comboBoxTeam1);
		
		JComboBox comboBoxTeam2 = new JComboBox();
		comboBoxTeam2.setBounds(106, 156, 170, 20);
		frame.getContentPane().add(comboBoxTeam2);
		
		JLabel lblTheWinningTeam = new JLabel("The winning team is");
		lblTheWinningTeam.setVerticalAlignment(SwingConstants.TOP);
		lblTheWinningTeam.setVisible(false);
		lblTheWinningTeam.setBounds(10, 249, 671, 142);
		frame.getContentPane().add(lblTheWinningTeam);
	}
	
	
	private void compareTeam() {
		
	}
}
