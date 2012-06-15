package org.djd.fun.threeglasses;

import junit.framework.Assert;

import org.junit.Test;

public class NodeAddChildTest {

   @Test
   public void addChild_800child350_success() {
      Node node = new Node(null, 8, 0, 0);
      Node child = new Node(node, 3, 5, 0);

      node.addChild(child);
      Assert.assertEquals(1, node.children.size());

   }

   @Test
   public void addChild_800nullChild_noChildAdded() {
      Node node = new Node(null, 8, 0, 0);
      Node child = null;

      node.addChild(child);
      Assert.assertEquals(0, node.children.size());

   }
   
   
   @Test
   public void addChild_800child350child800_grandChildNotAdded() {
      Node node = new Node(null, 8, 0, 0);
      Node child = new Node(node, 3, 5, 0);
      Node grandChild = new Node(child, 8, 0, 0);

      node.addChild(child);
      child.addChild(grandChild);
      Assert.assertEquals(1, node.children.size());
      Assert.assertEquals(0, child.children.size());

   }

}
