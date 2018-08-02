const qs = (list, pivot) =>
  list.length < 2
    ? list
    : (pivot = list.pop(),
      [
        ...qs(list.filter(x => x <= pivot)),
        pivot,
        ...qs(list.filter(x => x > pivot))
      ]);

// or alternatively
const qs2 = ([pivot = [], ...list]) => 
  (pivot.length == 0) ? [] :
   [
    ...qs2(list.filter(x => x <= pivot)),
    pivot,
    ...qs2(list.filter(x => x > pivot))
  ];
