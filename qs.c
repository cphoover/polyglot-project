#include <stdio.h>
#include <string.h>

void printArr(int arr[], int size, char label[]) {
        printf("--- (Array %s Size: %d )", label, size);
        for (int i = 0; i < size; i++) {
                printf("%d ", arr[i]);
        }
        printf(" --- \n");
}

void qs(int arr[], int size) {
        if(size > 1) {

          int pivot = arr[0];
          int left[size];
          int right[size];
          int left_size = 0;
          int right_size = 0;
          for (int i = 1; i < size; i++) {
                  if(arr[i] <= pivot) {
                          left[left_size] = arr[i];
                          left_size++;
                  } else {
                          right[right_size] = arr[i];
                          right_size++;
                  }
          }

          qs(left, left_size);
          qs(right, right_size);
          memcpy(arr, left, left_size * sizeof(int));
          arr[left_size] = pivot;
          memcpy(arr + left_size + 1, right, right_size * sizeof(int));
        }
}

int main(void) {
        printf("starting quicksort\n ");
        int arr[10] = {1,25,3, 6, 10, 25, 32, 33, 1, 2};
        qs(arr, 10);
        printArr(arr, 10, "sorted");
        return 0;
}
