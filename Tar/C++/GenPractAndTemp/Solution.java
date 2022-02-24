import java.util.*;

class Solution{

    public String toBinary(int mask){
        StringBuilder res=new StringBuilder();
        if(mask==0){
            res.append("0");
            return res.toString();
        }
        while(mask!=1){
            if(mask%2==0){
                res.append("0");
            } else{
                res.append("1");
            }
            mask/=2;
        }
        res.append("1");
        StringBuilder fnres=res.reverse();
        return fnres.toString();
    }

    public int toggle(int bitVector, int index){
        System.out.println("bitVec earlier "+toBinary(bitVector));
        if(index<0) return bitVector;
        int mask=1<<index;
        System.out.println("mask "+toBinary(mask));
        bitVector^=mask;
        return bitVector;
    }

    int createBitVector(String in){
        int bitVector=0;
        for(char ch: in.toCharArray()){
            int x=Character.getNumericValue(ch);
            System.out.println(x);
            bitVector=toggle(bitVector, x);
            System.out.println("bitVec now "+toBinary(bitVector));
            System.out.println("-------");
        }
        return bitVector;
    }

    boolean checkAtMostOneBitSet(int bitVector){
        return (bitVector&(bitVector-1))==0;
    }

    boolean isPermutationOfPalindome(String in){
        int bitVector=createBitVector(in);
        return checkAtMostOneBitSet(bitVector);
    }

    public static void main(String[] args){
        Solution obj=new Solution();
        String input="madam";
        boolean ans=obj.isPermutationOfPalindome(input);
        System.out.println("");
    }
}