#include <stdio.h>
int main(int argc, char *argv[])
{
    double x = 59.0, y = 7.0;
    printf("%.55f\n", x/y);

    float x_ = 59.0f, y_ = 7.0f;
    printf("%.55f\n", x_/y_);
    return 0;
}