package gitupload;

/*
�������������������������������������������������
		�� �� ǥ
------------------------------------------------
	��ȣ �̸�	����	����	����	����	���
------------------------------------------------
	1   ���켺	90	80	95	265	88
	2   ���ϴ�	100	80	95	275	91
	3   Ȳ����	95	80	90	265	88
	4   ������	95	90	99	284	94
	5   ������	90      90      90     270     90
------------------------------------------------
�������������������������������������������������
* ���� ���̺��� �ۼ��ϴ� ���α׷��� �ۼ��Ͻÿ� 
*/
public class ScoreTable {

	public static void main(String[] args) {
		Ex01_modifier[] score = {new Ex01_modifier(1,"���켺",90,80,95),
								 new Ex01_modifier(2,"���ϴ�",70,92,80),
								 new Ex01_modifier(3,"Ȳ����",65,78,98),
								 new Ex01_modifier(4,"������",91,54,50),
								 new Ex01_modifier(5,"������",88,82,67),};
		System.out.println("�����������������������������������������");
		System.out.println("\t\t����ǥ");
		System.out.println("-----------------------------------------");
		System.out.println("\t��ȣ  �̸�  ����  ����  ����  ����  ���");
		for(Ex01_modifier s:score) {
			s.printTable();
		}
		System.out.println("-----------------------------------------");
		System.out.println("������������������������������������������");
								
		}

	}