public class BST {
    //data
    Node root;

    //methods
    //Delete - skip

    //CountLetters

    public int NumberOfAllLetters()
    {
        return NumberOfAllLettersHelper(root);
    }

    public int NumberOfAllLettersHelper(Node current)
    {
        if(current==null)
        {
            return 0;
        }
        else
        {
            //divide and conquer
            return current.value.length() +
            NumberOfAllLettersHelper(current.left) +
            NumberOfAllLettersHelper(current.right);
        }
    }

    //algorithms

    public int CounterNodes()
    {
        return CounterNodesHelper(root);
    
    }

    public int CounterNodesHelper(Node current)
    {
        if (current!=null)
            return CounterNodesHelper(current.left)+CounterNodesHelper(current.right)+1;
        else
            return 0;
    }
    //Clear
    public void Clear()
    {
        root = null;
    }

    //IsEmpty
    public boolean IsEmpty()
    {
        return root == null;
    }

    //Search
    public Node Search(String valueSearched)
    {
        Node finger = root;

        while(finger!=null) //does finger point to a node?
        {   
            if(finger.value.equals(valueSearched))  //check its value
            {
                return finger;//found it!
            }
            else if(valueSearched.compareTo(finger.value)<0)
            {
                finger = finger.left;//go left
            }
            else
            {
                finger = finger.right;//go right
            }
        }
        //we get here when finger points to null
        return null;
    }


    public boolean Search2(String value)
    {
        return Search(value) != null;
    }
    
    //Insert
    public void Insert(String someValue)
    {
        Node node = new Node(someValue);//create a new node

        if(IsEmpty())
        {
            root = node; //make root point to the new node
            //root =new Node(someValue);
        }
        else
        {
            //start at the root
            Node finger = root;

            while(true) //traverse the tree
            {
                if(someValue.compareTo(finger.value)  <=  0)
                {
                    if(finger.left!=null)//is there a left node???
                    {
                        finger = finger.left; //if there is a left node then move finger to left
                    }
                    else
                    {
                        //if there is no left node then link in new node to the left
                        finger.left = node;
                        break; //done with the loop
                    }
                }
                else
                {
                    if(finger.right!=null)//is there a right node???
                    {
                        finger = finger.right; //if there is a right node then move finger to right
                    }
                    else
                    {
                        //if there is no right node then link in new node to the right
                        finger.right = node;
                        break; //done with the loop
                    }
                }
            }
        }
    }

    //Max/Min
    public String Max() throws Exception
    {
        Node finger = root;
        if(IsEmpty())
        {
            throw new Exception("no max in empty tree");
        }
        else
        {
            while(finger.right != null)
            {
                finger = finger.right;
            }

            //finger now points at right most node
            return finger.value;
        }
    }


    //Traversals
    //PreOrder - NLR
    public void PreOrder()
    {
        PreOrderHelper(root);
    }

    public void PreOrderHelper(Node current) //think of current as "finger"
    {
        if(current!=null)
        {
            System.out.println(current.value); //N - visit the node
            PreOrderHelper(current.left); //L - visit the left subtree
            PreOrderHelper(current.right); //R - visit the left subtree
        }
    }

    //InOrder - LNR
    public void InOrder()
    {
        InOrderHelper(root);
    }

    public void InOrderHelper(Node current) //think of current as "finger"
    {
        if(current!=null)
        {
            InOrderHelper(current.left); //L - visit the left subtree
            System.out.println(current.value); //N - visit the node
            InOrderHelper(current.right); //R - visit the left subtree
        }
    }


    //PostOrder - LRN

    //CountLeafNodes

    public int CountLeafNodes()
    {
        return CountLeafNodesHelper(root);
    }

    public int CountLeafNodesHelper(Node current)
    {
        if (current == null)
        {
            return 0;
        }
        else if (current.left == null && current.right == null)
        {
            return 1; //found the leaf node
        }
        else{

        return CountLeafNodesHelper(current.left)+CountLeafNodesHelper(current.right);
        }
    }


    //FindHeight

    public int FindHeight()
    {
        return FindHeightHelper(root);
    }

    public int FindHeightHelper(Node current)
    {
        if (current ==null) {
            return -1;
        }
        else
        {
            return Math.max (FindHeightHelper(current.left),
                                            FindHeightHelper(current.right))+1;
        }

    
    


    //ctor
    }
}

