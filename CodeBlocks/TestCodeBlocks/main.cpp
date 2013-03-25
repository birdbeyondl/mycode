#include <iostream>
#include <bitset>
#include <string>

using namespace std;

int main()
{
    cout << "Hello world!" << endl;
    bitset<16> bitvec1(0x0000);
    cout<<bitvec1.any()<<endl;
    string str("0011");
    bitset<32> bitvec2(str);
    cout<<bitvec2<<endl;

    string str2("110001000101010101001");
    bitset<32> bitvec3(str2,5,4);
    cout<<bitvec3<<endl;

    bitset<32> bitvec4(str2,5);
    size_t total = bitvec4.count();
    cout<<total<<endl;
    cout<<bitvec4.size()<<endl;


    short value1=32767;
    short value2=1;
    value1+=value2;
    cout<<value1<<endl;

    int val = 24/15%3;
    cout<<val<<endl;

    //将字符串的第一个单词中的英文变成大写字母
    string s("hello wust luo");
    string::iterator it = s.begin();
    while(it != s.end() && !isspace(*it)){
        *it = toupper(*it);
        it++;
    }
    cout<<s<<endl;

    //位操作
    unsigned char bits = 0227;
    bits = ~bits;
    cout<<bits<<endl;

    int ival = 0;
    ival = 3.14;
    cout<<ival<<endl;

    //赋值操作
    int i;
    double d;
    i = d =3.5;
    cout<<i<<"   "<<d<<endl;

    //表达式
    cout<<"表达式计算:"<<endl;
    int a = 2;
    a+=a+1;
    cout<<a<<endl;

     i = 2;
    int j = 3;
    cout<<(i>j)?i:j;

    //
    double x[10];
    double *p = x;
    cout<<"Sizefo:"<<endl;
    cout<<sizeof(x)/sizeof(*x)<<endl;
    cout<<sizeof(p)/sizeof(*p)<<endl;

    return 0;
}
