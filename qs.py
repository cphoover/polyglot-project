def qs(vals):
  if(len(vals) < 2):
    return vals

  pivot = vals[0]
  newlist = vals[1:]
  left = filter(lambda x : x <= pivot, newlist)
  right = filter(lambda x : x > pivot, newlist)
  return qs(list(left)) + [pivot] + qs(list(right))
