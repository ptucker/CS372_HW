/*
FEEDBACK

Read from the file correctly: 20/20%
Implement class hierarchy correctly: 20/20%
Populate appropriate data structures with shape data: 15/15%
Show list of shapes correctly: 15/15%
Show specific shape properties correctly: 15/15%
Well-structured, well-commented code: 13/15%


Comments:
  separate the FileReading code into a separate class.
  fails to select first shape (line 160 should check getSelectedIndex() >= 0)
*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ShapesApp {

	private JFrame frame;
	String curdir = System.getProperty("user.dir");
	JTextPane ShapeDetails;
	JLabel ShapeIcon;
	JList shapeListPanel;
	JButton DisplayInfoButton;
	private Vector<Shape> shapes = new Vector<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapesApp window = new ShapesApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Color stringToColor(String s) {	//converts string to java.awt color
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(s);
		    color = (Color)field.get(null);
		} catch (Exception e) {
		    color = null;
		}
		return color;
	}
	
	/**
	 * Create the application.
	 */
	public ShapesApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Panel containing the default shape icon and shape's details
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(160, 0, 424, 411);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		//label containing the icon to be displayed after a shape is clicked on
		ShapeIcon = new JLabel("");
		ShapeIcon.setIcon(new ImageIcon(curdir + "\\default.png"));
		ShapeIcon.setBackground(Color.WHITE);
		ShapeIcon.setBounds(124, 11, 260, 165);
		ShapeIcon.setOpaque(true);
		infoPanel.add(ShapeIcon);
		
		//text area containing the description to be displayed after a shape is clicked on
		ShapeDetails = new JTextPane();
		ShapeDetails.setText("No text yet. Click on a shape in the list to view its details here!");
		ShapeDetails.setBounds(40, 224, 344, 165);
		infoPanel.add(ShapeDetails);
		
		String splitBy = " ";	//information segmented by spaces
		System.out.print(curdir);
		
        File cd =  new File(curdir);
        File[] files = cd.listFiles();
        
        for (File f: files) {
        	
            if (f.getName().endsWith(".txt")) {		//we want text files only
            	
                try (FileInputStream is = new FileInputStream(f)) {
                	
                    InputStreamReader ir = new InputStreamReader(is);
                    BufferedReader rdr = new BufferedReader(ir);
                    String line = rdr.readLine();
                    
                    while (line != null) {
                    	
                    	Vector<String> customerInfo = new Vector<>();		//we use a vector to store each piece of info because we don't know how many parameters to expect
                        customerInfo = new Vector<String>(Arrays.asList(line.split(splitBy)));	//the vector is created with each element representing a single parameter
                        
                        //check first element of vector to decide what type of shape to make
                        //all string parameters get converted to integers and Color objects to be passed as arguments validly
                        if (customerInfo.get(0).equals("circle:"))
                        	shapes.add(new Circle( Integer.parseInt(customerInfo.get(1)), Integer.parseInt(customerInfo.get(2)), stringToColor(customerInfo.get(3)), customerInfo.get(3)));
                        
                        else if (customerInfo.get(0).equals("square:"))
                        	shapes.add(new Square( Integer.parseInt(customerInfo.get(1)), Integer.parseInt(customerInfo.get(2)), stringToColor(customerInfo.get(3)), customerInfo.get(3)));
                        
                        else if(customerInfo.get(0).equals("triangle:"))
                        	shapes.add(new Triangle( Integer.parseInt(customerInfo.get(1)), Integer.parseInt(customerInfo.get(2)), Integer.parseInt(customerInfo.get(3)), Integer.parseInt(customerInfo.get(4)), stringToColor(customerInfo.get(5)), customerInfo.get(5)));
                        	
                        
                        else if(customerInfo.get(0).equals("rectangle:"))
                        	shapes.add(new Rectangle( Integer.parseInt(customerInfo.get(1)), Integer.parseInt(customerInfo.get(2)), Integer.parseInt(customerInfo.get(3)), stringToColor(customerInfo.get(4)), customerInfo.get(4)));
                        
                        else	//is an unknown type
                        	System.out.printf("failed to create instance of %s\n", customerInfo.get(0));
                        
                      //go to next line
                        line = rdr.readLine();
                        
                        }


                    }
                catch (Exception ex) {
                	System.out.printf("Failed for %s\n", f.getName());
                }
            }
        }
        
        //create clickable list with arrayList of shapes
        shapeListPanel = new JList(shapes);
        shapeListPanel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        shapeListPanel.setLayoutOrientation(JList.VERTICAL);
        shapeListPanel.setVisibleRowCount(-1);
		shapeListPanel.setBounds(0, 0, 160, 411);
		frame.getContentPane().add(shapeListPanel);
		
		JScrollPane listScroller = new JScrollPane(shapeListPanel);
		listScroller.setBounds(0, 0, 160, 411);
		frame.getContentPane().add(listScroller);
		
		DisplayInfoButton = new JButton("Display");
		DisplayInfoButton.setBounds(10, 11, 78, 53);
		DisplayInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Integer)shapeListPanel.getSelectedIndex() > 0 && (Integer)shapeListPanel.getSelectedIndex() < shapes.size() - 1) {
					int index = shapeListPanel.getSelectedIndex();
					ShapeDetails.setText(shapes.get(index).getDetailString());
					ShapeIcon.setBackground(shapes.get(index).getColor());
					
					if (shapes.get(index).getKind().equals("Circle")){
							ShapeIcon.setIcon(new ImageIcon(curdir + "\\circle.png"));
					}
					else if (shapes.get(index).getKind().equals("Square")) {
							ShapeIcon.setIcon(new ImageIcon(curdir + "\\square.png"));
					}
					else if (shapes.get(index).getKind().equals("Triangle")) {

							ShapeIcon.setIcon(new ImageIcon(curdir + "\\triangle.png"));
					}
					else if (shapes.get(index).getKind().equals("Rectangle")) {
							ShapeIcon.setIcon(new ImageIcon(curdir + "\\rectangle.png"));
					}
				}
				else {
					ShapeDetails.setText("Please select a shape first!");
				}
			}
		});
		infoPanel.add(DisplayInfoButton);
	
	
	}
}
