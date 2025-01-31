public class FindMinMax {
    class Pair{
        int min;
        int max;
        Pair(int min, int max){
            this.min=min;
            this.max=max;
        }
    }
    Pair findMinMax(int a[] ,int s ,int e){
        if (s==e) {
            return new Pair(a[s], a[s]);
        }
        if (s+1==e) {
            if (a[s]>a[e]) {
                return new Pair(a[e], a[s]);
            }
            else{
                return new Pair(a[s], a[e]);
        }
        }
        int mid=(s+e)/2;
        Pair leftPair=findMinMax(a, s, mid);
        Pair rightPair=findMinMax(a, mid+1, e);

        int overallmin=Math.min(leftPair.min,rightPair.min);
        int overallmax=Math.max(leftPair.max, rightPair.max);
        return new Pair(overallmin, overallmax);
    }
    }

