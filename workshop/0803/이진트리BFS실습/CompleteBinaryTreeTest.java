package d0803_work2;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {

		int size = 10;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);

		for (int i = 0; i < size; ++i) {
			tree.add((char) (65 + i));
		}

		tree.bfs();
		tree.bfs2();
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();

	}

}