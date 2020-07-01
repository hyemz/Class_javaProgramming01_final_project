import java.util.Scanner;
public class MemberManagementInterface 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager(100);
		Member m = null;
		Member editManager = null;
		int menu;
		
		while(true)
		{
			UserInterfaceScanner.menu();					
			menu = scan.nextInt();
			
			switch(menu)							
			{
			case 1 :
				System.out.println("< �߰�(add} >");
				
				// �߰��� ������ �Է��Ѵ�.
				System.out.println("�̸�: ");
				String name = scan.next();
				System.out.println("Ű: ");
				double height = scan.nextDouble();
				System.out.println("������: ");
				double weight = scan.nextDouble();
				System.out.println("�ּ�: ");
				String address = scan.next();
				System.out.println("��ȣ: ");
				String phone = scan.next();
				
				// �Է��� ������ m�� ����
				m = new Member(name, height, weight, address, phone);
				manager.add(m);
				break;	
				
			case 2 :  
				System.out.println("< ����(delete) >");	
				
				// ������ ������ �̸��� �Է��Ѵ�.
				System.out.println("������ ������ �̸�: ");
				String deleteName = scan.next();
				
				try 
				{
					manager.delete(deleteName);
					System.out.println("���� �Ǿ����ϴ�.");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				break;
				
			case 3 : 
				System.out.println("< �˻�(search) >");
				
				// ã����� ������ �̸��� �Է��Ѵ�.
				System.out.println("�˻��� ������ �̸�: ");
				String findName = scan.next();
				
				try
				{
					System.out.println("�̸�: " + manager.findObject(findName).getName() + 
							" Ű: " + manager.findObject(findName).getHeight() +
							" ������: " + manager.findObject(findName).getWeight() +
							" �ּ�: " + manager.findObject(findName).getAddress() +
							" ��ȣ: " + manager.findObject(findName).getPhone());
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				break;	
				
			case 4 :
				// ����Ǿ� �ִ� ��� ������ ����Ѵ�.
				System.out.println("< ��ü ����(displayAll) >");
				System.out.println("-----------------------------------------");
				
				try 
				{
					for(int i = 0; i < manager.getCount(); i++)
						{
							System.out.println("�̸�: " + manager.getMember(i).getName() + 
								" Ű: " + manager.getMember(i).getHeight() + 
								" ������: " + manager.getMember(i).getWeight() + 
								" �ּ�: " + manager.getMember(i).getAddress() + 
								" ��ȣ: " + manager.getMember(i).getPhone());
						}
				}
				catch (Exception e) // ����� ������ ���� ��� �ͼ��� 
				{
					e.printStackTrace();
				}
				break;	
				
			case 5 :
				// ���������� ���ο������� �Է¹޾Ƽ� ���´�.(=�����Ѵ�)
				System.out.println("< �����ϱ�(update)>");
				
				// �����ϰ� ���� ������ �̸��� �Է��Ѵ�.
				System.out.println("�����ϰ� ���� ����(���� ����)�� �̸� �Է�: ");
				String originalName = scan.next();
				
				// ���� ������ �Է��Ѵ�.
				System.out.println("������ ����(���ο� ����)�Է�: ");
				System.out.println("�̸�: ");
				String editName = scan.next();
				System.out.println("Ű: ");
				double editHeight = scan.nextDouble();
				System.out.println("������: ");
				double editWeight = scan.nextDouble();
				System.out.println("�ּ�: ");
				String editAddress = scan.next();
				System.out.println("��ȣ: ");
				String editPhone = scan.next();
				
				// �Է��� ������ edit_m�� ����
				editManager = new Member(editName, editHeight, editWeight, editAddress, editPhone);
			
				try 
				{
					manager.update(editManager, originalName);
					System.out.println("���� �Ǿ����ϴ�.");
				} 
				catch (Exception e) // �����ϰ� ���� ����(���� ����)�� ���� ��� �ͼ��� �߻�
				{
					e.printStackTrace();
				}
				break;
				
			case 6 : 
				System.out.println(" ���α׷��� �����մϴ�. ");
				break;
				
			default:
				// �޴��� ���� ��ȣ �Է� ���� ���
				System.out.println(" �ٽ� �Է��ϼ��� ");
				break;
				
			}
			if(menu == 6)						
			break;
		}
	}
}

