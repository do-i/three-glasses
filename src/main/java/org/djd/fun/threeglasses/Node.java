package org.djd.fun.threeglasses;

import java.util.ArrayList;
import java.util.List;

public class Node {

   final static int MAX_FIRST = 8;
   final static int MAX_SECOND = 5;
   final static int MAX_THIRD = 3;
   /**
    * null indicates this node is a root node.
    */
   Node parent;
   int first;
   int second;
   int third;

   /**
    * no children indicates this is a leaf node.
    */
   List<Node> children = new ArrayList<Node>();

   public Node(Node parent, int first, int second, int third) {
      super();
      this.parent = parent;
      this.first = first;
      this.second = second;
      this.third = third;
   }

   /**
    * if arg is <code>null</code> then it does not add.
    * 
    * @param child
    *           to be added to Children list.
    */
   public void addChild(Node child) {
      if (null != child) {

         // this is confusing to call child's method.
         if (!child.existInAncestors(this)) {
            children.add(child);
         }
      }
   }

   

   /**
    * 
    * @param ancestor
    * @return false means this node is uniquely exist (keep this). true means
    *         duplicate node already exists in ancestor (dump this)
    */
   boolean existInAncestors(Node ancestor) {
      if (null == ancestor) {
         return false;
      }

      if (isSame(ancestor)) {
         return true;
      } else {
         return existInAncestors(ancestor.parent);
      }
   }
   
   private boolean isSame(Node node) {
      boolean sameNode = true;
      sameNode &= this.first == node.first;
      sameNode &= this.second == node.second;
      sameNode &= this.third == node.third;

      return sameNode;
   }

   int moveAmount(int sourceAmount, int destinationAmount, int maxDestinationAmount) {
      return Math.min(sourceAmount, maxDestinationAmount - destinationAmount);
   }

   /**
    * pour first to second and result state is created as new {@link Node}
    * instance.
    * 
    * @return new instance of {@link Node} which state is after pour right
    *         amount from one glass to another. <code>null</code> if none is
    *         poured.
    */
   Node pourFirstToSecond() {
      Node child = null;
      int moveAmount = moveAmount(first, second, MAX_SECOND);
      if (0 != moveAmount) {
         child = new Node(this, first - moveAmount, second + moveAmount, third);
      }
      return child;
   }

   Node pourFirstToThird() {
      Node child = null;
      int moveAmount = moveAmount(first, third, MAX_THIRD);
      if (0 != moveAmount) {
         child = new Node(this, first - moveAmount, second, third + moveAmount);
      }
      return child;
   }

   Node pourSecondToFirst() {
      Node child = null;
      int moveAmount = moveAmount(second, first, MAX_FIRST);
      if (0 != moveAmount) {
         child = new Node(this, first + moveAmount, second - moveAmount, third);
      }
      return child;
   }

   Node pourSecondToThird() {
      Node child = null;
      int moveAmount = moveAmount(second, third, MAX_THIRD);
      if (0 != moveAmount) {
         child = new Node(this, first, second - moveAmount, third + moveAmount);
      }
      return child;
   }

   Node pourThirdToFirst() {
      Node child = null;
      int moveAmount = moveAmount(third, first, MAX_FIRST);
      if (0 != moveAmount) {
         child = new Node(this, first + moveAmount, second, third - moveAmount);
      }
      return child;
   }

   Node pourThirdToSecond() {
      Node child = null;
      int moveAmount = moveAmount(third, second, MAX_SECOND);
      if (0 != moveAmount) {
         child = new Node(this, first, second + moveAmount, third - moveAmount);
      }
      return child;
   }

}
