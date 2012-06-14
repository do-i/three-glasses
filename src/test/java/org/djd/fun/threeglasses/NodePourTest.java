package org.djd.fun.threeglasses;

import junit.framework.Assert;

import org.junit.Test;

public class NodePourTest {

   @Test
   public void pourFirstToSecond_800_350() {
      Node node = new Node(null, 8, 0, 0);
      Node child =  node.pourFirstToSecond();
      Assert.assertNotNull(child);
      Assert.assertEquals(3, child.first);
      Assert.assertEquals(5, child.second);
      Assert.assertEquals(0, child.third);
   }
   

}
