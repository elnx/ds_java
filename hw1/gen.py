import random
n = [10, 100, 1000, 10000, 100000, 1000000, 10000000, 20000000 ]
for nn in n[:-1]:
    with open("%d.in" % nn, "w+") as f:
        l = map(str, range(nn))
        random.shuffle(l)
        f.write(' '.join(l))
