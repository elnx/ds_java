#include <algorithm>
#include <cstdio>
using namespace std;
int a[1<<30];
int main(int argc, char* argv[]) {
    if (argc != 2) {
        return 1;
    }
    freopen(argv[1], "r", stdin);
    int n = atoi(argv[1]);
    int i = 0;
    for(; i < n; ++i) {
        scanf("%d", &a[i]);
    }
    nth_element(a, a+(n>>1), a+n);
    printf("%d\n", a[n>>1]);
}
