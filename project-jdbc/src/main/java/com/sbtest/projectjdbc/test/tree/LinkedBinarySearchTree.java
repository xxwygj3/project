package com.sbtest.projectjdbc.test.tree;

import com.sbtest.projectjdbc.test.list.ElementNotFoundException;
import com.sbtest.projectjdbc.test.list.NonComparableElementException;
import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

import java.util.Iterator;

/**
 * 链表二叉查找树
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) {
        super(element);//LinkedBinaryTree 超类
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }
    }

    /**
     * 根据给定元素的值，在树中的恰当位置添加该元素。
     * 如果这个元素不是Comparable，则抛出NonComparableElementException异常。
     * 如果树为空，则这个新元素就将成为根结点。
     * 如果树非空，这个新元素会与根元素进行比较。
     * 如果它小于根结点中存储的那个元素且根的左孩子为null，则这个新元素就将成为根的左孩子。
     * 如果这个新元素小于根结点中存储的那个元素且根的左孩子不是null，则会遍历根的左孩子，并再次进行比较操作。
     * 如果这个新元素大于或等于树根存储的那个元素且根的右孩子为null，则这个新元素会成为根的右孩子。
     * 如果这个新元素大于或等于根处存储的那个元素且根的右孩子不是null，则会遍历根的右孩子，并再次进行比较操作。
     *
     * @param element
     */
    @Override
    public void addElement(T element) {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {
            root = new BinaryTreeNode<T>(element);
        } else {
            if (comparableElement.compareTo(root.getElement()) < 0) {
                if (root.getLeft() == null) {
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                } else {
                    addElement(element, root.getLeft());
                }
            } else {
                if (root.getRight() == null) {
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                } else {
                    addElement(element, root.getRight());
                }
            }
        }
        modCount++;
    }

    /**
     * @param element
     * @param node
     */
    private void addElement(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (comparableElement.compareTo(node.getElement()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getRight());
            }
        }
    }

    /**
     * 从二叉查找树中删除一个元素时，必须推选出另一个结点来代替要被删除的那个结点。
     * 当在树中找不到给定目标元素时，则抛出ElementNotFoundException异常。
     * 受保护方法replacement返回指向一个结点的引用，该结点将代替要删除的结点。
     * 选择替换结点的三种情况如下：
     * 如果被删除结点没有孩子，则replacement返回null。
     * 如果被删除结点只有一个孩子，则replacement返回这个孩子。
     * 如果被删除结点有两个孩子，则replacement会返回中序后继者（因为相等元素会放到右边）
     *
     * @param targetElement
     * @return
     */
    @Override
    public T removeElement(T targetElement) {
        T result = null;
        if (isEmpty()) {
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        }
        BinaryTreeNode<T> parent = null;
        if (((Comparable<T>) targetElement).equals(root.element)) {
            result = root.element;
            BinaryTreeNode<T> temp = replacement(root);
            if (temp == null) {
                root = null;
            } else {
                root.element = temp.element;
                root.setRight(temp.right);
                root.setLeft(temp.left);
            }
            modCount--;
        } else {
            parent = root;
            if (((Comparable<T>) targetElement).compareTo(root.element) < 0) {
                result = removeElement(targetElement, root.getLeft(), parent);
            } else {
                result = removeElement(targetElement, root.getRight(), parent);
            }
        }
        return result;
    }

    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) throws ElementNotFoundException {
        T result = null;
        if (node == null) {
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        }
        if (((Comparable<T>) targetElement).equals(node.element)) {
            result = node.element;
            BinaryTreeNode<T> temp = replacement(node);
            if (parent.right == node) {
                parent.right = temp;
            } else {
                parent.left = temp;
            }
            modCount--;
        } else {
            parent = node;
            if (((Comparable<T>) targetElement).compareTo(node.element) < 0) {
                result = removeElement(targetElement, node.getLeft(), parent);
            } else {
                result = removeElement(targetElement, node.getRight(), parent);
            }
        }
        return result;
    }

    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            current.left = node.left;
            if (node.right != current) {
                parent.left = current.right;
                current.right = node.right;
            }
            result = current;
        }
        return result;
    }

    /**
     * 从二叉树中删除指定元素的所有存在
     * 当在树中找不到指定元素时，则抛出ElementNotFoundException异常。
     * 如果指定元素不是Comparable，则抛出ClassCastException异常。
     * @param targetElement
     */
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException{
        removeElement(targetElement);
        try {
            while(contains((T)targetElement)){
                removeElement(targetElement);
            }
        }catch (Exception ElementNotFoundException){

        }
    }

    //重载find
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        return super.find(targetElement);
    }

    /**
     * 最小元素在二叉查找树中位置有3种可能情形：
     * 如果树根没有左孩子，则树根就是最小元素，而树根的右孩子会变成新的根结点；
     * 如果树的最左侧结点是一片叶子，则这片叶子就是最小元素，这时只需设置其父结点的左孩子引用为null即可。
     * 如果树的最左侧结点是一个内部结点，则需要设置其父结点的左孩子引用指向这个将删除结点的右孩子。
     * @return
     */
    @Override
    public T removeMin() {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        }
        if(root.left == null){
            result=root.element;
            root=root.right;
        }else {
            BinaryTreeNode<T> parent = root;
            BinaryTreeNode<T> current = root.left;
            while (current.left!=null){
                parent=current;
                current=current.left;
            }
            result=current.element;
            parent.left=current.right;
        }
        modCount--;
        return result;
    }

    @Override
    public T removeMax() {
        return null;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

}
