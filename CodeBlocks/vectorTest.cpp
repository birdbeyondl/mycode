#include<iostream>
#include<vector>
#include<iterator>
using namespace std;

int main()
{
    vector<int> vec;
    vector<int>::iterator i;
    for(int j=0;j<10;j++)
    {
        vec.push_back(j);
    }
    for(i=vec.begin();i!=vec.end();++i)
    {
        cout<<*i<<endl;
    }
}


/*
//stl_cpp_2.cpp
#include <vector>
#include <iostream>

int main(void)
{
    std::vector<double> a;
    std::vector<double>::const_iterator i;
    a.push_back(1);
    a.push_back(2);
    a.push_back(3);
    a.push_back(4);
    a.push_back(5);
    for(i=a.begin(); i!=a.end(); ++i){
        std::cout<<(*i)<<std::endl;
    }
    return 0;
}
*/
