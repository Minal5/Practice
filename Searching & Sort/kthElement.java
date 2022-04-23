class kthElement {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int[] ans=new int[m+n];
        for(int i=0;i<n;i++)
        {
            ans[i]=arr1[i];
        }
        int j=0;
        for(int i=n;i<n+m;i++)
        {
            ans[i]=arr2[j];
            j++;
        }
        
        Arrays.sort(ans);
        int start=0;
        int end=n+m-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid==k)
            {
                return ans[mid-1];
            }
            else if(mid>k)
            {
                end=mid-1;
            }
            else if(mid<k)
            {
                start=mid+1;
            }
        }
        return -1;
    }
}
