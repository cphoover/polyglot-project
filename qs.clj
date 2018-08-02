(defn qs [[pivot & list]]
  (when pivot
   (concat 
      (qs (filter #(<= % pivot) list))
      [pivot]
      (qs (filter #(> % pivot) list))
    )
  )
)
