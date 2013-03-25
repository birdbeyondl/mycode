#include<vector>
#include<iostream>
using namespace std;
int main()
{
    vector<int> q;
    q.push_back(10);
    q.push_back(12);
    q.push_back(14);

    vector<int> v;
    for(int i=0;i<5;++i)
    {
        v.push_back(i);
    }
    vector<int>::iterator it = v.begin();
/*    for(it;it!=v.end();it++)
    {
        cout<<*it<<endl;
    }
*/
    it=v.insert(it,33);


}
