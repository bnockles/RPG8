package project.save;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SubmitButton extends JButton {

	private static final long serialVersionUID = 1L;

	public SubmitButton() {
		// TODO Auto-generated constructor stub
	}

	public SubmitButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public SubmitButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public SubmitButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public SubmitButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public SubmitButton(final String text, final JLabel jl, final JTextField jt, final Hashtable t) {
		super(text);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jl.setText(String.format("%s: %s", text.substring(4), jt.getText()));
				t.put(text.substring(4), jt.getText());
				jt.setText(null);
			}
		});
	}

}
