package 재귀DFS_BFS.이진트리순회_BinaryTree;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree(int value) {
        root = new TreeNode(value);
    }

    // 전위 순회
    void printPreOrder(TreeNode node) {
        if (node == null) return;

        // 현재 노드 출력
        System.out.print(node.value + " ");

        // 왼쪽 서브트리를 먼저 방문
        printPreOrder(node.left);

        // 오른쪽 서브트리를 마지막에 방문
        printPreOrder(node.right);
    }

    // 중위 순회
    void printInOrder(TreeNode node) {
        if (node == null) return;

        // 왼쪽 서브트리를 먼저 방문
        printInOrder(node.left);

        // 현재 노드 출력
        System.out.print(node.value + " ");

        // 오른쪽 서브트리를 마지막에 방문
        printInOrder(node.right);
    }

    // 후위 순회
    void printPostOrder(TreeNode node) {
        if (node == null) return;

        // 왼쪽 서브트리를 먼저 방문
        printPostOrder(node.left);

        // 오른쪽 서브트리를 그다음에 방문
        printPostOrder(node.right);

        // 현재 노드 출력
        System.out.print(node.value + " ");
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal");
        bt.printPreOrder(bt.root);
        System.out.println();

        System.out.println("Inorder traversal");
        bt.printInOrder(bt.root);
        System.out.println();

        System.out.println("Postorder traversal");
        bt.printPostOrder(bt.root);
    }
}
