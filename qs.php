function qs($arr) {
  if (count($arr) < 2) {
    return $arr;
  }
  $pivot = array_shift($arr);
  $left = array_filter($arr, function($x) use ($pivot) {
    return $x <= $pivot;
  });
  $right = array_filter($arr, function($x) use ($pivot)  {
    return $x > $pivot;
  });
  return array_merge(qs($left), [$pivot], qs($right));
}
