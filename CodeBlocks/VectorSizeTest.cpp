#include<iostream>
#include<vector>
using namespace std;

int main()
{
    vector<int> vec;
    cout<<"vec size:"<<vec.size()<<"   vec capacity: "<<vec.capacity()<<endl;
    for(vector<int>::size_type i=0;i!=10;i++)
    {
        vec.push_back(i);
    }
    cout<<"vec size:"<<vec.size()<<"   vec capacity: "<<vec.capacity()<<endl;

    vec.reserve(50);
    cout<<"after reserve 50:"<<endl;
    cout<<"vec size:"<<vec.size()<<"   vec capacity: "<<vec.capacity()<<endl;

    while(vec.size()!=vec.capacity())
    {
        vec.push_back(0);
    }
    cout<<"vec size:"<<vec.size()<<"   vec capacity: "<<vec.capacity()<<endl;

    vec.push_back(51);
    vec.push_back(52);
    cout<<"vec size:"<<vec.size()<<"   vec capacity: "<<vec.capacity()<<endl;

    return 0;
}
