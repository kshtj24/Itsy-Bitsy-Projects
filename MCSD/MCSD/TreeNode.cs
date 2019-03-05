using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MCSD
{
    class TreeNode:IEnumerable<TreeNode>
    {
        public int Depth = 0;
        public string Text = "";
        public List<TreeNode> Children = new List<TreeNode>();

        public TreeNode(string text) 
        {
            Text = text;
        }

        //Add and create children
        public TreeNode AddChild(string text)
        {
            TreeNode child = new TreeNode(text);
            child.Depth = Depth + 1;
            Children.Add(child);
            return child;
        }

        //return the tree's nodes in an preorder traversal
        public List<TreeNode> Preorder()
        {
            //Creating result list
            List<TreeNode> nodes = new List<TreeNode>();
            //Traverse node's subtree
            TraversePreorder(nodes);
            //Return the result
            return nodes;
        }

        private void TraversePreorder(List<TreeNode> nodes)
        {
            //Traverse this node
            nodes.Add(this);

            //Traverse the children
            foreach (TreeNode child in Children)
            {
                child.TraversePreorder(nodes);
            }
        }

        public IEnumerator<TreeNode> GetEnumerator()
        {
            return new TreeEnumerator(this);
        }

        IEnumerator<TreeNode> IEnumerable.GetEnumerator()
        {
            return new TreeEnumerator(this);
        }
    }
}
