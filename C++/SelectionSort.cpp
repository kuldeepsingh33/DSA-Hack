#include <iostream>



void swap(int *xp,int *yp){
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void selectionSort(int arr[],int n){
    for(int i = 0 ; i<n;i++){
        
        int min = i;
        //Checking for the minimum element in the unsorted array
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min]){
                min = j;
            }
        }
        
        swap(&arr[i],&arr[min]);
        

    }

}

void PrintArray(int arr[],int n){
    printf("\nPrinting the Array\n");
    for(int i=0;i<n;i++){
        printf("%d->",arr[i]);
    }
}
int main(){
    int a[] = {3,5,6,11,2,22};
    int n = sizeof(a)/sizeof(a[0]);
    selectionSort(a,n);
    PrintArray(a,n);
                   
                    
                  
    return 0;
}

