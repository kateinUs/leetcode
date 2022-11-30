package jiuzhang;

/**
 * @author huimin
 * @create 2022-11-21 23:59
 */
public class T463_Sort_Integers {
    public void sortIntegers(int[] a) {
        if(a == null || a.length == 0)
            return;
        quickSort(a, 0, a.length-1);
    }
    public void quickSort(int[] a, int start, int end){
        if(start >= end) return;
        int left = start, right = end;
        int pivot = a[(left + right)/2];
        while(left <= right){
            while(left <= right && a[left] < pivot){
                left ++;
            }
            while(left <= right && a[right] > pivot){
                right --;
            }
            if(left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left ++;
                right --;
            }
        }
        // start ... right | left, ... end
        //        <= pivot | >= pivot
        quickSort(a, start, right);
        quickSort(a, left, end);
    }

    public void sortIntegers2(int[] a) {
        if(a == null || a.length == 0)
            return;
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length-1, temp);
    }
    public void mergeSort(int[] a, int start, int end, int[] temp){
        if(start >= end) return;
        int mid = (start+ end)/2;
        mergeSort(a, start, mid, temp);
        mergeSort(a, mid+1, end, temp);
        merge(a, start, end, temp);
    }
    public void merge(int[] a, int start, int end, int[] temp){
        // 因为start != end在mergesort里就检查过了，相等的话不会进入merge
        int mid = (start+ end)/2;
        int leftIndex = start;
        int rightIndex = mid+1;
        int index= start;
        // start ... mid | mid+1 ... end
        while(leftIndex <= mid && rightIndex <= end){
            if(a[leftIndex] < a[rightIndex]){
                temp[index++] = a[leftIndex++];
            }else{
                temp[index++] = a[rightIndex++];
            }
        }
        while(leftIndex <= mid){
            temp[index++] = a[leftIndex++];
        }
        while(rightIndex <= end){
            temp[index++] = a[rightIndex++];
        }
        for(int i=start; i<=end; i++){
            a[i] = temp[i];
        }
    }
}
