#include<iostream>
#include<cstring>
#include<vector>


using namespace std;

int ar[10] = {12,45,25,89,54,76,84,52,19,42};
char *str = "Hello world";
int main(){
    vector<int> vec1(ar,ar+10);
    vector<char> vec2(str,str+strlen(str));
    cout<<"vec1"<<endl;
    for(vector<int>::const_iterator iter = vec1.begin();iter != vec1.end();++iter)
        cout<<*iter<<endl;
    for(vector<char>::const_iterator iter2 = vec2.begin();iter2!= vec2.end();++iter2)
        cout<<*iter2;
    getchar();


    return 0;
}
