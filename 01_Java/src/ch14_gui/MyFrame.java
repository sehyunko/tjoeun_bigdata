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
/*�̸�, ��ȭ, ���̸� �Է��� �� �ִ� 3���� TextField�� ����,
 *����ڰ� �̸�, ��ȭ, ���̸� �Է��ϰ� ��� ��ư�� ������ ArrayList�� ������ �������� �����ϰ� 
 *��� ��ư�� ������ ArrayList�� ����� ȸ�������� person.txt��� ���Ϸ� ����Ѵ�*/

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
		btnInput = new JButton("�Է�",iconInput);
		btnOutput = new JButton("���",iconOutput); 
		panel.add(new JLabel("�̸�",(int)CENTER_ALIGNMENT)); 
		panel.add(txtName); 
		panel.add(new JLabel(("��ȭ"),(int)CENTER_ALIGNMENT));
		panel.add(txtPhone); 
		panel.add(new JLabel(("����"),(int)CENTER_ALIGNMENT));
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
				System.out.println("��ȿ���� ���� ���̰��̹Ƿ� 0���� �Էµ˴ϴ�");
			}
			 
			String regex = "^\\d{3}-\\d{4}-\\d{4}$";
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
			if(name.equals("")) {
				System.out.println("�̸����� ��ȿ���� �ʽ��ϴ�");
				return; 
			}
			if(Pattern.matches(regex, phone)==false) {
				System.out.println("000-0000-0000 �������� ��ȭ��ȣ�� �����ϼ���");
				return;
			}
			if(age<=0 || age>150) {
				System.out.println("���̰��� ��ȿ���� �����Ƿ� 0���� �Էµ˴ϴ�");
				return; 
			}
			persons.add(new Person(name,phone,age));
		}
		if(e.getSource()==btnOutput) {
			Writer writer = null; 
			try {
				writer = new FileWriter("D:\\BigData\\src\\01_Java\\ch17_io\\textFile\\person.txt",true);
				writer.write("�̸�\t��ȭ\t����\n");
				for(int i=0; i<persons.size();i++) {
					writer.write(persons.get(i).toString()); 
				}
				System.out.println("��� ����");
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
		new MyFrame("GUI ����");
	}

}
