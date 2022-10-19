#include <iostream>
using namespace std;

void bubbleSort(int arr[], int n) {
    if (n == 1)
        return;
    for (int i = 0; i < n-1; i++) {
        if (arr[i] > arr[i+1]) {        // comparing adjacent elements
            int temp = arr[i+1];        // swapping adjacent elements if second one is less than the first one
            arr[i+1] = arr[i];  
            arr[i] = temp;
        }
    }
    bubbleSort(arr, n-1);       // Recursive for BubbleSort(array, 1...n-1), Biggest element will be left at the index n;
}

int main() {
    int n;              // array length
    cin >> n;
    int arr[n];         // array itself
    for (int i = 0; i < n; i++)         // input in the aray
        cin >> arr[i];
    bubbleSort(arr, n);
    for (int i = 0; i < n; i++)
        cout << arr[i] << ' ';             // output array after Bubble Sort
    return 0;
}