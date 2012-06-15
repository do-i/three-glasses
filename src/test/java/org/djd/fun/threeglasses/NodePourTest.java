package org.djd.fun.threeglasses;

import junit.framework.Assert;

import org.junit.Test;

public class NodePourTest {

   @Test
   public void pourFirstToSecond_800_350() {
      Node node = new Node(null, 8, 0, 0);
      Node child = node.pourFirstToSecond();
      Assert.assertNotNull(child);
      Assert.assertEquals(3, child.first);
      Assert.assertEquals(5, child.second);
      Assert.assertEquals(0, child.third);
   }

   @Test
   public void pourFirstToThird_800_503() {
      Node node = new Node(null, 8, 0, 0);
      Node child = node.pourFirstToThird();
      Assert.assertNotNull(child);
      Assert.assertEquals(5, child.first);
      Assert.assertEquals(0, child.second);
      Assert.assertEquals(3, child.third);
   }

   @Test
   public void pourSecondToFirst_800_null() {
      Node node = new Node(null, 8, 0, 0);
      Assert.assertNull(node.pourSecondToFirst());
   }

   /**
    * even though second amount is over max amount it does not care.
    */
   @Test
   public void pourSecondToFirst_755_855() {
      Node node = new Node(null, 7, 6, 5);
      Node child = node.pourSecondToFirst();
      Assert.assertNotNull(child);
      Assert.assertEquals(8, child.first);
      Assert.assertEquals(5, child.second);
      Assert.assertEquals(5, child.third);
   }

   @Test
   public void pourSecondToThird_341_323() {
      Node node = new Node(null, 3, 4, 1);
      Node child = node.pourSecondToThird();
      Assert.assertNotNull(child);
      Assert.assertEquals(3, child.first);
      Assert.assertEquals(2, child.second);
      Assert.assertEquals(3, child.third);
   }

   @Test
   public void pourThirdToFirst_341_440() {
      Node node = new Node(null, 3, 4, 1);
      Node child = node.pourThirdToFirst();
      Assert.assertNotNull(child);
      Assert.assertEquals(4, child.first);
      Assert.assertEquals(4, child.second);
      Assert.assertEquals(0, child.third);
   }

   @Test
   public void pourThirdToSecond_242_251() {
      Node node = new Node(null, 2, 4, 2);
      Node child = node.pourThirdToSecond();
      Assert.assertNotNull(child);
      Assert.assertEquals(2, child.first);
      Assert.assertEquals(5, child.second);
      Assert.assertEquals(1, child.third);
   }

}
