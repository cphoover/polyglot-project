import Enum;
defmodule QuickSort do
  def qs([]) do [] end
  def qs([h|t]) do
    qs(filter(t, fn x -> x <= h end )) ++ [h] ++ qs(filter(t, fn x -> x > h end))
  end
end

defmodule QuickSort2 do
  def qs([]) do [] end
  def qs([h|t]) do
    {lo, hi} = Enum.split_with(t, fn x -> x <= h end )
    qs(lo) ++ [h] ++ qs(hi)
  end
end


IO.inspect QuickSort.qs([4,3,1,2,3,45,32,4,3,123,43])
IO.inspect QuickSort2.qs([4,3,1,2,3,45,32,4,3,123,43])
