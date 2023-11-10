package base.arithmetic.soort;

public class StringRevert {

    public void revertCharArray(){
        String[] s = {"h", "e", "l", "l", "o"};
        for(int left = 0, right = s.length - 1; left < right; left++, right--){
            String temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
