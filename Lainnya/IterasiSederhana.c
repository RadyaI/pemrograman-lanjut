#include <stdio.h>
#include <math.h>

// (1) Definisikan F(x) dan g(x)
double F(double x) {
    return x*x - 3*x - 10;
}
double g(double x) {
    return sqrt(3*x + 10);
}

int main() {
    // (2) Toleransi error dan iterasi maksimum
    double err = 0.0001;
    int n = 20;

    // (3) Pendekatan awal x0
    double x0 = 4.0;
    double x1, Fx, error;
    int i;

    printf("Iter\t   x0\t\t   x1\t\t   F(x1)\t   error\n");
    printf("----------------------------------------------------------\n");

    // (4) Proses iterasi
    for (i = 1; i <= n; i++) {
        x1 = g(x0);
        Fx = F(x1);
        error = fabs(Fx);

        printf("%d\t%.5f\t%.5f\t%.5f\t%.5f\n", i, x0, x1, Fx, error);

        if (error < err) {
            // (5) Akar terakhir
            printf("\nAkar ditemukan pada x ≈ %.5f setelah %d iterasi\n", x1, i);
            return 0;
        }

        x0 = x1;
    }

    printf("\nIterasi maksimum tercapai. Akar terakhir ≈ %.5f\n", x1);
    return 0;
}
