public class Manager {
	private Member[] member;
	private int count = 0; // ����Ǿ��ִ� ���� ����
	
	public Manager(int size)
	{
		member = new Member[size];
	}
	
	// ���� ���� �ϱ�
	public void add(Member m)
	{
		member[count++] = m; 
	}
	
	// �̸��� �ִ� �� ã��
	public int findIndex(String name)
	{
		for(int i = 0; i < count; i++)
		{
			if(member[i].getName().equals(name))
			{
				return i; // ã�� �̸��� �ִٸ� �� ��ȣ�� �����Ѵ�.
			}
		}
		return -1; // ã�� �̸��� ���ٸ� -1 ����
	}
	
	// �̸� ã��
	public Member findObject(String name)throws Exception
	{
		for(int i=0; i < count; i++)
		{
			if(member[i].getName().equals(name))
			{
				return member[i]; // ã�� �̸��� ������ �����Ѵ�.
			}
		}
 		throw new Exception("ã�� �̸��� �����ϴ�.");
	}
	
	// ���� �����
	void delete(String name)throws Exception // �ͼ��� �߻�
	{
		int a = findIndex(name);
		if(a != -1)
		{
			for(int j = a; j < count - 1; j++)
				member[j] = member[j+1]; // ã�� �̸� �濡 ���� ���� �ֱ�
			count--;
		}
		//ã�� �̸��� ���ٸ� exception
		else
			throw new Exception("�ش� ȸ���� �����ϴ�");
	}

	// �ε����� ã�� 
	public Member getMember(int index)
	{
		return member[index];		
	}
	
	// ���� �����ϱ�
	public void update(Member editManager, String name)throws Exception { // editManager:���ο� ����(����), name:���� ������ �̸�
		int a = findIndex(name);
			if(a != -1)
			{
				member[a] = editManager;
			}
			else // ���� ������ ���� ��� 
			throw new Exception ("���� ������ ���� update �� �� �����ϴ�.");
			}

	// �� ���� ����
	public int getCount()throws Exception
	{
		if(count == 0)
		{
			throw new Exception("����� ������ �����ϴ�."); // ������ �ϳ��� ���� �Ǿ����� ���� ��� ��� ������ �˸���.
		}
		else
		return count; // ������ ���� �Ǿ� �ִٸ� ��� ���� �ִ��� �����Ѵ�. 
	} 
}
