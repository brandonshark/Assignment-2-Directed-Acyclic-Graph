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

    public void delink(node<x> root)
    {
    	if(root!=null)
    	{
    		this.catalogue.remove(root);
    		root.in--;
    	}
    }
}
