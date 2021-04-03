package projet_index_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class AppWindows implements ActionListener{

	private JFrame frmRechercheindexe;
	private JButton btnNewButton_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindows window = new AppWindows();
					window.frmRechercheindexe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechercheindexe = new JFrame();
		frmRechercheindexe.setLocationByPlatform(true);
		frmRechercheindexe.setMinimumSize(new Dimension(600, 300));
		frmRechercheindexe.setMaximumSize(new Dimension(600, 300));
		frmRechercheindexe.setResizable(false);
		frmRechercheindexe.setPreferredSize(new Dimension(600, 250));
		frmRechercheindexe.setVisible(true);
		frmRechercheindexe.setTitle("Recherche-Index\u00E9e");
		frmRechercheindexe.setSize(new Dimension(600, 250));
		frmRechercheindexe.getContentPane().setMaximumSize(new Dimension(600, 300));
		frmRechercheindexe.getContentPane().setMinimumSize(new Dimension(600, 300));
		frmRechercheindexe.getContentPane().setPreferredSize(new Dimension(600, 300));
		frmRechercheindexe.getContentPane().setSize(new Dimension(600, 300));
		frmRechercheindexe.setBounds(100, 100, 787, 721);
		frmRechercheindexe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechercheindexe.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 155, 413, 462);
		frmRechercheindexe.getContentPane().add(list);
		frmRechercheindexe.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton_1}));
		
		/*****/
		/*****/
		//Lister tout les document.txt existants dans un dossier donné:
		File myfolder = new File("C:\\Users\\Hewlett Packard\\Desktop\\textes");
		String fileExt = "";
        list.removeAll();
        String myfiles = null;
	    File[] MylistOfFiles = myfolder.listFiles();
	    HashMap<String, Integer> documents = new HashMap<String,Integer>();
	        // 'MylistOfFiles' stores all files' list on array
	        DefaultListModel MyJlistModel = new DefaultListModel();
	        for (int i = 0; i < MylistOfFiles.length; i++) {
	            //Loop 'MylistOfFiles' to get the files in jlist
	            if (MylistOfFiles[i].isFile()) {
					fileExt = MylistOfFiles[i].getName().substring(MylistOfFiles[i].getName().lastIndexOf(".")+1); 
					if(fileExt.equalsIgnoreCase("txt")) {
		                myfiles = MylistOfFiles[i].getName();
		                documents.put(MylistOfFiles[i].getName(),(int) MylistOfFiles[i].length());
		                MyJlistModel.addElement(myfiles);
					}
	            }
	        }
	        list.setModel(MyJlistModel);
	    /******/
	    /******/
	        
	    // Ajout de fichier dans le dossier textes   
		btnNewButton_1 = new JButton("Ajouter un docs +");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBounds(595, 54, 153, 35);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Enregistrement de documents");
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					File dest = new File("C:\\Users\\Hewlett Packard\\Desktop\\textes",file.getName());
					try {
						FileOutputStream fileOutPutStream = new FileOutputStream(dest);
						fileOutPutStream.flush();
						fileOutPutStream.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}});
		frmRechercheindexe.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Collection de documents");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 122, 233, 27);
		frmRechercheindexe.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(447, 155, 315, 153);
		frmRechercheindexe.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(447, 374, 315, 242);
		frmRechercheindexe.getContentPane().add(table_1);
		
		JLabel lblIdtailsSurLe = new JLabel("D\u00E9tails sur le document");
		lblIdtailsSurLe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblIdtailsSurLe.setBounds(447, 343, 233, 27);
		frmRechercheindexe.getContentPane().add(lblIdtailsSurLe);
		
		JLabel lblDtailsSurLa = new JLabel("D\u00E9tails sur la collection");
		lblDtailsSurLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblDtailsSurLa.setBounds(447, 122, 233, 27);
		frmRechercheindexe.getContentPane().add(lblDtailsSurLa);
		
		JButton btnNewButton_1_1 = new JButton("Lancer le Traitement");
		btnNewButton_1_1.setToolTipText("");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(235, 632, 171, 35);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Traitement_indexation frame= new Traitement_indexation();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	
		frmRechercheindexe.getContentPane().add(btnNewButton_1_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Recherche et indexation");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_1.setBounds(286, 10, 221, 50);
		frmRechercheindexe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("total :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(350, 127, 48, 17);
		frmRechercheindexe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(398, 125, 25, 23);
        // "MyFiles_Lst.getModel().getSize()" - indicate the total number of files in jList
		lblNewLabel_3.setText(String.valueOf(list.getModel().getSize()));
		frmRechercheindexe.getContentPane().add(lblNewLabel_3);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
