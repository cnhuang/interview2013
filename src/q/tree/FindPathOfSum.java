package q.tree;

import java.util.ArrayList;
import java.util.List;

import ds.TreeNode;


public class FindPathOfSum
{
	//Crack code interview p33
	public static void main(String[] args)
	{
		TreeNode<Integer> t = TreeNode.getRandomTree(500);
		Find(t,new ArrayList<Integer>(),20);
	}
	
	public static void Find(TreeNode<Integer> t, List<Integer> buffer, int sum)
	{
		if(t == null)
			return;
		else
			buffer.add(t.data);
		
		int tmp = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = buffer.size()-1 ; i >=0 ; i--)
		{
			tmp += buffer.get(i);
			sb.append(buffer.get(i)).append(",");
			if(tmp == sum)
			{
				System.out.println(sb.toString());
			}
		}
		
		Find(t.left,buffer,sum);
		Find(t.right,buffer,sum);
		buffer.remove(buffer.size()-1);
		
	}

}
