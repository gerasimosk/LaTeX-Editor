package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.LatexEditorController;

public class LatexEditorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static LatexEditorView frame;
	private static JTextArea textArea=new JTextArea();
	private static LatexEditorController controller;
	public String key;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LatexEditorView();
					frame.setVisible(true);
					frame.setTitle("LaTeX Editor");
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						    	if (JOptionPane.showConfirmDialog(frame, 
						            "Are you sure you want to close the window?", "Close Window?", 
						            JOptionPane.YES_NO_OPTION,
						            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						    		frame.dispose();
						        }
					    	}
						});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public LatexEditorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setEditable(false);
		setBounds(100, 100, 950, 600);
		Image img=new ImageIcon(this.getClass().getResource("/latex.png")).getImage();
		setIconImage(img);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		DocumentDetails doc=new DocumentDetails();
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Load");
		mntmOpen.setIcon(new ImageIcon(this.getClass().getResource("/load.png")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(){
					public void run() {
						if(!textArea.isEditable()) {
							JFileChooser file=new JFileChooser();
							file.setFileSelectionMode(JFileChooser.FILES_ONLY);
							int result=file.showOpenDialog(LatexEditorView.this);
							if(result==JFileChooser.APPROVE_OPTION) {
								controller = new LatexEditorController();
								String path=file.getSelectedFile().getAbsolutePath().toString();
								controller.enact("5",textArea,path,doc.getDetails());
								if (controller.getDocument() == null) {
									controller = null;
									JOptionPane.showMessageDialog(rootPane,"This is not a latex file");
								}else {
									textArea.setEditable(true);
									frame.setTitle(path);
								}
							}
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		
		JMenu mnCreate = new JMenu("Create");
		mnCreate.setIcon(new ImageIcon(this.getClass().getResource("/create.png")));
		mnFile.add(mnCreate);
		
		JMenuItem mntmReport = new JMenuItem("Report");
		mntmReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(!textArea.isEditable()) {
							controller=new LatexEditorController();
							key="1";
							doc.setVisible(true);
							doc.setFlag(true);
							while(doc.getflag() == true) {
								System.out.print("");
							}
							doc.setVisible(false);
							textArea.setEditable(true);
							controller.enact("1",textArea,"1",doc.getDetails());
							frame.setTitle(doc.getDetails()[0]+".tex");
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		mnCreate.add(mntmReport);
		
		JMenuItem mntmBook = new JMenuItem("Book");
		mntmBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						if(!textArea.isEditable()) {
							controller=new LatexEditorController();
							key="2";
							doc.setVisible(true);
							doc.setFlag(true);
							while(doc.getflag() == true) {
								System.out.print("");
							}
							doc.setVisible(false);
							textArea.setEditable(true);
							controller.enact("1",textArea,"2",doc.getDetails());
							frame.setTitle(doc.getDetails()[0]+".tex");
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		mnCreate.add(mntmBook);
		
		JMenuItem mntmArticle = new JMenuItem("Article");
		mntmArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(!textArea.isEditable()) {
							controller=new LatexEditorController();
							key="3";
							doc.setVisible(true);
							doc.setFlag(true);
							textArea.setEditable(true);
							while(doc.getflag() == true) {
								System.out.print("");
							}
							doc.setVisible(false);
							textArea.setEditable(true);
							controller.enact("1",textArea,"3",doc.getDetails());
							frame.setTitle(doc.getDetails()[0]+".tex");
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		mnCreate.add(mntmArticle);
		
		JMenuItem mntmLetter = new JMenuItem("Letter");
		mntmLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(!textArea.isEditable()) {
							controller=new LatexEditorController();
							key="4";
							doc.setVisible(true);
							doc.setFlag(true);
							textArea.setEditable(true);
							while(doc.getflag() == true) {
								System.out.print("");
							}
							doc.setVisible(false);
							textArea.setEditable(true);
							controller.enact("1",textArea,"4",doc.getDetails());
							frame.setTitle(doc.getDetails()[0]+".tex");
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		mnCreate.add(mntmLetter);
		
		JMenuItem mntmEmpty = new JMenuItem("Empty");
		mntmEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(!textArea.isEditable()) {
							controller=new LatexEditorController();
							key="5";
							doc.setVisible(true);
							doc.setFlag(true);
							while(doc.getflag() == true) {
								System.out.print("");
							}
							doc.setVisible(false);
							textArea.setEditable(true);
							controller.enact("1",textArea,"5",doc.getDetails());
							frame.setTitle(doc.getDetails()[0]+".tex");
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: A file is open\nClose this file to continue!");
						}
					}
				}.start();
			}
		});
		mnCreate.add(mntmEmpty);
		mnFile.add(mntmOpen);
		
		JMenuItem mntmEdit = new JMenuItem("Edit/Commit");
		mntmEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						if(controller!=null) {
							controller.enact("4",frame);
						}else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		
		JMenuItem mntmExportpdf = new JMenuItem("Export(.pdf)");
		mntmExportpdf.setIcon(new ImageIcon(this.getClass().getResource("/pdf.png")));
		mntmExportpdf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		mntmExportpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						if(controller != null) {
							JOptionPane.showMessageDialog(rootPane,"Choose PDF converter","Choose executable",
							        JOptionPane.INFORMATION_MESSAGE);
							JFileChooser filechooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter(".exe","exe");
							filechooser.setFileFilter(filter);
							int exeResult = filechooser.showOpenDialog(frame);
							File file2 = filechooser.getSelectedFile();
							if(exeResult == JFileChooser.APPROVE_OPTION) {
								String array[] = {file2.getAbsolutePath()};
								JFileChooser file = new JFileChooser();
								file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
								JOptionPane.showMessageDialog(rootPane,"Choose directory to save the PDF file","Choose directory",
								        JOptionPane.INFORMATION_MESSAGE);
								int result = file.showOpenDialog(LatexEditorView.this);
								if(result == JFileChooser.APPROVE_OPTION) {
									String path = file.getSelectedFile().getAbsolutePath().toString();
									controller.enact("10",textArea,path,array);
								}
							}
						}else {
							JOptionPane.showMessageDialog(rootPane,"Warning: No file to export","Export",
							        JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}.start();
			}
		});
		mnFile.add(mntmExportpdf);
		mntmEdit.setIcon(new ImageIcon(this.getClass().getResource("/edit.png")));
		mnFile.add(mntmEdit);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						if(controller!=null) {
							JFileChooser file=new JFileChooser();
							file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							int result=file.showSaveDialog(LatexEditorView.this);
							if(result==JFileChooser.APPROVE_OPTION) {
								String path=file.getSelectedFile().getAbsolutePath().toString();
								controller.enact("6",textArea,path,doc.getDetails());
								controller = null;
								textArea.setText(null);
								textArea.setEditable(false);
								frame.setTitle("LaTeX Editor");
							}
						}else {
							JOptionPane.showMessageDialog(rootPane,"You have no file to save!");
						}
					}
				}.start();
			}
		});
		mntmSave.setIcon(new ImageIcon(this.getClass().getResource("/save.png")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(){
					public void run() {
						if(controller!=null) {
							JFileChooser file=new JFileChooser();
							file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							int result=file.showOpenDialog(LatexEditorView.this);
							if(result==JFileChooser.APPROVE_OPTION) {
								String path=file.getSelectedFile().getAbsolutePath().toString();
								controller.enact("6",textArea,path,doc.getDetails());
							}
						}
						frame.dispose();
					}
				}.start();
			}
		});
		mntmExit.setIcon(new ImageIcon(this.getClass().getResource("/exit.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHistory = new JMenu("Version");
		mnHistory.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnHistory);
		
		JMenuItem mntmEnabled = new JMenuItem("Enabled Version");
		mntmEnabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("7",frame);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
					
				}.start();
			}
		});
		mnHistory.add(mntmEnabled);
		
		JMenuItem mntmDisable = new JMenuItem("Disable Version");
		mntmDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("8",frame);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
					
				}.start();
			}
		});
		mnHistory.add(mntmDisable);
		
		JMenuItem mntmChangeStrategy = new JMenuItem("Change Strategy");
		mntmChangeStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("9",frame);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnHistory.add(mntmChangeStrategy);
		
		JMenuItem mntmGoToPrevious = new JMenuItem("Go to Previous Version");
		mntmGoToPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("3",frame);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnHistory.add(mntmGoToPrevious);
		
		JMenu mnCommands = new JMenu("Commands");
		mnCommands.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnCommands);
		
		JMenuItem mntmAddTable = new JMenuItem("Add table");
		mntmAddTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"1",null);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddTable);
		
		JMenuItem mntmAddFingure = new JMenuItem("Add fingure");
		mntmAddFingure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"2",null);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddFingure);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		mntmAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"3",null);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddSection);
		
		JMenuItem mntmAddChapter = new JMenuItem("Add chapter");
		mntmAddChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"4",null);
						}else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddChapter);
		
		JMenuItem mntmAddSubsrction = new JMenuItem("Add subsection");
		mntmAddSubsrction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"5",null);
						}else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddSubsrction);
		
		JMenuItem mntmAddEnumerationList = new JMenuItem("Add itemize list");
		mntmAddEnumerationList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"6",null);
						}else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddEnumerationList);
		
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		mntmAddSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"7",null);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddSubsubsection);
		
		JMenuItem mntmAddEnumarateList = new JMenuItem("Add enumarate list");
		mntmAddEnumarateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(controller!=null) {
							controller.enact("2",textArea,"8",null);
						}
						else {
							JOptionPane.showMessageDialog(rootPane,"You have to open a file first");
						}
					}
				}.start();
			}
		});
		mnCommands.add(mntmAddEnumarateList);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnAbout);
		
		JMenuItem mntmInformation = new JMenuItem("Information");
		mntmInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "This is a LaTeX editor that provides useful tools and friendly user interface to help get used to manipulate\n"
						+ "a LaTeX project for all knowledge level of users!\n"
						+ "\n Here are some tools provided by the editor:\n"
						+ "1) Create 4 different emplates of latex\n"
						+ "2) Loading an existing LaTeX document from disk\n"
						+ "3) Export LaTeX document to PDF\n"
						+ "4) Keep versions of the document to disk or RAM\n"
						+ "5) Save the LaTeX document\n"
						+ "6) Add commands to the document\n";
				JOptionPane.showMessageDialog(rootPane,message,"Information",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAbout.add(mntmInformation);
		
		JMenuItem mntmCopyrights = new JMenuItem("Copyrights");
		mntmCopyrights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "This is a project for Software Engineering lesson               \n"
						+ "Department of Computer Science & Engineering\n"
						+ "University of Ioannina, 2019\n\n"
						+ "Created by:\n"
						+ "Vasilis Vouronikos, AM: 3152\n"
						+ "Gerasimos Kassaras, AM: 2993\n"
						+ "Konstantinos Chanioglou, AM: 3104\n";
				JOptionPane.showMessageDialog(rootPane,message,"Copyrights",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmCopyrights.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnAbout.add(mntmCopyrights);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 
		textArea.setBounds(0, 0, 932, 524);
		contentPane.add(textArea,BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane);
	}
	public String getKey() {
		return key;
	}
	public JTextArea gettext() {
		return textArea;
		
	}
	public JPanel getPane() {
		return contentPane;
		
	}
}