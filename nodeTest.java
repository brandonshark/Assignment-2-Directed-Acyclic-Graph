import static org.junit.Assert.*;

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

}
