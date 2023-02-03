class Solution {
    public int longestConsecutive(int[] arr) {
        Set <Integer> hashSet = new HashSet<Integer>();
        for(int num: arr){
            hashSet.add(num);
        }
        int maxlength = 0;
        for(int num : arr){
            if(!hashSet.contains(num-1)){
                int currNum = num;
                int length = 1;
                while(hashSet.contains(currNum+1)){
                    currNum+=1;
                    length +=1;
                }
                maxlength = Math.max(maxlength,length);
            }
        }
        return maxlength;
    }
}
