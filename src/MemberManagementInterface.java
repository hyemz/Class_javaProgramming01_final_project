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
				System.out.println("< 추가(add} >");
				
				// 추가할 정보를 입력한다.
				System.out.println("이름: ");
				String name = scan.next();
				System.out.println("키: ");
				double height = scan.nextDouble();
				System.out.println("몸무게: ");
				double weight = scan.nextDouble();
				System.out.println("주소: ");
				String address = scan.next();
				System.out.println("번호: ");
				String phone = scan.next();
				
				// 입력한 정보를 m에 저장
				m = new Member(name, height, weight, address, phone);
				manager.add(m);
				break;	
				
			case 2 :  
				System.out.println("< 삭제(delete) >");	
				
				// 삭제할 정보의 이름을 입력한다.
				System.out.println("삭제할 정보의 이름: ");
				String deleteName = scan.next();
				
				try 
				{
					manager.delete(deleteName);
					System.out.println("삭제 되었습니다.");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				break;
				
			case 3 : 
				System.out.println("< 검색(search) >");
				
				// 찾고싶은 정보의 이름을 입력한다.
				System.out.println("검색할 정보의 이름: ");
				String findName = scan.next();
				
				try
				{
					System.out.println("이름: " + manager.findObject(findName).getName() + 
							" 키: " + manager.findObject(findName).getHeight() +
							" 몸무게: " + manager.findObject(findName).getWeight() +
							" 주소: " + manager.findObject(findName).getAddress() +
							" 번호: " + manager.findObject(findName).getPhone());
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				break;	
				
			case 4 :
				// 저장되어 있는 모든 정보를 출력한다.
				System.out.println("< 전체 보기(displayAll) >");
				System.out.println("-----------------------------------------");
				
				try 
				{
					for(int i = 0; i < manager.getCount(); i++)
						{
							System.out.println("이름: " + manager.getMember(i).getName() + 
								" 키: " + manager.getMember(i).getHeight() + 
								" 몸무게: " + manager.getMember(i).getWeight() + 
								" 주소: " + manager.getMember(i).getAddress() + 
								" 번호: " + manager.getMember(i).getPhone());
						}
				}
				catch (Exception e) // 저장된 정보가 없을 경우 익셉션 
				{
					e.printStackTrace();
				}
				break;	
				
			case 5 :
				// 기존정보를 새로운정보를 입력받아서 덮는다.(=갱신한다)
				System.out.println("< 갱신하기(update)>");
				
				// 수정하고 싶은 정보의 이름을 입력한다.
				System.out.println("수정하고 싶은 정보(기존 정보)의 이름 입력: ");
				String originalName = scan.next();
				
				// 덮을 정보를 입력한다.
				System.out.println("갱신할 정보(새로운 정보)입력: ");
				System.out.println("이름: ");
				String editName = scan.next();
				System.out.println("키: ");
				double editHeight = scan.nextDouble();
				System.out.println("몸무게: ");
				double editWeight = scan.nextDouble();
				System.out.println("주소: ");
				String editAddress = scan.next();
				System.out.println("번호: ");
				String editPhone = scan.next();
				
				// 입력한 정보를 edit_m에 저장
				editManager = new Member(editName, editHeight, editWeight, editAddress, editPhone);
			
				try 
				{
					manager.update(editManager, originalName);
					System.out.println("갱신 되었습니다.");
				} 
				catch (Exception e) // 수정하고 싶은 정보(기존 정보)가 없을 경우 익셉션 발생
				{
					e.printStackTrace();
				}
				break;
				
			case 6 : 
				System.out.println(" 프로그램을 종료합니다. ");
				break;
				
			default:
				// 메뉴에 없는 번호 입력 했을 경우
				System.out.println(" 다시 입력하세요 ");
				break;
				
			}
			if(menu == 6)						
			break;
		}
	}
}

