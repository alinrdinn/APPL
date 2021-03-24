// **********************
// PrimePanel.java

// Represents the panel for a program that displays all primes
// up to a number input by the user.
// **********************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PrimePanel extends JPanel {
	private JTextField number;
	private JButton computeButton;
	private JTextArea primeList;
	private JScrollPane scroll_pane;

	// Sets up a panel with a heading, a labeled text field for the user to enter an integer,
	// a button to trigger the calculation, and a text area to display the list of primes.
	public PrimePanel() {
		JLabel heading = new JLabel("Prime Number Listing");
		heading.setFont(new Font("Helvetica", Font.BOLD, 30));
		JLabel inputLabel = new JLabel("Enter a number: ");
		number = new JTextField(8);
		computeButton = new JButton("Click to see all primes up to your number!");
		primeList = new JTextArea(10, 30);
		computeButton.addActionListener(new ButtonListener());
		scroll_pane = new JScrollPane(primeList);
		scroll_pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// Add the components to the panel
		add(heading);
		add(inputLabel);
		add(number);
		add(computeButton);
		add(scroll_pane);
		setPreferredSize(new Dimension(400, 320));
		setBackground(Color.yellow);
	}
		// Represents a listener for the click of the button.
	private class ButtonListener implements ActionListener {

		// Generates and displays a list of primes when the button is clicked.
		public void actionPerformed(ActionEvent event) {
			String textNum;
			int num;
			try {
				textNum = number.getText();
				num = Integer.parseInt(textNum);
			} catch (Exception e){
				primeList.setText("The input is not an integer");
				return;
			}
			String ans = "";
				int count = 0;
			if (num<2)
				ans = "There no primes less than " + num;
			else {
				ans = " " + 2;
				count++;
				for (int i = 3; i<= num; i += 2) {
					boolean foundDivisor = false;
					int j = 3;
					while (j< (i/2)+1 && !foundDivisor) {
						if (i % j == 0) foundDivisor = true;
						else
							j++;
						}
						// Add i to the list if it is prime if (j == i)
						{
							ans += " " + i;
							count++;
							if (count % 10 == 0) ans += "\n";
						}
					}
			}
			primeList.setText(ans);
		}
	}
}
