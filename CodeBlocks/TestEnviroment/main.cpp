#include <iostream>

using namespace std;
//C_++中，switch中的case条件只能是数字或者char，不能是字串
int main()
{
    cout << "Hello world! Dillan" << endl;
    char str = 'a';
    switch(str){
    case 'a':
        cout<<"out is ab"<<endl;
        break;
    case 'b':
        cout<<"out is cd"<<endl;
        break;
    default:
        break;
    }
    return 0;
}
