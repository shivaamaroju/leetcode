class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
    Tire obj=new Tire();
    for(var s:dictionary){
        obj.insert(s);
    }
    String a[]=sentence.split(" ");

  StringBuilder result = new StringBuilder();

        for (String word : a) {
            result.append(obj.search(word)).append(" ");
        }

        return result.toString().trim();
      
    }
}
class Node{
    Node a[]=new Node [26];
    boolean ew=false;
}
class Tire{
    Node root=new Node();
    public void insert(String word){
        Node temp=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(temp.a[idx]==null){
                Node nn=new Node();
                temp.a[idx]=nn;
                temp=temp.a[idx];
            }
            else temp=temp.a[idx];
        }
        temp.ew=true;
        
    }
   public String search(String word) {
    Node temp = root;
    StringBuilder prefix = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        int idx = ch - 'a';

        if (temp.a[idx] == null) {
            return word; // No prefix found
        }

        prefix.append(ch);
        temp = temp.a[idx];

        if (temp.ew) {
            return prefix.toString(); // Return root word
        }
    }

    return word; // No root word matched
}

}