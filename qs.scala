def qs[T <% Ordered[T]](list: List[T]) : List[T] = {
  if (list.size < 2)
    list
  else {
    val pivot = list.last
    val (left, right) = list.init.partition(_ <= pivot);
    (qs(left) :+ pivot) ++ qs(right)
  }
}
