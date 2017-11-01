import java.util.ArrayList;

public class LCAsets {
	
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
	
	
}
