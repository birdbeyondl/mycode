#include<iostream>
#include<cstring>
#include<vector>


using namespace std;

int ar[10] = {12,45,25,89,54,76,84,52,19,42};
char *str = "Hello world";
int main(){
    vector<int> vec1(ar,ar+10);
    vector<char> vec2(str,str+strlen(str));

    cout<<vec1.front()<<endl;
    cout<<vec1.back()<<endl;
    cout<<vec1.at(2)<<endl;
    cout<<vec1[3]<<endl;

    vec1.pop_back();
    cout<<vec1.back()<<endl;

    vec1.erase(vec1.begin()+1,vec1.end()-2);

    cout<<"vec1:"<<endl;
    for(vector<int>::const_iterator iter = vec1.begin();iter != vec1.end();++iter)
        cout<<*iter<<endl;

    cout<<vec1.size()<<endl;
    vec1.empty();
    cout<<vec1.size()<<endl;

    return 0;
}
