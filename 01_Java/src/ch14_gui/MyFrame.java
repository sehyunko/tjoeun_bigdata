package gitupload;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*이름, 전화, 나이를 입력할 수 있는 3개의 TextField를 생성,
 *사용자가 이름, 전화, 나이를 입력하고 출력 버튼을 누르면 ArrayList에 정보를 차곡차곡 저장하고 
 *출력 버튼을 누르면 ArrayList에 저장된 회원정보를 person.txt라는 파일로 출력한다*/

public class MyFrame extends JFrame implements ActionListener {
	private Container container; 
	private JPanel panel;
	private JPanel panelButton; 
	private JTextField txtName; 
	private JTextField txtPhone;
	private JTextField txtAge; 
	private JButton btnInput; 
	private JButton btnOutput; 
	private ImageIcon iconInput;
	private ImageIcon iconOutput;
	private ArrayList<Person> persons = new ArrayList<Person>(); 

	public MyFrame(String title) {
		setTitle(title); 
		container = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(3,2)); 
		panelButton = new JPanel(new GridLayout(1,2)); 
		txtName = new JTextField();
		txtPhone = new JTextField(); 
		txtAge = new JTextField(); 
		iconInput = new ImageIcon("D:\\BigData\\src\\01_Java\\ch18_gui\\icon\\join.png");
		iconOutput = new ImageIcon("D:\\BigData\\src\\01_Java\\ch18_gui\\icon\\output.png"); 
		btnInput = new JButton("입력",iconInput);
		btnOutput = new JButton("출력",iconOutput); 
		panel.add(new JLabel("이름",(int)CENTER_ALIGNMENT)); 
		panel.add(txtName); 
		panel.add(new JLabel(("전화"),(int)CENTER_ALIGNMENT));
		panel.add(txtPhone); 
		panel.add(new JLabel(("나이"),(int)CENTER_ALIGNMENT));
		panel.add(txtAge); 
		panelButton.add(btnInput);
		panelButton.add(btnOutput); 
		container.add(panel,BorderLayout.CENTER); 
		container.add(panelButton,BorderLayout.SOUTH);
 
		
		
		setVisible(true);
		setSize(new Dimension(400,200));
		setLocation(100,100); 
		
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
		
	}
	
	public MyFrame() {
		this(""); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnInput) {
			String name= txtName.getText().trim();
			String phone = txtPhone.getText().trim(); 
			int age =0;
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch(NumberFormatException n) {
				System.out.println("유효하지 않은 나이값이므로 0으로 입력됩니다");
			}
			 
			String regex = "^\\d{3}-\\d{4}-\\d{4}$";
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
			if(name.equals("")) {
				System.out.println("이름값이 유효하지 않습니다");
				return; 
			}
			if(Pattern.matches(regex, phone)==false) {
				System.out.println("000-0000-0000 형식으로 전화번호를 기입하세요");
				return;
			}
			if(age<=0 || age>150) {
				System.out.println("나이값이 유효하지 않으므로 0으로 입력됩니다");
				return; 
			}
			persons.add(new Person(name,phone,age));
		}
		if(e.getSource()==btnOutput) {
			Writer writer = null; 
			try {
				writer = new FileWriter("D:\\BigData\\src\\01_Java\\ch17_io\\textFile\\person.txt",true);
				writer.write("이름\t전화\t나이\n");
				for(int i=0; i<persons.size();i++) {
					writer.write(persons.get(i).toString()); 
				}
				System.out.println("출력 성공");
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage()); 
				
			} finally {
				if(writer!=null) {
					try {
						writer.close();
					} catch (IOException e1) {
		
					}
				}
			}
			
			
		}
		

	}
	public static void main(String[] args) {
		new MyFrame("GUI 예제");
	}

}
