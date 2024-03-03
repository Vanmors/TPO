package org.example.task2;

import lombok.Getter;

@Getter
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    @Getter
    public class Node {

        int key;

        Node left, right;

        boolean color;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    // Проверка цвета узла
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // Перекрашивание узла
    private void flipColors(Node x) {
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }

    // Вставка нового узла в дерево
    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK; // Корень всегда черный
    }

    private Node insert(Node h, int key) {
        if (h == null) return new Node(key, RED);

        if (key < h.key) h.left = insert(h.left, key);
        else if (key > h.key) h.right = insert(h.right, key);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    // Правый поворот
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Левый поворот
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

//    public void visualize() {
//        visualize(root, 0);
//    }
//
//    private void visualize(Node node, int level) {
//        if (node == null) return;
//
//        visualize(node.right, level + 1);
//
//        for (int i = 0; i < level; i++) {
//            System.out.print("    ");
//        }
//        System.out.println(node.key + (node.color == RED ? " (RED)" : " (BLACK)"));
//
//        visualize(node.left, level + 1);
//    }

//    public Object[] printTree() {
//
//        if (root == null) return null;
//
//        Queue<Node> queue = new ArrayDeque<>();
//
//        queue.add(root);
//        List<Integer> output = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            Node node = queue.remove();
//            output.add(node.key);
//            if (node.left != null) queue.add(node.left);
//            if (node.right != null) queue.add(node.right);
//        }
//
//        return output.toArray();
//    }

}

