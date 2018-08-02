const qs = (list, pivot) =>
  list.length < 2
    ? list
    : (pivot = list.pop(),
      [
        ...qs(list.filter(x => x <= pivot)),
        pivot,
        ...qs(list.filter(x => x > pivot))
      ]);
