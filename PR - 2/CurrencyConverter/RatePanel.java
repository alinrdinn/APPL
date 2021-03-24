// **********************
// RatePanel.java

// Panel for a program that converts different currencies to
// U.S. Dollars
// **********************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel {
	private double[] rate; // exchange rates private
	String[] currencyName;
	private JLabel result;
	private JComboBox combo_box;
	private JTextField cost_item;

	// Sets up a panel to convert cost from one of 6 currencies into U.S.Dollars.The panel contains a heading, a text field
	// for the cost of the item, a combo box for selecting // the currency, and a label to display the result.
	public RatePanel() {
			JLabel title = new JLabel("<HTML>How much is that in dollars?<BR></HTML>");
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			title.setFont(new Font("Helvetica", Font.BOLD, 20));
			cost_item = new JTextField("100");

			// Set up the arrays for the currency conversions currencyName
			currencyName = new String[] {
				"Select the currency..", "European Euro",
				"Canadian Dollar", "Japanese Yen", "Australian Dollar",
				"Indian Rupee", "Mexican Peso"
			};
			result = new JLabel(" ------------ ");
			combo_box = new JComboBox(currencyName);
			rate = new double[] {
				0.0,
				1.2103, 0.7351,
				0.0091, 0.6969,
				0.0222, 0.0880
			};

			add(cost_item);
			add(combo_box);
			combo_box.addActionListener(new ComboListener());
			add(title);
			add(result);
		}

		// Represents an action listener for the combo box.
		private class ComboListener implements ActionListener {

			// Determines which currency has been selected and the value in that currency then computes and displays the
			// value in U.S.Dollars.
			public void actionPerformed(ActionEvent event) {
				int icost_item = Integer.parseInt(cost_item.getText());
				int index = combo_box.getSelectedIndex();
				result.setText(" "+ cost_item.getText() + " " + currencyName[index] + " = " +
					String.format("%.4f" ,(rate[index]*icost_item)) + " U.S. Dollars");
			}
		}
}