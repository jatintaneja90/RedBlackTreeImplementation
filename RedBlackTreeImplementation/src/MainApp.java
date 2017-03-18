import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// In this class, I will call redblack object and create a tree.
		// will call different functions of redblack object to demonstrate its functionalities. 
		RedBlackTree rbt=new RedBlackTree();
		boolean exit=false;
//		TreeNode t1= rbt.createNode(11,color.black);
//				//new TreeNode(11,color.black);  /// root
//		TreeNode t2=new TreeNode(2,color.red);
//		TreeNode t3=new TreeNode(14,color.black);
//		TreeNode t4=new TreeNode(1,color.black);
//		TreeNode t5=new TreeNode(7,color.black);
//		TreeNode t6=new TreeNode(5,color.red);
//		TreeNode t7=new TreeNode(8,color.red);
//		TreeNode t8=new TreeNode(15,color.red);
//		TreeNode Nil=new TreeNode(-1,color.black);
		//TreeNode t9=new TreeNode(11,color.black);
		//TreeNode t10=new TreeNode(11,color.black);
//		t1.left=t2;
//		t1.right=t3;
//		t2.left=t4;
//		t2.right=t5;
//		t2.parent=t1;
//		t2.left=t4;
//		t2.right=t5;
//		t4.parent=t2;
//		t5.parent=t2;
//		t3.parent=t1;
//		t3.right=t8;
//		t8.parent=t3;
//		t5.left=t6;
//		t5.right=t7;
//		t6.parent=t5;
//		t7.parent=t5;
//		t1.parent=Nil;
//		t8.left=t8.right=Nil;
//		t3.left=Nil;
		
		
//		TreeNode t1= rbt.createNode(11,color.black);
//		//new TreeNode(11,color.black);  /// root
//		TreeNode t2=rbt.createNode(2,color.red);
//		TreeNode t3=rbt.createNode(14,color.black);
//		TreeNode t4=rbt.createNode(1,color.black);
//		TreeNode t5=rbt.createNode(7,color.black);
//		TreeNode t6=rbt.createNode(5,color.red);
//		TreeNode t7=rbt.createNode(8,color.red);
//		TreeNode t8=rbt.createNode(15,color.red);
		//TreeNode Nil=rbt.createNode(-1,color.black);
		
//		t1.left=t2;
//		t1.right=t3;
//		t2.left=t4;
//		t2.right=t5;
//		t2.parent=t1;
//		t2.left=t4;
//		t2.right=t5;
//		t4.parent=t2;
//		t5.parent=t2;
//		t3.parent=t1;
//		t3.right=t8;
//		t8.parent=t3;
//		t5.left=t6;
//		t5.right=t7;
//		t6.parent=t5;
//		t7.parent=t5;
//		rbt.root=t1;
		
		
		//RedBlackTree rbt=new RedBlackTree();
		
//		rbt.traverse(t1);
//		TreeNode tmp=rbt.successor(t1,11);
//		System.out.println(tmp.key);
		//tmp=rbt.predecessor(t1, 5);
		//System.out.println(tmp.key);
		
		// this is main testing suite
//		rbt.insert(rbt.root, 11);
//		rbt.insert(rbt.root, 2);
//		rbt.insert(rbt.root, 14);
//		rbt.insert(rbt.root, 1);
//		rbt.insert(rbt.root, 7);
//		rbt.insert(rbt.root, 15);
//		rbt.insert(rbt.root, 5);
//		rbt.insert(rbt.root, 8);
//		rbt.insert(rbt.root, 4);
//		System.out.println("After inserting a new node.");
//		rbt.traverse(rbt.root);
//		rbt.delete(rbt.root, rbt.createNode(4, color.black));
//		System.out.println("After deleting a node.");
//		rbt.traverse(rbt.root);
//		rbt.delete(rbt.root, rbt.createNode(7, color.black));
//		System.out.println("After deleting a node.");
//		rbt.traverse(rbt.root);
		int k,j,i;
		TreeNode t;
		String s;
		Scanner scan;
		ArrayList<Integer> ar;
		FileOperations fo;
		do{
			System.out.println("1. To read data from a file.");
			System.out.println("2. To insert a new key");
			System.out.println("3. To traverse current status of red black tree.");
			System.out.println("4. To find the successor of a node.");
			System.out.println("5. To find the predeccessor of a node.");
			System.out.println("6. To find the minimum of tree.");
			System.out.println("7. To find the maximum of tree.");
			System.out.println("8. To delete a node from tree.");
			System.out.println("9. To exit.");
			System.out.println("Please enter your choice : ");
			scan = new Scanner(System.in);
			i= scan.nextInt();
			switch(i){
			case 1: System.out.println("Enter the absolute address of file : ");
					s=scan.next();
					fo = new FileOperations();
					ar=fo.readFile(s);
					for(Integer m:ar){
						k=m;
						rbt.insert(rbt.root, k);
					}
					break;
			case 2: System.out.println("Enter the key you wish to add : ");
					j=scan.nextInt();
					rbt.insert(rbt.root, j);
					break;
			case 3: System.out.println("Current status of tree is:");
					rbt.traverse(rbt.root);
					break;
			case 4: System.out.println("Enter the key whose successor you wish to find:");
					k=scan.nextInt();
					t=rbt.successor(rbt.root, k);
					System.out.println(t.key);
					break;
			case 5: System.out.println("Enter the key whose predecessor you wish to find:");
					k=scan.nextInt();
					t=rbt.successor(rbt.root, k);
					System.out.println(t.key);
					break;
			case 6: t=rbt.Min(rbt.root);
					System.out.println(t.key);
					break;
			case 7: t=rbt.Max(rbt.root);
					System.out.println(t.key);
					break;
			case 8: System.out.println("Enter the key you wish to delete:");
					k=scan.nextInt();
					rbt.delete(rbt.root, rbt.createNode(k, color.black));
					rbt.traverse(rbt.root);
					break;
			case 9: 
			default: exit=true;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}while(!exit);
		System.exit(0);
	}	
}
