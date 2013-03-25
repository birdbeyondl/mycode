#include<iostream>
#include<vector>
#include<string>

using namespace std;
int main()
{
    vector<string> svec;
    svec.reserve(8);
    string text;
    while(cin >> text)
    {
        svec.push_back(text);
    }
    svec.resize(svec.size()+svec.size()/2);
    cout<<"svec size:"<<svec.size()<<"   svec capacity: "<<svec.capacity()<<endl;

    return 0;

}
