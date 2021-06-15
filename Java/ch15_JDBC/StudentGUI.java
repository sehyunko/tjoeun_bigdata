package com.lect.ex3Student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGUI extends JFrame implements ActionListener{
	private JTextField txtSno, txtSname, txtScore; 
	private JButton btnSno, btnSname, btnMname, btnInputStudent, btnCorrectStudent, btnPrintStudent,
			btnPrintExpel,btnExpelStudent,btnExit; 
	private Vector<String> mnames;
	private JComboBox<String> comMajor; 
	private JPanel txtPanel, btnPanel; 
	private JTextArea txtPool; 
	private JScrollPane scrollpane;
	private Container container; 
	private StudentDao dao;
	private ArrayList<StudentDto> student; 
	
	public StudentGUI(String title) {
		super(title); 
		dao = StudentDao.getInstance(); 
		container = getContentPane(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		txtPanel = new JPanel(new GridLayout(4,3));
		btnPanel = new JPanel(new FlowLayout()); 
		txtSno = new JTextField(20); 
		txtSname = new JTextField(20); 
		txtScore = new JTextField(20); 
		mnames = dao.getMNamelist(); 
		comMajor = new JComboBox<String>(mnames);
		btnSno = new JButton("학번검색");
		btnSname = new JButton("이름검색");
		btnMname = new JButton("전공검색");
		btnInputStudent = new JButton("학생입력");
		btnCorrectStudent = new JButton("학생수정");
		btnPrintStudent = new JButton("학생출력");
		btnPrintExpel = new JButton("제적자출력");
		btnExpelStudent = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnSno.setPreferredSize(new Dimension(150, 50));
		btnSname.setPreferredSize(new Dimension(150, 50));
		btnMname.setPreferredSize(new Dimension(150, 50));
		btnInputStudent.setPreferredSize(new Dimension(100, 50));
		btnCorrectStudent.setPreferredSize(new Dimension(100, 50));
		btnPrintStudent.setPreferredSize(new Dimension(100, 50));
		btnPrintExpel.setPreferredSize(new Dimension(100, 50));
		btnExpelStudent.setPreferredSize(new Dimension(100, 50));
		txtPool = new JTextArea(10,60);
		scrollpane = new JScrollPane(txtPool);
		
		txtPanel.add(new JLabel("학번")); 
		txtPanel.add(txtSno);
		txtPanel.add(btnSno); 
		txtPanel.add(new JLabel("이름")); 
		txtPanel.add(txtSname);
		txtPanel.add(btnSname); 
		txtPanel.add(new JLabel("전공"));
		txtPanel.add(comMajor);
		txtPanel.add(btnMname);
		txtPanel.add(new JLabel("점수")); 
		txtPanel.add(txtScore);
		
		btnPanel.add(btnInputStudent); 
		btnPanel.add(btnCorrectStudent); 
		btnPanel.add(btnPrintStudent); 
		btnPanel.add(btnPrintExpel); 
		btnPanel.add(btnExpelStudent); 
		btnPanel.add(btnExit); 
		
		container.setLayout(new FlowLayout());
		container.add(txtPanel);
		container.add(btnPanel);
		container.add(scrollpane);
		
		setVisible(true);
		setSize(new Dimension(700, 600));
		setLocation(200, 150);
		
		btnSno.addActionListener(this);
		btnSname.addActionListener(this);
		btnMname.addActionListener(this);
		btnInputStudent.addActionListener(this);
		btnCorrectStudent.addActionListener(this);
		btnPrintStudent.addActionListener(this);
		btnPrintExpel.addActionListener(this);
		btnExpelStudent.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSno) {
			// 학번으로 학생 정보 검색 
			if(!btnSno.getText().equals("")) {
				String sNo = txtSno.getText().trim(); 
				student = dao.sNogetStudent(sNo);
				txtPool.append("학번"+"\t"+"이름"+"\t"+"전공명"+"\t"+"점수"+"\n"); 
				for(int idx=0;idx<student.size();idx++) {
					txtPool.append(student.get(idx).toString());
				}
				txtSno.setText("");
			} else {
				txtPool.setText("학번을 정확히 입력하세요");
				
			}
			//이름으로 학생 정보 검색
		} else if(e.getSource() == btnSname) {
			String sName = txtSname.getText().trim(); 
			student = dao.sNamegetInfo(sName);
			if(!btnSname.getText().equals("")) {
				txtPool.append("학번"+"\t"+"이름"+"\t"+"전공명"+"\t"+"점수"+"\n"); 
				for(int idx=0;idx<student.size();idx++) {
					txtPool.append(student.get(idx).toString());
				}
			} else {
				txtPool.setText("이름을 정확히 입력하세요");
			}
		}
			// 전공명으로 학과 속한 학생 정보 검색
			else if(e.getSource() == btnMname) {
			int mNo = comMajor.getSelectedIndex(); 
			if(mNo != 0) {
				student = dao.mNamegetStudent(mNo); 
				txtPool.append("등수"+"\t"+"이름"+"\t\t"+"점수"+"\n");
				for(int idx=0;idx<student.size();idx++) {
					txtPool.append(student.get(idx).toString());
				}
			} else {
				txtPool.setText("학과명을 정확히 입력하세요");
			}
		} else if(e.getSource() == btnInputStudent) {
				String sName = txtSname.getText().trim();
				int score = Integer.parseInt(txtScore.getText().trim());
				int mNo = comMajor.getSelectedIndex();  
				StudentDto dto = new StudentDto(sName,score,mNo); 
				int result = dao.insertStudent(dto); 
				txtSname.setText("");
				txtScore.setText("");
				if(result == StudentDao.SUCCESS) {
					txtPool.setText("입력 성공");
				} else {
					txtPool.setText("입력 실패");
				}
				
			} else if(e.getSource() == btnCorrectStudent) {
				String sName = txtSname.getText().trim();
				int score = Integer.parseInt(txtScore.getText().trim()); 
				int mNo = comMajor.getSelectedIndex(); 
				String sNo = txtSno.getText().trim();
				StudentDto dto = new StudentDto(sNo,sName,score,mNo); 
				int result = dao.updateStudent(dto); 
				if(result == StudentDao.SUCCESS) {
					txtPool.setText("수정 성공");
				} else {
					txtPool.setText("수정 실패");
				}
				
			} else if(e.getSource() == btnPrintStudent) {
				student = dao.getStudents();
				txtPool.append("등수"+"\t"+"이름"+"\t\t"+"점수"+"\n");
				for(int idx=0;idx<student.size();idx++) {
					txtPool.append(student.get(idx).toString());
				}
			} else if(e.getSource() == btnPrintExpel) {
				student = dao.getStudentsExpel(); 
				for(int idx=0;idx<student.size();idx++) {
					txtPool.append(student.get(idx).toString());
				}
			} else if(e.getSource() == btnExpelStudent) {
				String sNo = txtSno.getText();
				int result = dao.sNoExpel(sNo); 
				if(result == StudentDao.SUCCESS) {
					txtPool.setText("제적 처리 성공");
				} else {
					txtPool.setText("제적 처리 실패");
				}
			} else if(e.getSource() == btnExit) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
		
	}
	


