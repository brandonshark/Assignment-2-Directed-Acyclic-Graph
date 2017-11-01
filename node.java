import java.util.ArrayList;

public class node<x> {
	public x data;
	public ArrayList<node<x>> catalogue;
	public x key;
	public int in;
	public int out;

	public node(x ID,x val)
	{
		key = ID;
		data = val; 
		catalogue = new ArrayList<node<x>>();
		in = 0;
		out = catalogue.size();
	} 


	public void link(node<x> root)
	{
		if(root != null)
		{
			this.catalogue.add(root);
			root.in++;
		}

	}

	public void unlink(node<x> root)
	{
		if(root!=null)
		{
			this.catalogue.remove(root);
			root.in--;
		}
	}

	public void removeAt(ArrayList<node<x>> var)
	{
		if(var==null) return;
		for(int i = 0; i < var.size(); i++)
		{
			node<x> temp = var.get(i);
			if(temp.catalogue.contains(this))
			{
				temp.catalogue.remove(temp.catalogue.indexOf(this));
			}
		}
		this.catalogue = null;
	}

}

