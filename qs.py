import random


def qs_generator(vals):
    if len(vals) < 2:
        return vals

    pivot = vals[0]
    newlist = vals[1:]
    left = [x for x in newlist if x <= pivot]
    right = [x for x in newlist if x > pivot]
    return qs_generator(left) + [pivot] + qs_generator(right)


def qs_lambda(vals):
    if len(vals) < 2:
        return vals

    pivot = vals[0]
    newlist = vals[1:]
    left = filter(lambda x: x <= pivot, newlist)
    right = filter(lambda x: x > pivot, newlist)
    return qs_lambda(list(left)) + [pivot] + qs_lambda(list(right))


values = random.sample(range(10000), 10000)

if __name__ == '__main__':
    from timeit import Timer
    t1 = Timer(lambda: qs_generator(values))
    t2 = Timer(lambda: qs_lambda(values))
    print('With Generator', t1.timeit(number=10))
    print('With lambda', t2.timeit(number=10))
