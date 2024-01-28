public class Question_12 {
}
class Solution_3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=0; i<m+n ; i++){
            if(m!=0){
                m--;
                continue;
            }
            nums1[i]=nums2[j];
            j++;
        }
    }
    private int[] sort( int[] arr){

        int n  = arr.length;
        for (int i=1;i<n;++i){
            int j = i-1;
            int key = arr[i];

            while (j>=0 && key<arr[i]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }

        return arr;
    }
}
