
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
    node a = new node("a",1);
    cycleList.add(a);
    assertEquals("Testing for Acyclic with 1 element list", true, LCAsets.acyclicVerification(cycleList));
    
    node b = new node("b",3);
    node c = new node("c",42);
    node d = new node("d",188);
    
    a.link(b);
    b.link(c);
    a.link(d);
      
    cycleList.add(b);
    cycleList.add(c);
    cycleList.add(d);
    
    assertEquals("Testing for Acyclic", true, LCAsets.acyclicVerification(cycleList));
    d.link(a);
    assertEquals("Testing for Acyclic", false, LCAsets.acyclicVerification(cycleList));
    c.link(a);
    assertEquals("Testing for Acyclic", false, LCAsets.acyclicVerification(cycleList));
    c.link(c);
    assertEquals("Testing for Acyclic", false, LCAsets.acyclicVerification(cycleList));
    
  }

  
}
