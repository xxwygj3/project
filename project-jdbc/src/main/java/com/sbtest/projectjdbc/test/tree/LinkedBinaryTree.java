package com.sbtest.projectjdbc.test.tree;

import com.sbtest.projectjdbc.test.arrayList.ArrayUnorderedList;
import com.sbtest.projectjdbc.test.linkedList.ConcurrentModificationException;
import com.sbtest.projectjdbc.test.linkedList.NoSuchElementException;
import com.sbtest.projectjdbc.test.list.ElementNotFoundException;
import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 链表二叉树实现二叉树接口
 *
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected BinaryTreeNode<T> root;//二叉树根节点
    protected int modCount;//二叉树的元素数目

    /**
     * 创建空的链接二叉树
     */
    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * 创建一个带有特定元素的节点作为二叉树的根
     *
     * @param element
     */
    public LinkedBinaryTree(T element) {
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * 创建一个带有特定元素的节点作为二叉树的根，并且设置其左子树和右子树
     *
     * @param element
     * @param left
     * @param right
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * 返回根节元素
     *
     * @return
     */
    @Override
    public T getRootElement() throws EmptyCollectionException {
        if (root == null) {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
        return root.getElement();
    }

    /**
     * 判断二叉树是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * 返回二叉树的节点个数
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<T> root) {
        int count = 0;
        if (root == null) {
            return count;//树为空
        }
        count++;//根节点
        count += size(root.getLeft());//计算左子树大小
        count += size(root.getRight());//计算右子树大小
        return count;
    }

    /**
     * 返回二叉树的深度(树的高度是指从根到叶子之间最远路径的长度)
     *
     * @return
     */
    public int getHeight() {
        return getHeitht(root);
    }

    private int getHeitht(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int LeftDepth = getHeitht(root.getLeft());
        int RightDepth = getHeitht(root.getRight());
        if (LeftDepth > RightDepth) {
            return ++LeftDepth;
        } else {
            return ++RightDepth;
        }
    }

    /**
     * 返回特定节点的树的高度88
     *
     * @param node
     * @return
     */
    private int height(BinaryTreeNode<T> node) {
        return 0;
    }

    /**
     * 判断树是否包含目标元素如果包含,返回true
     * @param targetElement
     * @return
     */
    @Override
    public boolean contains(T targetElement) {
        return findNode(targetElement, root) != null;
    }

    /**
     * 根据目标元素查找节点
     *
     * @param targetElement
     * @return
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        if (current == null) {
            throw new ElementNotFoundException("LinkedBinaryTree");
        }
        return (current.getElement());
    }

    /**
     * 根据特定的元素查找目标节点
     *
     * @param targetElement
     * @param next
     * @return
     */
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        if (next.getElement().equals(targetElement)) {
            return next;
        }
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        if (temp == null) {
            temp = findNode(targetElement, next.getRight());
        }
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }

    /**
     * 中序遍历
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        return new TreeIterator(tempList.iterator());
    }

    /**
     * 中序
     *
     * @param node
     * @param tempList
     */
    protected void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * 前序遍历
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preOrder(root, tempList);
        return new TreeIterator(tempList.iterator());
    }

    /**
     * 前序
     *
     * @param node
     * @param tempList
     */
    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }

    /**
     * 后序遍历
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postOrder(root, tempList);
        return new TreeIterator(tempList.iterator());
    }

    /**
     * 后序
     *
     * @param node
     * @param tempList
     */
    protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    /**
     * 层次遍历
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = new ArrayUnorderedList<BinaryTreeNode<T>>();
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;
        nodes.addToRear(root);
        while (!nodes.isEmpty()) {
            current = nodes.removeFirst();
            if (current != null) {
                tempList.addToRear(current.getElement());
                if (current.getLeft() != null) {
                    nodes.addToRear(current.getLeft());
                }
                if (current.getRight() != null) {
                    nodes.addToRear(current.getRight());
                }
            } else {
                tempList.addToRear(null);
            }
        }
        return new TreeIterator(tempList.iterator());
    }

    /**
     * 表示树的元素的迭代器的内部类
     */
    private class TreeIterator implements Iterator<T> {
        private int expectedModCount;
        private Iterator<T> iter;

        public TreeIterator(Iterator<T> iter) {
            this.iter = iter;
            expectedModCount = modCount;
        }

        public boolean hasNext() throws ConcurrentModificationException {
            if (!(modCount == expectedModCount)) {
                throw new ConcurrentModificationException();
            }
            return (iter.hasNext());
        }

        public T next() throws NoSuchElementException {
            if (hasNext()) {
                return (iter.next());
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * 返回根节点
     *
     * @return
     * @throws EmptyCollectionException
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException {
        if (root == null) {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
        return root;
    }

    /**
     * @return
     */
    public LinkedBinaryTree<T> getLeft() {
        if (root == null) {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
        return root.getLeft();
    }

    public LinkedBinaryTree<T> getRight() {
        if (root == null) {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
        return root.getRight();
    }


}
