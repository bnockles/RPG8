package project.save;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	public Hashtable t = doLoad();

	private JPanel jp = new JPanel();
	private JLabel jl = new JLabel();
	private JTextField jt = new JTextField(16);
	private JButton charLevel = new SubmitButton("Set charLevel", jl, jt, t);
	private JButton charHealth = new SubmitButton("Set charHealth", jl, jt, t);
	private JButton charPosX = new SubmitButton("Set charPosX", jl, jt, t);
	private JButton charPosY = new SubmitButton("Set charPosY", jl, jt, t);

	private JButton saveButton = new JButton("Save");
	private JButton loadButton = new JButton("Load");
	private JButton resetButton = new JButton("Reset");

	public SaveScreen() {
		setTitle("Save Game Demo");
		setVisible(true);
		setSize(320, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jp.add(jt);
		jp.add(jl);
		jp.add(charLevel);
		jp.add(charHealth);
		jp.add(charPosX);
		jp.add(charPosY);
		jp.add(saveButton);
		jp.add(loadButton);
		jp.add(resetButton);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});

		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLoad();
				printAll(t);
			}
		});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDefaultSave();
			}
		});

		add(jp);
	}

	private void doSave() {
		System.out.println("Saving...\n");

		try {
			// Creating File/Object output stream
			FileOutputStream fileOut = new FileOutputStream("RPG8.save");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			// Writing Hashtable Object
			out.writeObject(t);

			// Closing all output streams
			out.close();
			fileOut.close();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Hashtable doLoad() {
		System.out.println("Loading...\n");
		
		Hashtable h = new Hashtable();
		
		try {
			// Creating File/Object input stream
			FileInputStream fileIn = new FileInputStream("RPG8.save");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Loading Hashtable Object
			h = (Hashtable)in.readObject();

			// Closing all input streams
			in.close();
			fileIn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) {
			System.out.println("No File.");
			System.out.println("Creating default save file.");
			t = new Hashtable();
			doDefaultSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return h;
	}

	private void doDefaultSave() {		
		t.put("charHealth", 100);
		t.put("charPosX", 400);
		t.put("charPosY", 400);
		t.put("charName", "B.J. Blazkowicz");
		t.put("testDouble", Math.PI);
		
		doSave();
		printAll(t);
	}
	private void printAll(Hashtable h) {
		System.out.println("Printing all loaded elements...\n");
		for (Enumeration e = h.keys(); e.hasMoreElements(); ) {
			Object obj = e.nextElement();
			System.out.printf("%s = %s\n", obj, h.get(obj));
		}

		System.out.println("\nTesting null values: charLevel is " + h.get("charLevel"));
	}

	public String getStringData(String key) {
		return (String)t.get(key);
	}

	public int getIntData(String key) {
		try {
			return (int)t.get(key);
		} catch (ClassCastException e) {
			return Integer.parseInt((String)t.get(key));
		} catch (NullPointerException e) {
			return Integer.MIN_VALUE;
		}
	}

	public double getDoubleData(String key) {
		try {
			return (double)t.get(key);
		} catch (ClassCastException e) {
			return Double.parseDouble((String)t.get(key));
		} catch (NullPointerException e) {
			return Double.MIN_VALUE;
		}
	}
}
