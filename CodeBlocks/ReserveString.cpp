#include<iostream>
#include<vector>
#include<string>

using namespace std;
int main()
{
    vector<string> vec;
    string text;
    while(cin>>text)
        vec.push_back(text);
    for(vector<string>::iterator i = vec.end()-1;i>=vec.begin();--i)
        cout<<" "<<*i<<" ";
    return 0;
}
