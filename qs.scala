def qs[T <% Ordered[T]](list: List[T]) : List[T] = {
  if (list.size < 2)
    list
  else {
    val (left, right) = list.init.partition(_ <= list.last);
    (qs(left) :+ list.last) ++ qs(right)
  }
}
