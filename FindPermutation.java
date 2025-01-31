public class FindPermutation {

    public static void main(String[] args) {
        String str ="ABC";
        FindPermutation p = new FindPermutation();
        p.printPermutation(str, "");

    }

    void printPermutation(String str, String perm){


        if (str.equals("")) {
            System.out.println(perm);
            return;
        }

        if (perm.length()>1 && perm.charAt(1)!='C') {
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char currchar=str.charAt(i);
            String remstring=str.substring(0,i)+str.substring(i+1);
            printPermutation(remstring, perm+currchar);
        }

    }
  
}
