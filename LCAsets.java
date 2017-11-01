import java.util.ArrayList;

public class LCAsets {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<node> LCAset(ArrayList<node> nodeCata, node x, node y)
	{  	
		if(nodeCata == null || x == null || y == null || nodeCata.size() == 0 ||!nodeCata.contains(x) || !nodeCata.contains(y) ) return null;
		if(!acyclicVerification(nodeCata)) return null;
		ArrayList<node> rootCata = new ArrayList<node>();
		ArrayList<node> ListA = new ArrayList<node>();
		ArrayList<node> ListB = new ArrayList<node>();
		ArrayList<node> commonList = new ArrayList<node>();
		for(int i = 0; i < nodeCata.size(); i++)
		{
			if(nodeCata.get(i).in== 0)
			{
				rootCata.add(nodeCata.get(i));
			}
		}
		ListA.add(x);
		ListB.add(y);
		for(int i = 0; i < rootCata.size(); i++)
		{
			search(rootCata.get(i), ListA, ListB);
		}
		commonList = junction(ListA, ListB);
		if(commonList.size() == 0) return null;
		while(commonList.size() != 1)
		{
			for(int i = 0; i < commonList.size(); i++)
			{

				if(impasse(commonList))
				{
					return commonList;
				}
				else
				{
					if(junction(commonList, commonList.get(i).catalogue).size() != 0)
					{
						commonList.remove(i);
					}
				}
			}	
		}
		return commonList;

	}



	@SuppressWarnings("rawtypes")
	public static boolean acyclicVerification(ArrayList<node> index)
	{
		if(index == null || index.size() == 0)
			return true;

		for(int i = 0; i < index.size(); i++)
		{
			ArrayList<node> marked = new ArrayList<node>();
			ArrayList<node> heap = new ArrayList<node>();
			node origin = index.get(i);
			boolean isCycle = false;
			isCycle = isCycle(index, origin, marked, heap, isCycle);
			if(isCycle)
			{
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	private static boolean isCycle(ArrayList<node> list, node temp, ArrayList<node> marked, ArrayList<node> heap, boolean isCycle)
	{
		marked.add(temp);
		heap.add(temp);

		for(int x= 0; x < temp.catalogue.size(); x++)
		{
			node y = (node)temp.catalogue.get(x);
			if(!marked.contains(y)) 
			{
				isCycle = isCycle || isCycle(list, y, marked, heap, isCycle);
			}
			else if(heap.contains(y))
			{
				isCycle = true;
				return isCycle;
			}
		}
		heap.remove(temp);
		return isCycle;
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<node> junction(ArrayList<node> cata1, ArrayList<node> cata2) {
		ArrayList<node> cata = new ArrayList<node>();

		for (node x : cata1) {
			if(cata2.contains(x)) {
				cata.add(x);
			}
		}
		return cata;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean impasse(ArrayList<node> commonList) 
	{
		for(int i = 0; i < commonList.size(); i++)
		{
			node temp = commonList.get(i);
			if(junction(commonList, temp.catalogue).size() != 0)
			{
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static void search(node root, ArrayList<node> ListA, ArrayList<node> ListB)
	{
		if(root.catalogue == null || root.catalogue.size() == 0) return;

		for(int i = 0; i < root.catalogue.size(); i++)
		{
			node temp = (node) root.catalogue.get(i);
			if(!(ListA.contains(temp) || ListB.contains(temp))) search(temp, ListA, ListB);
			if(ListA.contains(temp)) ListA.add(root);
			if(ListB.contains(temp)) ListB.add(root);	
		}
	}
}
