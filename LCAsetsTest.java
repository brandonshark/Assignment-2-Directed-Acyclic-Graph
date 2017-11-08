
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
public class LCAsetsTest{

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testAcyclicVerification()
	{
		assertEquals("Testing for Acyclic with null List", true, LCAsets.acyclicVerification(null));

		ArrayList<node> cycleList = new ArrayList<node>();
		node x = new node("x",1);
		cycleList.add(x);
		assertEquals("Verifying Acyclic with 1 entry set", true, LCAsets.acyclicVerification(cycleList));
		node y = new node("y",7);
		node z = new node("z",78);
		node l = new node("l",234);
		x.link(y);
		y.link(z);
		x.link(l);
		cycleList.add(y);
		cycleList.add(z);
		cycleList.add(l);

		assertEquals("Verifying Acyclic", true, LCAsets.acyclicVerification(cycleList));
		l.link(x);
		assertEquals("Verifying not Acyclic", false, LCAsets.acyclicVerification(cycleList));
		z.link(x);
		assertEquals("Verifying not Acyclic", false, LCAsets.acyclicVerification(cycleList));
		z.link(z);
		assertEquals("Verifying not Acyclic", false, LCAsets.acyclicVerification(cycleList));
	}
	
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	  public void testLCAsets()
	  {
	    node x = new node("x",6);
	    node y = new node("y",9);
	    node z = new node("z",38);
	    node l = new node("l",385);
	    
	    x.link(y);
	    y.link(z);
	    x.link(l);
	    assertEquals("Testing null inputs", null, LCAsets.LCAset(null, null, null));
	    assertEquals("Testing null inputs", null, LCAsets.LCAset(null, x, null));
	    assertEquals("Testing null inputs", null, LCAsets.LCAset(null, null, y));
	    
	    ArrayList<node> list = new ArrayList<node>();
	    assertEquals("Testing empty list", null, LCAsets.LCAset(list, x, y));
	   
	    list.add(x);
	    list.add(y);
	    assertEquals("Testing with node not in list", null, LCAsets.LCAset(list, z, y));
	    list.add(z);
	    list.add(l);
	    ArrayList<node> answers = new ArrayList<node>();
	    answers.add(x);
	    assertEquals("Testing LCA with one Common Ancestor.", false, answers.retainAll(LCAsets.LCAset(list, z, l)));
	    
	    node j = new node("j",250);
	    j.link(y);
	    list.add(j);
	    assertEquals("Testing LCA with one Common Ancestor.", false, answers.retainAll(LCAsets.LCAset(list, z, l)));
	    j.link(l);
	    answers.add(j);
	    assertEquals("Testing LCA with two Common Ancestors.", false, answers.retainAll(LCAsets.LCAset(list, z, l)));
	    
	    node k = new node("k", 235);
	    k.link(x);
	    k.link(z);
	    list.add(k);
	    assertEquals("Testing LCA with two Common Ancestors.", false, answers.retainAll(LCAsets.LCAset(list, z, l)));

	    y.link(x);
	    z.link(k);
	    assertEquals("Testing LCA with x cycle.", null, LCAsets.LCAset(list, z ,l));
	    y.unlink(x);
	  }



}
