package main

import (
	"fmt"
)

func main() {
	sortMe := []int{55, 43, 12, 54, 3, 123, 432, 1}
	sorted := qs(sortMe)
	fmt.Printf("Sorted Slice: %v", sorted)
}

func qs(x []int) []int {
	if len(x) < 2 {
		return x
	}

	pivot := x[0]
	left := []int{}
	right := []int{}
	for _, num := range x[1:] {
		if num <= pivot {
			left = append(left, num)
		} else {
			right = append(right, num)
		}
	}
	left, right = qs(left), qs(right)
	left = append(left, pivot)
	return append(left, right...)
}
