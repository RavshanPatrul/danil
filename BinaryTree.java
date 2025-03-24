class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public void insert(Node parent, Node child, boolean isLeft) {
        if (isLeft) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.data + " ");
            traverseInOrder(node.right);
        }
    }

    public void insertBST(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) return new Node(value);

        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        } else {
            current.right = insertRecursive(current.right, value);
        }
        return current;
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример ручной вставки
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        Node leftChild = new Node(2);
        Node rightChild = new Node(3);

        tree.insert(tree.root, leftChild, true);
        tree.insert(tree.root, rightChild, false);

        System.out.println("In-order обход дерева:");
        tree.traverseInOrder(tree.root); // Вывод: 2 1 3
        System.out.println();

        // Пример автоматической вставки (BST)
        BinaryTree bst = new BinaryTree();
        bst.insertBST(50);
        bst.insertBST(30);
        bst.insertBST(70);
        bst.insertBST(20);
        bst.insertBST(40);
        bst.insertBST(60);
        bst.insertBST(80);

        System.out.println("In-order обход BST дерева:");
        bst.traverseInOrder(bst.root); // Вывод: 20 30 40 50 60 70 80
        System.out.println();
    }
}
