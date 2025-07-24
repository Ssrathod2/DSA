class Solution {
    public int getAns(String s,int x,int y,char a,char b){
        int ca=0,cb=0;
        int n = s.length();
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == a){
                if(cb > 0){
                   ans += x;
                   cb--;
                }else{
                    ca++;
                }
            }else if(s.charAt(i) == b){
                cb++;
            }else{
                ans += Math.min(ca,cb) * y;
                ca=0;
                cb=0;
            }
        }

        ans += Math.min(ca,cb) * y;
        return ans;
    }
    public int maximumGain(String s, int x, int y) {
       if(y>x){
          return getAns(s,y,x,'b','a');
       }else return getAns(s,x,y,'a','b');
    }
}

//cbdcbbaaabab

