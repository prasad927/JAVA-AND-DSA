class BS_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high=arr.length-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid+1]){
                high=mid; //move till mid only because mid is potential ans
            }else if(arr[mid]>arr[mid-1]){
                low=mid;////move till mid only because mid is potential ans
            }
        }
        return low;//to avoid error.
    }
}