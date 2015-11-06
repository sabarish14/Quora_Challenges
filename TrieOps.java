 class Trie {
	Boolean leaf;
	Trie[] children;
	
	Trie()
	{
		leaf=false;
		children=new Trie[26];
		for (Trie t:children)
		{
			t=null;
		}
	}
	

}
class TrieOps {

	Trie root;
	TrieOps()
	{
		root=new Trie();
	}
	void insert(String word)
	{
		Trie temp=root;
		for (int i=0;i<word.length();i++)
		{
			int ch;
			if (Character.isUpperCase(word.charAt(i)))
			{
				ch=word.charAt(i)-65;
			}
			else
			{
				ch=word.charAt(i)-97;
			}
			if (temp.children[character]==null)
			{
				temp.children[character]=new Trie();
				
			}
			temp=temp.children[character];
			
		}
		temp.leaf=true;
	}
	Boolean search(String word)
	{
	
		Trie temp=root;
		for (int i=0;i<word.length();i++)
		{
			int character=(int)(word.charAt(i))-97;
			temp=temp.children[character];
			if (temp==null)
			{				
					return false;
			}
			if (temp.leaf)
				return true;
		}
		return false;
	}
	Boolean subStringCheck(String word)
	{
		Boolean flag=true;
		Trie temp=root;
		for (int i=0;i<word.length;i++)
		{
			int ch;
			if (Character.isUpperCase(word.charAt(i)))
			{
				ch=word.charAt(i)-65;
			}
			else
			{
				ch=word.charAt(i)-97;
			}
			temp=temp.children[ch];
			
			if (temp==null)
			{
				if (temp.leaf)
					return true;
				return false;
			}
			else
			{
				temp=temp.children[ch];
			}
		}		
		return true;
	}
}
