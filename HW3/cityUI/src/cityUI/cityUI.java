package cityUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;



public class cityUI implements MouseMotionListener{

	private JFrame frame;
	ArrayList<JLabel> labels = new ArrayList<>();
	String info = "Click and drag a person to view information about them displayed here!";
    Point diffDrag;
    JLabel infoPanelText = new JLabel();
    ArrayList<Person> allPeople = new ArrayList<>();
    ArrayList<Person>[] personALA = new ArrayList[3];	//person ArrayList array 	(0 = city hall, 1 = outside, 2 = school)
    ArrayList<JLabel>[] labelALA = new ArrayList[3];	//JLabel ArrayList array 	(0 = city hall, 1 = outside, 2 = school)
    Random rnd = new Random();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cityUI window = new cityUI();
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
	public cityUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for (int i = 0; i < 3; i++) {
			personALA[i] = new ArrayList<Person>();
			labelALA[i] = new ArrayList<JLabel>();
		}
		
		//police objects(sometimes on patrol but mostly at City Hall)
        allPeople.add(new Police("Jake Peralta",29,Police.Role.Patrol));
        allPeople.add(new Police("Raymond Holt",47,Police.Role.Captain));
        allPeople.add(new Police("Terry Jeffords",34,Police.Role.Sergeant));
        allPeople.add(new Police("Charles Boyle",31,Police.Role.Chief));
        allPeople.add(new Police());
        
        //teacher objects(always in schools)
        allPeople.add(new Teacher("Peter Tucker",50,true,14));
        allPeople.add(new Teacher("Kent Jones",56,true,13));
        allPeople.add(new Teacher("David Weaver",12,false,0));
        allPeople.add(new Teacher());

        //kid objects(students that are either in class or skip)
        allPeople.add(new Kid("Kyle Shepard",19,"Butterfinger"));
        allPeople.add(new Kid("Lauren Shepard",15,"Junior Mints"));
        allPeople.add(new Kid("Brooklyn Shepard",15,"Gummy Worms"));
        allPeople.add(new Kid("Some Child",8,"Dirt"));
        allPeople.add(new Kid());

        //Generic people(roam the city)
        allPeople.add(new Person("Chad",20));
        allPeople.add(new Person("Gloria",52));
        allPeople.add(new Person());
		
        //for(int i = 0; i < 3; i++)
        	//labels.add(new JLabel());
        
		frame = new JFrame();
		frame.setTitle("City Sim");
		frame.setBounds(100, 100, 736, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel cityPanel = new JPanel();
		cityPanel.setBounds(0, 0, 540, 540);
		frame.getContentPane().add(cityPanel);
		cityPanel.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane cityLayeredPane = new JLayeredPane();
		cityPanel.add(cityLayeredPane, BorderLayout.CENTER);
		cityLayeredPane.setLayout(null);
		cityLayeredPane.addMouseMotionListener(this);
		
		JLabel cityBackground = new JLabel("");
		cityLayeredPane.setLayer(cityBackground, 0);
		cityBackground.setBounds(0, 0, 540, 540);
		cityBackground.setHorizontalAlignment(SwingConstants.CENTER);
		cityBackground.setIcon(new ImageIcon("C:\\Users\\KyleDesktop\\eclipse-workspace\\cityUI\\src\\cityUI\\CityBackground.png"));
		cityLayeredPane.add(cityBackground);
		
	      //puts all people where they should be
        for(int i = 0; i < allPeople.size(); i++){
        	Person p = allPeople.get(i);
        	JLabel temp = new JLabel();
        	cityLayeredPane.setLayer(temp, 1);
        	temp.setBounds(100 + i * 10, 50 + i * 5, 30, 30);
        	temp.setOpaque(false);
        	
            if (p instanceof Police){
                if(rnd.nextInt(10) < 7) { //70% chance for police to be in City Hall
                    personALA[0].add(p);
                    labelALA[0].add(temp);
                }
                else {
                	personALA[1].add(p);
                	labelALA[1].add(temp);
                }
                temp.setIcon(new ImageIcon("C:\\Users\\KyleDesktop\\eclipse-workspace\\cityUI\\src\\cityUI\\policeIcon.png"));
            }
            else if (p instanceof Teacher){
                personALA[2].add(p);    //100% chance for teachers to be at school
                labelALA[2].add(temp);
                temp.setIcon(new ImageIcon("C:\\Users\\KyleDesktop\\eclipse-workspace\\cityUI\\src\\cityUI\\teacherIcon.png"));
                
            }
            else if (p instanceof Kid){
                if(rnd.nextInt(10) != 9) {//90% chance for kids to be at school
                	personALA[2].add(p);
                	labelALA[2].add(temp);
                }
                else {
                	personALA[1].add(p);
                	labelALA[1].add(temp);
                }
                temp.setIcon(new ImageIcon("C:\\Users\\KyleDesktop\\eclipse-workspace\\cityUI\\src\\cityUI\\kidIcon.png"));
            }
            else {
            	temp.setIcon(new ImageIcon("C:\\Users\\KyleDesktop\\eclipse-workspace\\cityUI\\src\\cityUI\\personIcon.png"));
            	personALA[1].add(p);
            	labelALA[1].add(temp);
            }
            //labels.add(temp);
            cityLayeredPane.add(temp,1);
        }
		

		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(540, 0, 180, 540);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel infoPanelTitle = new JLabel("Information:");
		infoPanelTitle.setBounds(0, 0, 180, 40);
		infoPanel.add(infoPanelTitle);
		infoPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		String labelText = formatText(info,160);
		
		infoPanelText.setText(labelText);
		infoPanelText.setBounds(10, 40, 160, 160);
		infoPanel.add(infoPanelText);
		infoPanelText.setVerticalAlignment(SwingConstants.TOP);
	}
	
	public void mouseDragged(MouseEvent e) {
        System.out.println("dragging");
        JLabel label = null;
        Person person = null;
        String name = "";
        int location = -1;
        for (int i = 0; i < labelALA.length; i++) {
        	for (int j = 0; j < labelALA[i].size(); j++) {
        		if (labelALA[i].get(j).getBounds().contains(e.getPoint())) {
        			location = i;
        			label = labelALA[i].get(j);
        			person = personALA[i].get(j);
        			infoPanelText.setText(formatText(person.getInfo(),160));
        		}
        	}
        }
        if (label != null) {
            if (diffDrag == null)
                diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
            label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
            System.out.printf("moved %s to <%d, %d>",person.getName(), e.getX() - diffDrag.x, e.getY()-diffDrag.y);
            
            int x = e.getX();
            
            if(x < 180 && location != 0) {
            	personALA[location].remove(person);
            	labelALA[location].remove(label);
            	personALA[0].add(person);
            	labelALA[0].add(label);
            	System.out.printf("Moved %s to city hall.", person.getName());
            }
            else if (x > 360 && location != 2) {
            	personALA[location].remove(person);
            	labelALA[location].remove(label);
            	personALA[2].add(person);
            	labelALA[2].add(label);
            	System.out.printf("Moved %s to school.", person.getName());
            }
            else {
            	personALA[location].remove(person);
            	labelALA[location].remove(label);
            	personALA[1].add(person);
            	labelALA[1].add(label);
            	System.out.printf("Moved %s to outside.", person.getName());
            }
            
        }
    }

    public void mouseMoved(MouseEvent e) {
        diffDrag = null;
    }
    
    public String formatText(String s, int width) {
    	return String.format("<html><div WIDTH=%d>%s</div><html>", width, s);
    }
}
