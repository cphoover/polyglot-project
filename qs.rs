fn main() {
    let nums: Vec<i32> = vec![10, 5, 8, 330, 22, 3];

    let sorted = qs(&nums);
    println!("{:#?}", sorted);
}

fn qs(items: &[i32]) -> Vec<i32> {
    match items {
        [] => vec![],
        [pivot, rest @ ..] => {
            let (hi, low): (Vec<i32>, Vec<i32>) = rest.iter().partition(|&n| n <= pivot);
            [qs(&hi), vec![*pivot], qs(&low)].concat()
        }
    }
}
