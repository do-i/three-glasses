package org.djd.fun.threeglasses;

import junit.framework.Assert;

import org.junit.Test;

public class NodeMoveAmountTest {

   @Test
   public void moveAmount_800firstSecond_5() {
      Node node = new Node(null, 8, 0, 0);
      Assert.assertEquals(5, node.moveAmount(node.first, node.second, Node.MAX_SECOND));
   }
   
   @Test
   public void moveAmount_800firstThird_3() {
      Node node = new Node(null, 8, 0, 0);
      Assert.assertEquals(3, node.moveAmount(node.first, node.third, Node.MAX_THIRD));
   }
   
   @Test
   public void moveAmount_800secondFirst_0() {
      Node node = new Node(null, 8, 0, 0);
      Assert.assertEquals(0, node.moveAmount(node.second, node.first, Node.MAX_FIRST));
   }
   
   @Test
   public void moveAmount_332firstSecond_2() {
      Node node = new Node(null, 3, 3, 2);
      Assert.assertEquals(2, node.moveAmount(node.first, node.second, Node.MAX_SECOND));
   }
   
   @Test
   public void moveAmount_332firstThird_1() {
      Node node = new Node(null, 3, 3, 2);
      Assert.assertEquals(1, node.moveAmount(node.first, node.third, Node.MAX_THIRD));
   }
   
   @Test
   public void moveAmount_332secondFirst_3() {
      Node node = new Node(null, 3, 3, 2);
      Assert.assertEquals(3, node.moveAmount(node.second, node.first, Node.MAX_FIRST));
   }
   
   @Test
   public void moveAmount_332secondThird_1() {
      Node node = new Node(null, 3, 3, 2);
      Assert.assertEquals(1, node.moveAmount(node.second, node.third, Node.MAX_THIRD));
   }
   
   @Test
   public void moveAmount_251FirstSecond_0() {
      Node node = new Node(null, 2, 5, 2);
      Assert.assertEquals(0, node.moveAmount(node.first, node.second, Node.MAX_SECOND));
   }

}
