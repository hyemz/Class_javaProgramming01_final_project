public class Manager {
	private Member[] member;
	private int count = 0; // 저장되어있는 방의 갯수
	
	public Manager(int size)
	{
		member = new Member[size];
	}
	
	// 정보 저장 하기
	public void add(Member m)
	{
		member[count++] = m; 
	}
	
	// 이름이 있는 방 찾기
	public int findIndex(String name)
	{
		for(int i = 0; i < count; i++)
		{
			if(member[i].getName().equals(name))
			{
				return i; // 찾는 이름이 있다면 방 번호를 리턴한다.
			}
		}
		return -1; // 찾는 이름이 없다면 -1 리턴
	}
	
	// 이름 찾기
	public Member findObject(String name)throws Exception
	{
		for(int i=0; i < count; i++)
		{
			if(member[i].getName().equals(name))
			{
				return member[i]; // 찾는 이름의 정보를 리턴한다.
			}
		}
 		throw new Exception("찾는 이름이 없습니다.");
	}
	
	// 정보 지우기
	void delete(String name)throws Exception // 익셉션 발생
	{
		int a = findIndex(name);
		if(a != -1)
		{
			for(int j = a; j < count - 1; j++)
				member[j] = member[j+1]; // 찾은 이름 방에 다음 방을 넣기
			count--;
		}
		//찾는 이름이 없다면 exception
		else
			throw new Exception("해당 회원이 없습니다");
	}

	// 인덱스로 찾기 
	public Member getMember(int index)
	{
		return member[index];		
	}
	
	// 정보 갱신하기
	public void update(Member editManager, String name)throws Exception { // editManager:새로운 정보(수정), name:기존 정보의 이름
		int a = findIndex(name);
			if(a != -1)
			{
				member[a] = editManager;
			}
			else // 기존 정보가 없을 경우 
			throw new Exception ("기존 정보가 없어 update 할 수 없습니다.");
			}

	// 방 개수 세기
	public int getCount()throws Exception
	{
		if(count == 0)
		{
			throw new Exception("저장된 정보가 없습니다."); // 정보가 하나도 저장 되어있지 않을 경우 비어 있음을 알린다.
		}
		else
		return count; // 정보가 저장 되어 있다면 몇개의 방이 있는지 리턴한다. 
	} 
}
