package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocumentDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String title;
	private String date;
	private String author;
	private String copyright;
	private JTextField Title;
	private boolean flag;
	private String details[] = new String[4];
	private JTextField Author;
	private JTextField Copyright;
	private JTextField Date;
	private JLabel lblGiveCopyright;
	private JLabel lblGiveDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentDetails frame = new DocumentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DocumentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFileName = new JLabel("Give the title of the file:");
		lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFileName.setBounds(48, 25, 180, 16);
		contentPane.add(lblFileName);
		
		Title = new JTextField();
		Title.setBounds(259, 24, 116, 22);
		contentPane.add(Title);
		Title.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						title=Title.getText();
						author=Author.getText();
						date=Date.getText();
						copyright=Copyright.getText();

						if(Title.getText().equals("")|| Author.getText().equals("") || Copyright.getText().equals("") || Date.getText().equals("")) {
							JOptionPane.showMessageDialog(rootPane,"One or more fields are empty\nPlease fill the empty fields");
						}else {
							details[0] = title;
							details[1] = author;
							details[2] = date;
							details[3] = copyright;
							flag = false;
							Date.setText(null);
							Author.setText(null);
							Copyright.setText(null);
							Title.setText(null);
						}
					}
				}.start();
			}
		});
		btnCreate.setBounds(278, 194, 97, 25);
		contentPane.add(btnCreate);
		
		JLabel lblNewLabel = new JLabel("Give the author:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 66, 160, 16);
		contentPane.add(lblNewLabel);
		
		Author = new JTextField();
		Author.setBounds(259, 65, 116, 22);
		contentPane.add(Author);
		Author.setColumns(10);
		
		Copyright = new JTextField();
		Copyright.setBounds(259, 104, 116, 22);
		contentPane.add(Copyright);
		Copyright.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(259, 145, 116, 22);
		contentPane.add(Date);
		Date.setColumns(10);
		
		lblGiveCopyright = new JLabel("Give copyright:");
		lblGiveCopyright.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGiveCopyright.setBounds(48, 107, 160, 16);
		contentPane.add(lblGiveCopyright);
		
		lblGiveDate = new JLabel("Give date:");
		lblGiveDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGiveDate.setBounds(48, 146, 160, 16);
		contentPane.add(lblGiveDate);
	}
	public String[] getDetails() {
		return details;
	}
	public boolean getflag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
