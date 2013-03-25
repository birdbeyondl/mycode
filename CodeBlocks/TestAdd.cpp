#include<iostream>
using namespace std;

int main()
{
 /*   int i=7;
    cout<<i++*i++<<endl;
    cout<<i<<endl;
    return 0;
*/
    int i=2;
    i=i++;
    cout<<i<<endl;
    int a[5];
    a[i]=i++;
    cout<<a[i]<<endl<<a[i-1]<<endl<<i<<endl;

    int d=10;
    int b=20;
    long int c = d*b;
    cout<<"c:"<<c<<endl;

    return 0;
}
