package ch07_abstract;

/*������ 3��, ����� 2���� ������ ����ؼ� ���� ������ �ܼ�â�� ����ϱ�
 * �������� �̸��� ������ �Է� �޾� ������ ����ϰ�, ������ 10%�� �󿩱����� �����Ѵ�
 * ������� �̸��� �Ϻ� �ٹ��ð�, �ñ��� �Է¹޾� ������ ����ϰ�, ������ 8%�� �󿩱����� �����Ѵ�*/
public class SalaryMain {

	public static void main(String[] args) {
		Employee[] salary = {new SalaryEmployee("�����",30000000),
							 new SalaryEmployee("�̺���",40000000),
							 new HourlyEmployee("�輼��",9,10000), 
							 new HourlyEmployee("�̱�ȿ",8,10000),
							 new HourlyEmployee("��ȣâ",10,10000)}; 
							 
		System.out.println("\t\t���� ����");
		System.out.println("----------------------------");
		System.out.println("�̸� \t�������\t����\t�󿩱�");
		System.out.println("----------------------------");
		for(Employee e:salary) {
			if(e instanceof SalaryEmployee) {
				System.out.print(e.getName()+"\t������"+"\t"+e.computePay()+"\t"+e.computIncentive()+"\n");
			} else if(e instanceof HourlyEmployee) {
				System.out.print(e.getName()+"\t�����"+"\t"+e.computePay()+"\t"+e.computIncentive()+"\n");
			}
		
		}
		System.out.println("----------------------------");
	}

}
