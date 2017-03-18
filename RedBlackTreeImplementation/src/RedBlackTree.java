
public class RedBlackTree {
	int p,l,r;
	TreeNode Nil=new TreeNode(-1,color.black);
	TreeNode root=Nil;
	void traverse(TreeNode T){
		if(T == Nil)
			return;
		traverse(T.left);
//		if(T.parent==null){
//			p=-1;
//		}else p=T.parent.key;
//		if(T.left==null){
//			l=-1;
//		}else l=T.left.key;
//		if(T.right==null)
//			r=-1;
//		else
//			r=T.right.key;
		System.out.println("Key is : "+T.key+" and color is "+T.c +" and parent is " +
				T.parent.key +" and left child is " + T.left.key +" and right is"+ T.right.key);
		traverse(T.right);
	}
	
	TreeNode Min(TreeNode n){
		while(n.left!=Nil){
			n=n.left;
		}
		return n;
	}
	
	TreeNode Max(TreeNode n){
		while(n.right!=Nil){
			n=n.right;
		}
		return n;
	}
	
	boolean Search(TreeNode n,int k){
		boolean found=false;
		while(n!=Nil && !found){
			if(n.key==k){
				found=true;
			}
			else if(k<n.key){
				n=n.left;
			}else{
				n=n.right;
			}			
		}
		return found;
	}
	
	TreeNode successor(TreeNode n,int k){			// here n given is root of tree, need to find successor of 
		boolean found=false;						// node whose value is k
		TreeNode y;
		while(n!=Nil && !found){
			if(n.key==k){
				found=true;
			}
			else if(k<n.key){
				n=n.left;
			}else{
				n=n.right;
			}			
		}
		if(found){
											// when found=true, n becomes the node whose successor we need to find.
			if(n.right != Nil){
				return Min(n.right);
			}else{
				if(n.parent.left==n){					
					return n.parent;
				}else{
					y=n.parent;
					//System.out.println("y.key = "+y.key);
					while(y!=Nil && n!=y.left){
						n=y;
						y=y.parent;
					}
					if(y==Nil){
						System.out.println("Er: Key whose successor is needed is not found.");
						//System.exit(1);
						//return new TreeNode(-1,color.black);
						return Nil;
					}else
						return y;
				}
			}
		}else{
			System.out.println("Er: Key whose successor is needed is not found.");
			//System.exit(1);
			return Nil;
		}	
	}
	
	TreeNode predecessor(TreeNode n,int k){				// here n given is root of tree
		boolean found=false;
		TreeNode y;
		while(n!=Nil && !found){
			if(n.key==k){
				found=true;
			}
			else if(k<n.key){
				n=n.left;
			}else{
				n=n.right;
			}			
		}
		if(found){
										// when found=true, n becomes the node whose successor we need to find.
			if(n.left != Nil){
				return Max(n.left);
			}else{
				if(n.parent.right==n){
					return n.parent;
				}else{
					y=n.parent;
					while(y!= Nil && n!=y.right){
						n=y;
						y=y.parent;
					}
					if(y==Nil){
						System.out.println("Er: Key whose successor is needed is not found.");
						//System.exit(1);
						return Nil;
					}else
						return y;
				}
			}
		}else{
			System.out.println("Er: Key whose successor is needed is not found.");
			//System.exit(1);
			return Nil;
		}	
	}

	

	void rightRotate(TreeNode T,TreeNode n){
//		boolean found=false;
//		TreeNode n=T;
//		//TreeNode y;
//		while(n!=null && !found){
//			if(n.key==k){
//				found=true;
//			}
//			else if(k<n.key){
//				n=n.left;
//			}else{
//				n=n.right;
//			}			
//		}  								// now n is the node found.
		//if(found){
			TreeNode y = n.left;
			n.left=y.right;
			y.right.parent=n;
			y.parent=n.parent;
			if(n.parent==Nil)
				root=y;
			else if(n==n.parent.left)
				n.parent.left=y;
			else
				n.parent.right=y;
			y.right=n;
			n.parent=y;
//			y.left=n.right;
//			n.right.parent=y;
//			n.parent=y.parent;
//			if(y.parent==null)
//				T=n;
//			else if(y==y.parent.left)
//				y.parent.left=n;
//			else
//				y.parent.right=n;
//			y.right=y;
//			y.parent=n;
	//	}	
	}
	
	void leftRotate(TreeNode T,TreeNode n){
		//boolean found=false;								
		//TreeNode n=T;
//		while(n!=null && !found){
//			if(n.key==k){
//				found=true;
//			}
//			else if(k<n.key){
//				n=n.left;
//			}else{
//				n=n.right;
//			}			
//		}  								// now n is the node found.
		//if(found){
			TreeNode y = n.right;
			//System.out.println(y.key);
			n.right=y.left;
			y.left.parent=n;
			y.parent=n.parent;
			if(n.parent==Nil)
				root=y;
			else if(n==n.parent.left)
				n.parent.left=y;
			else
				n.parent.right=y;
			y.left=n;
			n.parent=y;
		//}	
	}
	
	void insert(TreeNode T,int key){
		TreeNode y=null;
		TreeNode z=T;
		if(T==Nil){
//			root=new TreeNode(key,color.black);
//			root.left=Nil;
//			root.right=Nil;
//			root.parent=Nil;
			root=createNode(key,color.black);
			return;
		}
//		TreeNode n = new TreeNode(key,color.red);
//		n.left=Nil;
//		n.right=Nil;
//		n.parent=Nil;
		TreeNode n=createNode(key,color.red);
		while(z!=Nil){
			y=z;
			if(key <= z.key)
				z=z.left;
			else
				z=z.right;
		}
			n.parent=y;
			if(y==Nil)
				root=n;
			else if(key<y.key)
				y.left=n;
			else
				y.right=n;
			//System.out.println(y.key);
			//traverse(root);
			insertFix(T,n);
	}
	
	public void insertFix(TreeNode T,TreeNode z){
		//boolean found=false;								
	//	TreeNode n=T;
		TreeNode y;
//		while(n!=null && !found){
//			if(n.key==z.key){
//				found=true;
//			}
//			else if(z.key<n.key){
//				n=n.left;
//			}else{
//				n=n.right;
//			}			
//		}  
//		z=n;
		while(z.parent.c==color.red){
			if(z.parent==z.parent.parent.left){
				y=z.parent.parent.right;
				//System.out.println("uncle is : " + y.key +"and color is " + y.c);
				if(y.c==color.red){							//case1: when uncle's color is red.
					y.c=color.black;
					z.parent.c=color.black;
					z.parent.parent.c=color.red;
					z=z.parent.parent;
				}else{
					if(z==z.parent.right){					// case2: when z is right child of red node.
						z=z.parent;
						//System.out.println("Goin for left rotate and Key is "+ z.key);
						leftRotate(T,z);
					}
					if(z==z.parent.left){	
					z.parent.c=color.black;						// case3: when z is left child of red node.
					z.parent.parent.c=color.red;
					//System.out.println("Goin for right rotate and Key is "+ z.parent.parent.key);
					rightRotate(T,z.parent.parent);
					}
				}									
			}else{
				//System.out.println("In else condition and Key is "+ z.key);
					y=z.parent.parent.left;
					if(y.c == color.red){							//case1: when uncle's color is red.
						y.c=color.black;
						z.parent.c=color.black;
						z.parent.parent.c=color.red;
						z=z.parent.parent;
					}else{ // if y is black
						if(z==z.parent.left){					// case2: when z is left child of red node.
							z=z.parent;
							rightRotate(T,z);
						}
						if(z==z.parent.right){
							z.parent.c=color.black;	  					// case3 : when z is right child of red node.
							z.parent.parent.c=color.red;
							leftRotate(T,z.parent.parent);
						}	
					}
								
			}
			root.c=color.black;
		}
	}
	
	
	// method to delete a key from red black tree
	public void delete(TreeNode T,TreeNode z){
		boolean found=false;								
		TreeNode n=T;
		TreeNode y,x;
		while(n!=Nil && !found){
			if(n.key==z.key){
				found=true;
			}
			else if(z.key<n.key){
				n=n.left;
			}else{
				n=n.right;
			}			
		}  
		z=n;
		y=z;
		color y_original_color=y.c;
		if(z.right==Nil){
			x=z.left;
			System.out.println(x.key);
			Transplant(T,z,z.left);
		}else if(z.left==Nil){
			x=z.right;
			System.out.println(x.key);
			Transplant(T,z,z.right);
		}else{
			y=Min(z.right);
			y_original_color=y.c;
			x=y.right;
			System.out.println(y.key + " "+x.key);
			if(y.parent==z){
				x.parent =y;	
			}else{
				Transplant(T,y,y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			Transplant(T,z,y);
			y.left=z.left;
			y.left.parent = y;
			y.c=z.c;
		}
		if(y_original_color==color.black){
			deleteTreeFix(T,x);
		}
	}
	
	// helper function Transplant to replace node u with v
	public void Transplant(TreeNode T,TreeNode u,TreeNode v){
//		boolean found=false;								
//		TreeNode n=T;
//		while(n!=Nil && !found){
//			if(n.key==u.key){
//				found=true;
//			}
//			else if(u.key<n.key){
//				n=n.left;
//			}else{
//				n=n.right;
//			}			
//		}  
//		u=n;
		if(u.parent==Nil){
			root=v;
		}
		else if(u.parent.left==u){
			u.parent.left=v;
		}else{
			u.parent.right=v;
		}
		v.parent=u.parent;
	}
	
	public void deleteTreeFix(TreeNode T,TreeNode x) {
		TreeNode w;
		System.out.println("Inside deleteFix" + x.key);
		while(x!= T && x.c==color.black){
			if(x.parent.left==x){
				w=x.parent.right;
				if(w.c==color.red){					// case 1: when sibling is red
					w.c=color.black;
					x.parent.c=color.red;
					leftRotate(T,x.parent);
					w=x.parent.right;
				}
				if(w.left.c==color.black && w.right.c==color.black){	//case 2 both children of w are black
					w.c=color.red;
					x=x.parent;
				}else if(w.right.c==color.black){
					w.c=color.red;
					w.left.c=color.black;
					rightRotate(T,w);
					w=x.parent.right;
				}
				w.c=x.parent.c;
				w.right.c=color.black;
				x.parent.c=color.black;
				leftRotate(T,x.parent);
				x=T;
				
				}else{						// need to check rotate function in else section
					w=x.parent.left;
					if(w.c==color.red){					// case 1: when sibling is red
						w.c=color.black;
						x.parent.c=color.red;
						rightRotate(T,x.parent);
						w=x.parent.left;
					}
					if(w.left.c==color.black && w.right.c==color.black){
						w.c=color.red;
						x=x.parent;
					}else if(w.left.c==color.black){
						w.c=color.red;
						w.right.c=color.black;
						leftRotate(T,w);
						w=x.parent.left;
					}
					w.c=x.parent.c;
					w.left.c=color.black;
					x.parent.c=color.black;
					rightRotate(T,x.parent);
					x=T;
		
				}
			//x.c=color.black;
		}
		x.c=color.black;
					
	}
	
	TreeNode createNode(int key,color c){
		TreeNode tn=new TreeNode(key,c);
		tn.left=tn.right=tn.parent=Nil;
		return tn;
	}
	
}
