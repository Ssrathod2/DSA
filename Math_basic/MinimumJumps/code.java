class Solution {
    static int calcIdx(int[] arr,int id){
        int n = arr[id];
        int MaxE = Integer.MIN_VALUE;
        int ans = -1;
        for(int i= id+1;i<=id+n;i++ ){
            if(MaxE < arr[i]+i){
                MaxE = arr[i]+i;
                ans = i;
            }
            MaxE = Math.max(MaxE,arr[i]+i);
        }
        
        return ans;
    }
    
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        int op = 1;
        for(int i=0;i<arr.length;){
            if(i+arr[i]>=n-1) return op;
            i=calcIdx(arr,i);
            //System.out.println(i);
            if(i==-1) return -1;
            op++;
        }
        
        return op;
        
    }
}