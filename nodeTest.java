import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class nodeTest {
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testLink()
	{
		node x = new node("x", 3);
		node y = new node("y", 2);
		x.link(y);
		assertTrue(x.catalogue.size()==1);
		y.link(x);
		assertTrue(y.catalogue.size()==1);
		y.link(null);
		assertTrue(y.catalogue.size()==1);
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testUnlink()
	{
		node x = new node("x", 3);
		node y = new node("y", 2);
		x.link(y);
		y.link(x);
		y.link(null);
		x.unlink(y);
		assertTrue(x.catalogue.size()==0);
		y.unlink(x);
		assertTrue(y.catalogue.size()==0);
		y.unlink(null);
		assertTrue(y.catalogue.size()==0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	  public void testRemoveAt()
	  {
	    node x = new node("x", 17); node y = new node("y", 16); node z = new node("z", 18);
	    ArrayList<node> index = new ArrayList<node>(Arrays.asList(x,y,z));
	    x.link(y);
	    x.link(z);
	    z.removeAt(index);
	    assertEquals("Verifying removeAt method operates correctly", false, x.catalogue.contains(z));
	  }
}




